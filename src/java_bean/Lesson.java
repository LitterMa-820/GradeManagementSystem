package java_bean;

/**
 * @ProjectName: GradeManager
 * @Package: java_bean
 * @ClassName: Lesson
 * @Author: 82042
 * @Description:
 * @Date: 2020/9/11 22:42
 * @Version: 1.0
 */
public class Lesson {
    private int cno;
    private String cname;
    private String teacher;
    private int credit;

    public Lesson(int cno, String cname, String teacher, int credit) {
        this.cno = cno;
        this.cname = cname;
        this.teacher = teacher;
        this.credit = credit;
    }

    public Lesson() {
    }

    public int getCno() {
        return cno;
    }

    public void setCno(int cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
}
