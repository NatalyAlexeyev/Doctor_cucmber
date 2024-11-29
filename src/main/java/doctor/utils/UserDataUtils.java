package doctor.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserDataUtils {

    public static void saveUserData(String email, String password) {
        try (FileWriter writer = new FileWriter("user_data.csv", true)) {

            writer.append(email).append(",").append(password).append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String[] getRandomUserData() {
        List<String[]> users = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("user_data.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",");
                users.add(userData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Random random = new Random();
        if (!users.isEmpty()) {
            return users.get(random.nextInt(users.size()));
        }
        return null;
    }
}
