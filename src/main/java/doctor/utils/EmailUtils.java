package doctor.utils;

import java.util.Random;

public class EmailUtils {
    public static String generateRandomEmail() {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder email = new StringBuilder();
        Random random = new Random();

        // Генерируем случайную часть до символа '@'
        for (int i = 0; i < 10; i++) {
            email.append(characters.charAt(random.nextInt(characters.length())));
        }

        // Завершаем адресом с нужным доменом
        email.append("@gmx.test");
        return email.toString();
    }
}