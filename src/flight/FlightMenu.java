package flight;

import connectionSQL.FlightMethod;

import java.util.Scanner;

public class FlightMenu {
    static Scanner sc = new Scanner(System.in);

    public static void start() {
        FlightMethod flightMethod = new FlightMethod();
        while (true) {
            int menuItem;
            System.out.println("Меню рейсов: ");
            System.out.println("1) Добавление рейса ");
            System.out.println("2) Удаление рейса");
            System.out.println("3) Изменение рейса ");
            System.out.println("4) Поиск рейса по номеру ");
            System.out.println("5) Выводе списка рейсов ");
            System.out.println("0) Выход");
            System.out.print("Ввод: ");
            menuItem = sc.nextInt();
            if (menuItem == 1) {
                addFlight(flightMethod);
            } else if (menuItem == 2) {
                deleteFlight(flightMethod);
            } else if (menuItem == 3) {
                updateFlight(flightMethod);
            } else if (menuItem == 4) {
                getFlight(flightMethod);
            } else if (menuItem == 5) {
                getAllFlight(flightMethod);
            } else if (menuItem == 0) {
                System.out.println("Выход в главное меню");
                return;
            } else {
                System.out.println("Ошибка! Введите цифру из меню");
            }
        }
    }

    public static void addFlight(FlightMethod flightMethod) {
        Flight flight = new Flight();
        System.out.println("Добавление рейса! ");
        System.out.print("Модель самолёта: ");
        flight.setAirplane_model(sc.next());
        System.out.print("Введите код аэропорта(отправление): ");
        flight.setDeparture_place(sc.nextInt());
        System.out.print("Введите код аэропорта(прибытие): ");
        flight.setPlace_of_arrival(sc.nextInt());
        System.out.print("Количество мест: ");
        flight.setNumber_of_seats(sc.nextInt());
        System.out.print("Номер рейса: ");
        flight.setFlight_number(sc.nextInt());
        flightMethod.addFlight(flight);
    }

    public static void deleteFlight(FlightMethod flightMethod) {
        System.out.println("Удаление рейса! ");
        System.out.print("Введите номер рейса: ");
        int flight_number = sc.nextInt();
        flightMethod.deleteFlight(flight_number);
    }

    public static void updateFlight(FlightMethod flightMethod) {
        System.out.println("Изменение рейса! ");
        System.out.print("Введите номер рейса: ");
        int flight_number = sc.nextInt();
        Flight flight = new Flight();
        System.out.print("Введите новый код аэропорта(отправление): ");
        flight.setDeparture_place(sc.nextInt());
        System.out.print("Введите новый код аэропорта(прибытие): ");
        flight.setPlace_of_arrival(sc.nextInt());
        flightMethod.updateFlight(flight, flight_number);
    }

    public static void getFlight(FlightMethod flightMethod) {
        System.out.println("Информация о рейсе! ");
        System.out.print("Введите номер рейса: ");
        int flight_number = sc.nextInt();
        Flight flight = flightMethod.getFlight(flight_number);
        System.out.println(flight);
    }

    public static void getAllFlight(FlightMethod flightMethod) {
        while (true) {
            int menuItem;
            System.out.println("Фильтры получения рейсов : ");
            System.out.println("1) Без фильтра");
            System.out.println("2) По коду аэропорта");
            System.out.println("0) Выход");
            System.out.print("Ввод: ");
            menuItem = sc.nextInt();
            if (menuItem == 1) {
                System.out.println(flightMethod.getAllFlight());
            } else if (menuItem == 2) {
                System.out.println("Фильтр по коду аэропорта! ");
                System.out.print("код аэропорта отправление: ");
                int code_of_the_airport_ot = sc.nextInt();
                System.out.print("код аэропорта прибытие: ");
                int code_of_the_airport_do = sc.nextInt();
                System.out.println(flightMethod.getAllFlightWithCodeOfAirport(code_of_the_airport_ot, code_of_the_airport_do));
            } else if (menuItem == 0) {
                System.out.println("Выход в главное меню...");
                return;
            } else {
                System.out.println("Ошибка! Введите цифру из меню!");
            }
        }
    }
}
