package sms;

import contact.ContactManegir;

import java.time.LocalDateTime;

public class sms {
    private int id;
    private String telefon;
    private  String xabar;

    private LocalDateTime sentDate;

    public LocalDateTime getSentDate() {
        return sentDate;
    }

    public void setSentDate(LocalDateTime sentDate) {
        this.sentDate = sentDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getXabar() {
        return xabar;
    }

    public void setXabar(String xabar) {
        this.xabar = xabar;
    }
}
