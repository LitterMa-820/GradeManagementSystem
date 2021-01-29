package dialog;

import javax.swing.*;
import java.awt.*;

/**
 * @ProjectName: StudentAchievementManagementSystem
 * @Package: dialog
 * @ClassName: ErrDialog
 * @Author: 82042
 * @Description: 错误弹窗
 * @Date: 2020/9/10 18:57
 * @Version: 1.0
 */
public class ErrDialog extends JDialog {
    JButton button=new JButton("关闭");
    public  ErrDialog(String errMessage,int i) {
        setVisible(true);
        setResizable(false);
        setLayout(new GridLayout(2,1));
        JLabel label = new JLabel();
        label.setHorizontalAlignment(SwingConstants.CENTER);
        if (i==1){
            setBounds(650,300,200,100);
        }
        else if (i==2){
            setBounds(650,300,400,100);
            label.setText(errMessage);
            label.setBounds(25,0,100,25);
        }
        Container contentPane = getContentPane();
        label.setText(errMessage);
        contentPane.add(label);
        button.setSize(60,25);
        contentPane.add(button);
        button.addActionListener(e -> {
           dispose();
        });
    }
}
