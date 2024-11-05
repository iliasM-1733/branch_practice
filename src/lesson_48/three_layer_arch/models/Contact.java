package lesson_48.three_layer_arch.models;

import java.util.Optional;

public class Contact {

    private final int id;
    private String name;
    private String phoneNumber;

    // тк есть возможно создать Contact без указания номера телефона,
    // то есть значение поля phoneNumber = null, это может привести к NullPointerException.
    // Чтобы избежать этого исключения,
    // попытаемся заменить "private String phoneNumber;" на контейнер Optional:
    Optional<String> optionalPhoneNumber;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public Contact(int id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.optionalPhoneNumber = Optional.ofNullable(phoneNumber);

//        this.optionalPhoneNumber = Optional.ofNullable(phoneNumber); равноценно записи ниже:
//        if (phoneNumber == null) {
//            this.optionalPhoneNumber = Optional.empty();
//        } else { // если значение phoneNumber не равно null
//            this.optionalPhoneNumber = Optional.of(phoneNumber);
//        }
    }
}
