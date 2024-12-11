package qa;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import qa.ComponentInWindow;
import qa.JFrameInsertStudent;

public class MainMenu extends JFrame{
	public MainMenu() {
//		JFrame frame = new JFrame("失物招领管理系统");
        setSize(300, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);
        
        setVisible(true);
		
	}
//    public static void main(String[] args) {
//        );
//    }
//    
    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);
        
        JButton submitButton = new JButton("提交失物");
        submitButton.setBounds(50, 30, 200, 25);
        panel.add(submitButton);

        JButton queryButton = new JButton("查询失物");
        queryButton.setBounds(50, 65, 200, 25);
        panel.add(queryButton);
        
        JButton otherButton = new JButton("其他");
        otherButton.setBounds(50, 100, 200, 25);
        panel.add(otherButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a new instance of the ComponentInWindow and display it when submitButton is clicked
                ComponentInWindow componentInWindow = new ComponentInWindow();
                componentInWindow.setSize(400, 300);
                componentInWindow.setVisible(true);               
            }
        });
        
        queryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 处理查询失物按钮点击事件
            	JFrameInsertStudent JFrameInsertStudent = new JFrameInsertStudent();

            }
        });

        otherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 处理其他按钮点击事件
                JOptionPane.showMessageDialog(null, "点击了其他按钮");
            }
        });
    }
}