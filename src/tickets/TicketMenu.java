package tickets;

import airport.Airports;
import connectionSQL.AirportMethod;
import connectionSQL.TicketsMethod;

import java.util.Scanner;

public class TicketMenu {
    static Scanner sc = new Scanner(System.in);
    public static void start(){
        TicketsMethod ticketsMethod = new TicketsMethod();
        while (true){
            int menuItem;
            System.out.println("Меню билетов: ");
            System.out.println("1) Добавление билета");
            System.out.println("2) Удаление билета");
            System.out.println("3) Изменение билета");
            System.out.println("4) Поиск билета по номеру");
            System.out.println("5) Вывод списка билетов");
            System.out.println("0) Выход");
            System.out.print("Ввод: ");
            menuItem = sc.nextInt();
            if(menuItem == 1){
                addTicket(ticketsMethod);
            }else if(menuItem == 2){
                deleteTicket(ticketsMethod);
            }else if(menuItem == 3){
                updateTicket(ticketsMethod);
            }else if(menuItem == 4){
                getTicket(ticketsMethod);
            }else if(menuItem == 5){
                getAllTicket(ticketsMethod);
            }else if(menuItem == 0){
                System.out.println("Выход в главное меню...");
                return;
            }else {
                System.out.println("Ошибка! Введите цифру из меню!");
            }
        }
    }
    public static void addTicket(TicketsMethod ticketsMethod) {
        Tickets ticket = new Tickets();
        System.out.println("Добавление Билета ! ");
        System.out.print("Введите id клиента: ");
        ticket.setId_client(sc.nextInt());
        System.out.print("Введите номер рейса: ");
        ticket.setFlight_number(sc.nextInt());
        System.out.print("Введите номер билета: ");
        ticket.setNumber_of_ticket(sc.nextInt());
        ticketsMethod.addTicket(ticket);

    }
    public static void deleteTicket(TicketsMethod ticketsMethod) {
        System.out.println("Удаление билета! ");
        System.out.print("Введите номер билета : ");
        int number_of_ticket = sc.nextInt();
        ticketsMethod.deleteTicket(number_of_ticket);
    }

    public static void updateTicket(TicketsMethod ticketsMethod) {
        System.out.println("Изменение билета! ");
        System.out.print("Введите номер билета: ");
        int number_of_ticket = sc.nextInt();
        Tickets tickets = new Tickets();
        System.out.print("Введите новый id клиента: ");
        tickets.setId_client(sc.nextInt());
        System.out.print("Введите новый номер рейса: ");
        tickets.setFlight_number(sc.nextInt());
        System.out.print("Введите новый номер билета: ");
        tickets.setNumber_of_ticket(sc.nextInt());
        ticketsMethod.updateTicket(tickets, number_of_ticket);
    }
    public static void getTicket(TicketsMethod ticketsMethod) {
        System.out.println("Информация о билете! ");
        System.out.print("Введите номер билета: ");
        int number_of_ticket = sc.nextInt();
        Tickets tickets = ticketsMethod.getTicket(number_of_ticket);
        System.out.println(tickets);
    }
    public static void getAllTicket(TicketsMethod ticketsMethod) {
        while (true) {
            int menuItem;
            System.out.println("Фильтры получения пассажира : ");
            System.out.println("1) Без фильтра");
            System.out.println("2) По номеру рейса");
            System.out.println("3) По id паспорта пассажира");
            System.out.println("0) Выход");
            System.out.print("Ввод: ");
            menuItem = sc.nextInt();
            if (menuItem == 1) {
                System.out.println(ticketsMethod.getAllTickets());
            } else if (menuItem == 2) {
                System.out.println("Фильтр по номеру рейса! ");
                System.out.println("Введите номер рейса: ");
                int flight_number = sc.nextInt();
                System.out.println(ticketsMethod.getAllTicketsWithFlight(flight_number));
            } else if (menuItem == 3) {
                System.out.println("Фильтр по id пассажира! ");
                System.out.print("id паспорта пассажира от: ");
                int id_clients_ot = sc.nextInt();
                System.out.print("id паспорта пассажира до: ");
                int id_clients_do = sc.nextInt();
                System.out.println(ticketsMethod.getAllTicketsWithIdClient(id_clients_ot, id_clients_do));
            } else if (menuItem == 0) {
                System.out.println("Выход в главное меню...");
                return;
            } else {
                System.out.println("Ошибка! Введите цифру из меню!");
            }
        }
    }
}
