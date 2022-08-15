package patPerson;

import java.util.ArrayList;
import java.util.Scanner;

public class MainDZ2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("number of people: ");
        int numberOfPeople = sc.nextInt();
        Scanner scc =new Scanner(System.in);
        System.out.println("find people in city: ");
        System.out.println();
        String printedCity = scc.nextLine();
        ApiPerson api = new ApiPerson();
        ArrayList<Person> persons = new ArrayList<>();
        try {
            persons = api.getApiPersonFromRequestDZ(numberOfPeople,printedCity);
            System.out.println(persons);
        } catch (Exception e) {
            e.printStackTrace();

        }
        System.out.println();
        //PersonSort.filterCity(persons, person -> person.getCity().equals(printedCity),numberOfPeople );
    }
}
