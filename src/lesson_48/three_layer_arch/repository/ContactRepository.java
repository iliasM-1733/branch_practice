package lesson_48.three_layer_arch.repository;

import lesson_48.three_layer_arch.models.Contact;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContactRepository {
    // ключ - id, значение - Contact
    private Map<Integer, Contact> contactMap;

    public ContactRepository() {
        this.contactMap=new HashMap<>();
    }

    public boolean removeContact(int id) {
        if (!contactMap.containsKey(id)) {
            return false;
        }
        contactMap.remove(id);
        return true;
    }

    public boolean addContact(Contact contact) {
        if (contactMap.containsKey(contact.getId())) {
            return false;
        }
        contactMap.put(contact.getId(), contact);
        return true;
    }

    public boolean updateContact(Contact contact) {
        if (!contactMap.containsKey(contact.getId())) {
            return false;
        }
        contactMap.put(contact.getId(), contact);
        return true;
    }

    //todo: доработать логику, чтобы искать можно было по части имени и возвращать список контактов
    // перенести в сервис?
    public Contact getContactByNameDEPRICATED(String name) {
        // чтобы итерироваться по мапе мы можем получить список всех ключей из жтой мапы:
        Set<Integer> keyset=contactMap.keySet();

        // перебираем все ключи и сравниваем имена полученных значений с тем, которое пришло в аргументе:
        for (Integer key : keyset) {
            Contact contactValue=contactMap.get(key);
            String potentialName=contactValue.getName();

            // если имя из полученного контакта совпадает с именем из аргумента, то возвращаем контакт целиком:
            if (potentialName.equals(name)) {
                return contactValue;
            }
        }
        return null;
    }

    public Set<Contact> getContactByName(String name) {
        Set<Contact> contacts=new HashSet<>();
        Set<Integer> keyset=contactMap.keySet();

        // перебираем все ключи и сравниваем имена полученных значений с тем, которое пришло в аргументе:
        for (Integer key : keyset) {
            Contact contactValue=contactMap.get(key); //
            String potentialName=contactValue.getName();

            if (potentialName.toLowerCase().contains(name.toLowerCase().trim())) {
                contacts.add(contactValue);
            }
        }

        // 1. создать Set который мы вернем
        // 2. перебирать все контакты в мапе
        // 3. сравнивать содержит ли имя из контакта в мапе name, если содержит, то положить в сет
        // 4. по окончанию перебора вернуть сет с контактами
        return contacts;
    }


    public Contact getContactByPhone(String phone) {
        //...
        return null;
    }

    public Set<Contact> getAllContacts() {
        Set<Contact> allContacts=new HashSet<>();
        Set<Integer> allKeys=contactMap.keySet();

        for (Integer key : allKeys) {
            Contact contact=contactMap.get(key);
            allContacts.add(contact);
        }
        return allContacts;
    }
}
