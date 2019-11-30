package main.com.epam.secondtask.action.loading;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LineValidationAction {
    public boolean clientComplianceCheck(String line, Pattern p) {
        Matcher m = p.matcher(line);
        return m.matches();
    }

    public boolean carComplianceCheck(String line, Pattern p) {
        Matcher m = p.matcher(line);
        return m.matches();
    }
}
