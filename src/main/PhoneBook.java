package main;

import java.security.Key;
import java.util.*;

public class PhoneBook {
    Map<String, List<String>> list = new HashMap<>();
    /*
    Используем Map для создания хэш - карточки.
     */

    public void addingАUser(String name, String number) {
        if (list.containsKey(name)) {
            list.get(name).add(number);
        } else {
            List<String> phoneNumbers = new ArrayList<>();// создали для номеров телефона, чтобы они хранились отдельно.
            phoneNumbers.add(number);
            list.put(name, phoneNumbers);
        }
    }

    public void gettingUser(String name) {
        System.out.println("Name: " + name + " " + "\nNumber: " + list.getOrDefault(name, new ArrayList<>()));
    }

    @Override
    public String toString() {
        return "PhoneBook: " + list.toString();
    }
}

