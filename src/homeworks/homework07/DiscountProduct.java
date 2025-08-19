package homeworks.homework07;

import java.time.LocalDate;

public class DiscountProduct extends Products1 {
    //Объявляем характеристики дополненного класса
    private Products1 products1;
    private double discount;
    private LocalDate discountExDate;

    //Задаем те же характеристики, что и у простых продуктов
    public DiscountProduct(String naimenovanie, int cost, double discount) {
        super(naimenovanie, cost);

        //Убрал проверки, так как они уже выполняются в рамках класса Products1

    }
    //Добавляем дату истечения скидки
    public void setDiscountExDate (LocalDate exDate) {
        this.discountExDate = exDate;
    }

    public LocalDate getDiscountExDate() {
        return discountExDate;
    }

    //Добавляем метод для назначения количества дней скидки
    public void setDiscountDays (double discount, int discDays) {
        this.discount = discount;
        this.discountExDate = LocalDate.now().plusDays(discDays);
    }

    //Проверка на действие скидки
    public boolean isDiscValid () {
        return discount > 0 && LocalDate.now().isBefore(discountExDate);
    }

    //Добавление метода для проверки цены скидочного продукта
    public double getDiscCost() {
        if (isDiscValid()) {
            return cost * (1 - discount / 100);
        }
        return cost;
    }
}
