import java.awt.*;
import javax.swing.*;

public class StudentView {
    private JFrame fr;
    private JPanel p1, p2;
    private JLabel lb1, lb2, lb3, lbnum;
    private JTextField tf1, tf2;
    private JButton bt1, bt2;
    private StdEvent std;
    public StudentView() {
        std = new StdEvent(this);
        
        fr = new JFrame("Student View");
        fr.setLayout(new GridLayout(2, 1));
        fr.addWindowListener(std);
        
        lb1 = new JLabel("ID:");
        lb2 = new JLabel("Name:");
        lb3 = new JLabel("Money:");
        lbnum = new JLabel("0");

        tf1 = new JTextField();
        tf2 = new JTextField();

        p1 = new JPanel(new GridLayout(3, 2, 5, 5));
        p1.add(lb1);
        p1.add(tf1);
        p1.add(lb2);
        p1.add(tf2);
        p1.add(lb3);
        p1.add(lbnum);

        bt1 = new JButton("Deposit");
        bt1.addActionListener(std);
        bt2 = new JButton("Withdraw");
        bt2.addActionListener(std);
        
        p2 = new JPanel();
        p2.add(bt1);
        p2.add(bt2);

        fr.add(p1);
        fr.add(p2);

        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.pack();
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
    }

    public JFrame getFr() {
        return fr;
    }

    public void setFr(JFrame fr) {
        this.fr = fr;
    }

    public JPanel getP1() {
        return p1;
    }

    public void setP1(JPanel p1) {
        this.p1 = p1;
    }

    public JPanel getP2() {
        return p2;
    }

    public void setP2(JPanel p2) {
        this.p2 = p2;
    }

    public JLabel getLb1() {
        return lb1;
    }

    public void setLb1(JLabel lb1) {
        this.lb1 = lb1;
    }

    public JLabel getLb2() {
        return lb2;
    }

    public void setLb2(JLabel lb2) {
        this.lb2 = lb2;
    }

    public JLabel getLb3() {
        return lb3;
    }

    public void setLb3(JLabel lb3) {
        this.lb3 = lb3;
    }

    public JLabel getLbnum() {
        return lbnum;
    }

    public void setLbnum(JLabel lbnum) {
        this.lbnum = lbnum;
    }

    public JTextField getTf1() {
        return tf1;
    }

    public void setTf1(JTextField tf1) {
        this.tf1 = tf1;
    }

    public JTextField getTf2() {
        return tf2;
    }

    public void setTf2(JTextField tf2) {
        this.tf2 = tf2;
    }

    public JButton getBt1() {
        return bt1;
    }

    public void setBt1(JButton bt1) {
        this.bt1 = bt1;
    }

    public JButton getBt2() {
        return bt2;
    }

    public void setBt2(JButton bt2) {
        this.bt2 = bt2;
    }
    
}