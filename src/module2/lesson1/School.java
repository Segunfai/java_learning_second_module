package module2.lesson1;

public class School {
    private final String title;
    private final String address;

    public School(String title, String address) {
        this.address = address;
        this.title = title;
    }

    @Override
    public String toString() {
        return "School{" +
                "title='" + title + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
