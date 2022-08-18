package lesson21;

import patPerson.ApiPerson;
import patPerson.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lesson21DZ {
    public static void main(String[] args) throws IOException, InterruptedException {
        ApiPerson api = new ApiPerson();
        ArrayList<Person> people = api.getApiPersonFromRequest(100);
        //запросить 100 людей
        //раскидать их по листам
        List<Person> male;
        male = people.stream()
                .filter(person -> person.getGender().equals("male"))
                .collect(Collectors.toList());
        System.out.println(male);
        System.out.println("___________");

        List<Person> female;
        female = people.stream()
                .filter(person -> person.getGender().equals("female"))
                .collect(Collectors.toList());
        System.out.println(female);
        // по регионам динамические

    }
}
