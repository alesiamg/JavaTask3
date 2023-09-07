package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckNumber {

    /** метод checkNumberOfAuto возвращает true, если введенный номер авто соответсвует шаблону: **/
    public static boolean checkNumberOfAuto(String carNumber) {
        /** шаблон строки как должен быть введен номер:
         * ^ - начало строки
         * [A-Z]{1} - одна заглавная буква
         * \\s* - неограниченное количество пробелов
         * \\d{3} - 3 цифры
         * [A-Z]{2} - 2 заглавные буквы
         * d{2,3} - две или три цифры
         * (RUS)? - необязательное обозначение
         * $ - конец строки
         */
        String pattern = "^[A-Z]{1}\\s*\\d{3}\\s*[A-Z]{2}\\s*\\d{2,3}(RUS)?$";

        //компиляция pattern в объект класса Pattern и применение CASE_INSENSITIVE
        // для преобразования в регулярное вырожение без учета регистра:
        Pattern carNumberPattern = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);

        // создаем объект matcher для строки carNumber для сопоставления с регул. выражением:
        Matcher matcher = carNumberPattern.matcher(carNumber);

        return matcher.matches(); // maches() -возвращает true если carNumber соответствует carNumberPattern
    }

    /** Метод extractRegion будет сопоставлять введенный номер авто с шаблоном, а затем с помощью метода
    * find() извлекать подстроку кода региона из номера авто **/
    public static String extractRegion(String carNumber) {
        //шаблон для извлечения кода региона из регистрационного номера автомобиля:
        String pattern = "\\d{2,3}(RUS)?$";
        Pattern regionPattern = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);

        Matcher matcher = regionPattern.matcher(carNumber);

        //Метод find() будет искать подстроку нашего кода региона в строке carNumber
        if (matcher.find()) {
            return matcher.group(0); //возвращает найденный код региона, 0 - извлечений всей найденной подстроки
        } else {
            return "Неизвестный регион";
        }
    }

    public static void main(String[] args) {
//        System.out.println(extractRegion("A777AA77777"));
//        System.out.println(checkNumberOfAuto("N 123NN77"));


    }
}


