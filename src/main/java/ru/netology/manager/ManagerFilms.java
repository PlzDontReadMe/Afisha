package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Film;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ManagerFilms {

    private Film[] films = new Film[0];
    private int limit = 10;

    public ManagerFilms(int limit) {
        this.limit = limit;
    }

    public void add(Film film) {
        int length = films.length + 1;
        Film[] tmp = new Film[length];
        System.arraycopy(films, 0, tmp, 0, films.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = film;
        films = tmp;
    }


    public Film[] findAll() {
        Film[] result = new Film[films.length];
        for (int i = 0; i < result.length; i++) {
            int index = films.length - i - 1;
            result[i] = films[index];
        }
        return result;
    }

    public Film[] findLast() {
        int result = 0;
        if (films.length <= limit) {
            result = films.length;
        }
        Film[] tmp = new Film[result];
        for (int i = 0; i < result; i++) {
            int index = result - i - 1;
            tmp[i] = films[index];
        }
        return tmp;
    }
}