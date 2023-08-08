package sem3.task1;

import java.util.Arrays;
import java.util.Scanner;

public class PasswordVerifier {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите пароль: ");
        String password = sc.nextLine();

        try {
            System.out.println(checkPassword(password));
        } catch (PasswordVerifierException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String checkPassword(String password) throws PasswordVerifierException {
        if (password.length() < 8)
            throw new PasswordVerifierException("Пароль должен содержать минимум 8 символов");
        else {
            boolean checkForNumber = false;
            boolean checkForUpperChar = false;

            Character[] numbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
            Character[] characters = {'A', 'B', 'C', 'D', 'E',
                    'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
                    'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
                    'V', 'W', 'X', 'Y', 'Z'};

            for (int i = 0; i < password.length(); i++) {
                if (Arrays.asList(numbers).contains(password.charAt(i)))
                    checkForNumber = true;

                if (Arrays.asList(characters).contains(password.charAt(i)))
                    checkForUpperChar = true;
            }

            if (!checkForNumber)
                throw new PasswordVerifierException("Пароль должен содержать минимум одну цифру");

            if (!checkForUpperChar)
                throw new PasswordVerifierException("Пароль должен содержать минимум одну заглавную букву");
        }
        return "Пароль корректный";
    }
}

class PasswordVerifierException extends Exception {
    public PasswordVerifierException(String message) {
        super(message);
    }
}
