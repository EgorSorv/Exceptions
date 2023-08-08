package task2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите делимое: ");
        int dividend = sc.nextInt();

        System.out.print("Введите делитель: ");
        int divider = sc.nextInt();

        try {
            System.out.println("Результат деления => " + divide(dividend, divider));
        } catch (DivisionByZeroException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int divide(int dividend, int divider) throws DivisionByZeroException {
        if (divider == 0)
            throw new DivisionByZeroException("Деление на ноль недопустимо");
        return dividend / divider;
    }
}

class DivisionByZeroException extends Exception {
    public DivisionByZeroException(String message) {
        super(message);
    }
}
