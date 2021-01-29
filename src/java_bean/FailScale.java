package java_bean;

/**
 * @ProjectName: GradeManager
 * @Package: java_bean
 * @ClassName: FailScale
 * @Author: 82042
 * @Description: 不及格人数及比例对象
 * @Date: 2020/9/12 15:41
 * @Version: 1.0
 */
public class FailScale {
    private String cname;
    private int fails;
    private int total;
    private String scale;

    public FailScale() {
    }

    public FailScale(String cname, int fails, int total, String scale) {
        this.cname = cname;
        this.fails = fails;
        this.total = total;
        this.scale = scale;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getFails() {
        return fails;
    }

    public void setFails(int fails) {
        this.fails = fails;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }
}
