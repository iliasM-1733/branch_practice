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
}
