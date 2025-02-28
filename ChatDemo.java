import java.awt.*;
import javax.swing.*;
public class ChatDemo{
    private JFrame fr;
    private JTextArea ta;
    private JTextField tf;
    private JButton b1, b2;
    private JPanel p;
    private HandleEvent handle;
    public ChatDemo() {
        fr = new JFrame("");
        fr.setLayout(new BorderLayout());
        handle = new HandleEvent(this);
        
        fr.addWindowListener(handle);
        ta = new JTextArea(20,45);
        ta.setEditable(false);
        
        tf = new JTextField(45);
        
        b1 = new JButton("Submit");
        b2 = new JButton("Reset");
        b1.addActionListener(handle);
        b2.addActionListener(handle);
        
        p = new JPanel();
        p.add(b1); p.add(b2);
        
        fr.add(ta, BorderLayout.NORTH);
        fr.add(tf);
        fr.add(p, BorderLayout.SOUTH);
        
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

    public JTextArea getTa() {
        return ta;
    }

    public void setTa(JTextArea ta) {
        this.ta = ta;
    }

    public JTextField getTf() {
        return tf;
    }

    public void setTf(JTextField tf) {
        this.tf = tf;
    }

    public JButton getB1() {
        return b1;
    }

    public void setB1(JButton b1) {
        this.b1 = b1;
    }

    public JButton getB2() {
        return b2;
    }

    public void setB2(JButton b2) {
        this.b2 = b2;
    }

    public JPanel getP() {
        return p;
    }

    public void setP(JPanel p) {
        this.p = p;
    }

    public HandleEvent getHandle() {
        return handle;
    }

    public void setHandle(HandleEvent handle) {
        this.handle = handle;
    }
    
}
