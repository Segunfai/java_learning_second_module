package module2.lesson1.Homework_extend;

import com.sun.nio.sctp.IllegalReceiveException;

import java.time.LocalDate;

public class DiscountProduct extends Products1 {
    //Объявляем характеристики дополненного класса
    private Products1 products1;
    private double discount;
    private LocalDate discountExDate;

    //Задаем те же характеристики, что и у простых продуктов
    public DiscountProduct(String naimenovanie, int cost) {
        super(naimenovanie, cost);
        //Задаем проверку на название скидочного продукта
        if (naimenovanie == null || naimenovanie.isEmpty()) {
            throw new IllegalArgumentException("Наименование не может быть пустым!");
        }

        if (naimenovanie.length() < 3) {
            throw new IllegalArgumentException("Наименование не может быть короче 3х символов!");
        }
        //Добавляем проверку на содержание только цифр в названии скидочного продукта
        if (naimenovanie != null && naimenovanie.matches("\\d+")) {
            throw new IllegalArgumentException("Наименование не может состоять только из цифр!");
        }


    }

    public void setDiscountExDate (LocalDate exDate) {
        this.discountExDate = exDate;
    }

    public LocalDate getDiscountExDate() {
        return discountExDate;
    }
}
