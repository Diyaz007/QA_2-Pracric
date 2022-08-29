import Airport.AirportMenu;
import Clients.CustomerMenu;
import Countries.CountryMenu;
import Flight.FlightMenu;
import Tickets.TicketMenu;

import java.util.Scanner;

public class MainMenu {
    public static void start() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int menuItem;
            System.out.println("главное меню: ");
            System.out.println("1) Работа с рейсами");
            System.out.println("2) Работа со странами");
            System.out.println("3) Работа с аэропортами");
            System.out.println("4) Работа с клиентами");
            System.out.println("5) Работа с билетами");
            System.out.println("0) Bыxoд");
            System.out.print("Ввод: ");
            menuItem = sc.nextInt();
            if (menuItem == 1) {
                FlightMenu.start();
            } else if (menuItem == 2) {
                CountryMenu.start();
            } else if (menuItem == 3) {
                AirportMenu.start();
            } else if (menuItem == 4) {
                CustomerMenu.start();
            } else if (menuItem == 5) {
                TicketMenu.start();
            } else if (menuItem == 0) {
                System.out.println("Bыxoд из прогpаммы...");
                break;
            } else {
                System.out.println("Ошибка! Введите цифру из жены");
            }
        }
    }
}