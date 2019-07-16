package ru.otus.l62.cache;

import java.util.List;

/**
 * @author sergey
 * created on 14.08.18.
 */
public final class Data {
    private final int id;
    private final List<String> values;

    Data(int id, List<String> values) {
        this.id = id;
        this.values = values;
    }

    int getId() {
        return id;
    }

    List<String> getValues() {
        return values;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", values=" + values +
                '}';
    }
}
