package Clients;

import java.util.Scanner;

public class CustomerMenu {
    public static void start() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int menuItem;
            System.out.println("Меню клиентов: ");
            System.out.println("1) Добавление клиента");
            System.out.println("2) Удаление клиента");
            System.out.println("3) Изменение клиента");
            System.out.println("4) Поиск клиента по номеру паспорта");
            System.out.println("5) Вывод списка клиентов");
            System.out.println("0) Выход");
            System.out.print("Ввод: ");
            menuItem = sc.nextInt();
            if (menuItem == 1) {

            } else if (menuItem == 2) {

            } else if (menuItem == 3) {

            } else if (menuItem == 4) {

            } else if (menuItem == 5) {

            } else if (menuItem == 0) {
                System.out.println("Выход в главное меню...");
                return;
            } else {
                System.out.println("Ошибка! Введите цифру из меню!");
            }
        }
    }
}
