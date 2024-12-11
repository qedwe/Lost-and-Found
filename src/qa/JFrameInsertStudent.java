package qa;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class JFrameInsertStudent extends JFrame implements ActionListener {
    Connection conn = null;
    Statement stmt;
    ResultSet rs;
    String uri = "jdbc:mysql://localhost:3306/your_database_name";
    String user = "root";
    String password = "";

    JTextField sno, sname, birthday, adress,depart, speciality;
    JRadioButton ssexrb1, ssexrb2, memberrb1, memberrb2;
    
    

    JPanel panel1, panel2, northPanel, viewPanel, buttonsPanel;
    JButton saveButton, cancelButton;

    public JFrameInsertStudent() {
        setTitle("查询失物记录");
        setLayout(new BorderLayout());

        sno = new JTextField("", 10);
        sname = new JTextField("", 10);
        birthday = new JTextField("", 10);
        adress= new JTextField("", 20);
        depart = new JTextField("", 20);
        speciality = new JTextField("", 20);

        panel1 = new JPanel(new GridLayout(1, 2));
        ssexrb1 = new JRadioButton("男");
        ssexrb2 = new JRadioButton("女");

        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(ssexrb1);
        btnGroup.add(ssexrb2);

        panel1.add(ssexrb1);
        panel1.add(ssexrb2);

        panel2 = new JPanel(new GridLayout(1, 2));
        memberrb1 = new JRadioButton("是");
        memberrb2 = new JRadioButton("否");

        ButtonGroup btnGroup2 = new ButtonGroup();
        btnGroup2.add(memberrb1);
        btnGroup2.add(memberrb2);

        panel2.add(memberrb1);
        panel2.add(memberrb2);

        
        

        buttonsPanel = new JPanel(new FlowLayout());
        saveButton = new JButton("添加");
        cancelButton = new JButton("返回");
        buttonsPanel.add(saveButton);
        buttonsPanel.add(cancelButton);

        viewPanel = new JPanel();
        viewPanel.setSize(100, 150);
        viewPanel.setLayout(new GridLayout(6, 1));

        viewPanel.add(new JLabel("丢失物品", JLabel.LEFT));
        viewPanel.add(sno);
        viewPanel.add(new JLabel("姓名", JLabel.LEFT));
        viewPanel.add(sname);
        viewPanel.add(new JLabel("性别", JLabel.LEFT));
        viewPanel.add(panel1);
        viewPanel.add(new JLabel("丢失日期", JLabel.LEFT));
        viewPanel.add(birthday);
        viewPanel.add(new JLabel("丢失地点", JLabel.LEFT));
        viewPanel.add(adress);
        

        northPanel = new JPanel(new GridLayout(6, 2));
        northPanel.add(viewPanel);
        northPanel.add(buttonsPanel);

        add(northPanel, BorderLayout.NORTH);

        saveButton.addActionListener(this);
        cancelButton.addActionListener(this);

        setSize(300, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton) {
            try {
                if (insert() == 1)
                    JOptionPane.showMessageDialog(this, "添加成功", "提示ʾ", JOptionPane.INFORMATION_MESSAGE);
                else
                    JOptionPane.showMessageDialog(this, "添加失败", "提示ʾ", JOptionPane.INFORMATION_MESSAGE);

                query();
                clearAllInputData();
            } catch (Exception ee) {
                ee.printStackTrace();
            }
        } else if (e.getSource() == cancelButton) {
            clearAllInputData();
        }
    }


    public void clearAllInputData() {
        sno.setText("");
        sname.setText("");
        birthday.setText("");
        depart.setText("");
        speciality.setText("");
        adress.setText("");
        
    }

    public int insert() throws Exception {
        String sno1 = sno.getText().trim();
        String sname1 = sname.getText().trim();
        String ssex = ssexrb1.isSelected() ? "男":"女" ;
        
        String birthday1 = birthday.getText().trim();
        String adress1 = adress.getText().trim();
        String depart1 = depart.getText().trim();
        String speciality1 = speciality.getText().trim();
        int member = memberrb1.isSelected() ? 1 : 0;

        String sqlStr = "INSERT INTO studentInfo (stu_id, stu_name, sex, province, city, birthday, adress,department, speciality, member) ";
        sqlStr += "values(?,?,?,?,?,?,?,?,?)";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(uri, user, password);
            PreparedStatement pstmt = conn.prepareStatement(sqlStr);

            pstmt.setString(1, sno1);
            pstmt.setString(2, sname1);
            pstmt.setString(3, ssex);
            
            pstmt.setString(4, birthday1);
            pstmt.setString(5, adress1);
            pstmt.setString(6, depart1);
            pstmt.setString(7, speciality1);
            pstmt.setInt(8, member);

            pstmt.executeUpdate();
            pstmt.close();
            return 1;
        } catch (SQLException ex) {
            System.out.println(ex);
            return 0;
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            return 0;
        }
    }

    public void query() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(uri, user, password);
            String str = "SELECT * FROM studentinfo";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(str);

            // Display query results in the text area
            // (You need to replace 'textarea' with the actual text area variable)
            // Example: textarea.setText("");
            // Example: textarea.append(line + "\n");

            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {
        new JFrameInsertStudent();
    }
}
        	