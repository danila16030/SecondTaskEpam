package main.com.epam.secondtask.pattern;

import java.util.regex.Pattern;

public class SetOfPatterns {
    public static final Pattern CAR_PATTERN = Pattern.compile("\\s*(\\-?\\d+\\.?\\d*)\\s*");
    public static final Pattern CLIENT_PATTERN = Pattern.compile( "\\s*(\\-?\\d+\\.?\\d*)\\s+(\\-?\\d+\\.?\\d*)\\s*");

    private SetOfPatterns() {
    }
}
