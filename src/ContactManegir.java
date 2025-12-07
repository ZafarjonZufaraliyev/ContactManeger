import java.util.Scanner;

public class ContactManegir {
     Contact[] ContactArr = new Contact[10];
    int index = 0;

    public  void start(){
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
                    String qidiruvValue = query();
                    search(qidiruvValue);
                    break;

                case 4:
                    String telefonDelete = inputDeletePhone();
                    deleteContact(telefonDelete);
                    break;

                case 0:
                    System.out.println("|| Dastur tugadi ||");
                    start = false;
                    break;

                default:
                    System.out.println("Iltimos tog'ri ma'lumot kiriting !!!");
            }
        }
    }

    public  void deleteContact(String telefonDelete) {
        for (int i = 0; i < ContactArr.length; i++) {
            Contact contact = ContactArr[i];
            if (contact != null && contact.telefon.equals(telefonDelete)) {
                System.out.println("|| " + contact.ism+" "+contact.familya + " kontakti o'chirildi ||");
                ContactArr[i] = null;
                return;
            }
        }
        System.out.println("|| Kontakt topilmadi ||");
    }

    public  String inputDeletePhone() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Telefon raqam: ");
        return sc.next();
    }

    public  String query() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Qidirish: ");
        return sc.next();
    }

    public  void search(String qidiruvValue) {
        boolean found = true;
        String inputSon=qidiruvValue.toLowerCase();
        for (Contact c : ContactArr) {
            if (c != null &&
                    (c.ism.toLowerCase().contains(inputSon) ||
                            c.familya.toLowerCase().contains(inputSon) ||
                            c.telefon.toLowerCase().contains(inputSon))) {

                System.out.println(c.ism + " " + c.familya + " " + c.telefon);
                found = false;
            }
        }
        if (found) System.out.println("|| Hech narsa topilmadi ||");
    }

    public  void printList() {
        boolean empty = true;
        for (Contact c : ContactArr) {
            if (c != null) {
                System.out.println(c.ism + " " + c.familya + " " + c.telefon);
                empty = false;
            }
        }
        if (empty) System.out.println("|| Kontaktlar yo‘q ||");
    }

    public  void addArrayContact(Contact contact) {
        if (!checkContact(contact)) return;

        if (index == ContactArr.length) {
            Contact[] newArr = new Contact[ContactArr.length * 2];

            for (int i = 0; i < ContactArr.length; i++) {
                newArr[i] = ContactArr[i];
            }
            ContactArr = newArr;
        }

        ContactArr[index] = contact;
        index++;
        System.out.println("|| Kontakt qo‘shildi ||");
    }

    public  boolean checkContact(Contact c) {
        if (c.ism == null || c.ism.trim().length() < 3) {
            System.out.println("|| Ism xato !!! ||");
            return false;
        }
        if (c.familya == null || c.familya.trim().length() < 3) {
            System.out.println("|| Familya xato !!! ||");
            return false;
        }
        if (c.telefon == null || c.telefon.length() != 12 || !c.telefon.startsWith("998")) {
            System.out.println("|| Telefon xato !!! ||");
            return false;
        }

        for (char tel : c.telefon.toCharArray()) {
            if (!Character.isDigit(tel)) {
                System.out.println("|| Telefon faqat raqam bo‘lishi kerak !!! ||");
                return false;
            }
        }
        return true;
    }

    public  Contact addContact() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ism kiriting: ");
        String ism = sc.next();

        System.out.print("Familya kiriting: ");
        String familya = sc.next();

        System.out.print("Telefon kiriting: ");
        String telefon = sc.next();

        Contact contact = new Contact();
        contact.ism = ism;
        contact.familya = familya;
        contact.telefon = telefon;

        return contact;
    }

    public  void menu() {
        System.out.println("\n  ***** Menu *****  ");
        System.out.println("1. Kontakt qo'shish ");
        System.out.println("2. Kontakt ro'yxati ");
        System.out.println("3. Kontakt qidirish ");
        System.out.println("4. Kontakt o'chirish ");
        System.out.println("0. Tugatish ");
    }

    public  int getNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Qanday amal bajarasiz: ");
        return sc.nextInt();
    }
}
