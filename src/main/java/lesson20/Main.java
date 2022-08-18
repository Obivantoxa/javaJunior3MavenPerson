package lesson20;

import patPerson.ApiPerson;
import patPerson.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        ApiPerson api = new ApiPerson();
        ArrayList<Person> people = api.getApiPersonFromRequest(20);


//        people.stream()
//                .map(p -> p.getCountry())
//                .forEach(System.out::println);
//        System.out.println();
//
////        people.stream().map(p -> p.getCountry())
////                .filter(country -> country.equals("Turkey"))
////                .forEach(System.out::println);
////        System.out.println();
////        people.stream().map(p -> "Country: " + p.getCountry() + p.getFirstname())
////                .forEach(System.out::println);
////        ;
////        System.out.println();
//        people.stream()
//                .filter(p -> p.getDob().getYear() < 1980)
//                .forEach(System.out::println);
//        System.out.println();
//
//        Stream.of(1, 2, 3, 4, 5, 6).reduce((count, n) -> count + n).ifPresent(System.out::println);//сумма чисел
//
//        Integer reduce = Stream.of(1, 2, 3, 4, 5, 6).reduce(0, (count, n) -> count + n);//сумма чисел
//
        Stream.of(1, 2, 3, 4, 5, 6).reduce((count, n) -> count++);//количество  чисел в стриме


//        people.stream()
//                .sorted((p, p1) -> {
//                    if (p.getFirstname().compareTo(p1.getFirstname()) != 0) {
//                        return p.getFirstname().compareTo(p1.getFirstname());
//                    } else if (p.getLastname().compareTo(p1.getLastname()) != 0) {
//                        return p.getLastname().compareTo(p1.getLastname());
//                    } else {
//                        return p.getDob().compareTo(p1.getDob());
//                    }
//                }).forEach(System.out::println);
//
        /*

1)Сортировку по возрасту.
2) посчитать количество людей, которым от 30 до 40 лет.
3) вывести результат по примеру:
Мистер или миссис(* в зависимости от пола) Смит, родом из Канады. 1990 года рождения. Связаться по емейл
         */
        people.stream()
                .sorted((s, s1) -> {
                    if (s.getDob().compareTo(s1.getDob()) != 0) {
                        return s.getDob().compareTo(s1.getDob());
                    } else if (s.getLastname().compareTo(s1.getLastname()) != 0) {
                        return s.getLastname().compareTo(s1.getLastname());
                    } else {
                        return s.getFirstname().compareTo(s1.getFirstname());

                    }
                }).forEach(System.out::println);
        System.out.println("___2 задание");

        Object[] reduce = people.stream()
                .filter(p -> (p.getDob().getYear() >= 1982) && (p.getDob().getYear() <= 1992))
                .map(person -> person.getFirstname()).toArray();
        System.out.println(reduce.length);

        System.out.println("___3задание");
        // не понятно задание
//        people.stream()
//                //.peek(System.out::println)
//
//                .filter(s -> s.getGender().equals("male"))
//                .forEach(System.out::println);


        people.stream()
                .map(person -> {
                            return person.getGender().equals("male") ?
                                    "Mr " + person.getLastname() + person.getCountry() + person.getDob().getYear() + " года рождения " :
                                    "Mrs " + person.getLastname() + person.getCountry() + person.getDob().getYear() + " года рождения ";
                        }
                        )
                .forEach(System.out::println);


//                    +person.getLastname()
//                        +person.getCountry()+person.getDob().getYear()+" года рождения ")}

        //3) вывести результат по примеру:
        //Мистер или миссис(* в зависимости от пола) Смит, родом из Канады. 1990 года рождения. Связаться по емейл


    }
}
