package lesson21;

import patPerson.ApiPerson;
import patPerson.Person;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

//        List.of(1, 2, 3);
//        Stream.of(1, 2, 3, 4);
//        IntStream
//                .range(0, 100)
//                .limit(50) // ограничить
//                .skip(10)
//                .forEach(System.out::println); //промежуток

        ApiPerson api = new ApiPerson();
        ArrayList<Person> peoples = api.getApiPersonFromRequest(10);

//        Optional<Integer> max = peoples.stream()
//                .map(m -> LocalDate.now().getYear() - m.getDob().getYear())
//                .max((integer, anotherInteger) -> integer.compareTo(anotherInteger));
//        System.out.println(max);
//        Random random = new Random();
//
//        IntStream
//                .generate(()->random.nextInt(100))
//                .limit(10)
//                .forEach(System.out::println);
//        IntStream
//                .concat(IntStream.of(1,2,3),IntStream.of(3,4,5))
//                .forEach(System.out::println);
//
        peoples.stream()
                .sorted(Comparator.comparing(Person::getCountry)
                        .thenComparing(Person::getFirstname)
                        .thenComparing(Person::getLastname))
                .forEach(System.out::println);

        peoples.stream()
                .sorted(Comparator.comparing(Person::getGender).thenComparing(Person::getFirstname).thenComparing(Person::getLastname)).forEach(System.out::println);

        String collect = peoples.stream()
                .map(m -> m.getLastname() + m.getDob().getYear())
                .collect(Collectors.joining("@gmail.com ","","@gmail.com"));

        System.out.println(collect);
    }
}
