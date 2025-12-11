package util;

import java.util.Scanner;

public class scannerUtil {
    public static  Scanner sc ;
    public static  Scanner scLine ;
    public static  Scanner scInt ;
    static {
        sc=new Scanner(System.in);
        scLine=new Scanner(System.in);
        scInt=new Scanner(System.in);
    }

    public static int getNumber1() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Qanday amal bajarasiz: ");
        return sc.nextInt();
    }
}
