package patPerson;

import netscape.javascript.JSObject;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.ZonedDateTime;
import java.util.ArrayList;

public class ApiPerson {
    public ArrayList<Person> getApiPersonFromRequest(int col) throws IOException, InterruptedException {

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder() //запрос
                .GET()
                // .uri(URI.create("https://randomuser.me/api"))
                .uri(URI.create(String.format("https://randomuser.me/api/?results=%s", col)))
                .build();
        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        return parcePersonResponse(response.body());
    }

    public ArrayList<Person> parcePersonResponse(String response) {
        ArrayList<Person> persons = new ArrayList<>();
        int infoCount = new JSONObject(response)
                .getJSONObject("info")
                .getInt("results");
        for (int i = 0; i < infoCount; i++) {
            Person p = new Person();
            JSONObject fullData = new JSONObject(response)
                    .getJSONArray("results")
                    .getJSONObject(i);

            p.setGender(fullData.getString("gender"));
            p.setFirstname(fullData.getJSONObject("name").getString("first"));
            p.setLastname(fullData.getJSONObject("name").getString("last"));
            p.setEmail(fullData.getString("email"));
            p.setCountry(fullData.getJSONObject("location").getString("country"));
            p.setCity(fullData.getJSONObject("location").getString("city"));
            ZonedDateTime zonedDateTime = ZonedDateTime.parse(fullData.getJSONObject("dob").getString("date"));
            p.setDob(zonedDateTime.toLocalDateTime());
            persons.add(p);
        }
        return persons;
    }

    public ArrayList<Person> getApiPersonFromRequestDZ(int numberOfPeople, String printedCity) throws IOException, InterruptedException {
        ArrayList<Person> arr = new ArrayList<>();

        while ((arr.size() != numberOfPeople)) {
            HttpClient httpClient = HttpClient.newHttpClient();

            HttpRequest httpRequest = HttpRequest.newBuilder() //запрос
                    .GET()
                    .uri(URI.create("https://randomuser.me/api"))

                    .build();

            HttpResponse<String> response = httpClient
                    .send(httpRequest, HttpResponse.BodyHandlers.ofString());

            if (parcePersonResponceDZ(response.body()).getCity() == printedCity) {
                arr.add(parcePersonResponceDZ(response.body()));
            }


        }
        return arr;
    }

    public Person parcePersonResponceDZ(String response ) {
        Person p = new Person();

        JSONObject fullData = new JSONObject(response)
                .getJSONArray("results")
                .getJSONObject(0);

        p.setGender(fullData.getString("gender"));
        p.setFirstname(fullData.getJSONObject("name").getString("first"));
        p.setLastname(fullData.getJSONObject("name").getString("last"));
        p.setEmail(fullData.getString("email"));
        p.setCountry(fullData.getJSONObject("location").getString("country"));
        p.setCity(fullData.getJSONObject("location").getString("city"));
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(fullData.getJSONObject("dob").getString("date"));
        p.setDob(zonedDateTime.toLocalDateTime());

        return p;
    }


}