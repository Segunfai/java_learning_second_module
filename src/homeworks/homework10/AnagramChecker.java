package homeworks.homework10;

import java.util.Arrays;
import java.util.Scanner;

public class AnagramChecker {

    /**
     * @param s первая строка
     * @param t вторая строка
     * @return true если строки являются анаграммами, иначе false
     */
    public static boolean isAnagram(String s, String t) {
        // Удаляем пробелы и приводим к нижнему регистру для регистронезависимого сравнения
        String s1 = s.replaceAll("\\s", "").toLowerCase();
        String t1 = t.replaceAll("\\s", "").toLowerCase();

        // Если длины разные - не могут быть анаграммами
        if (s1.length() != t1.length()) {
            return false;
        }

        // Преобразуем строки в массивы символов и сортируем
        char[] sArray = s1.toCharArray();
        char[] tArray = t1.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);

        // Сравниваем отсортированные массивы
        return Arrays.equals(sArray, tArray);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите первую строку:");
        String s = scanner.nextLine();

        System.out.println("Введите вторую строку:");
        String t = scanner.nextLine();

        boolean result = isAnagram(s, t);
        System.out.println("Результат: " + result);
    }
}
