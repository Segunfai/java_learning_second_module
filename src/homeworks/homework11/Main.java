package homeworks.homework11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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

    //1 способ, Добавляем входные данные в список
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
    /*
    //2 способ с добавлением данных из файла (добавил после просмотра консультации)
    public void main(String[] args) throws IOException {

        try {
            Files.lines(Paths.get("D:\\desktop\\Homeworks\\Homework11\\input_data.txt"))
                    .map(line -> line.split("\\|"))
                    .forEach(parts -> {
                        if(parts.length >= 5) {
                            vehicles.add(new Automobile(
                                    parts[0], parts[1], parts[2],
                                    Integer.parseInt(parts[3]), (int) Long.parseLong(parts[4])
                            ));
                        }
                    });
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e);
        }
     */
    /*
    Реализация фильтра для задания 1 - Номера всех автомобилей, имеющих заданный в переменной цвет
    colorToFind или нулевой пробег mileageToFind
    */
    public String getVehiclesByColorOrMileage(String colorToFind, Long mileageToFind) {
        return vehicles.stream()
                .filter(vehicle -> vehicle.getColor().equals(colorToFind) || vehicle.getMileage().equals(mileageToFind.intValue()))
                .map(Automobile::getVehicleNumber)
                .collect(Collectors.joining(" "));
    }

    /*
    Реализация фильтра для задания 2 - Количество уникальных моделей в ценовом диапазоне от n до m тыс.
     */
    public long getUniqueModelsInCostRange (long minPrice, long maxPrice) {
        return vehicles.stream()
                .filter(vehicle -> vehicle.getCost() >= minPrice && vehicle.getCost() <= maxPrice)
                .map(Automobile::getModel)
                .distinct()
                .count();
    }

    /*
    Реализация задания 3 - Вывести цвет автомобиля с минимальной стоимостью
     */

    public String getColorOfLowCostVehicle() {
        return vehicles.stream()
                .min((vehicle1, vehicle2) -> vehicle1.getCost().compareTo(vehicle2.getCost()))
                .map(Automobile::getColor)
                .orElse("Не найдено");
    }

    public static void main(String[] args) {

        Main main = new Main();
        //Выводим все автомобили в базе
        main.printAllVehicles();
        System.out.println();


        //Задаем поля для фильтра по заданию 1
        String colorToFind = "Black";
        Long mileageToFind = 0L;

        //Выводим результат задания 1
        String resultTask1 = main.getVehiclesByColorOrMileage(colorToFind, mileageToFind);
        System.out.println("Номера автомобилей по цвету или пробегу: " + resultTask1);

        //Задаем фильтры для задания 2
        Long minPrice = 700_000L;
        Long maxPrice = 800_000L;

        //Выводим результат второго задания
        long resultTask2 = main.getUniqueModelsInCostRange(minPrice, maxPrice);
        System.out.println("Уникальные автомобили: " + resultTask2);

        //Выводим результат задания 3
        String resultTask3 = main.getColorOfLowCostVehicle();
        System.out.println("Цвет автомобиля с минимальной стоимостью: " + resultTask3);

    }

}
