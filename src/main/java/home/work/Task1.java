package home.work;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        getUserInput();
    }

        public static float getUserInput() {
            Scanner scanner = new Scanner(System.in);
            float userInput = 0.0f;
            boolean isValidInput = false;

            while (!isValidInput) {
                try {
                    System.out.print("Введите дробное число: ");
                    userInput = Float.parseFloat(scanner.nextLine());
                    isValidInput = true;
                } catch (NumberFormatException e) {
                    System.out.println("Некорректный ввод. Пожалуйста, введите дробное число.");
                }
            }

            return userInput;
        }
    }


