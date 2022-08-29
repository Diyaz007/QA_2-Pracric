package tickets;

import java.util.Scanner;

public class TicketMenu {
    public static void start(){
        Scanner sc = new Scanner(System.in);
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

            }else if(menuItem == 2){

            }else if(menuItem == 3){

            }else if(menuItem == 4){

            }else if(menuItem == 5){

            }else if(menuItem == 0){
                System.out.println("Выход в главное меню...");
                return;
            }else {
                System.out.println("Ошибка! Введите цифру из меню!");
            }
        }
    }
}
