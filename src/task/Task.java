package task;

public class Task {
    private Integer Id;
    private String sarlavha;
    private String mazmun;
    private String holat; //bajarildi, bajarilmadi

    public String getSarlavha() {
        return sarlavha;
    }

    public void setSarlavha(String sarlavha) {
        this.sarlavha = sarlavha;
    }

    public String getMazmun() {
        return mazmun;
    }

    public void setMazmun(String mazmun) {
        this.mazmun = mazmun;
    }

    public int getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getHolat() {
        return holat;
    }

    public void setHolat(String holat) {
        this.holat = holat;
    }
}
