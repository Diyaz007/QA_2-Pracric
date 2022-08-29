package Countries;

import ConnectionSQL.CountryMethod;

import java.util.Scanner;

public class CountryMenu {
    static Scanner sc = new Scanner(System.in);

    public static void start() {
        CountryMethod countryMethod = new CountryMethod();
        while (true) {
            int menuItem;
            System.out.println("Меню стран: ");
            System.out.println("1) Дoбaвление страны");
            System.out.println("2) Удаление страны");
            System.out.println("3) Изменение страны");
            System.out.println("4) Поиск страны по коду");
            System.out.println("5) Выводе списка стран");
            System.out.println("0) Выход");
            System.out.print("Ввод: ");
            menuItem = sc.nextInt();
            if (menuItem == 1) {
                addCountry(countryMethod);
            } else if (menuItem == 2) {
                deleteCountry(countryMethod);
            } else if (menuItem == 3) {
                updateCountry(countryMethod);
            } else if (menuItem == 4) {
                getCountry(countryMethod);
            } else if (menuItem == 5) {
                getAllCountry(countryMethod);
            } else if (menuItem == 0) {
                System.out.println("Выход в главное меню...");
                return;
            } else {
                System.out.println("Ошибка! Введите цифру из меню!");
            }
        }
    }

    public static void addCountry(CountryMethod countryMethod) {
        Country country = new Country();
        System.out.println("Добавление страны! ");
        System.out.print("Введите код страны: ");
        country.setCode_of_the_country(sc.nextInt());
        sc.nextLine();
        System.out.print("Введите название страны: ");
        country.setName_of_country(sc.nextLine());
        countryMethod.addCountry(country);
    }

    public static void deleteCountry(CountryMethod countryMethod) {
        System.out.println("Удаление Страны! ");
        System.out.print("Введите код страны: ");
        int code_of_the_country = sc.nextInt();
        countryMethod.deleteNews(code_of_the_country);

    }

    public static void updateCountry(CountryMethod countryMethod) {
        System.out.println("Изменение страны! ");
        System.out.print("Введите код страны: ");
        int code_of_the_country = sc.nextInt();
        Country country = new Country();
        System.out.print("Введите новый код страны: ");
        country.setCode_of_the_country(sc.nextInt());
        sc.nextLine();
        System.out.print("Введите новое название страны: ");
        country.setName_of_country(sc.nextLine());
        countryMethod.updateCountry(country, code_of_the_country);

    }

    public static void getCountry(CountryMethod countryMethod) {
        System.out.println("Информация о стране! ");
        System.out.print("Введите код страны: ");
        int code_of_the_country = sc.nextInt();
        System.out.println(countryMethod.getCountry(code_of_the_country));
    }

    public static void getAllCountry(CountryMethod countryMethod) {
        while (true) {
            int menuItem;
            System.out.println("Фильтры получения стран : ");
            System.out.println("1) Без фильтра");
            System.out.println("2) По коду страны");
            System.out.println("3) По названию страны");
            System.out.println("0) Выход");
            System.out.print("Ввод: ");
            menuItem = sc.nextInt();
            if (menuItem == 1) {
                System.out.println(countryMethod.getAllCountry());
            } else if (menuItem == 2) {
                System.out.println("Фильтр по коду страны! ");
                System.out.print("код страны от: ");
                int code_of_the_country_ot = sc.nextInt();
                System.out.print("код страны до: ");
                int code_of_the_country_do = sc.nextInt();
                System.out.println(countryMethod.getAllCountryWithCodeOfCountry(code_of_the_country_ot, code_of_the_country_do));
            } else if (menuItem == 3) {
                System.out.println("Фильтр по названию страны! ");
                sc.nextLine();
                System.out.print("Введите название: ");
                String name_of_country = sc.nextLine();
                System.out.println(countryMethod.getAllCountryWithName(name_of_country));
            } else if (menuItem == 0) {
                System.out.println("Выход в главное меню...");
                return;
            } else {
                System.out.println("Ошибка! Введите цифру из меню!");
            }
        }
    }
}
