package lesson_48.three_layer_arch.presentation;

import lesson_48.three_layer_arch.services.ContactService;

import java.util.Scanner;

public class ContactBookFront {
    public static void main(String[] args) {
        ContactService service = new ContactService();
        Scanner scanner = new Scanner(System.in);

        boolean isWorking = true;

        while (isWorking) {
            System.out.println("Привет! Это приложение - записаня книжка. Тут пока не так много опций, но можно выбрать:" +
                    "\n 1. - добавить контакт" +
                    "\n 2. - изменить контакт" +
                    "\n 3. - удалить контакт" +
                    "\n 4. - найти контакт" +
                    "\n 0. - завершить работу приложения");

            String code = scanner.nextLine();
            try {
                int codeNum = Integer.parseInt(code);
                // вызов соответствующего мтеода
                if (codeNum == 0) {
                    System.out.println("Вы уверены, что хотите остановить работу?" +
                            "1. - да, остановить работу и выйти" +
                            "2. - нет, продолжить работу");
                    code = scanner.nextLine();

                    codeNum = Integer.parseInt(code);

                    if (codeNum == 1) {
                        isWorking = false;
                        System.out.println("Я заканчиваю работу");
                    } else {
                        System.out.println("Я продолжаю работу");
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите число, соответствующее операции от 0 до 4");
            }
        }
    }
}
