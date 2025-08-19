package module2.lesson1.Homework_extend;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class App1 {
    public static void main(String[] args) {
        Scanner magaz = new Scanner(System.in);
        List<Person1> lyudi = new ArrayList<>();
        List<Products1> spisokpokupok  = new ArrayList<>();

        // System.out.println("Введите Имя покупателя и количество его денег в формате 'Имя = деньги; Имя = деньги'. \nДля завершения программы введите 'END'.");
        /* Моя изначальная версия
        while (true) {
            String vvod = magaz.nextLine();
            if (vvod.equals("END")) break;

            String[] razdelenie = vvod.split(" = ");
            String imya = razdelenie[0];
            int dengi = Integer.parseInt(razdelenie[1]);

            lyudi.add(new Person(imya, dengi));
        }
        */

        // Дополнение от нейросети по формату "Имя = деньги"
        System.out.println("Введите покупателей в формате 'Имя = деньги; Имя = деньги'. \nДля завершения введите 'END'.");
        while (true) {
            String vvod = magaz.nextLine();
            if (vvod.equals("END")) break;

            // Разделяем строку по ";"
            String[] ekzy = vvod.split(";");
            for (String ekz : ekzy) {
                try {
                    ekz = ekz.trim();  // Удаляем лишние пробелы
                    if (ekz.isEmpty()) continue;  // Пропускаем пустые части

                    String[] razdelenie = ekz.split(" = ");
                    if (razdelenie.length != 2) {
                        System.out.println("Ошибка формата! Используйте 'Имя = деньги'");
                        continue;
                    }

                    String imya = razdelenie[0].trim();
                    int dengi = Integer.parseInt(razdelenie[1].trim());
                    lyudi.add(new Person1(imya, dengi));

                } catch (NumberFormatException e) {
                    System.out.println("Ошибка! Деньги должны быть числом: " + ekz);
                } catch (Exception e) {
                    System.out.println("Ошибка ввода: " + e.getMessage());
                }
            }
        }

        System.out.println("Введите продукты в формате 'Наименование = стоимость; Наименование = стоимость'. \nДля завершения введите 'END'.");
        while (true) {
            String vvod = magaz.nextLine();
            if (vvod.equals("END")) break;

            String[] produkty = vvod.split(";");
            for (String produkt : produkty) {
                try {
                    produkt = produkt.trim();
                    if (produkt.isEmpty()) continue;

                    String[] razdelenie = produkt.split(" = ");
                    if (razdelenie.length != 2) {
                        System.out.println("Ошибка формата! Используйте 'Наименование = стоимость'");
                        continue;
                    }

                    String nazvanie = razdelenie[0].trim();
                    int cena = Integer.parseInt(razdelenie[1].trim());
                    spisokpokupok.add(new Products1(nazvanie, cena));

                } catch (NumberFormatException e) {
                    System.out.println("Ошибка! Цена должна быть числом: " + produkt);
                }
            }
        }

        System.out.println("Введите покупки в формате 'Имя - Наименование' через разделитель или построчно.\nДля завершения введите 'END'.");
        while (true) {
            String vvod = magaz.nextLine().trim();  // trim сразу при чтении

            if (vvod.equals("END")) break;
            if (vvod.isEmpty()) continue;  // Пропускаем пустые строки

            // Разделяем покупки с поддержкой разных форматов ввода
            String[] pokupki = vvod.contains(";") ? vvod.split(";") : new String[]{vvod};

            for (String pokupka : pokupki) {
                try {
                    pokupka = pokupka.trim();
                    if (pokupka.isEmpty()) continue;

                    // Улучшенная проверка формата

                    if (pokupka.contains(" ") && !pokupka.contains(" - ")) {
                        System.out.println("Ошибка формата! Используйте 'Имя - Наименование'. Введено: '" + pokupka + "'");
                        continue;
                    }

                    if (!pokupka.contains(" - ")) {
                        System.out.println(pokupka + " ничего не купил");
                        continue;
                    }

                    String[] razdelenie = pokupka.split(" - ", 2);  // Разделяем только по первому " - "
                    String imya = razdelenie[0].trim();
                    String naimenovanie = razdelenie.length > 1 ? razdelenie[1].trim() : "";

                    // Для кейса, когда человек ничего не покупает
                    if (naimenovanie.equalsIgnoreCase("ничего") || naimenovanie.equalsIgnoreCase("END")) {
                        System.out.println(imya + " ничего не покупает");
                        continue;
                    }


                    // Поиск покупателя и продукта
                    Person1 person = lyudi.stream()
                            .filter(p -> p.getName().equals(imya))
                            .findFirst()
                            .orElse(null);

                    Products1 product = spisokpokupok.stream()
                            .filter(p -> p.getNaimenovanie().equals(naimenovanie))
                            .findFirst()
                            .orElse(null);

                    if (person == null) {
                        System.out.println("Покупатель '" + imya + "' не найден");
                    } else if (product == null) {
                        System.out.println("Продукт '" + naimenovanie + "' не найден");
                    } else {
                        person.pokupka(product);
                    }

                } catch (Exception e) {
                    System.out.println("Поздравляем! Вы сломали магазин! '" + pokupka + "'. " + e.getMessage());
                }
            }
        }

        // Вывод итогов
        System.out.println("\nРезультаты покупок:\n");
        for (Person1 person : lyudi) {
            System.out.println(person);
        }

        System.out.println("\nСпасибо, что воспользовались нашим симулятором магазина!\nЖдем Вас снова!");
    }
}
