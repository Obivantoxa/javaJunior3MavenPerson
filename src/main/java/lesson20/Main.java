package lesson20;

import patPerson.ApiPerson;
import patPerson.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        ApiPerson api = new ApiPerson();
        ArrayList<Person> people = api.getApiPersonFromRequest(5);


        people.stream()
                .map(p -> p.getCountry())
                .forEach(System.out::println);
        System.out.println();

//        people.stream().map(p -> p.getCountry())
//                .filter(country -> country.equals("Turkey"))
//                .forEach(System.out::println);
//        System.out.println();
//        people.stream().map(p -> "Country: " + p.getCountry() + p.getFirstname())
//                .forEach(System.out::println);
//        ;
//        System.out.println();
//        people.stream()
//                .filter(p -> p.getDob().getYear() < 1980)
//                .forEach(System.out::println);
//        System.out.println();

        Stream.of(1, 2, 3, 4, 5, 6).reduce((count, n) -> count + n).ifPresent(System.out::println);//сумма чисел

        Integer reduce = Stream.of(1, 2, 3, 4, 5, 6).reduce(0, (count, n) -> count + n);//сумма чисел

        Stream.of(1, 2, 3, 4, 5, 6).reduce((count, n) -> count++);//количество  чисел в стриме


        people.stream()
                .sorted((p, p1) -> {
                    if (p.getFirstname().compareTo(p1.getFirstname()) != 0) {
                        return p.getFirstname().compareTo(p1.getFirstname());
                    } else if (p.getLastname().compareTo(p1.getLastname()) != 0) {
                        return p.getLastname().compareTo(p1.getLastname());
                    }else {
                        return p.getDob().compareTo(p1.getDob());
                    }
                }).forEach(System.out::println);
        Stream.of(1, 1,2, 2,3, 3, 4, 5, 6)
                .distinct()
                .forEach(System.out::println);
    }

}
