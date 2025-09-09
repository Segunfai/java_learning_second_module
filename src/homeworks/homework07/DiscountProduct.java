package homeworks.homework07;

import java.time.LocalDate;

public class DiscountProduct extends Products1 {
    //Объявляем характеристики дополненного класса
    private Products1 products1;
    private double discount;
    private LocalDate discountExDate;

    //Задаем те же характеристики, что и у простых продуктов
    public DiscountProduct(String naimenovanie, int cost, double discount, int discDays) {
        super(naimenovanie, cost);

        /*
        Убрал проверки, так как они уже выполняются в рамках класса Products1
        Добавил проверки на скидки
         */
        if (discount <0 || discount > 100) {
            throw new IllegalArgumentException("Скидка должна быть в размере от нуля до ста процентов");
        }

        if (discDays <= 0) {
            throw new IllegalArgumentException("Количество скидочных дней должно быть больше 0");
        }

        this.discount =discount;
        this.discountExDate = LocalDate.now().plusDays(discDays);

    }

    //Добавление метода для проверки цены скидочного продукта
    public double getDiscCost() {
        if (isDiscValid()) {
            return getCost() * (1 - discount / 100);
        }
        return getCost();
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
        return LocalDate.now().isBefore(discountExDate);
    }

    @Override
    public String toString() {
        return "Продукт " + getNaimenovanie() +
                " со скидкой " + discount +
                "% стоит " + getCost() +
                ", скидка действует до " + discountExDate;
    }
}
