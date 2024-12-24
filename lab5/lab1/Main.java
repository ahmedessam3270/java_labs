import lab1Package.*;

public class Main {
    public static void main(String[] args) {
        String string1 = "Ahmed";
        String string2 = "Essam";
        String longer = StringUtils.betterString(string1, string2, (s1, s2) -> s1.length() > s2.length());
        String first = StringUtils.betterString(string1, string2, (s1, s2) -> true);
        System.out.println("The longer string is: " + longer);
        System.out.println("The first string is: " + first);
    }
}