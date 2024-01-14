package com.github.vonnemo212;

import com.ptc.cipjava.jxthrowable;
import com.ptc.pfc.pfcCommand.*;
import com.ptc.pfc.pfcSession.*;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.builder.api.*;
import org.apache.logging.log4j.core.config.builder.impl.BuiltConfiguration;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class ControlPlansStart {

    public static final Logger logger;

    static {
        buildNewCfg("C:\\Users\\Administrator\\Desktop\\test\\logtest.txt");
        logger = LogManager.getLogger(ControlPlansStart.class);
    }

    public static void start() {


        //CustomConfigurationFactory config = new CustomConfigurationFactory();
       // config.getConfiguration("testLog",null);
        //Configurator.initialize(config.getConfiguration("testLog",null));


        JOptionPane optionPane = new JOptionPane();
        JDialog dialog = optionPane.createDialog(null,"Debug purposes");
        dialog.setVisible(true);
        logger.info("test");
        logger.trace("test");


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

    public static void buildNewCfg(String name) {

        String pattern = "%d %p %c [%t] %m%n";

        ConfigurationBuilder<BuiltConfiguration> builder = ConfigurationBuilderFactory.newConfigurationBuilder();

        builder.setStatusLevel(Level.DEBUG);
        builder.setConfigurationName("DefaultFileLogger");

        // Root logger
        RootLoggerComponentBuilder rootLogger = builder.newRootLogger(Level.DEBUG);

        //Set the pattern layout and patter
        LayoutComponentBuilder layoutBuilder = builder.newLayout("PatternLayout").addAttribute("pattern", pattern);

        //Create file appender
        AppenderComponentBuilder appenderBuilder = builder.newAppender("LogToFile","File").addAttribute("fileName",name).add(layoutBuilder);

        builder.add(appenderBuilder);
        rootLogger.add(builder.newAppenderRef("LogToFile"));
        builder.add(rootLogger);
        Configurator.initialize(builder.build());
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