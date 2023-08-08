package task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите положительное число: ");
        int number = sc.nextInt();

        try {
            System.out.println(checkNumber(number));
        } catch (InvalidNumberException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String checkNumber(int number) throws InvalidNumberException {
        if (number == 0 || number < 0)
            throw new InvalidNumberException("Некорректное число");
        return "Число корректно";
    }
}

class InvalidNumberException extends Exception {
    public InvalidNumberException(String message) {
        super(message);
    }
}
