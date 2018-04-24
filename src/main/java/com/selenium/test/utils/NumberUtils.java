package com.selenium.test.utils;

import java.util.Collection;
import java.util.List;
import java.util.Random;

public class NumberUtils {

    public static int getRandomNumberBetween(int low, int high) {
        Random r = new Random();
        if(high < 1) {
            return 0;
        }
        int randomNumber = r.nextInt(high - low) + low;
        return randomNumber;
    }

    public static int getRandomNumberForList(Collection<?> c) {
        int randomNumber = getRandomNumberBetween(0, Math.max(c.size() - 1, 0));
        return randomNumber;
    }
}
