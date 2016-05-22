package org.yeming.articles.javaagent.test;

import java.lang.instrument.Instrumentation;

/**
 * Author:yaoalong.
 * Date:2016/3/30.
 * Email:yaoalong@foxmail.com
 */
public class SimpleAgent {
    public static void premain(String agentArguments,

                               Instrumentation instrumentation){

        System.out.println("Simple Agent");

        SimpleClassTransformer transformer =

        new SimpleClassTransformer();

     //   instrumentation.addTransformer(transformer);

    }

}
