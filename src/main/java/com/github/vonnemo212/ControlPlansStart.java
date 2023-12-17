package com.github.vonnemo212;

import com.ptc.cipjava.jxthrowable;
import com.ptc.pfc.pfcCommand.*;
import com.ptc.pfc.pfcCommand.UICommand;
import com.ptc.pfc.pfcSession.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import javax.swing.*;


public class ControlPlansStart {

    private static final Logger logger = LogManager.getRootLogger();
    public static void start() {


        JOptionPane optionPane = new JOptionPane();
        JDialog dialog = optionPane.createDialog(null,"Debug purposes");
        dialog.setVisible(true);
        logger.info("Logger test");
        logger.warn("Test");
        System.out.println("Test");
        logger.error("Test");



        /*try {
            //Session curSession = pfcSession.GetCurrentSessionWithCompatibility(CreoCompatibility.C4Compatible);
            //UICommand cmd = curSession.UICreateCommand("JL.Test", new MenuButtonListener());
            //curSession.UIAddButton(cmd,"File",null, "Test", "null", "null");

        } catch (jxthrowable e) {
            throw new RuntimeException(e);
       }*/


    }

    public static void stop() {

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