import contact.ContactManegir;
import task.taskManeger;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        taskManeger taskManeger = new taskManeger();
        ContactManegir contactManegir = new ContactManegir();
        boolean boshlasAsosiy = true;
        while (boshlasAsosiy) {
            menu();
            int b = getNumber();
            switch (b) {
                case 1:
                    contactManegir.start();
                    break;
                case 2:
                    taskManeger.start();
                    break;
                case 0:
                    boshlasAsosiy = false;
                    System.out.println("Dastur tugadi !");
                    break;
            }
        }
    }

    public static void menu() {
        System.out.printf("-----------------------------%n");
        System.out.printf("|         ****Menu****      |%n");
        System.out.printf("-----------------------------%n");
        System.out.printf("| %-25s |%n", "1. Contact Maneger");
        System.out.printf("| %-25s |%n", "2. Task Maneger");
        System.out.printf("| %-25s |%n", "0. Chiqish");
        System.out.printf("-----------------------------%n");
    }

    public static int getNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Qaysi dastur ishga tushsin: ");
        return scanner.nextInt();
    }
}
