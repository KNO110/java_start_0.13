package main.java;

public class StringUtils {
    public static boolean isPalindrome(String s) {
        String clean = s.replaceAll("\\s+", "").toLowerCase();
        return clean.equals(new StringBuilder(clean).reverse().toString());
    }
    public static int countVowels(String s) {
        return (int) s.chars().filter(c -> "аеёиоуыэюяАЕЁИОУЫЭЮЯ".indexOf(c) != -1).count();
    }
    public static int countConsonants(String s) {
        return (int) s.chars().filter(c -> "бвгджзйклмнпрстфхцчшщБВГДЖЗЙКЛМНПРСТФХЦЧШЩ".indexOf(c) != -1).count();
    }
    public static int countWordOccurrences(String text, String word) {
        int count = 0, index = 0;
        while ((index = text.indexOf(word, index)) != -1) {
            count++;
            index += word.length();
        }
        return count;
    }
}
