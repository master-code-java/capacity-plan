package com.caceis.capacityplan.utils;

public class BooleanUtils {

    public static int toInt(Boolean value){
        return value ? 1 : 0;
    }

    public static boolean toBoolean(Integer value){
        return value.equals(1);
    }

}
