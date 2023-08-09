package home.work;

import java.util.Scanner;


public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите что-нибудь: ");
            String input = scanner.nextLine();

            if (input.isEmpty()) {
                throw new EmptyStringException("Пустые строки вводить нельзя");
            }

            System.out.println("Вы ввели: " + input);
        } catch (EmptyStringException e) {
            System.out.println(e.getMessage());
        }
    }
}

class EmptyStringException extends Exception {
    public EmptyStringException(String message) {
        super(message);
    }
}

