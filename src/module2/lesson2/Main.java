package module2.lesson2;

import module2.lesson1.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Person> myPersonClass = Person.class;
        System.out.println(Arrays.toString(myPersonClass.getConstructors()));
        Constructor myPersonConstr = myPersonClass.getConstructors()[0];
        System.out.println(myPersonConstr.getName());
        myPersonConstr.newInstance(Person.class, "", "");
    }
}
