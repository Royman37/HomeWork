package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    /*
    Используем HasMap для создания хэш - карточки.
    С помощью <Ключ, значение> находим нужный номер.
     */
    public void lookingForANumber() {
        System.out.println("Task2: \n");

        HashMap<String, String> list =new HashMap<>();
        list.put("Roma", "+375 44 224 65 82");
        list.put("Grisha", "+375 44 221 33 82");
        list.put("Petya", "+375 29 233 26 11");
        list.put("Sam", "+375 29 126 72 11");
        list.put("John", "+375 44 221 26 00");
        list.put("John", "+375 44 221 26 00");
        list.get("John");

        }
    }
