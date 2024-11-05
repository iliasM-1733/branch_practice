package lesson_48.three_layer_arch.presentation;

import lesson_48.three_layer_arch.models.Contact;
import lesson_48.three_layer_arch.services.ContactService;

import java.util.Scanner;
import java.util.Set;

public class ContactBookFront {
    public static void main(String[] args) {
        ContactService service=new ContactService();
        Scanner scanner=new Scanner(System.in);

        boolean isWorking=true;

        // todo: дописать логику отображения всех контактов

        while (isWorking) {
            System.out.println("Привет! Это приложение - записаня книжка. Тут пока не так много опций, но можно выбрать:" +
                    "\n 1. - добавить контакт" +
                    "\n 2. - изменить контакт" +
                    "\n 3. - удалить контакт" +
                    "\n 4. - найти контакт" +
                    "\n 5. - отобразить все контакты" +
                    "\n 0. - завершить работу приложения");

            String code=scanner.nextLine();
            try {
                int codeNum=Integer.parseInt(code);
                // вызов соответствующего мтеода
                if (codeNum == 0) {
                    System.out.println("Вы уверены, что хотите остановить работу?" +
                            "1. - да, остановить работу и выйти" +
                            "2. - нет, продолжить работу");
                    code=scanner.nextLine();

                    codeNum=Integer.parseInt(code);

                    if (codeNum == 1) {
                        isWorking=false;
                        System.out.println("Я заканчиваю работу");
                    } else {
                        System.out.println("Я продолжаю работу");
                    }
                } else if (codeNum == 1) {
                    addContact(scanner, service);
                } else if (codeNum == 2) {
                } else if (codeNum == 3) {
                } else if (codeNum == 4) {
                    findContact(scanner, service);
                } else if (codeNum == 5) {
                    findAllContacts(scanner, service);


                } else {
                    System.out.println("Такого кода пока нет в системе. Попробуйте еще раз");
                }
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите число, соответствующее операции от 0 до 4");
            }
        }
    }

    public static void addContact(Scanner scanner, ContactService service) {
        System.out.println("Введите пожалуйста имя нового контакта:");

        String name=scanner.nextLine();

        System.out.println("Введите пожалуйста номер телефона для " + name + ":");
        String phone=scanner.nextLine();

        System.out.println("Вы хотите создать контакт с именем " + name + " и номером " + phone + " введите: " +
                "\n1 - если все верно" +
                "\n0 - вернуться в основное меню");

        String code=scanner.nextLine();

        try {
            int codeNum=Integer.parseInt(code);
            if (codeNum == 1) {
                String answer=service.addContact(name, phone);
                System.out.println(answer);
            }
        } catch (NumberFormatException e) {
            System.out.println("Вы ввели некорректное значение, вы будете возвращены в основное меню");
        }
    }

    public static void findContact(Scanner scanner, ContactService service) {
        System.out.println("Пожалуйста, введите имя для поиска контакта.");

        String name=scanner.nextLine();

        Set<Contact> foundName=service.getContact(name);

        if (foundName == null) {
            System.out.println("Такого контакта нет в записной книжке.");
        } else {
            System.out.println("Найдено контактов: " + foundName.size());
            for (Contact contact : foundName) {
                System.out.println("Имя: " + contact.getName() + ", номер телефона: " + contact.getPhoneNumber());
            }
        }

    }

    public static void findAllContacts(Scanner scanner, ContactService service){

       Set<Contact> allContacts = service.getAllContacts();

        if (allContacts.isEmpty()) {
            System.out.println(" Список контактов пуст, пожалуйста добавите новый контакт");
        }else {
            for (Contact contact: allContacts){
                System.out.println("Имя: " + contact.getName()+ ", номер телефона: " + contact.getPhoneNumber());
            }
        }

    }
}
