package module2.lesson1;

public class Person {
    protected String fio;
    protected String address;

    public Person (String fio, String address) {
        this.fio = fio;
        this.address = address;

    }

    protected void sleep(){
        System.out.println("I am sleeping");
    }

    @Override
    public String toString() {
        return "Person{" +
                "fio='" + fio + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
