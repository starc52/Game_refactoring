import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;

public class last5GamesView implements ActionListener {
    private JFrame win;
    private JLabel label1, label2, label3, label4, label5;
    private JButton abort;
    public last5GamesView(Vector result) {

        win = new JFrame("Control Desk");
        win.getContentPane().setLayout(new BorderLayout());
        ((JPanel) win.getContentPane()).setOpaque(false);

        JPanel colPanel = new JPanel();
        colPanel.setLayout(new BorderLayout());

        // Controls Panel
        JPanel controlsPanel = new JPanel();
        controlsPanel.setLayout(new GridLayout(3, 1));
        controlsPanel.setBorder(new TitledBorder("Last 5 Games"));

        if(result.size()==1){
            label1 = new JLabel("Date is: "+((Score)result.get(0)).getDate()+" Score: " +((Score)result.get(0)).getScore());
            controlsPanel.add(label1);

        }
        else if(result.size()==2){
            label1 = new JLabel("Date is: "+((Score)result.get(0)).getDate()+" Score: " +((Score)result.get(0)).getScore());
            label2 = new JLabel("Date is: "+((Score)result.get(1)).getDate()+" Score: " +((Score)result.get(1)).getScore());
            controlsPanel.add(label1);
            controlsPanel.add(label2);

        }
        else if(result.size()==3){
            label1 = new JLabel("Date is: "+((Score)result.get(0)).getDate()+" Score: " +((Score)result.get(0)).getScore());
            label2 = new JLabel("Date is: "+((Score)result.get(1)).getDate()+" Score: " +((Score)result.get(1)).getScore());
            label3 = new JLabel("Date is: "+((Score)result.get(2)).getDate()+" Score: " +((Score)result.get(2)).getScore());
            controlsPanel.add(label1);
            controlsPanel.add(label2);
            controlsPanel.add(label3);

        }
        else if(result.size()==4){
            label1 = new JLabel("Date is: "+((Score)result.get(0)).getDate()+" Score: " +((Score)result.get(0)).getScore());
            label2 = new JLabel("Date is: "+((Score)result.get(1)).getDate()+" Score: " +((Score)result.get(1)).getScore());
            label3 = new JLabel("Date is: "+((Score)result.get(2)).getDate()+" Score: " +((Score)result.get(2)).getScore());
            label4 = new JLabel("Date is: "+((Score)result.get(3)).getDate()+" Score: " +((Score)result.get(3)).getScore());
            controlsPanel.add(label1);
            controlsPanel.add(label2);
            controlsPanel.add(label3);
            controlsPanel.add(label4);

        }
        else if(result.size()==5){
            label1 = new JLabel("Date is: "+((Score)result.get(0)).getDate()+" Score: " +((Score)result.get(0)).getScore());
            label2 = new JLabel("Date is: "+((Score)result.get(1)).getDate()+" Score: " +((Score)result.get(1)).getScore());
            label3 = new JLabel("Date is: "+((Score)result.get(2)).getDate()+" Score: " +((Score)result.get(2)).getScore());
            label4 = new JLabel("Date is: "+((Score)result.get(3)).getDate()+" Score: " +((Score)result.get(3)).getScore());
            label5= new JLabel("Date is: "+((Score)result.get(4)).getDate()+" Score: " +((Score)result.get(4)).getScore());
            controlsPanel.add(label1);
            controlsPanel.add(label2);
            controlsPanel.add(label3);
            controlsPanel.add(label4);
            controlsPanel.add(label5);

        }

        abort = new JButton("Abort");
        JPanel abortPanel = new JPanel();
        controlsPanel.add(makeButtonWithPanel(abort, abortPanel));

        colPanel.add(controlsPanel, "Center");
        win.getContentPane().add("Center", colPanel);

        win.pack();

        /* Close program when this window closes */
        win.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // Center Window on Screen
        Dimension screenSize = (Toolkit.getDefaultToolkit()).getScreenSize();
        win.setLocation(
                ((screenSize.width) / 2) - ((win.getSize().width) / 2),
                ((screenSize.height) / 2) - ((win.getSize().height) / 2));
        win.show();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(abort)) {
            win.hide();
        }
    }
    public JPanel makeButtonWithPanel(JButton bttn, JPanel bttnPanel){
        bttnPanel.setLayout(new FlowLayout());
        bttn.addActionListener(this);
        bttnPanel.add(bttn);
        return  bttnPanel;
    }
}
