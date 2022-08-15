package patPerson;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ApiPerson api = new ApiPerson();
        ArrayList<Person> persons = new ArrayList<>();
        try {
            long l = System.currentTimeMillis();
            persons = api.getApiPersonFromRequest(10);
            System.out.println(persons);
            System.out.println(System.currentTimeMillis()-l);
        } catch (Exception e) {
            e.printStackTrace();

        }

        System.out.println();

        // так как нет реализации метода проверки в инт Proverka, для этого самый простой способ
        // создать анонимный класс как и там он переопределится
        // сделать это можно 2 способами обычный и лямбда
        // так как мы фильтруем по возрасту то и проверку делаем по возрасту
//        PersonSort.filter(persons, new Proverka<Person>() {
//            @Override
//            public boolean test(Person person) {
//                return LocalDateTime.now().getYear() - person.getDob().getYear() > 40;
//            }
//        });
        // лямбда )
//        PersonSort.filter(persons,person ->{
//            return LocalDateTime.now().getYear() - person.getDob().getYear() > 40;
//        } );


    }
}
