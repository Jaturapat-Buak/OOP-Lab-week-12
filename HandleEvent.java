/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
import java.awt.event.*;
import java.io.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
public class HandleEvent implements ActionListener, WindowListener {
    private ChatDemo gui;
    
    public HandleEvent(ChatDemo gui) {
        this.gui = gui;
    }
    
    @Override
    public void actionPerformed(ActionEvent a) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String command = a.getActionCommand();
        if(command.equals("Submit")) {
            String message = gui.getTf().getText();
            gui.getTa().append(dtf.format(LocalDateTime.now()) + " : " + message +"\n");
            gui.getTf().setText("");
        }
        
        else if (command.equals("Reset")) {
            gui.getTa().setText("");
        }
    }
    
    @Override
    public void windowOpened(WindowEvent e) {
        File file = new File("ChatDemo.dat");
        if(file.exists()){
            System.out.println("LOADDDDDDDDD");
            try (FileInputStream fin = new FileInputStream("ChatDemo.dat"); DataInputStream din = new DataInputStream(fin);){
                String history = din.readUTF();
                if (!history.isEmpty()) {
                    gui.getTa().append(history);
                    System.out.println("ALREADY LOAD");
                }
             }
             catch (IOException ex) {
                 System.out.println(ex.toString());
             }
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        try (FileOutputStream fout = new FileOutputStream("ChatDemo.dat"); DataOutputStream dout = new DataOutputStream(fout);) {
            dout.writeUTF(gui.getTa().getText());
            System.out.println("ALREADY SAVE");
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        System.exit(0);
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
