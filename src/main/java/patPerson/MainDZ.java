package patPerson;

import java.util.ArrayList;

public class MainDZ {

    public static void main(String[] args) {
        // make sorting country
        // make method
        //  вводим число и город  и возвращает данное
        //  количество людей из этого города
        ApiPerson api = new ApiPerson();
        ArrayList<Person> persons = new ArrayList<>();
        try {
            persons = api.getApiPersonFromRequest(10);
            System.out.println(persons);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
        PersonSort.filter(persons, person -> person.getCountry().equals("United States"));
    }
}
