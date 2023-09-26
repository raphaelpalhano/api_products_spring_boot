package com.myecommerce.store.utils;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSubstitutor {
    private static final String VARIABLE_PATTERN = "\\$\\{([^}]*)\\}";

    public static String replace(String input, Map<String, Object> keywords) {
        if (input == null || keywords == null) {
            return input;
        }

        Pattern pattern = Pattern.compile(VARIABLE_PATTERN);
        Matcher matcher = pattern.matcher(input);

        StringBuffer result = new StringBuffer();

        while (matcher.find()) {
            String variable = matcher.group(1);
            Object replacement = keywords.get(variable);

            if (replacement != null) {
                matcher.appendReplacement(result, Matcher.quoteReplacement(replacement.toString()));
            }
        }

        matcher.appendTail(result);

        return result.toString();
    }
}
