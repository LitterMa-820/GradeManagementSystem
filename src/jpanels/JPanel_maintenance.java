package jpanels;

import dialog.ErrDialog;
import method.SqlMethod;

import javax.swing.*;
import java.awt.*;

/**
 * @ProjectName: GradeManager
 * @Package: jpanels
 * @ClassName: JPanel_maintenance
 * @Author: 82042
 * @Description: 系统维护面板
 * @Date: 2020/9/11 11:50
 * @Version: 1.0
 */
public class JPanel_maintenance extends JPanel {
    private JPasswordField old_password=new JPasswordField();
    private JPasswordField new_password=new JPasswordField();
    private JLabel remind=new JLabel("修改密码");
    private JLabel jLabel_old_password=new JLabel("请输入原密码:");
    private JLabel jLabel_new_password=new JLabel("请输入新密码:");
    private JButton affirm_button=new JButton("确认");
    private JButton button_storage=new JButton("转存");
    private JButton help_button=new JButton("帮助");
    private int role;
    private String username;
    public JPanel_maintenance(String username,int role) {
        this.username=username;
        this.role=role;
        init();
    }
    //初始化
    public void init(){
        setBounds(100,50,980,620);
        setLayout(null);
        setVisible(false);
        buttonEvent();
        setBackground(new Color(235,235,235));
        remind.setBounds(460,150,70,25);
        jLabel_old_password.setBounds(310,180,80,25);
        old_password.setBounds(395,180,180,25);
        jLabel_new_password.setBounds(310,210,80,25);
        new_password.setBounds(395,210,180,25);
        affirm_button.setBounds(445,245,80,25);
        affirm_button.setBackground(new Color(253,254,254));
        button_storage.setBounds(10,10,80,25);
        button_storage.setToolTipText("转存储数据库");
        button_storage.setBackground(new Color(253,254,254));
        help_button.setBounds(95,10,80,25);
        help_button.setToolTipText("帮助和代码维护");
        help_button.setBackground(new Color(253,254,254));
        add(help_button);
        add(button_storage);
        add(affirm_button);
        add(new_password);
        add(jLabel_new_password);
        add(old_password);
        add(jLabel_old_password);
        add(remind);
    }
    //按钮事件
    public void buttonEvent(){
        affirm_button.addActionListener(e->{
            //修改密码
            String oldPassword = new String(old_password.getPassword());
            String newPassword = new String(new_password.getPassword());
            SqlMethod.changePassword(username,oldPassword,newPassword);
            old_password.setText("");
            new_password.setText("");
        });
        button_storage.addActionListener(e->{
            //转存储
            if (role!=2)new ErrDialog("权限不够",1);
            else
            SqlMethod.localStorage();
        });
        help_button.addActionListener(e->{
            //帮助功能
            new ErrDialog("帮助和代码维护请联系管理员mjh820421241@163.com",2);
        });
    }
}
