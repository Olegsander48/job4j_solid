package ru.job4j.ood.srp.report;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;
import java.util.function.Predicate;

public class JsonReportEngine implements Report {
    private final Store store;
    private final Gson library;

    private final DateTimeParser<Calendar> dateTimeParser;

    public JsonReportEngine(Store store) {
        this.store = store;
        library = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        dateTimeParser = new ReportDateTimeParser();
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        var employees = store.findBy(filter)
                .stream()
                .map(employee -> {
                    JsonObject object = new JsonObject();
                    object.addProperty("name", employee.getName());
                    object.addProperty("hired", dateTimeParser.parse(employee.getHired()));
                    object.addProperty("fired", dateTimeParser.parse(employee.getFired()));
                    object.addProperty("salary", employee.getSalary());
                    return object;
                })
                .toList();
        return library.toJson(employees);
    }
}
