package org.yeming.articles.javaagent.test;

import java.lang.instrument.Instrumentation;

/**
 * Author:yaoalong.
 * Date:2016/3/30.
 * Email:yaoalong@foxmail.com
 */
public class TestJavaAgent {

    public static void premain(String agentArgument, Instrumentation instrumentation){
        System.out.println("test java agent");
    }
}
