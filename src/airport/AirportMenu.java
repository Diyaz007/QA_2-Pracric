package airport;

import connectionSQL.AirportMethod;

import java.util.Scanner;

public class AirportMenu {
    static Scanner sc = new Scanner(System.in);

    public static void start() {
        AirportMethod airportMethod = new AirportMethod();
        while (true) {
            int menuItem;
            System.out.println("Меню аэропортов: ");
            System.out.println("1) Добавление аэропорта");
            System.out.println("2) Удаление аэропорта");
            System.out.println("3) Изменение аэропорта");
            System.out.println("4) Поиск аэропорта по коду");
            System.out.println("5) Вывод списка аэропортов");
            System.out.println("0) Выход");
            System.out.print("Ввод: ");
            menuItem = sc.nextInt();
            if (menuItem == 1) {
                addAirport(airportMethod);
            } else if (menuItem == 2) {
                deleteAirport(airportMethod);
            } else if (menuItem == 3) {
                updateAirport(airportMethod);
            } else if (menuItem == 4) {
                getAirport(airportMethod);
            } else if (menuItem == 5) {
                getAllAirports(airportMethod);
            } else if (menuItem == 0) {
                System.out.println("Выход в главное меню...");
                return;
            } else {
                System.out.println("Ошибка! Введите цифру из меню!");
            }
        }
    }

    public static void addAirport(AirportMethod airportMethod) {
        Airports airport = new Airports();
        System.out.println("Добавление аэропорта! ");
        System.out.print("Введите код аэропорта: ");
        airport.setCode_of_the_airport(sc.nextInt());
        System.out.print("Введите код города: ");
        airport.setCode_of_the_city(sc.nextInt());
        System.out.print("Введите код страны: ");
        airport.setCode_of_the_country(sc.nextInt());
        airportMethod.addAirport(airport);

    }

    public static void deleteAirport(AirportMethod airportMethod) {
        System.out.println("Удаление аэропорта! ");
        System.out.print("Введите код аэропорта: ");
        int code_of_the_airport = sc.nextInt();
        airportMethod.deleteAirport(code_of_the_airport);
    }

    public static void updateAirport(AirportMethod airportMethod) {
        System.out.println("Изменение аэропорта! ");
        System.out.print("Введите код аэропорта: ");
        int code_of_the_airport = sc.nextInt();
        Airports airport = new Airports();
        System.out.print("Введите новый код аэропорта: ");
        airport.setCode_of_the_airport(sc.nextInt());
        System.out.print("Введите новый код города: ");
        airport.setCode_of_the_city(sc.nextInt());
        System.out.print("Введите новый код страны: ");
        airport.setCode_of_the_country(sc.nextInt());
        airportMethod.updateAirport(airport, code_of_the_airport);
    }

    public static void getAirport(AirportMethod airportMethod) {
        System.out.println("Информация о аэропорте! ");
        System.out.print("Введите код аэропорта: ");
        int code_of_the_airport = sc.nextInt();
        Airports airports = airportMethod.getAirport(code_of_the_airport);
        System.out.println(airports);
    }

    public static void getAllAirports(AirportMethod airportMethod) {
        while (true) {
            int menuItem;
            System.out.println("Фильтры получения аэропортв : ");
            System.out.println("1) Без фильтра");
            System.out.println("2) По коду аэропорта");
            System.out.println("3) По коду страны");
            System.out.println("0) Выход");
            System.out.print("Ввод: ");
            menuItem = sc.nextInt();
            if (menuItem == 1) {
                System.out.println(airportMethod.getAllAirports());
            } else if (menuItem == 2) {
                System.out.println("Фильтр по коду аэропорта! ");
                System.out.print("код аэропорта от: ");
                int code_of_the_airport_ot = sc.nextInt();
                System.out.print("код аэропорта до: ");
                int code_of_the_airport_do = sc.nextInt();
                System.out.println(airportMethod.getAllAirportsWithCodeOfAirport(code_of_the_airport_ot, code_of_the_airport_do));
            } else if (menuItem == 3) {
                System.out.println("Фильтр по коду страны! ");
                System.out.print("код страны от: ");
                int code_of_the_airport_ot = sc.nextInt();
                System.out.print("код страны до: ");
                int code_of_the_airport_do = sc.nextInt();
                System.out.println(airportMethod.getAllAirportsWithCodeOfCountry(code_of_the_airport_ot, code_of_the_airport_do));
            } else if (menuItem == 0) {
                System.out.println("Выход в главное меню...");
                return;
            } else {
                System.out.println("Ошибка! Введите цифру из меню!");
            }
        }
    }
}
