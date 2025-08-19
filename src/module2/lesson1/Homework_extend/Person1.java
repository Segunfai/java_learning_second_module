package module2.lesson1.Homework_extend;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person1 {
    //Объявляем характеристики человека
    private final String name;
    private int money;
    private final List<Products1> produkty;

    //Объявляем конструктор
    public Person1 (String name, int money) {
        //Проверка на пустое значение и меньше 3 символов
        if (name == null || name.isEmpty() || name.length() < 3) {
            //Как и в случае с классом Products, выводим ошибку, чтобы объект не создавался
            throw new IllegalArgumentException("Имя не может быть пустым и должно содержать не меньше 3х символов!");
        }
        //Проверка на отрицательное количество денег
        if (money<0) throw new IllegalArgumentException("Количество денег не может быть отрицательным!");
        //Инициализация полей и пустого списка покупок
        this.name = name;
        this.money = money;
        this.produkty = new ArrayList<>();

    }

    //Генерируем геттеры
    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }
    //Получаем пустой список покупок - корзину
    public List<Products1> getProdukty() {
        return produkty;
    }

    //Добавляем метод покупки продуктов
    public void pokupka(Products1 pokupka) {
        //Проверка на null
        if (pokupka == null)  {
            throw new IllegalArgumentException("Продукт не может быть несуществующим или null");
        }
        //Если средств хватает, то добавляем продукт в список
        if (money >= pokupka.getCost()) {
            produkty.add(pokupka);
            //Уменьшаем количество денег на стоимость продуктв
            money -= pokupka.getCost();
            //Выводим сообщение о покупке
            System.out.println(name + " купил " + pokupka.getNaimenovanie());
        } else {
            //Либо сообщение, что человек не может купить продукт
            System.out.println(name + " не может позволить себе " + pokupka.getNaimenovanie());
        }
    }

    //Добавлен метод для возвращения человека и его средств
    public String getMoneyInfo() {
        return name + " = " + money + " руб.)";
    }

    //Добавляем переопределение в строку для человека, который ничего не купил
    @Override
    public String toString() {
        if (produkty.isEmpty()) {
            return name + " - Ничего не куплено";
        }
        String result = produkty.toString();
        return name + " - " + result.substring(1, result.length()-1);
    }
    // Переопределение equals() и hashCode()
    public boolean equals(Object produkt_obj) {
        if (this == produkt_obj) return true;
        if (produkt_obj == null || getClass() != produkt_obj.getClass()) return false;
        Person1 person = (Person1) produkt_obj;
        return money == person.money && Objects.equals(name, person.name);
    }
    //Переопределяем хэшкоды с теми же полями, что и в сравнении
    @Override
    public int hashCode() {
        return Objects.hash(name, money);
    }
}
