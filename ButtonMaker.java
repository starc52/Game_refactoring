import java.awt.*;
import java.awt.event.*;
import javax.print.DocFlavor;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.util.*;
import java.io.*;

public class ButtonMaker {
    public static JPanel makeButtonWithPanel(String textToMatch, UnivView viewClass, String identify){
        JButton bttn = new JButton(textToMatch);
        JPanel bttnPanel = new JPanel();
        bttnPanel.setLayout(new FlowLayout());
        if(identify == (String)"Control") {
            bttn.addActionListener((ControlDeskView)viewClass);
            bttnPanel.add(bttn);
        }
        else if(identify == (String)"AddParty"){
            bttn.addActionListener((AddPartyView)viewClass);
            bttnPanel.add(bttn);
        }
        else if(identify == (String)"LaneStatus"){
            bttn.addActionListener((LaneStatusView)viewClass);
            bttnPanel.add(bttn);
            if(textToMatch == (String)"View Lane"){
                bttn.setEnabled(false);
            }
            else if(textToMatch==(String)"Pinsetter"){
                bttn.setEnabled(false);
            }
        }
        else if(identify==(String)"NewPatron"){
            bttn.addActionListener((NewPatronView)viewClass);
            bttnPanel.add(bttn);
        }
        return bttnPanel;
    }
}
