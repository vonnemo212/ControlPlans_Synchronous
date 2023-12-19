package com.github.vonnemo212;

import com.ptc.cipjava.jxthrowable;
import com.ptc.pfc.pfcCommand.*;
import com.ptc.pfc.pfcSession.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.swing.*;


public class ControlPlansStart {



    private static Logger logger = null;

    public static void start() {


        logger = LogManager.getLogger("ControlPlansStart");
        JOptionPane optionPane = new JOptionPane();
        JDialog dialog = optionPane.createDialog(null,"Debug purposes");
        dialog.setVisible(true);

        logger.trace("We've just greeted the user!");
        logger.debug("We've just greeted the user!");
        logger.info("We've just greeted the user!");
        logger.warn("We've just greeted the user!");
        logger.error("We've just greeted the user!");
        logger.fatal("We've just greeted the user!");




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