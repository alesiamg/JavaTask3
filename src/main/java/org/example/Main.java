package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /** Запускаем цикл ввода пользователем номеров автомобилей формата:
         * А123АА777,
         * А 123АА77
         * A 123 AA RUS 777
         * В диапазоне от A-Z (русские буквы не распознаются)
         * в остальных случаях будет выводится сообщение, что номер введен не верно
         * до тех пор, пока пользователь не введет "exit"
         * в любом регистре.
         * ВВеденный номер проверяется методом checkNumberOfAuto, который возвращает true or false.
         * Если номер авто введен корректно, пользователь получает информацию об этом, а также получает информацию
         * о коде региона введенного номера**/
        Scanner scanner = new Scanner(System.in);
        String input; // хранит введенные номера авто
        //цикл, пока пользователь не выйдет из программы:
        do {
            System.out.println("введите номера авто");
            input = scanner.nextLine();

            //проверка, является ли введенная строка командой выхода:
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Вы вышли из программы!");
                break;
            }
            if (CheckNumber.checkNumberOfAuto(input)) {
                System.out.println("номер введен правильно");
                String region = CheckNumber.extractRegion(input);
                System.out.println("Регион: " + region);
            } else {
                System.out.println("номер авто введен не верно");
            }
        } while (!input.equalsIgnoreCase("exit"));
    }
}

