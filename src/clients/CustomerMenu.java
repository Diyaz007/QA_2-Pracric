package clients;

import airport.Airports;
import connectionSQL.AirportMethod;
import connectionSQL.ClientsMethod;

import java.util.Scanner;

public class CustomerMenu {
    static Scanner sc = new Scanner(System.in);

    public static void start() {
        ClientsMethod clientsMethod = new ClientsMethod();
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
                addClient(clientsMethod);
            } else if (menuItem == 2) {
                deleteClient(clientsMethod);
            } else if (menuItem == 3) {
                updateClient(clientsMethod);
            } else if (menuItem == 4) {
                getClient(clientsMethod);
            } else if (menuItem == 5) {
                getAllClients(clientsMethod);
            } else if (menuItem == 0) {
                System.out.println("Выход в главное меню...");
                return;
            } else {
                System.out.println("Ошибка! Введите цифру из меню!");
            }
        }
    }

    public static void addClient(ClientsMethod clientsMethod) {
        Clients client = new Clients();
        System.out.println("Добавление клиента! ");
        System.out.print("Введите идентификационный номер: ");
        client.setIdentification_number(sc.nextInt());
        System.out.print("Введите id паспорта: ");
        client.setId_passport(sc.nextInt());
        sc.nextLine();
        System.out.print("Введите ФИО: ");
        client.setFull_name(sc.nextLine());
        System.out.print("Введите Пол: ");
        client.setGender(sc.nextLine());
        System.out.print("Введите код страны: ");
        client.setCountry(sc.nextInt());
        clientsMethod.addClient(client);

    }
    public static void deleteClient(ClientsMethod clientsMethod) {
        System.out.println("Удаление клиента! ");
        System.out.print("Введите id паспорта: ");
        int id_passport = sc.nextInt();
        clientsMethod.deleteClient(id_passport);
    }

    public static void updateClient(ClientsMethod clientsMethod) {
        System.out.println("Изменение клиента! ");
        System.out.print("Введите id паспорта: ");
        int id_passport = sc.nextInt();
        Clients client = new Clients();
        System.out.print("Введите новый идентификационный номер: ");
        client.setIdentification_number(sc.nextInt());
        System.out.print("Введите новый id паспорта: ");
        client.setId_passport(sc.nextInt());
        sc.nextLine();
        System.out.print("Введите новый ФИО: ");
        client.setFull_name(sc.nextLine());
        System.out.print("Введите новый Пол: ");
        client.setGender(sc.nextLine());
        System.out.print("Введите новый код страны: ");
        client.setCountry(sc.nextInt());
        clientsMethod.updateClient(client,id_passport);
    }
    public static void getClient(ClientsMethod clientsMethod) {
        System.out.println("Информация о клиенте! ");
        System.out.print("Введите id паспорта: ");
        int id_passport = sc.nextInt();
        Clients client = clientsMethod.getClient(id_passport);
        System.out.println(client);
    }
    public static void getAllClients(ClientsMethod clientsMethod){
        System.out.println("Информация о клиентах! ");
        System.out.println(clientsMethod.getAllClients());
    }
}
