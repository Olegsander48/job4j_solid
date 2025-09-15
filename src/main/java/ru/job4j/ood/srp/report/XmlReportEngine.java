package ru.job4j.ood.srp.report;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.model.EmployeesXml;
import ru.job4j.ood.srp.store.Store;
import java.io.IOException;
import java.io.StringWriter;
import java.util.function.Predicate;

public class XmlReportEngine implements Report {
    private final Store store;

    public XmlReportEngine(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder xml = new StringBuilder();
        try {
            JAXBContext context = JAXBContext.newInstance(EmployeesXml.class, Employee.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            try (StringWriter writer = new StringWriter()) {
                marshaller.marshal(new EmployeesXml(store.findBy(filter)), writer);
                xml.append(writer.getBuffer().toString());
            }
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
        return xml.toString();
    }
}
