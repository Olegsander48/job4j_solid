package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.*;

class JsonReportEngineTest {
    @Test
    void whenAccountantsGenerated() {
        MemoryStore store = new MemoryStore();
        Employee employee = new Employee("John Doe",
                new GregorianCalendar(2023, Calendar.JUNE, 8, 17, 41),
                new GregorianCalendar(2023, Calendar.JUNE, 8, 17, 41),
                5000.0);
        Employee employee1 = new Employee("Jane Smith",
                new GregorianCalendar(2023, Calendar.JUNE, 8, 17, 41),
                new GregorianCalendar(2023, Calendar.JUNE, 8, 17, 41),
                6000.0);
        store.add(employee);
        store.add(employee1);
        Report engine = new JsonReportEngine(store);
        String ex = """
                [
                  {
                    "name": "John Doe",
                    "hired": "08:06:2023 17:41",
                    "fired": "08:06:2023 17:41",
                    "salary": 5000.0
                  },
                  {
                    "name": "Jane Smith",
                    "hired": "08:06:2023 17:41",
                    "fired": "08:06:2023 17:41",
                    "salary": 6000.0
                  }
                ]""";
        assertThat(engine.generate(em -> true)).isEqualTo(ex);
    }

    @Test
    void whenAccountantsWithFilterGenerated() {
        MemoryStore store = new MemoryStore();
        Employee employee1 = new Employee("John Doe",
                new GregorianCalendar(2023, Calendar.JUNE, 8, 17, 41),
                new GregorianCalendar(2023, Calendar.JUNE, 8, 17, 41),
                5000.0);
        Employee employee2 = new Employee("Jane Smith",
                new GregorianCalendar(2023, Calendar.JUNE, 8, 17, 41),
                new GregorianCalendar(2023, Calendar.JUNE, 8, 17, 41),
                6000.0);
        Employee employee3 = new Employee("David Goggins",
                new GregorianCalendar(2021, Calendar.MARCH, 8, 3, 45),
                new GregorianCalendar(2024, Calendar.SEPTEMBER, 1, 23, 41),
                3300.0);
        Employee employee4 = new Employee("Willy Jones",
                new GregorianCalendar(2021, Calendar.JANUARY, 8, 3, 33),
                new GregorianCalendar(2021, Calendar.DECEMBER, 2, 11, 41),
                2600.0);
        store.add(employee1);
        store.add(employee2);
        store.add(employee3);
        store.add(employee4);
        Report engine = new JsonReportEngine(store);
        String ex = """
                [
                  {
                    "name": "John Doe",
                    "hired": "08:06:2023 17:41",
                    "fired": "08:06:2023 17:41",
                    "salary": 5000.0
                  },
                  {
                    "name": "Jane Smith",
                    "hired": "08:06:2023 17:41",
                    "fired": "08:06:2023 17:41",
                    "salary": 6000.0
                  }
                ]""";
        assertThat(engine.generate(em -> em.getSalary() >= 5000)).isEqualTo(ex);
    }
}