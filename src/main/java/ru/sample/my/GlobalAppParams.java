package ru.sample.my;

import java.util.Properties;

public class GlobalAppParams {
    public static void main(String[] args) {
        //PropertyEnum propertyEnum = PropertyEnum.FIRST;

        Properties properties = new Properties();

        properties.setProperty("first", "value1");
        properties.setProperty("second", "value2");

        PropertyApp.setProperties(properties);

        System.out.println(PropertyApp.PropertyEnum.FIRST.getPropertyValue());
        System.out.println(PropertyApp.PropertyEnum.SECOND.getPropertyValue());
        System.out.println(PropertyApp.PropertyEnum.THIRD.getPropertyValue());
    }
}

class PropertyApp {
    private static Properties properties = new Properties();

    enum PropertyEnum implements PropertyAsEnum {
        FIRST("first"),
        SECOND("second"),
        THIRD("third");

        private final String propertyName;
        //private Properties propertySource;


        PropertyEnum(String propertyName) {
            this.propertyName = propertyName;
        }

        public Object getPropertyValue() {
            return properties.get(propertyName);
        }
    }

    static void setProperties(Properties properties) {
        PropertyApp.properties = properties;
    }

    private PropertyApp() {
    }
}

interface PropertyAsEnum<T> {
    T getPropertyValue();
}
//
//enum PropertyEnum implements PropertyAsEnum  {
//    FIRST("first",),
//    SECOND("second");
//
//    private final String propertyName;
//    private Properties propertySource;
//
//
//    PropertyEnum(String propertyName, PropertyApp propertySource) {
//        this.propertyName = propertyName;
//    }
//}
