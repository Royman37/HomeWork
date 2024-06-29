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
        /*
        Т.к. HaskMap перезаписывает ячейку, если указать идентичный ключ.
        Создал ArrayList состоящий из HashMap
         */
        List<Map<String, String>> values = new ArrayList<>();
        values.add(new HashMap<String, String>() {{
            put("Roma", "+375 44 221 26 82");
        }});
        values.add(new HashMap<String, String>() {{
            put("Petya", "+375 29 233 26 11");
            put("Sam", "+375 29 126 72 11");
        }});
        values.add(new HashMap<String, String>() {{
            put("Sam", "+375 44 261 13 36");
        }});
        values.add(new HashMap<String, String>() {{
            put("Bob", "+375 29 111 11 21");
        }});
        System.out.println(values + "\n");

        for (Map<String, String> map : values) {
            if (map.containsKey("Sam")) {
                System.out.println(map.get("Sam"));
            }
        }
    }
}
