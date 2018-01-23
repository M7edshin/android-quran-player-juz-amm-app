package shahin.quranmisharyrashid.Models;


public class Azkar {

    private String alzikr;
    private int times;
    private String benefits;

    public Azkar(String alzikr, int times, String benefits) {

        this.alzikr = alzikr;
        this.times = times;
        this.benefits = benefits;
    }

    public String getAlzikr() {
        return alzikr;
    }

    public int getTimes() {
        return times;
    }

    public String getBenefits() {
        return benefits;
    }
}
