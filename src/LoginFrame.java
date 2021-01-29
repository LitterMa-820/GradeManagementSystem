import dialog.ErrDialog;
import java_bean.User;
import method.SqlMethod;

import javax.swing.*;
import java.awt.*;

/**
 * @ProjectName: StudentAchievementManagementSystem
 * @Package: frames
 * @ClassName: LoginFrame
 * @Author: 82042
 * @Description: 登录窗口
 * @Date: 2020/9/10 15:19
 * @Version: 1.0
 */
public class LoginFrame extends JFrame {
    //创建容器
    Container container = getContentPane();
    //设置窗口图标标签
    JLabel label_headLogin = new JLabel("学生成绩管系统");
    //用户名标签
    JLabel label_username = new JLabel("用户名:");
    //设置用户名输入域
    JTextField text_username = new JTextField(25);
    //密码标签
    JLabel label_password = new JLabel("密码:");
    //设置密码输入域
    JPasswordField text_password = new JPasswordField();
    //设置登录按钮
    JButton button_login = new JButton("登录");
    //初始化
    public void init(){
        //设置窗口可见
        setVisible(true);
        //设置窗口大小
        //窗口大小
        int frame_width = 540;
        int frame_high = 270;
        setBounds(500,300, frame_width, frame_high);
        //窗口可关闭
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //窗口大小不可调整
        setResizable(false);
        //设置为绝对布局
        setLayout(null);
        label_headLogin.setBounds(230,30,100,25);
        //设置用户名标签位置和大小
        label_username.setBounds(140,75,40,25);
        text_username.setBounds(185,75,180,25);
        //设置密码标签的位置和大小
        label_password.setBounds(140,105,40,25);
        text_password.setBounds(185,105,180,25);
        //按钮位置
        button_login.setBounds(235,140,75,25);
        button_login.setBackground(new Color(253,254,254));
        //往容器中添加组件
        container.add(label_headLogin);
        container.add(label_username);
        container.add(text_username);
        container.add(label_password);
        container.add(text_password);
        container.add(button_login);
        loginEvent();
    }
    public LoginFrame() {
        init();
    }
    public void loginEvent(){
        //添加监听事件
        button_login.addActionListener((e)->{
            String username = text_username.getText();
            String password = new String(text_password.getPassword());
            boolean login = SqlMethod.login(username, password);
            //如果登录成功则隐藏窗口并创建菜单窗口,如果失败则会弹出失败窗口
            if (login){ setVisible(false);
                User user = SqlMethod.getUser();
                new MenuFrame(user.getUsername(), user.getRole());
            }else{
                new ErrDialog("用户名或密码错误",1);
            }
        });
    }
}
