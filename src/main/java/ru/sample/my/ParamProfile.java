package ru.sample.my;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

class ParamProfile<T extends EnumAsProperty, V> {
    private final Map<String, V> source;

    public static <T extends EnumAsProperty, V> ParamProfile<T, V> of(Map<String, V> source) {
        return new ParamProfile<T, V>(source);
    }

    public static <T extends EnumAsProperty, V> ParamProfile<T, V> of(Properties source) {
        Map<String, V> sourceMap = new HashMap<>();
        source.forEach((k, v) -> sourceMap.put((String) k, (V) v));
        return new ParamProfile<T, V>(sourceMap);
    }

    private ParamProfile(Map<String, V> source) {
        this.source = source;
    }

    public V get(T enumValue) {
        return source.get(enumValue.getParamName());
    }
}
