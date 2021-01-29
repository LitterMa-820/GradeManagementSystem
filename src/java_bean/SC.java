package java_bean;

/**
 * @ProjectName: GradeManager
 * @Package: java_bean
 * @ClassName: SC
 * @Author: 82042
 * @Description:
 * @Date: 2020/9/11 23:04
 * @Version: 1.0
 */
public class SC {
    private int sno;
    private int cno;
    private double grade;
    private double credit;

    public SC() {
    }

    public SC(int sno, int cno, double grade, double credit) {
        this.sno = sno;
        this.cno = cno;
        this.grade = grade;
        this.credit = credit;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public int getCno() {
        return cno;
    }

    public void setCno(int cno) {
        this.cno = cno;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }
}
