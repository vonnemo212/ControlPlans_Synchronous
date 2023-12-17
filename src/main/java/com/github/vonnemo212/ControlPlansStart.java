package com.github.vonnemo212;

import com.ptc.cipjava.jxthrowable;
import com.ptc.pfc.pfcCommand.*;
import com.ptc.pfc.pfcCommand.UICommand;
import com.ptc.pfc.pfcSession.*;
import org.apache.log4j.Logger;


import javax.naming.ldap.Control;
import javax.swing.*;
import java.util.logging.Level;

public class ControlPlansStart {

    public static void start() {
        Logging.init();
        Logging.log.log(Level.WARNING, "Test");

        JOptionPane optionPane = new JOptionPane();
        JDialog dialog = optionPane.createDialog(null,"Debug purposes");
        dialog.setVisible(true);



        /*try {
            //Session curSession = pfcSession.GetCurrentSessionWithCompatibility(CreoCompatibility.C4Compatible);
            //UICommand cmd = curSession.UICreateCommand("JL.Test", new MenuButtonListener());
            //curSession.UIAddButton(cmd,"File",null, "Test", "null", "null");

        } catch (jxthrowable e) {
            throw new RuntimeException(e);
       }*/

        System.out.println("Test msg");

    }

    public static void stop() {
        System.out.println("Program stopped");
    }

}

class MenuButtonListener extends DefaultUICommandActionListener {

    public void OnCommand() {

        try {
            Session curSession = pfcSession.GetCurrentSession();
            new TestClass(curSession);

        } catch (jxthrowable e) {
            throw new RuntimeException(e);
        }
    }
}