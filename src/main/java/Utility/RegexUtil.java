package Utility;

import java.util.regex.Pattern;

public class RegexUtil {
    public boolean isNameValid(String input){
        boolean checkCondition = Pattern.matches(ERegexPattern.NAME_PATTERN.getValue(),input);
        return checkCondition;
    }
    public boolean isPasswordValid(String input){
        boolean checkCondition = Pattern.matches(ERegexPattern.PASSWORD_PATTERN.getValue(),input);
        return checkCondition;
    }

}