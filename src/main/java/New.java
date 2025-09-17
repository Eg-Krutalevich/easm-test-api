import lombok.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
class Person {
    String name;
    int age;

}

public class New {

    public static List<String> func(List<Person> personList) {
        return personList.stream()
                .filter(str -> !str.getName().endsWith("w"))
                .sorted(Comparator.comparingInt(Person::getAge).reversed())
                .map(x -> x.getName().toUpperCase())
                .distinct()
                .toList();
    }

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("new", 9));
        persons.add(new Person("new6", 89));
        persons.add(new Person("new89", 13));
        persons.add(new Person("new5", 81));

        System.out.println(func(persons));
    }

    private void a() {

    }
}