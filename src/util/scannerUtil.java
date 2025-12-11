package util;

import java.util.Scanner;

public class scannerUtil {
    public static  Scanner sc ;
    static {
        sc=new Scanner(System.in);
    }

    public static int getNumber1() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Qanday amal bajarasiz: ");
        return sc.nextInt();
    }
}
