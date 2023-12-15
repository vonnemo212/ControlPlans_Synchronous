package com.github.vonnemo212;

import com.ptc.cipjava.jxthrowable;
import com.ptc.pfc.pfcModel.Model;
import com.ptc.pfc.pfcSession.*;

public class TestClass {

    private Session creoSession;

    public TestClass(Session inSession) {

        creoSession = inSession;
        //try {
            //String creoModel = creoSession.GetCurrentModel().GetInstanceName();
            //System.out.println(creoModel);
        //} catch (jxthrowable e) {
            //throw new RuntimeException(e);
        //}
    }

}
