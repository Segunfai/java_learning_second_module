package module2.lesson1;

public class Student extends Person {
    private School school;
    public Student(String fio, String address, School school) {
        super(fio, address);
        this.school = school;

    }

    @Override
    public String toString() {
        return "Student{" +
                "school=" + school +
                ", fio='" + fio + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
