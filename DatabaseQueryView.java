/* AddPartyView.java
 *
 *  Version
 *  $Id$
 *
 *  Revisions:
 * 		$Log: NewPatronView.java,v $
 * 		Revision 1.3  2003/02/02 16:29:52  ???
 * 		Added ControlDeskEvent and ControlDeskObserver. Updated Queue to allow access to Vector so that contents could be viewed without destroying. Implemented observer model for most of ControlDesk.
 *
 *
 */

/**
 * Class for GUI components need to add a patron
 *
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

import java.io.IOException;
import java.util.*;
import java.text.*;

public class DatabaseQueryView implements ActionListener {

    private int maxSize;

    private JFrame win;
    private JButton abort, highestScore, lowestScore, highestOverallScore, lowestOverallScore, last5Games;
    private JLabel nickLabel;
    private JTextField nickField;
    private String nick;

    private boolean done;

    private String selectedNick, selectedMember;
    private ControlDeskView cdv;

    public DatabaseQueryView(ControlDeskView cdvPara) {

        cdv=cdvPara;
        done = false;

        win = new JFrame("Search");
        win.getContentPane().setLayout(new BorderLayout());
        ((JPanel) win.getContentPane()).setOpaque(false);

        JPanel colPanel = new JPanel();
        colPanel.setLayout(new BorderLayout());

        // Patron Panel
        JPanel patronPanel = new JPanel();
        patronPanel.setLayout(new GridLayout(3, 1));
        patronPanel.setBorder(new TitledBorder("Query"));

        JPanel nickPanel = new JPanel();
        nickPanel.setLayout(new FlowLayout());
        nickLabel = new JLabel("Nick Name");
        nickField = new JTextField("", 15);
        nickPanel.add(nickLabel);
        nickPanel.add(nickField);




        patronPanel.add(nickPanel);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 1));

        Insets buttonMargin = new Insets(4, 4, 4, 4);

//        finished = new JButton("Add Patron");
//        JPanel finishedPanel = new JPanel();
//        buttonPanel.add(makeButtonWithPanel(finished, finishedPanel));

        abort = new JButton("Abort");
        JPanel abortPanel = new JPanel();
        buttonPanel.add(makeButtonWithPanel(abort, abortPanel));

        highestScore = new JButton("Highest Score");
        JPanel highestScorePanel = new JPanel();
        buttonPanel.add(makeButtonWithPanel(highestScore, highestScorePanel));

        lowestScore = new JButton("Lowest Score");
        JPanel lowestScorePanel = new JPanel();
        buttonPanel.add(makeButtonWithPanel(lowestScore, lowestScorePanel));

        highestOverallScore = new JButton("Highest Overall Score");
        JPanel highestOverallScorePanel = new JPanel();
        buttonPanel.add(makeButtonWithPanel(highestOverallScore, highestOverallScorePanel));

        lowestOverallScore = new JButton("Lowest Overall Score");
        JPanel lowestOverallScorePanel = new JPanel();
        buttonPanel.add(makeButtonWithPanel(lowestOverallScore, lowestOverallScorePanel));

        last5Games = new JButton("Last 5 Games");
        JPanel last5GamesPanel = new JPanel();
        buttonPanel.add(makeButtonWithPanel(last5Games, last5GamesPanel));

        // Clean up main panel
        colPanel.add(patronPanel, "Center");
        colPanel.add(buttonPanel, "East");

        win.getContentPane().add("Center", colPanel);

        win.pack();

        // Center Window on Screen
        Dimension screenSize = (Toolkit.getDefaultToolkit()).getScreenSize();
        win.setLocation(
                ((screenSize.width) / 2) - ((win.getSize().width) / 2),
                ((screenSize.height) / 2) - ((win.getSize().height) / 2));
        win.show();

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(abort)) {
            done = true;
            win.hide();
        }

        if (e.getSource().equals(highestScore)) {
            nick = nickField.getText();
            done = true;
            try {
                int result = ScoreHistoryFile.highestScore(nick);
                ScoreView scv = new ScoreView(result);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            win.hide();
        }
        if (e.getSource().equals(lowestScore)) {
            nick = nickField.getText();
            done = true;
            try {
                int result = ScoreHistoryFile.lowestScore(nick);
                ScoreView scv = new ScoreView(result);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            win.hide();
        }
        if (e.getSource().equals(highestOverallScore)) {
            nick = nickField.getText();
            done = true;
            try {
                int result = ScoreHistoryFile.highestOverallScore();
                ScoreView scv = new ScoreView(result);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            win.hide();
        }
        if (e.getSource().equals(lowestOverallScore)) {
            nick = nickField.getText();
            done = true;
            try {
                int result = ScoreHistoryFile.lowestOverallScore();
                ScoreView scv = new ScoreView(result);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            win.hide();
        }
        if (e.getSource().equals(last5Games)) {
            nick = nickField.getText();
            done = true;
            try {
                Vector result = ScoreHistoryFile.last5Games(nick);
                last5GamesView lgv = new last5GamesView(result);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            win.hide();
        }


    }

    public boolean done() {
        return done;
    }

    public String getNick() {
        return nick;
    }

//    public String getFull() {
//        return full;
//    }

//    public String getEmail() {
//        return email;
//    }
    public JPanel makeButtonWithPanel(JButton bttn, JPanel bttnPanel){
        bttnPanel.setLayout(new FlowLayout());
        bttn.addActionListener(this);
        bttnPanel.add(bttn);
        return  bttnPanel;
    }
}
