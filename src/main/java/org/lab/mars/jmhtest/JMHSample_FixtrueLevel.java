package org.lab.mars.jmhtest;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * Author:yaoalong.
 * Date:2016/5/18.
 * Email:yaoalong@foxmail.com
 */
@State(Scope.Thread)
public class JMHSample_FixtrueLevel {

    double x;
    @TearDown(Level.Iteration)
    public void check(){
        assert  x>Math.PI;
    }
    @Benchmark
    public void measureWrong(){
        double x=0;
        x++;
    }
    @Benchmark
    public void measureRight(){
        x++;
    }
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(JMHSample_FixtrueLevel.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .jvmArgs("-ea")
                .shouldFailOnError(false) // switch to "true" to fail the complete run
                .build();

        new Runner(opt).run();
    }

}
