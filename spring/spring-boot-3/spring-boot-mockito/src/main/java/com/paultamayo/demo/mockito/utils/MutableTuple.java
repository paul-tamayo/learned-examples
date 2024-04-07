package com.paultamayo.demo.mockito.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.persistence.Tuple;
import jakarta.persistence.TupleElement;

public class MutableTuple implements Tuple {

    private final List<String> keys = new ArrayList<>();

    private final Map<String, Object> values = new HashMap<>();

    @Override
    public Object get(int i) {
        return values.get(keys.get(i));
    }

    @Override
    public <X> X get(int i, Class<X> type) {
        return type.cast(values.get(keys.get(i)));
    }

    @Override
    public Object get(String alias) {
        return values.get(alias);
    }

    @Override
    public <T> T get(String alias, Class<T> type) {
        return type.cast(values.get(alias));
    }

    @Override
    public <X> X get(TupleElement<X> tupleElement) {
        return get(tupleElement.getAlias(), tupleElement.getJavaType());
    }

    @Override
    public List<TupleElement<?>> getElements() {
        return null;
    }

    public <T> void set(String alias, T value) {
        keys.add(alias);
        values.put(alias, value);
    }

    @Override
    public Object[] toArray() {
        return values.values().toArray();
    }

}