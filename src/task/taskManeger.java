package task;

import util.scannerUtil;

import java.util.Scanner;

public class taskManeger {
    public Task[] taskArray = new Task[10];
    public Integer index = 0;
    public Integer generalId = 1;

    public void start() {
        Boolean boshlanTask = true;
        while (boshlanTask) {
            menu();
            Integer number = scannerUtil.getNumber1();
            switch (number) {
                case 1:
                    Task task = addTask();
                    addToArray(task);
                    break;
                case 2:
                    prinTask();
                    break;
                case 3:
                    String getSarlavha = getChangeTitel();
                    changeStatusTitel(getSarlavha);
                    break;
                case 4:
                    int getId = getChangeId();
                    changeStatusId(getId);
                    break;
                case 5:
                    prinActivTask();
                    break;
                case 0:
                    break;
            }
        }
    }

    public Task addTask() {

        System.out.print("Sarlavha kiriting: ");
        String sarlavha = scannerUtil.scLine.nextLine();

        System.out.print("Mazmun kiriting: ");
        String mazmun = scannerUtil.scLine.nextLine();

        Task task = new Task();
        task.setSarlavha(sarlavha);
        task.setMazmun(mazmun);

        return task;
    }

    public boolean chekTask(Task task) {
        String sarlavha = task.getSarlavha();
        String mazmun = task.getMazmun();
        if (sarlavha.length() < 3 || sarlavha == null) {
            System.out.println("Sarlavhani to'liq kiriting!!!");
            return false;
        }
        if (mazmun.length() < 3 || mazmun == null) {
            System.out.println("Mazmuni to'liq kiriting!!!");
            return false;
        }
        return true;
    }

    public void addToArray(Task task) {
        if (!chekTask(task)) return;
        task.setHolat("Bajarilmadi");
        task.setId(generalId++);
        if (taskArray.length == index) {
            Task[] newtaskArray = new Task[taskArray.length * 2];
            for (int i = 0; i < taskArray.length; i++) {
                newtaskArray[i] = taskArray[i];
            }
            taskArray = newtaskArray;
        }
        taskArray[index] = task;
        index++;
        System.out.println("|| Kontakt qo‘shildi ||");
    }

    public void prinTask() {
        System.out.printf("--------------------------------------------------------------%n");
        System.out.printf("|                      TaskList                              |%n");
        System.out.printf("--------------------------------------------------------------%n");
        System.out.printf("| %-12s | %-25s | %-15s |\n", "Sarlavha", "Mazmun", "Holat");
        System.out.printf("--------------------------------------------------------------%n");
        for (Task task : taskArray) {
            if (task != null) {
                System.out.printf("|%-12s | %-25s | %-15s |%n", task.getSarlavha(), task.getMazmun(), task.getHolat());
            }
        }
        System.out.printf("--------------------------------------------------------------%n");
    }

    public String getChangeTitel() {
        System.out.print("Sarlavhani kiriting: ");
        return scannerUtil.sc.next();
    }

    public void changeStatusTitel(String sarlavha) {
        Boolean chiqish = true;
        for (Task task : taskArray) {
            if (task != null && task.getSarlavha().equals(sarlavha)) {
                if (task.getHolat().equals("Bajarilmadi")) {
                    task.setHolat("Bajarildi");
                } else {
                    task.setHolat("Bajarilmadi");
                }
                System.out.println("|| Holat o'zgartroldi ||");
                chiqish = false;
                break;
            }
        }
        if (chiqish) System.out.print("Bunda vazifa yo'q !!!");
    }

    public int getChangeId() {
        System.out.print("Id ni kiriting: ");
        return scannerUtil.scInt.nextInt();
    }

    public void changeStatusId(int Id) {
        Boolean chiqish = true;
        for (Task task : taskArray) {
            if (task != null && task.getId() == Id) {
                if (task.getHolat().equals("Bajarilmadi")) {
                    task.setHolat("Bajarildi");
                } else {
                    task.setHolat("Bajarilmadi");
                }
                System.out.print("|| Holat o'zgartrildi ||");
                chiqish = false;
                break;
            }
        }
        if (chiqish) System.out.print("Bunda vazifa yo'q !!!");
    }

    public void prinActivTask() {
        System.out.printf("--------------------------------------------------------------%n");
        System.out.printf("|                      TaskList                              |%n");
        System.out.printf("--------------------------------------------------------------%n");
        System.out.printf("| %-3s | %-12s | %-22s | %-12s |\n", "Id", "Sarlavha", "Mazmun", "Holat");
        for (Task task : taskArray) {
            if (task != null && task.getHolat().equals("Bajarilmadi")) {
                System.out.printf("| %-3d | %-12s | %-22s | %-12s |\n", task.getId(), task.getSarlavha(), task.getMazmun(), task.getHolat());

            }
        }
        System.out.printf("--------------------------------------------------------------%n");
    }


    public void menu() {
        System.out.printf("------------------------------------%n");
        System.out.printf("|         ****Task Menu****        |%n");
        System.out.printf("------------------------------------%n");
        System.out.printf("| %-32s |%n", "1. Vazifa qo'shish ");
        System.out.printf("| %-32s |%n", "2. Vazifa ro'yxati ");
        System.out.printf("| %-32s |%n", "3. Holatni o‘zgartirish (nomi) ");
        System.out.printf("| %-32s |%n", "4. Holatni o‘zgartirish (id) ");
        System.out.printf("| %-32s |%n", "5. Aktiv vazifa ");
        System.out.printf("| %-32s |%n", "0. Tugatish ");
        System.out.printf("------------------------------------%n");
    }
}
