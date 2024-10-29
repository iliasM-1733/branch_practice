package lesson_48.three_layer_arch.services;

import lesson_48.three_layer_arch.models.Contact;
import lesson_48.three_layer_arch.repository.ContactRepository;

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

    public String removeContact(String name) {
        Contact contact = repository.getContactByName(name);
        if (contact == null) {
            return "контакт с таким именем не был найден";
        } else {
            if (repository.removeContact(contact.getId())) {
                return "контакт был успешно удален";
            } else {
                return "контакт не был удален";
            }
        }
    }
}
