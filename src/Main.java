import contact.ContactManegir;
import sms.SmsManeger;
import util.scannerUtil;
import task.taskManeger;

public class Main {

    public static void main(String[] args) {
        taskManeger taskManeger = new taskManeger();
        ContactManegir contactManegir = new ContactManegir();
        SmsManeger smsManeger=new SmsManeger(contactManegir);
        boolean boshlasAsosiy = true;
        while (boshlasAsosiy) {
            menu();
            Integer b = scannerUtil.getNumber1();
            switch (b) {
                case 1:
                    contactManegir.start();
                    break;
                case 2:
                    taskManeger.start();
                    break;
                case 3:
                    smsManeger.start();
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
        System.out.printf("| %-25s |%n", "3. Sms Maneger");
        System.out.printf("| %-25s |%n", "0. Chiqish");
        System.out.printf("-----------------------------%n");
    }

}
