package lesson_48.three_layer_arch.repository;

import lesson_48.three_layer_arch.models.Contact;

import java.util.*;

public class ContactRepository {
    // ключ - id, значение - Contact
    private Map<Integer, Contact> map;

    public ContactRepository() {
        this.map = new HashMap<>();
    }

    public boolean removeContact(int id) {
        if (!map.containsKey(id)) {
            return false;
        }
        map.remove(id);
        return true;
    }

    public boolean addContact(Contact contact) {
        if (map.containsKey(contact.getId())) {
            return false;
        }
        map.put(contact.getId(), contact);
        return true;
    }

    public boolean updateContact(Contact contact) {
        if (!map.containsKey(contact.getId())) {
            return false;
        }
        map.put(contact.getId(), contact);
        return true;
    }

    //todo: доработать логику, чтобы искать можно было по части имени и возвращать список контактов
    // перенести в сервис?
    public Contact getContactByNameDEPRICATED(String name) {
        // чтобы итерироваться по мапе мы можем получить список всех ключей из жтой мапы:
        Set<Integer> keyset = map.keySet();

        // перебираем все ключи и сравниваем имена полученных значений с тем, которое пришло в аргументе:
        for (Integer key : keyset) {
            Contact contactValue = map.get(key);
            String potentialName = contactValue.getName();

            // если имя из полученного контакта совпадает с именем из аргумента, то возвращаем контакт целиком:
            if (potentialName.equals(name)) {
                return contactValue;
            }
        }
        return null;
    }

    public Set<Contact> getContactByName(String name) {

        // 1. создать Set который мы вернем
        // 2. перебирать все контакты в мапе
        // 3. сравнивать содержит ли имя из контакта в мапе name, если содержит, то положить в сет
        // 4. по окончанию перебора вернуть сет с контактами
        return null;
    }


    public Contact getContactByPhone(String phone) {
        //...
        return null;
    }
}
