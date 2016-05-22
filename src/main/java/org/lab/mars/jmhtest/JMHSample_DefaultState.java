package org.lab.mars.jmhtest;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * Author:yaoalong.
 * Date:2016/5/17.
 * Email:yaoalong@foxmail.com
 */
@State(Scope.Thread)
public class JMHSample_DefaultState {

    double x=Math.PI;

    @Benchmark
    public void measure(){
        x++;
    }

    public static void main(String[] args) throws RunnerException {
      Options opt=new OptionsBuilder().include(JMHSample_DefaultState.class.getSimpleName()).warmupIterations(5).measurementIterations(5)
              .forks(1).build();
        new Runner(opt).run();
    }
}
