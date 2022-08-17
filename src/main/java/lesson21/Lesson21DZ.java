package lesson21;

import patPerson.ApiPerson;
import patPerson.Person;

import java.io.IOException;
import java.util.ArrayList;

public class Lesson21DZ {
    public static void main(String[] args) throws IOException, InterruptedException {
        ApiPerson api = new ApiPerson();
        ArrayList<Person> people = api.getApiPersonFromRequest(5);


    }
}
