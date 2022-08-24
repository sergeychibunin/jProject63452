package com.storeexample.demo.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StoreExampleUtil {

    private final static Pattern REQUEST_DYNAMIC_FILTER = Pattern.compile("(\\w+?\\.?\\w+?)(:)(\\w+?),");

    public static Matcher getRequestDynamicFilterMatcher(String search) {
        // TODO fix for cyrillic letters
        return REQUEST_DYNAMIC_FILTER.matcher(search + ",");
    }
}
