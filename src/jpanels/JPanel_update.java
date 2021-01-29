package jpanels;

import dialog.ErrDialog;
import java_bean.Lesson;
import java_bean.SC;
import java_bean.Student;
import method.SqlMethod;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.ArrayList;

/**
 * @ProjectName: GradeManager
 * @Package: JPanels
 * @ClassName: JPanel_update
 * @Author: 82042
 * @Description: 修改数据面板
 * @Date: 2020/9/11 10:00
 * @Version: 1.0
 */
//学生信息表修改面板
public class JPanel_update extends JPanel {
    private int role;
    private JTable jTable=new JTable();//用于显示列表
    private JScrollPane tablePane=new JScrollPane();
    private JButton jButton_add_s=new JButton("添加");//用于增加一行数据
    private JButton jButton_delete_s=new JButton("删除");//用于删除一行数据
    private JButton jButton_add_c=new JButton("添加");
    private JButton jButton_delete_c=new JButton("删除");//用于删除一行数据
    private JButton jButton_add_sc=new JButton("添加");
    private JButton jButton_delete_sc=new JButton("删除");//用于删除一行数据
    //学生表标签
    private JLabel jLabel_sno=new JLabel("学号");
    private JLabel jLabel_name=new JLabel("姓名");
    private JLabel jLabel_sex=new JLabel("性别");
    private JLabel jLabel_age=new JLabel("年龄");
    private JLabel jLabel_dept=new JLabel("学部");
    //课程表标签
    private JLabel jLabel_cno=new JLabel("课号");
    private JLabel jLabel_cname=new JLabel("课名");
    private JLabel jLabel_teacher=new JLabel("教师");
    private JLabel jLabel_credit=new JLabel("学分");
    //选课表标签
    private JLabel jLabel_sc_sno=new JLabel("学号");
    private JLabel jLabel_sc_cno=new JLabel("课号");
    private JLabel jLabel_sc_grade=new JLabel("成绩");
    //学生表输入框
    private JTextField jTextField_sno=new JTextField();
    private JTextField jTextField_name=new JTextField();
    private JTextField jTextField_sex=new JTextField();
    private JTextField jTextField_age=new JTextField();
    private JTextField jTextField_dept=new JTextField();
    private JTextField jTextField_delete_sno=new JTextField();//删除输入域
    //课表输入框
    private JTextField jTextField_cno=new JTextField();
    private JTextField jTextField_cname=new JTextField();
    private JTextField jTextField_teacher=new JTextField();
    private JTextField jTextField_credit=new JTextField();
    private JTextField jTextField_delete_c=new JTextField();//删除输入域
    //选课表输入框
    private JTextField jTextField_sc_sno=new JTextField();
    private JTextField jTextField_sc_cno=new JTextField();
    private JTextField jTextField_sc_grade=new JTextField();
    private JTextField jTextField_delete_sc_sno=new JTextField();//删除输入域
    private JTextField jTextField_delete_sc_cno=new JTextField();//删除输入域
    //下拉列表
    String[] contents={"学生表","课表","选课表"};
    JList<String> jList=new JList<>(contents);
    private String[] thead1=new String[]{"学号","姓名","性别","年龄","学部"};
    private String[] thead2=new String[]{"课号","课名","教师","学分"};
    private String[] thead3=new String[]{"学号","课号","成绩","学分"};
    //用于存储学生信息
    ArrayList<Student> sList=null;
    //用于存储课程信息
    ArrayList<Lesson> cList=null;
    //用于存储选课表信息
    ArrayList<SC> SCList=null;
    public JPanel_update(int role) {
        this.role=role;
        setBounds(100,50,980,620);
        setVisible(false);
        setLayout(null);
        //调用设置监听事件的方法
        buttonEvent();
        setBackground(new Color(235,235,235));
        jTable.getTableHeader().setReorderingAllowed(false);//无法移动
        jTable.getTableHeader().setResizingAllowed(false);//无法拉动
        jTable.setEnabled(false);//无法修改
        tablePane.setBounds(50,50,500,200);
        tablePane.setVisible(true);
        tablePane.setViewportView(jTable);
        tablePane.setBackground(new Color(186,188,185));
        this.add(tablePane);
        jLabel_sno.setBounds(50,255,70,25);
        jLabel_name.setBounds(150,255,70,25);
        jLabel_sex.setBounds(250,255,70,25);
        jLabel_age.setBounds(350,255,70,25);
        jLabel_dept.setBounds(450,255,70,25);
        add(jLabel_sno);
        add(jLabel_name);
        add(jLabel_sex);
        add(jLabel_age);
        add(jLabel_dept);
        //文本框
        jTextField_sno.setBounds(50,280,80,25);
        jTextField_name.setBounds(150,280,80,25);
        jTextField_sex.setBounds(250,280,80,25);
        jTextField_age.setBounds(350,280,80,25);
        jTextField_dept.setBounds(450,280,80,25);
        //添加组件
        add(jTextField_sno);
        add(jTextField_name);
        add(jTextField_sex);
        add(jTextField_age);
        add(jTextField_dept);
        jButton_add_s.setBounds(560,280,90,25);
        jButton_add_s.setToolTipText("增加一条学生信息");
        jButton_add_s.setBackground(new Color(253,254,254));
        add(jButton_add_s);
        //设置删除组件
        jTextField_delete_sno.setBounds(50,310,80,25);
        add(jTextField_delete_sno);
        jButton_delete_s.setBounds(560,310,90,25);
        jButton_delete_s.setToolTipText("删除一条学生信息");
        jButton_delete_s.setBackground(new Color(253,254,254));
        add(jButton_delete_s);
        //设置课表修改组件
        jLabel_cno.setBounds(50,345,70,25);
        jLabel_cname.setBounds(150,345,70,25);
        jLabel_teacher.setBounds(250,345,70,25);
        jLabel_credit.setBounds(350,345,70,25);
        add(jLabel_cno);
        add(jLabel_cname);
        add(jLabel_teacher);
        add(jLabel_credit);
        jTextField_cno.setBounds(50,370,80,25);
        jTextField_cname.setBounds(150,370,80,25);
        jTextField_teacher.setBounds(250,370,80,25);
        jTextField_credit.setBounds(350,370,80,25);
        add(jTextField_cno);
        add(jTextField_cname);
        add(jTextField_teacher);
        add(jTextField_credit);
        jButton_add_c.setBounds(560,370,90,25);
        jButton_add_c.setToolTipText("增加一条课程信息");
        jButton_add_c.setBackground(new Color(253,254,254));
        add(jButton_add_c);
        jTextField_delete_c.setBounds(50,400,80,25);
        add(jTextField_delete_c);
        jButton_delete_c.setBounds(560,400,90,25);
        jButton_delete_c.setToolTipText("删除一条课程信息");
        jButton_delete_c.setBackground(new Color(253,254,254));
        add(jButton_delete_c);
        //设置选课表组件
        jLabel_sc_sno.setBounds(50,435,70,25);
        jLabel_sc_cno.setBounds(150,435,70,25);
        jLabel_sc_grade.setBounds(250,435,70,25);
        add(jLabel_sc_sno);
        add(jLabel_sc_cno);
        add(jLabel_sc_grade);
        jTextField_sc_sno.setBounds(50,460,80,25);
        jTextField_sc_cno.setBounds(150,460,80,25);
        jTextField_sc_grade.setBounds(250,460,80,25);
        add(jTextField_sc_sno);
        add(jTextField_sc_cno);
        add(jTextField_sc_grade);
        jButton_add_sc.setBounds(560,460,90,25);
        jButton_add_sc.setToolTipText("增加一条选课信息");
        jButton_add_sc.setBackground(new Color(253,254,254));
        add(jButton_add_sc);
        jTextField_delete_sc_sno.setBounds(50,490,80,25);
        jTextField_delete_sc_cno.setBounds(150,490,80,25);
        add(jTextField_delete_sc_sno);
        add(jTextField_delete_sc_cno);
        jButton_delete_sc.setBounds(560,490,90,25);
        jButton_delete_sc.setToolTipText("删除一条选课信息");
        jButton_delete_sc.setBackground(new Color(253,254,254));
        add(jButton_delete_sc);
        //放置列表栏
        jList.setBounds(570,50,100,100);
        jList.setBackground(Color.WHITE);
        add(jList);
    }
    //设置按扭事件监听
    public void buttonEvent(){
        //增加学生信息按钮事件
        jButton_add_s.addActionListener(e -> {
            if (role<1) new ErrDialog("权限不够！",1);
            else {
                int sno = Integer.parseInt(jTextField_sno.getText());
                String name = jTextField_name.getText();
                String sex = jTextField_sex.getText();
                int age = Integer.parseInt(jTextField_age.getText());
                String dept = jTextField_dept.getText();
                //清空输入框
                jTextField_sno.setText("");
                jTextField_name.setText("");
                jTextField_sex.setText("");
                jTextField_age.setText("");
                jTextField_dept.setText("");
                SqlMethod.addS(sno, name, sex, age, dept);
            }
        });
        //增加课程信息按钮时间
        jButton_add_c.addActionListener((event)->{
            if (role<1)new ErrDialog("权限不够",1);
            else {
                int cno = Integer.parseInt(jTextField_cno.getText());
                String cname = jTextField_cname.getText();
                String teacher = jTextField_teacher.getText();
                int credit = Integer.parseInt(jTextField_credit.getText());
                jTextField_cno.setText("");
                jTextField_cname.setText("");
                jTextField_teacher.setText("");
                jTextField_credit.setText("");
                SqlMethod.addC(cno, cname, teacher, credit);
            }
        });
        //增加选课信息事件
        jButton_add_sc.addActionListener(e ->{
            if (role<1)new ErrDialog("权限不够",1);
            else {
                int sno = Integer.parseInt(jTextField_sc_sno.getText());
                int cno = Integer.parseInt(jTextField_sc_cno.getText());
                double grade = Double.parseDouble(jTextField_sc_grade.getText());
                jTextField_sc_sno.setText("");
                jTextField_sc_cno.setText("");
                jTextField_sc_grade.setText("");
                SqlMethod.addSC(sno, cno, grade);
            }
        });
        //删除事件
        jButton_delete_s.addActionListener(e->{
            if (role<1)new ErrDialog("权限不够",1);
            else {
                int sno = Integer.parseInt(jTextField_delete_sno.getText());
                jTextField_delete_sno.setText("");
                SqlMethod.DeleteS(sno);
            }
        });
        jButton_delete_c.addActionListener(e->{
            if (role<1)new ErrDialog("权限不够",1);
            else {
                int cno = Integer.parseInt(jTextField_delete_c.getText());
                jTextField_delete_c.setText("");
                SqlMethod.deleteC(cno);
            }
        });
        jButton_delete_sc.addActionListener(e->{
            if (role<1)new ErrDialog("权限不够",1);
            else {
                int sno = Integer.parseInt(jTextField_delete_sc_sno.getText());
                int cno = Integer.parseInt(jTextField_delete_sc_cno.getText());
                jTextField_delete_sc_sno.setText("");
                jTextField_delete_sc_cno.setText("");
                SqlMethod.deleteSC(sno, cno);
            }
        });
        //列表事件
        jList.addListSelectionListener(e -> {
           if (!e.getValueIsAdjusting()){//鼠标释放时触发
               String selectedValue = jList.getSelectedValue();
               switch (selectedValue)
               {
                   case "学生表":
                       //调用查询方法获得数据
                       sList=SqlMethod.showS();
                       String[][] s_data=new String[sList.size()][5];
                       for (int i = 0; i < sList.size(); i++) {
                           Student student=sList.get(i);
                           s_data[i][0]=student.getSno()+"";
                           s_data[i][1]=student.getName();
                           s_data[i][2]=student.getSex();
                           s_data[i][3]=student.getAge()+"";
                           s_data[i][4]=student.getDept();
                       }
                       TableModel s_head=new DefaultTableModel(s_data,thead1);
                       jTable.setModel(s_head);
                       break;
                   case "课表":
                       //调用查询方法获得数据
                       cList=SqlMethod.showC();
                       String[][] c_data=new String[cList.size()][4];
                       for (int i = 0; i < cList.size(); i++) {
                           Lesson lesson=cList.get(i);
                           c_data[i][0]=lesson.getCno()+"";
                           c_data[i][1]=lesson.getCname();
                           c_data[i][2]=lesson.getTeacher();
                           c_data[i][3]=lesson.getCredit()+"";
                       }
                       TableModel c_head=new DefaultTableModel(c_data,thead2);
                       jTable.setModel(c_head);
                       break;
                   case "选课表":
                       //调用查询方法获得数据
                       SCList=SqlMethod.showSC();
                       String[][] sc_data=new String[SCList.size()][4];
                       for (int i = 0; i < SCList.size(); i++) {
                           SC sc=SCList.get(i);
                           sc_data[i][0]=sc.getSno()+"";
                           sc_data[i][1]=sc.getCno()+"";
                           sc_data[i][2]=sc.getGrade()+"";
                           sc_data[i][3]=sc.getCredit()+"";
                       }
                       TableModel sc_head=new DefaultTableModel(sc_data,thead3);
                       jTable.setModel(sc_head);
                       break;
               }
           }
        });
    }
}
