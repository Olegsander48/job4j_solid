package ru.job4j.ood.tdd;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import java.util.Calendar;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

@Disabled("Тесты отключены. Удалить аннотацию после реализации всех методов по заданию.")
class CinemaTest {
    @Test
    void whenBuyThenGetTicket() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket).isEqualTo(new Ticket3D());
    }

    @Test
    void whenAddSessionThenItExistBetweenAllSessions() {
        Cinema cinema = new Cinema3D();
        Session session = new Session3D();
        cinema.add(session);
        List<Session> sessions = cinema.find(data -> true);
        assertThat(sessions).contains(session);
    }

    @Test
    void whenBuyOnInvalidRowThenGetException() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        assertThatThrownBy(() -> cinema.buy(account, -1, 1, date))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenBuyOnInvalidDateThenGetException() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(1969, 1, 1);
        assertThatThrownBy(() -> cinema.buy(account, -1, 1, date))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenBuyWithoutAccountThenGetException() {
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(1969, 1, 1);
        assertThatThrownBy(() -> cinema.buy(null, -1, 1, date))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenNoSessionsThenSessionListIsEmpty() {
        Cinema cinema = new Cinema3D();
        List<Session> sessions = cinema.find(data -> true);
        assertThat(sessions).isEmpty();
    }

    @Test
    void whenFindByNonExistingFilmThenSessionListIsEmpty() {
        Cinema cinema = new Cinema3D();
        Session session = new Session3D();
        cinema.add(session);
        List<Session> sessions = cinema.find(data -> false);
        assertThat(sessions).isEmpty();
    }
}