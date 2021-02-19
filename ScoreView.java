/*
 *  constructs a prototype Lane View
 *
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.util.*;

public class ScoreView implements ActionListener{

    private JFrame win;
    private JLabel label;
    private JButton abort;
    public ScoreView(int score) {

        win = new JFrame("Control Desk");
        win.getContentPane().setLayout(new BorderLayout());
        ((JPanel) win.getContentPane()).setOpaque(false);

        JPanel colPanel = new JPanel();
        colPanel.setLayout(new BorderLayout());

        // Controls Panel
        JPanel controlsPanel = new JPanel();
        controlsPanel.setLayout(new GridLayout(3, 1));
        controlsPanel.setBorder(new TitledBorder("Score"));

        label = new JLabel(Integer.toString(score));
        controlsPanel.add(label);

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

