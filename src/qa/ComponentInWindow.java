package qa;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ComponentInWindow extends JFrame {

    JTextField timeText, placeText, itemText;
    JButton submitButton;
    JComboBox<Object> comboBox;
    JTextArea descriptionArea;

    public ComponentInWindow() {
        init();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void init() {
        setLayout(new FlowLayout()); // 设置布局

        add(new JLabel("时间:"));
        timeText = new JTextField(10);
        add(timeText);

        add(new JLabel("地点:"));
        placeText = new JTextField(10);
        add(placeText);

        add(new JLabel("物品:"));
        itemText = new JTextField(10);
        add(itemText);

        add(new JLabel("具体描述"));
        descriptionArea = new JTextArea(6, 13);// 文本区设置行数和列数
        add(new JScrollPane(descriptionArea));

        add(new JLabel(" "));
        submitButton = new JButton("提交");
        add(submitButton);
    }
    public void actionPerformed(ActionEvent e) {
    	if (e.getSource() == submitButton) {
    		String str="提交成功！";
    	}
    }
        public static void main(String[] args) {
        	ComponentInWindow system = new ComponentInWindow();
            system.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            system.setSize(400, 300);
            system.setVisible(true);
    }
}