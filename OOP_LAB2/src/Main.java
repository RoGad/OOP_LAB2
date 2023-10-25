import java.util.Scanner;
import java.util.regex.*;

class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password;

        do {
            System.out.print("Введите пароль: ");
            password = scanner.nextLine();

            if (!isStrongPassword(password)) {
                System.out.println("Пароль ненадежен. Попробуйте снова.");
            }
        } while (!isStrongPassword(password));

        System.out.println("Пароль надежен.");
        scanner.close();
    }

    public static boolean isStrongPassword(String password) {
        // Проверка минимальной длины
        if (password.length() < 8) {
            return false;
        }

        // Проверка наличия букв верхнего и нижнего регистра
        if (!Pattern.compile("[a-z]").matcher(password).find() ||
                !Pattern.compile("[A-Z]").matcher(password).find()) {
            return false;
        }

        // Проверка наличия цифр
        if (!Pattern.compile("[0-9]").matcher(password).find()) {
            return false;
        }

        // Проверка наличия специальных символов (может потребоваться изменить паттерн)
        if (!Pattern.compile("[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?]").matcher(password).find()) {
            return false;
        }

        return true;
    }
}
