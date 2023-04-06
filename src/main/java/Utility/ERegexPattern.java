package Utility;

public enum ERegexPattern {
    NAME_PATTERN("^[A-Z][A-Za-z]{3}$"),
    PASSWORD_PATTERN("^[A-Z][a-z]{1,7}[!@#$%^&*][0-9]{1,}$");
    String constant;
    private ERegexPattern(String constant){
        this.constant = constant;
    }
    public String getValue(){
        return constant;
    }
}
