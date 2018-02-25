package ru.job4j.control;

import java.util.HashMap;
import java.util.Map;

/**
 * класс для решения задачи: состоят ли две строки из одних и тех же символов
 */
public class CheckStrings {
    /**
     * первая строка
     */
   private String string1;
    /**
     * вторая строка
     */
   private String string2;

    /**
     * конструктор.
     * @param string1 - первая строка
     * @param string2 - вторая строка
     */
   CheckStrings(String string1, String string2) {
     this.string1 = string1;
     this.string2 = string2;
   }

    /**
     * метод сравнивает строки.
     * @return true, если поля string1 и string2 состоят из одних и тех же символов
     */
   public boolean check() {
       boolean result = true;
       if (string1.length() != string2.length()) {
           result = false;
       } else {
           Map<Char, Integer> setOfSymbols = new HashMap<>(256);
           for (int i = 0; i < string1.length(); i++) {
               Char key = new Char(string1.charAt(i));
               if (setOfSymbols.get(key) != null) {
                   setOfSymbols.put(key, setOfSymbols.get(key) + 1);
               } else {
                   setOfSymbols.put(key, 1);
               }
           }
           for (int i = 0; i < string2.length(); i++) {
               Char key = new Char(string2.charAt(i));
               if (setOfSymbols.get(key) == null) {
                   result = false;
                   break;
                   } else {
                   if (setOfSymbols.get(key) == 1) {
                       setOfSymbols.remove(key);
                   } else {
                       setOfSymbols.put(key, setOfSymbols.get(key) - 1);
                   }
               }
           }
       }
       return result;
   }

}
