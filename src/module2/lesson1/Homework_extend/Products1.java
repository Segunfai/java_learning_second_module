package module2.lesson1.Homework_extend;

import java.util.Objects;

public class Products1 {
    //Объявляем характеристики
    private String naimenovanie;
    private int cost;
    //Объявляем конструктор
    public Products1 (String naimenovanie, int cost) {
        //Проверяем названия на пустоту и деньги на отрицательное значение
        if (naimenovanie == null || naimenovanie.isEmpty()) {
            //Используем именно эту конструкцию для того, чтобы объект не создавался, а не просто вывод сообщения в консоль
            throw new IllegalArgumentException("Название продукта не может быть пустым или содержать меньше 3х символов!");
        }
        //Добавил проверку на содержание только цифр в наименовании обычного продукта
        if (naimenovanie != null && naimenovanie.matches("\\d+")) {
            throw new IllegalArgumentException("Наименование не может состоять только из цифр!");
        }
        if (cost < 0) {
            throw new IllegalArgumentException("Цена продукта не может быть отрицательной!");
        }
        this.naimenovanie = naimenovanie;
        this.cost = cost;
    }
    //Генерируем геттеры
    public String getNaimenovanie() {
        return naimenovanie;
    }

    public int getCost() {
        return cost;
    }

    //Переопределяем все в строку
    @Override
    public String toString() {
        return naimenovanie;
    }
    //Сравниваем значения
    @Override
    public boolean equals(Object obj) {
        //Если один и тот объект, то истина
        if (this == obj) return true;
        //Проверка на null и объект другого класса
        if (obj == null || getClass() != obj.getClass()) return false;
        //Приведение к типу конструктора Products
        Products1 product = (Products1) obj;
        //Финальное сравнение на стоимость и наименование
        return cost == product.cost && Objects.equals(naimenovanie, product.naimenovanie);
    }
    // Генерируем хеш-код на основе полей
    @Override
    public int hashCode() {
        return Objects.hash(naimenovanie, cost);
    }
}
