package module2.lesson1;

public class Main {
    public static void main(String[] args) {
        School school = new School("Школа программирования", "г. Виртуальности, ул. Линуса Торвальдса");
        Person user = new Student("Сергей Брин", "г. Начинания, 234", school);
        System.out.println(user);
    }
}
