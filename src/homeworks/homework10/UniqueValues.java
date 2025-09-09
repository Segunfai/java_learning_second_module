package homeworks.homework10;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class UniqueValues {

    /**
     * Метод возвращает набор уникальных элементов из переданного ArrayList
     * @param list входной список элементов
     * @return Set уникальных элементов
     */
    public static <T> Set<T> getUniqueValues(ArrayList<T> list) {
        // Используем HashSet для автоматического удаления дубликатов
        return new HashSet<>(list);
    }

    // Пример использования
    public static void main(String[] args) {
        // Тестируем с целыми числами
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(2);
        numbers.add(1);
        numbers.add(4);

        Set<Integer> uniqueNumbers = getUniqueValues(numbers);
        System.out.println("Уникальные числа: " + uniqueNumbers);

        // Тестируем со строками
        ArrayList<String> words = new ArrayList<>();
        words.add("apple");
        words.add("banana");
        words.add("apple");
        words.add("orange");
        words.add("banana");

        Set<String> uniqueWords = getUniqueValues(words);
        System.out.println("Уникальные слова: " + uniqueWords);

        // Тест с пустым списком
        ArrayList<String> emptyList = new ArrayList<>();
        Set<String> emptyResult = getUniqueValues(emptyList);
        System.out.println("Пустой список: " + emptyResult); // []

        // Тест с null значениями
        ArrayList<Integer> listWithNull = new ArrayList<>();
        listWithNull.add(1);
        listWithNull.add(null);
        listWithNull.add(2);
        listWithNull.add(null);
        Set<Integer> nullResult = getUniqueValues(listWithNull);
        System.out.println("С null значениями: " + nullResult); // [null, 1, 2]
    }
}
