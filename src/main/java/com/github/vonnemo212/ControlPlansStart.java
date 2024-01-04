package com.github.vonnemo212;

import com.ptc.cipjava.jxthrowable;
import com.ptc.pfc.pfcCommand.*;
import com.ptc.pfc.pfcSession.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.Configurator;

import javax.swing.*;


public class ControlPlansStart {




    public static void start() {

        CustomConfigurationFactory config = new CustomConfigurationFactory();
        config.getConfiguration("testLog",null);
        Configurator.initialize(config.getConfiguration("testLog",null));


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