package ru.sample.my;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class LocalParam {
    public static void main(String[] args) {
        Map<String,String> propertiesMap = new HashMap<>();
        propertiesMap.put("first","value1");
        propertiesMap.put("second","value2");

        Properties properties = new Properties();
        properties.put("first","valueProp1");
        properties.put("second","valueProp2");

        ParamProfile<ParamNames,String> paramProfileProps = ParamProfile.of(properties);

        ParamProfile<ParamNames,String> paramProfileMap = ParamProfile.of(propertiesMap);
        System.out.println(paramProfileMap.get(ParamNames.FIRST));

        System.out.println(paramProfileProps.get(ParamNames.FIRST));

        System.out.println(paramProfileMap.get(ParamNames.SECOND));
        System.out.println(paramProfileMap.get(ParamNames.THIRD));

        System.out.println(paramProfileProps.get(ParamNames.SECOND));
    }
}

enum ParamNames implements EnumAsProperty {
    FIRST("first"),
    SECOND("second"),
    THIRD("third");

    private final String paramName;

    ParamNames(String paramName) {
        this.paramName = paramName;
    }

    public String getParamName() {
        return paramName;
    }
}


