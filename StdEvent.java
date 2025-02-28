import java.awt.event.*;
import java.io.*;

public class StdEvent implements ActionListener, WindowListener {
    private StudentView gui;
    private Student s = new Student();

    public StdEvent(StudentView gui) {
        this.gui = gui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("Deposit")) {
            this.s.setMoney(s.getMoney() + 100);
            this.gui.getLbnum().setText(String.valueOf(s.getMoney()));
        } else if (command.equals("Withdraw")) {  // แก้ "WithDraw" เป็น "Withdraw"
            this.s.setMoney(s.getMoney() - 100);
            this.gui.getLbnum().setText(String.valueOf(s.getMoney()));
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        File file = new File("StudentM.dat");
        if (file.exists()) {
            System.out.println("FOUNDDD");
            try (FileInputStream fin = new FileInputStream("StudentM.dat");
                ObjectInputStream in = new ObjectInputStream(fin)) {
                System.out.println("LOADDDDDD");
                Student write = (Student) in.readObject();
                s.setMoney(write.getMoney());
                this.gui.getTf1().setText(String.valueOf(write.getID()));  // แก้จาก getLb1() เป็น getTf1()
                this.gui.getTf2().setText(write.getName());  // แก้จาก getLb2() เป็น getTf2()
                this.gui.getLbnum().setText(String.valueOf(write.getMoney()));  // ใช้ getLbnum() แทน getLb3()
            } catch (IOException | ClassNotFoundException ex) {
                System.out.println(ex.toString());
            }
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        try (FileOutputStream fout = new FileOutputStream("StudentM.dat");
            ObjectOutputStream oout = new ObjectOutputStream(fout)) {
            System.out.println("SAVEEEEEEE");
            s.setID(Integer.parseInt(this.gui.getTf1().getText())); 
            s.setName(this.gui.getTf2().getText()); 
            oout.writeObject(s);
        } catch (IOException ex) {
            System.out.println(ex.toString());
        } finally {
            System.exit(0);
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
}
