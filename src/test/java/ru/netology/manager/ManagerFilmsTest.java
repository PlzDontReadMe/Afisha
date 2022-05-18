package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;

import static org.junit.jupiter.api.Assertions.*;

class ManagerFilmsTest {
    private final ManagerFilms manager = new ManagerFilms();
    private final ManagerFilms manager1 = new ManagerFilms(5);

    @Test
    void findAll() {
        Film film = new Film(1, "Бладшот");
        Film film1 = new Film(2, "Вперед");
        Film film2 = new Film(3, "Вперед2");
        Film film3 = new Film(4, "Вперед3");
        Film film4 = new Film(5, "Вперед4");
        Film film5 = new Film(6, "Вперед5");
        Film film6 = new Film(7, "Вперед6");
        manager.add(film);
        manager.add(film1);
        manager.add(film2);
        manager.add(film3);
        manager.add(film4);
        manager.add(film5);
        manager.add(film6);
        manager.findAll();
        assertArrayEquals(new Film[]{film6, film5, film4, film3, film2, film1, film}, manager.findAll());

    }

    @Test
    void findLastOverLimit() {
        Film film = new Film(1, "Бладшот");
        Film film1 = new Film(2, "Вперед");
        Film film2 = new Film(3, "Вперед2");
        Film film3 = new Film(4, "Вперед3");
        Film film4 = new Film(5, "Вперед4");
        Film film5 = new Film(6, "Вперед5");
        Film film6 = new Film(7, "Вперед6");
        manager1.add(film);
        manager1.add(film1);
        manager1.add(film2);
        manager1.add(film3);
        manager1.add(film4);
        manager1.add(film5);
        manager1.add(film6);
        manager1.findLast();
        assertArrayEquals(new Film[]{film6, film5, film4, film3, film2}, manager1.findLast());

    }

    @Test
    void findLastBelowLimit() {
        Film first = new Film(1, "Бладшот");
        Film second = new Film(2, "Вперед");
        manager.add(first);
        manager.add(second);
        manager.findLast();
        assertArrayEquals(new Film[]{second, first}, manager.findLast());
    }

    @Test
    void findAllNoFilms() {

        manager.findAll();
        assertArrayEquals(new Film[]{}, manager.findAll());

    }
}
