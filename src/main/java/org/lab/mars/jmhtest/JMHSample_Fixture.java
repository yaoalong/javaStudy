package org.lab.mars.jmhtest;

import org.junit.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;
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
public class JMHSample_Fixture {
    private double x=Math.PI;
    @Benchmark
    public void right(Blackhole bh){
        bh.consume(Math.PI);
        bh.consume(Math.PI);
    }
    @Benchmark
    public void bhRight(Blackhole bh){
        bh.consume(x);
        bh.consume(x);
    }
    @Benchmark
    public double testWrong(){
        return x;
    }
    @Test
    public void test() throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(JMHSample_Fixture.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .jvmArgs("-ea")
                .build();

        new Runner(opt).run();
    }
}
