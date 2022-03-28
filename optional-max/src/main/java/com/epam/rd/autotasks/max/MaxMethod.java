package com.epam.rd.autotasks.max;

import java.util.OptionalInt;

public class MaxMethod {
    public static OptionalInt max(int[] values) {
        OptionalInt result;
        if (values == null || values.length == 0) result = OptionalInt.empty();
        else {
            int max = values[0];
            for (int elem: values) {
                if (elem > max) max = elem;
            }
            result = OptionalInt.of(max);
        }
        return result;

    }
}
