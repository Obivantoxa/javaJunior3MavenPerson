package lesson21;

import patPerson.ApiPerson;
import patPerson.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main1 {

    public static void main(String[] args) throws IOException, InterruptedException {

        ApiPerson api = new ApiPerson();
        ArrayList<Person> people = api.getApiPersonFromRequest(5);

        ArrayList<Integer> i = new ArrayList<>();

        CopyOnWriteArrayList i2 = new CopyOnWriteArrayList();
        CopyOnWriteArrayList i3 = new CopyOnWriteArrayList();
        long l = System.currentTimeMillis();
        IntStream.range(0, 10_000).parallel().forEach(i::add);
        System.out.println(System.currentTimeMillis()-l);
        System.out.println(i.size());

    }
}
