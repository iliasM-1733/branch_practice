package lesson_48.three_layer_arch.repository;

import lesson_48.three_layer_arch.models.Contact;

import java.util.HashMap;
import java.util.Map;

public class ContactRepository {
    // ключ - id, значение - Contact
    private Map<Integer, Contact> map;

    public ContactRepository() {
        this.map = new HashMap<>();
    }

    public boolean addContact(Contact contact) {
        if (map.containsKey(contact.getId())) {
            return false;
        }
        map.put(contact.getId(), contact);
        return true;
    }
}
