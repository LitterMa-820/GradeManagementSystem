package jpanels;

import dialog.ErrDialog;
import java_bean.FailScale;
import method.SqlMethod;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.ArrayList;

/**
 * @ProjectName: GradeManager
 * @Package: JPanels
 * @ClassName: JPanel_calculate
 * @Author: 82042
 * @Description: 统计面板
 * @Date: 2020/9/11 10:29
 * @Version: 1.0
 */
public class JPanel_calculate extends JPanel {
    private JTable jTable=new JTable();
    private JScrollPane jScrollPane=new JScrollPane();
    private JButton jButton=new JButton("查询");
    private JLabel jLabel=new JLabel();
    private String[] thead=new String[]{"课程","不及格人数","总人数","比例"};
    ArrayList<FailScale> list=null;
    private int role;
    public JPanel_calculate(int role) {
        this.role=role;
        init();
    }
    public void init(){
        setLayout(null);
        setBounds(100,50,980,620);
        setVisible(false);
        setBackground(new Color(235,235,235));
        setJButtonEvent();
        jLabel.setText("按班级统计不及格人数");
        jLabel.setBounds(100,100,150,25);
        jButton.setBounds(100,130,90,25);
        jButton.setBackground(new Color(253,254,254));
        jScrollPane.setBounds(100,160,500,200);
        jScrollPane.setViewportView(jTable);
        jTable.setBackground(Color.WHITE);
        add(jButton);
        add(jLabel);
        add(jScrollPane);
    }
    public void setJButtonEvent(){
        jButton.addActionListener(e->{
            //权限判断
            if (role<1)new ErrDialog("权限不够",1);
            else {
                list = SqlMethod.failScale();
                String[][] fail_scale_data = new String[list.size()][4];
                for (int i = 0; i < list.size(); i++) {
                    FailScale failScale = list.get(i);
                    fail_scale_data[i][0] = failScale.getCname();
                    fail_scale_data[i][1] = failScale.getFails() + "";
                    fail_scale_data[i][2] = failScale.getTotal() + "";
                    fail_scale_data[i][3] = failScale.getScale();
                }
                TableModel tableModel = new DefaultTableModel(fail_scale_data, thead);
                jTable.setModel(tableModel);
            }
        });
    }
}
