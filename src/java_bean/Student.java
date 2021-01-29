package java_bean;

/**
 * @ProjectName: GradeManager
 * @Package: java_bean
 * @ClassName: Student
 * @Author: 82042
 * @Description: 学生信息
 * @Date: 2020/9/11 18:25
 * @Version: 1.0
 */
public class Student {
    private int sno;
    private String name;
    private String sex;
    private int age;
    private String dept;

    public Student(int sno, String name, String sex, int age, String dept) {
        this.sno = sno;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.dept = dept;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public Student() {
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return  "学号:" + sno +
                ", 姓名:'" + name + '\'' +
                ", 性别:'" + sex + '\'' +
                ", 年龄:" + age +
                ", 学部:'" + dept + '\''
                ;
    }
}
