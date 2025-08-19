package module2.lesson1;

public class Person {
    String fio;
    String address;

    public Person (String fio, String address) {
        this.fio = fio;
        this.address = address;

    }

    @Override
    public String toString() {
        return "Person{" +
                "fio='" + fio + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
