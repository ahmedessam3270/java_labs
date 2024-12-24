package lab1Package;

public class StringUtils {
    public static String betterString(String s1, String s2, Compare test ){
        return test.isBetter(s1, s2) ? s1: s2;
    }   
}
