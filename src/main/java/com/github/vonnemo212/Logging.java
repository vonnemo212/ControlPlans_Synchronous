package com.github.vonnemo212;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Logging {

    private static final String path = new File(Logging.class.getResource("").getPath().replaceFirst("target/.*", "")).getParent();
    public static Logger log = Logger.getLogger("MyLog");
    public static void init() {
        FileHandler fh;

        try {
            fh = new FileHandler(path + "/LogFile.log");
            log.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
