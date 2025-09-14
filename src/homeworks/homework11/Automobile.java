package homeworks.homework11;

import java.util.ArrayList;
import java.util.List;

public class Automobile {
    //Задаем параметры класса
    private String vehicleNumber; //номер автомобиля
    private String model; //Модель (марка)
    private String color; //Цвет
    private Integer mileage; //Пробег
    private Integer cost; //Стоимость (цена)


    //Создаем конструктор
    public Automobile (String vehicleNumber, String model, String color, Integer mileage, Integer cost) {
        this.vehicleNumber = vehicleNumber;
        this.model = model;
        this.color = color;
        this.mileage = mileage;
        this.cost = cost;
    }

    //Генерируем геттеры
    public String getVehicleNumber() {
        return vehicleNumber;
    }
    public String getModel() {
        return model;
    }
    public String getColor() {
        return color;
    }
    public Integer getMileage() {
        return mileage;
    }
    public Integer getPrice() {
        return cost;
    }



    //Переопределяем данные в строку c форматированием, как в просмотре БД
    @Override
    public String toString() {
        return String.format("%-8s %-10s %-8s %-8d %d",
                vehicleNumber, model, color, mileage, cost);
    }


}
