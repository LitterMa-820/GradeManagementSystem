package jpanels;

import method.SqlMethod;

import javax.swing.*;
import java.awt.*;

/**
 * @ProjectName: GradeManager
 * @Package: jPanels
 * @ClassName: JPanel_select
 * @Author: 82042
 * @Description: 查询功能面板
 * @Date: 2020/9/11 10:25
 * @Version: 1.0
 */
public class JPanel_select extends JPanel {
    private JLabel label=new JLabel("输入学号查询学生基本信息");
    private JTextField jTextField=new JTextField();
    private JButton button=new JButton("查询");
    private JTextArea jTextArea=new JTextArea();
    private JScrollPane textPanel=new JScrollPane();
    public JPanel_select() {
        init();
    }
    public void init(){
        setBounds(100,50,980,620);
        setVisible(false);
        setLayout(null);
        setBackground(new Color(235,235,235));
        label.setBounds(100,100,150,25);
        jTextField.setBounds(100,125,150,25);
        button.setBounds(260,125,90,25);
        button.setBackground(new Color(253,254,254));
        textPanel.setBounds(100,160,400,100);
        textPanel.setViewportView(jTextArea);
        jTextArea.setLineWrap(true);//自动换行
        jTextArea.setEditable(false);//不可编辑
        jTextArea.setBackground(Color.WHITE);
        buttonEvent();
        add(label);
        add(jTextField);
        add(button);
        add(textPanel);
    }
    //监听事件
    public void buttonEvent(){
        button.addActionListener(e->{
            int sno =Integer.parseInt(jTextField.getText());
            String student = SqlMethod.selectSBySno(sno);
            //截取姓名字段
            String substring = student.substring(10,14);
            //如果为空则不显示
            if (substring.equals("null"))
                jTextArea.setText("");
            else
            jTextArea.setText(student);
            jTextField.setText("");
        });
    }
}
