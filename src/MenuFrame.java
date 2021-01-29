import jpanels.JPanel_calculate;
import jpanels.JPanel_maintenance;
import jpanels.JPanel_select;
import jpanels.JPanel_update;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * @ProjectName: StudentAchievementManagementSystem
 * @Package: PACKAGE_NAME
 * @ClassName: MenuFrame
 * @Author: 82042
 * @Description: 菜单
 * @Date: 2020/9/10 19:18
 * @Version: 1.0
 */
public class MenuFrame extends JFrame {
    ArrayList<JButton> list=new ArrayList<>();//用于存储按钮
    ArrayList<JComponent>  list_panel=new ArrayList<>();//用于存储信息显示面板
    JPanel_update jPanel_update;//创建一个更新数据用的面板
    JPanel_select jPanel_select=new JPanel_select();//创建一个查询面板
    JPanel_calculate jPanel_calculate;//创建一个统计面板
    JPanel_maintenance jPanel_maintenance;//创建一个系统维护用的面板
    JPanel jPanel1 = new JPanel();//面板1,用于显示按钮栏
    JPanel jPanel2 = new JPanel();//面板2,用于显示查询功能栏
    JPanel jPanel3 = new JPanel();//面板3,用于显示上方信息栏
    Container container = getContentPane();//容器
    private final String username;//用户名
    private final int role;//权限
    public MenuFrame(String username, int role) {
        this.username=username;
        this.role=role;
        init();
        list_panel.add(jPanel2);
        list_panel.add(jPanel_update);
        list_panel.add(jPanel_select);
        list_panel.add(jPanel_calculate);
        list_panel.add(jPanel_maintenance);
        for (JComponent jPanel : list_panel) {
            container.add(jPanel);
        }
    }
    //初始化
    public void init(){
        setVisible(true);
        container.setLayout(null);
        jPanel_update=new JPanel_update(role);
        jPanel_calculate=new JPanel_calculate(role);
        jPanel_maintenance=new JPanel_maintenance(username,role);
        setBounds(250,50,1080,720);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        //设置面板1大小
        jPanel1.setBounds(0,50,100,620);
        jPanel1.setBackground(new Color(242,242,242));
        //设置面板2大小
        jPanel2.setBounds(100,50,980,620);
        jPanel2.setBackground(new Color(208,207,204));
        //设置面板3大小
        jPanel3.setBounds(0,0,1080,50);
        jPanel3.setBackground(new Color(253,254,254));//new Color(197,216,234)
        buttons(jPanel1);
        information(jPanel3);
        contentPanel(jPanel2);
        container.add(jPanel1);
        container.add(jPanel3);
    }
    //第1个面板用于按钮放置
    public void buttons(JPanel panel){
        JButton button1 = new JButton("编辑数据");
        JButton button2 = new JButton("查询数据");
        JButton button3 = new JButton("统计数据");
        JButton button4 = new JButton("系统维护");
        JButton button5 = new JButton("退出系统");
        button1.setBackground(new Color(253,254,254));
        button2.setBackground(new Color(253,254,254));
        button3.setBackground(new Color(253,254,254));
        button4.setBackground(new Color(253,254,254));
        button5.setBackground(new Color(253,254,254));
        list.add(button1);
        list.add(button2);
        list.add(button3);
        list.add(button4);
        list.add(button5);
        panel.setLayout(new GridLayout(5,1,10,10));
        for (JButton button : list) {
            panel.add(button);
        }
        button1.addActionListener(e -> {
            chosePanel(jPanel_update);
            buttonChangeColor(button1);
        });
        button2.addActionListener(e -> {
                chosePanel(jPanel_select);
                buttonChangeColor(button2);
        });
        button3.addActionListener(e -> {
            chosePanel(jPanel_calculate);
            buttonChangeColor(button3);
        });
        button4.addActionListener(e -> {
            chosePanel(jPanel_maintenance);
            buttonChangeColor(button4);
        });
        button5.addActionListener(e -> {
            System.exit(0);
        });
//        panel.setVisible(false);
    }
    //面板2用于放置选择提示内容
    public void contentPanel(JPanel jPanel){
        jPanel.setLayout(new BorderLayout());
        jPanel.setVisible(true);
        JLabel label = new JLabel("请选择左侧的按钮进行功能选择");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        jPanel.add(label);
    }
    //第3个面板,用于显示权限，姓名等
    public void information(JPanel jPanel){
        jPanel.setLayout(null);
        JLabel label1 = new JLabel();
        label1.setText("您好!: "+username);
        label1.setBounds(472,25,80,25);
        JLabel label2 = new JLabel();
        label2.setText("权限:  "+role);
        label2.setBounds(552,25,80,25);
        JLabel label3=new JLabel("欢迎使用学生成绩管理系统");
        label3.setFont(new Font("微软雅黑",Font.BOLD,18));
        label3.setBounds(425,0,300,25);
        jPanel.add(label1);
        jPanel.add(label2);
        jPanel.add(label3);
//        jPanel.setVisible(false);
    }
    //用于按钮切换功能面板
    public void chosePanel(JPanel panel){
        for (JComponent jPanel : list_panel) {
            jPanel.setVisible(jPanel == panel);
        }
    }
    //按钮变色
    public void buttonChangeColor(JButton button){
        for (JButton jButton : list) {
            if (button==jButton)
               jButton.setBackground(new Color(179,179,179));
            else jButton.setBackground(new Color(253,254,254));
        }
    }
}
