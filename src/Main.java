import java.util.Scanner;

public class Main {
    static Contact[] ContactArr = new Contact[10];
    static int index = 0;

    public static void main(String[] args) {
        boolean start = true;
        while (start) {
            menu();
            int getNumber = getNumber();
            switch (getNumber) {
                case 1:
                    Contact contact = addContact();
                    addArrayContact(contact);
                    break;
                case 2:
                    printList();
                    break;
                case 3:
                    String qidiruvVoule = query();
                    sourch(qidiruvVoule);
                    break;
                case 4:
                    String telefonDalet = DeletValyue();
                    DalteContact(telefonDalet);
                    break;
                case 0:
                    //code
                    start = false;
                    break;
                default:
                    System.out.println("Iltimos tog'ri ma'lumot kiriting !!!");
            }
        }
    }

    public static void toldrish(){
        for (int i = 0; i < ContactArr.length; i++) {
            if (ContactArr[i]!=null) {
                ContactArr[i] = ContactArr[i];
            }
        }
    }
    public static void DalteContact(String telefonDalet) {
        for (Contact contact1 : ContactArr) {
            if (contact1 != null) {
                if (contact1.telefon.equals(telefonDalet)) {
                    contact1 = null;
                }
            }
        }
    }

    public static String DeletValyue() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Telefon raqam: ");
        return sc.next();
    }

    public static void sourch(String qidiruvVoule) {
        for (Contact contact1 : ContactArr) {
            if (contact1 != null) {
                if (contact1.ism.contains(qidiruvVoule) || contact1.familya.contains(qidiruvVoule)
                        || contact1.telefon.contains(qidiruvVoule)) {
                    System.out.println(" 1. " + contact1.ism + " 2. " + contact1.familya + " 3. " + contact1.telefon);
                }
            }
        }
    }

    public static void printList() {
        for (Contact contact1 : ContactArr) {
            if (contact1 != null) {
                System.out.println(" 1. " + contact1.ism + " 2. " + contact1.familya + " 3. " + contact1.telefon);
            }
        }
    }

    public static String query() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Qidirish: ");
        return sc.next();
    }

    public static void addArrayContact(Contact contact) {

        if (isChekContact(contact)) {
            if (ContactArr.length == index) {
                Contact[] newContactArr = new Contact[ContactArr.length * 2];
                for (int i = 0; i < newContactArr.length; i++) {
                    newContactArr[i] = ContactArr[i];
                }
                ContactArr = newContactArr;
            }
            ContactArr[index] = contact;
            index++;
            System.out.println("Contact qoshildi");
        }
    }

    public static boolean isChekContact(Contact contact) {
        if (contact.ism.trim().length() < 3) {
            System.out.println("Ism xato !!!");
            return false;
        }
        if (contact.familya.trim().length() < 3) {
            System.out.println("Familya xato !!!");
            return false;
        }
        if (contact.telefon.length() != 7) {
            System.out.println("Telefon xato !!!");
            return false;
        }

        return true;
    }

    public static Contact addContact() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ism kiriting: ");
        String ism = sc.next();

        System.out.println("Familya kiriting: ");
        String familya = sc.next();

        System.out.println("Telefon kiriting: ");
        String telfon = sc.next();

        Contact contact = new Contact();
        contact.ism = ism;
        contact.familya = familya;
        contact.telefon = telfon;

        return contact;
    }

    public static void menu() {
        System.out.println("1.Kontakt qo'shish ");
        System.out.println("2.Kontakt ro'yxati ");
        System.out.println("3.Kontakt qidirish ");
        System.out.println("4.Kontakt o'chirish ");
        System.out.println("0.Tugatish ");

    }

    public static int getNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Qanday amal bajarasiz: ");
        return sc.nextInt();
    }
}