package homework3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Less3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите данные (Фамилия Имя Отчество датарождения номертелефона пол :");
        boolean validInput = false;
        do {
            String input = scanner.nextLine();
            String[] data = input.split(" ");

            if (data.length != 6) {
                System.out.println("Ошибка: неверное количество данных, введите корретные данные");
                continue; // Повторить цикл
            }

            String lastName = data[0];
            String firstName = data[1];
            String middleName = data[2];
            String birthDate = data[3];
            String phoneNumber = data[4];
            String gender = data[5];

            try {
                validateAndWriteToFile(lastName, firstName, middleName, birthDate, phoneNumber, gender);
                System.out.println("Данные успешно записаны в файл");
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("Ошибка при записи данных в файл");
                e.printStackTrace();
            }
        } while (!validInput);
    }
    public static void validateAndWriteToFile(String lastName, String firstName, String middleName,
                                              String birthDate, String phoneNumber, String gender) throws IOException {
        if (!isValidBirthDate(birthDate)) {
            throw new IllegalArgumentException("Неверный формат даты рождения");
        }

        if (!isValidPhoneNumber(phoneNumber)) {
            throw new IllegalArgumentException("Неверный формат номера телефона");
        }

        if (!isValidGender(gender)) {
            throw new IllegalArgumentException("Неверный формат пола");
        }

        String fileName = lastName + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(lastName + " " + firstName + " " + middleName + " " +
                    birthDate + " " + phoneNumber + " " + gender);
            writer.newLine();
        }
    }

    public static boolean isValidBirthDate(String birthDate) {
        return birthDate.matches("\\d{2}\\.\\d{2}\\.\\d{4}");
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("[+]?(\\d{11}|\\d{10})");
    }

    public static boolean isValidGender(String gender) {
        return gender.matches("[мж]");
    }
}
