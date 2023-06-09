package riho.project.sungjuk.model;

public class SungjukVO {
    private String name;
    private int kor;
    private int eng;
    private int mat;
    private int tot;
    private double avg;
    private String grd;

    public SungjukVO() {
    }

    public SungjukVO(String name, int kor, int eng, int mat) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.mat = mat;
    }

    public SungjukVO(String name, int kor, int eng, int mat, int tot, double avg, String grd) {
        this(name, kor, eng, mat);  //SungjukVO
        this.tot = tot;
        this.avg = avg;
        this.grd = grd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public int getMat() {
        return mat;
    }

    public void setMat(int mat) {
        this.mat = mat;
    }

    public int getTot() {
        return tot;
    }

    public void setTot(int tot) {
        this.tot = tot;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public String getGrd() {
        return grd;
    }

    public void setGrd(String grd) {
        this.grd = grd;
    }

    @Override
    public String toString() {
        String fmt = "%s %d %d %d %d %.1f %s\n ";
        return String.format(fmt,name,kor,eng,mat,tot,avg,grd);
    }
}
