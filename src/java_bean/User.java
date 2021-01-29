package java_bean;
/**
 * @ProjectName: StudentAchievementManagementSystem
 * @Package: PACKAGE_NAME
 * @ClassName: Uer
 * @Author: 82042
 * @Description: 这是一个用于存储登录信息的类
 * @Date: 2020/8/15 15:50
 * @Version: 1.0
 */
public class User {
    private String username;//用户名
    private int role;//权限

    public User() {
    }

    public User(String username, int role) {
        this.username = username;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Uer{" +
                "用户名：='" + username + '\'' +
                ", 权限=" + role +
                '}';
    }
}
