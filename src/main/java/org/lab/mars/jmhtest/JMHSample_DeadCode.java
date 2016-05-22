package org.lab.mars.jmhtest;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * Author:yaoalong.
 * Date:2016/5/17.
 * Email:yaoalong@foxmail.com
 */
@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class JMHSample_DeadCode {

    private double x=Math.PI;
    @Benchmark
    public void baseline(){

    }

    @Benchmark
    public void measureWrong(){
        Math.log(x);
    }
    @Benchmark
    public double measureRight(){
        return Math.log(x);
    }
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(JMHSample_DeadCode.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }

}
