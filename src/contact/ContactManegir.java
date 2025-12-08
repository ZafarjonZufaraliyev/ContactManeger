package contact;

import java.util.Scanner;

public class ContactManegir {
    Contact[] ContactArr = new Contact[10];
    int index = 0;

    public void start() {
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

    public void deleteContact(String telefonDelete) {
        for (int i = 0; i < ContactArr.length; i++) {
            Contact contact = ContactArr[i];
            if (contact != null && contact.getTelefon().equals(telefonDelete)) {
                System.out.println("|| " + contact.getIsm() + " " + contact.getFamilya() + " kontakti o'chirildi ||");
                ContactArr[i] = null;
                return;
            }
        }
        System.out.println("|| Kontakt topilmadi ||");
    }

    public String inputDeletePhone() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Telefon raqam: ");
        return sc.next();
    }

    public String query() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Qidirish: ");
        return sc.next();
    }

    public void search(String qidiruvValue) {
        boolean found = true;
        String inputSon = qidiruvValue.toLowerCase();
        System.out.printf("--------------------------------------------------%n");
        System.out.printf("|                       Ro'yxat                  |%n");
        System.out.printf("--------------------------------------------------%n");
        System.out.printf("| %-10s | %-15s | %-15s |%n", "Ism", "Familya", "Telefon");
        for (Contact c : ContactArr) {
            if (c != null &&
                    (c.getIsm().toLowerCase().contains(inputSon) ||
                            c.getFamilya().toLowerCase().contains(inputSon) ||
                            c.getFamilya().toLowerCase().contains(inputSon))) {

                System.out.printf("| %-10s | %-15s | %-15s |%n", c.getIsm(), c.getFamilya(), c.getTelefon());
                found = false;
            }
        }
        System.out.printf("--------------------------------------------------%n");
        if (found) System.out.println("|| Hech narsa topilmadi ||");
    }

    public void printList() {
        boolean empty = true;
        System.out.printf("--------------------------------------------------%n");
        System.out.printf("|                       Ro'yxat                  |%n");
        System.out.printf("--------------------------------------------------%n");
        System.out.printf("| %-10s | %-15s | %-15s |%n", "Ism", "Familya", "Telefon");
        for (Contact c : ContactArr) {
            if (c != null) {
                System.out.printf("| %-10s | %-15s | %-15s |%n", c.getIsm(), c.getFamilya(), c.getTelefon());
                empty = false;
            }
        }
        System.out.printf("--------------------------------------------------%n");
        if (empty) System.out.println("|| Kontaktlar yo‘q ||");
    }

    public void addArrayContact(Contact contact) {
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

    public boolean checkContact(Contact c) {
        if (c.getIsm() == null || c.getIsm().trim().length() < 3) {
            System.out.println("|| Ism xato !!! ||");
            return false;
        }
        if (c.getFamilya() == null || c.getFamilya().trim().length() < 3) {
            System.out.println("|| Familya xato !!! ||");
            return false;
        }
        if (c.getTelefon() == null || c.getTelefon().length() != 12 || !c.getTelefon().startsWith("998")) {
            System.out.println("|| Telefon xato !!! ||");
            return false;
        }

        for (char tel : c.getTelefon().toCharArray()) {
            if (!Character.isDigit(tel)) {
                System.out.println("|| Telefon faqat raqam bo‘lishi kerak !!! ||");
                return false;
            }
        }
        return true;
    }

    public Contact addContact() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ism kiriting: ");
        String ism = sc.next();

        System.out.print("Familya kiriting: ");
        String familya = sc.next();

        System.out.print("Telefon kiriting: ");
        String telefon = sc.next();

        Contact contact = new Contact();
        contact.setIsm(ism);
        contact.setFamilya(familya);
        contact.setTelefon(telefon);

        return contact;
    }

    public void menu() {
        System.out.printf("-----------------------------%n");
        System.out.printf("|   ****Contact Menu****    |%n");
        System.out.printf("-----------------------------%n");
        System.out.printf("| %-25s |%n", "1. Kontakt qo'shish ");
        System.out.printf("| %-25s |%n", "2. Kontakt ro'yxati ");
        System.out.printf("| %-25s |%n", "3. Kontakt qidirish ");
        System.out.printf("| %-25s |%n", "4. Kontakt o'chirish ");
        System.out.printf("| %-25s |%n", "0. Tugatish ");
        System.out.printf("-----------------------------%n");
    }

    public int getNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Qanday amal bajarasiz: ");
        return sc.nextInt();
    }
}
