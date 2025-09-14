package homeworks.homework11;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    //Создаем список автомобилей
    private List<Automobile> vehicles;

    //Создаем констуктор
    public Main () {
        this.vehicles = new ArrayList<>();
        initializeVehicles();
    }

    //Добавляем входные данные в список
    private void initializeVehicles () {
        vehicles.add(new Automobile("a123me", "Mercedes", "White", 0, 8300000));

    }

    //Пробный вывод списка
    public void printAllVehicles() {
        System.out.println("Автомобили в базе: ");
        System.out.printf("%-8s %-10s %-8s %-8s %s%n", "Number", "Model", "Color", "Mileage", "Cost");
        vehicles.forEach(System.out::println);
    }

}
