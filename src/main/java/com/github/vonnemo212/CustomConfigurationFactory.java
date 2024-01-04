package com.github.vonnemo212;


import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.appender.ConsoleAppender;
import org.apache.logging.log4j.core.appender.FileAppender;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.ConfigurationFactory;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.builder.api.AppenderComponentBuilder;
import org.apache.logging.log4j.core.config.builder.api.ConfigurationBuilder;
import org.apache.logging.log4j.core.config.builder.impl.BuiltConfiguration;

import java.net.URI;

public class CustomConfigurationFactory extends ConfigurationFactory {

    static Configuration createConfiguration(final String name, ConfigurationBuilder<BuiltConfiguration> builder) {

        builder.setConfigurationName(name);
        builder.setStatusLevel(Level.ERROR);

        AppenderComponentBuilder appenderBuilder = builder.newAppender("log","File");
        appenderBuilder.addAttribute("fileName","C:\\Users\\klemenm\\Desktop\\log_file\\testlog.log");
        builder.add(appenderBuilder);

        return builder.build();
    }

    @Override
    public Configuration getConfiguration(ConfigurationSource source) {
        return getConfiguration(source.toString(), null);
    }

    @Override
    public Configuration getConfiguration(final String name, final URI configLocation) {
        ConfigurationBuilder<BuiltConfiguration> builder = newConfigurationBuilder();
        return createConfiguration(name, builder);
    }

    @Override
    protected String[] getSupportedTypes() {
        return new String[]{"*"};
    }


}
