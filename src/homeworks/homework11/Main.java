package homeworks.homework11;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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
        vehicles.add(new Automobile("b873of", "Volga", "Black", 0, 673000));
        vehicles.add(new Automobile("w487mn", "Lexus", "Grey", 76000, 900000));
        vehicles.add(new Automobile("p987hj", "Volga", "Red", 610, 704340));
        vehicles.add(new Automobile("c987ss", "Toyota", "White", 254000, 761000));
        vehicles.add(new Automobile("o983op", "Toyota", "Black", 698000, 740000));
        vehicles.add(new Automobile("p146op", "BMW", "White", 271000, 850000));
        vehicles.add(new Automobile("u893ii", "Toyota", "Purple", 210900, 440000));
        vehicles.add(new Automobile("l097df", "Toyota", "Black", 108000, 780000));
        vehicles.add(new Automobile("y876wd", "Toyota", "Black", 160000, 1000000));
    }

    //Пробный вывод списка
    public void printAllVehicles() {
        System.out.println("Автомобили в базе: ");
        System.out.printf("%-8s %-10s %-8s %-8s %s%n", "Number", "Model", "Color", "Mileage", "Cost");
        vehicles.forEach(System.out::println);
    }

    //Создаем метод для вывода списка
    public static void main(String[] args) {
        Main main = new Main();

        main.printAllVehicles();
        System.out.println();
    }

}
