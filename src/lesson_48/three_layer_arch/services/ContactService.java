package lesson_48.three_layer_arch.services;

import lesson_48.three_layer_arch.models.Contact;
import lesson_48.three_layer_arch.repository.ContactRepository;

import java.util.Set;

public class ContactService {
    private ContactRepository repository;
    private static int contactCounter = 0;
    public ContactService() {
        repository = new ContactRepository();
    }

    public String addContact(String name, String phoneNumber) {
        // можно дописать некую логику проверки, что такого телефона нет в контактах
        // или, что данные не пусты и введены корректно

        Contact contact = new Contact(contactCounter, name, phoneNumber);
        contactCounter++;
        if (repository.addContact(contact)) {
            return "контакт был успешно добавлен";
        } else {
            return "контакт не был добавлен";
        }
    }

    public String addContact(String name) {
        Contact contact = new Contact(contactCounter, name, null);
        contactCounter++;
        if (repository.addContact(contact)) {
            return "контакт был успешно добавлен";
        } else {
            return "контакт не был добавлен";
        }
    }

    // методы для обновления контакта, получения контакта, удаления контакта.

    public String getContact(String name) {
        Set<Contact> contacts = repository.getContactByName(name);
        if (contacts.size() == 0) {
            return "контакт с таким именем не был найден";
        } else {
            StringBuilder result = new StringBuilder();
            for (Contact contact : contacts) {
                result.append(contact.toString()).append("; ");
            }
            return result.toString();
        }
    }

    //
    public Set deleteContact(String name) {
        Set<Contact> contacts = repository.getContactByName(name);
        if (contacts.isEmpty()) {
            return null;
        } else if (contacts.size() > 1) {
            return contacts;
        } else {
            for (Contact contact : contacts) {
                repository.removeContact(contact.getId());
            }
            return contacts;
        }
    }
}
