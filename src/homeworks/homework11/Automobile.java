package homeworks.homework11;

import java.util.ArrayList;
import java.util.List;

public class Automobile {
    //Задаем параметры класса
    private String vehicleNumber;
    private String model;
    private String color;
    private Integer mileage;
    private Integer price;


    //Создаем конструктор
    public Automobile (String vehicleNumber, String model, String color, Integer mileage, Integer price) {
        this.vehicleNumber = vehicleNumber;
        this.model = model;
        this.color = color;
        this.mileage = mileage;
        this.price = price;
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
        return price;
    }



    //Переопределяем данные в строку c форматированием
    @Override
    public String toString() {
        return String.format("%-8s %-10s %-8s %-8d %d",
                vehicleNumber, model, color, mileage, price);
    }


}
