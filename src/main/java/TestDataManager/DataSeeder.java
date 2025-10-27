package TestDataManager;

import com.github.javafaker.Faker;

import java.util.Date;
import java.util.HashMap;

/*
    ToDo: Impl. factory pattern pentru creeare de date
 */
public class DataSeeder {
    static Faker faker = new Faker();

    public static Object seedUser() {
        HashMap<String, Object> user = new HashMap();

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        Date age = faker.date().birthday(24, 29);
        String gender = faker.demographic().sex();

        user.put("firstName", firstName);
        user.put("lastName", lastName);
        user.put("age", age);
        user.put("gender", gender);

        return user;
    }
}
