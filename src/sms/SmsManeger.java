package sms;

import contact.Contact;
import contact.ContactManegir;
import util.scannerUtil;

import java.time.LocalDateTime;
import java.util.Scanner;

public class SmsManeger {
    private sms[] smsArray=new sms[10];
    private int index=1;
    private int indexOf=0;


    private ContactManegir contactManegir;

    public SmsManeger(ContactManegir contactManegir){
        this.contactManegir=contactManegir;
    }
    public void start(){
        boolean boshlashSms=true;
        while (boshlashSms){
            menu();
            int number= scannerUtil.getNumber1();
            switch (number){
                case 1:
                    sms smsXabar=sentSms();
                    addToArray(smsXabar);
                    //
                    break;
                case 2:
                    String raam=getSearch();
                    search(raam);
                    break;
                case 3:
                    Allsearch();
                    break;
                case 4:
                    String getDelet=getNumberDelet();
                    DeletSms(getDelet);
                    break;
                case 0:
                    System.out.println("|| Dastur tugadi! ||");
                    boshlashSms=false;
                    break;
                default:
                    System.out.println("Siz xato raqam or harf kritdingiz !!!");
            }

        }
    }


    public void DeletSms(String getNumber){
        for (int i=0; i<smsArray.length; i++){
            sms sms=smsArray[i];
            if (sms!=null && sms.getTelefon().equals(getNumber)){
                smsArray[i]=null;
                System.out.println("Sms o'chirildi");
            }
        }
    }
    public String getNumberDelet(){
        System.out.println("Telefon raqam: ");
        return scannerUtil.sc.nextLine();
    }
    public String getSearch(){
        System.out.println("Telefon qaraqam: ");
        return scannerUtil.sc.nextLine();
    }
    public void search(String raqam){
        for (sms sms:smsArray){
            if (sms!=null && sms.getTelefon().equals(raqam) ){
                System.out.println(sms.getId()+". "+sms.getTelefon()+"\n"+sms.getXabar()+" "+sms.getSentDate());
            }
        }
    }
    public void Allsearch(){
        for (int i=0;i<smsArray.length;i++){
            if (smsArray[i]!=null){
                System.out.println(smsArray[i].getId()+". "+smsArray[i].getTelefon()+"\n"+smsArray[i].getXabar());
            }
        }
    }
    public void addToArray(sms smsXabar){
            boolean b=contactManegir.isVlit(smsXabar.getTelefon());
            if(!b){
                System.out.println("Bunday telefon contada yo'q !!!");
                return;
            }
            smsXabar.setId(index++);
            smsXabar.setSentDate(LocalDateTime.now());
        if (smsArray.length==indexOf){
            sms[] newSmsArray=new sms[smsArray.length*2];
            for (int i=0;i<smsArray.length;i++){
                smsArray[i]=newSmsArray[i];
            }
            smsArray=newSmsArray;
        }
        smsArray[indexOf]=smsXabar;
        System.out.println("Jo'natildi");
    }
    public sms sentSms(){
        System.out.print("Telefon kiriting: ");
        String telefon=scannerUtil.sc.next();

        System.out.print("Xabar kiriting: ");
        String xabar=scannerUtil.scLine.nextLine();

        sms sms=new sms();
        sms.setTelefon(telefon);
        sms.setXabar(xabar);
        return sms;
    }
    public void menu(){
      System.out.printf("------------------------------------%n");
      System.out.printf("|         ****Sms Menu****        |%n");
    System.out.printf("------------------------------------%n");
    System.out.printf("| %-32s |%n", "1. Sms jo'natish ");
    System.out.printf("| %-32s |%n", "2. Sms tarixi ");
    System.out.printf("| %-32s |%n", "3. Barcha sms tarixi ");
    System.out.printf("| %-32s |%n", "4. Sms tarixini o'chirish ");
    System.out.printf("| %-32s |%n", "0. Tugatish ");
    System.out.printf("------------------------------------%n");
}
}

