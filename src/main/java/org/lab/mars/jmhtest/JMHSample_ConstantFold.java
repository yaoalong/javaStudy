package org.lab.mars.jmhtest;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * Author:yaoalong.
 * Date:2016/5/18.
 * Email:yaoalong@foxmail.com
 */
@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class JMHSample_ConstantFold {


    private final double wrongX = Math.PI;
    private double x = Math.PI;

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(JMHSample_ConstantFold.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    @Benchmark
    public double baseline() {
        return Math.PI;
    }

    @Benchmark
    public double measureWrong_1() {
        return Math.log(Math.PI);
    }

    @Benchmark
    public double measureWrong_2() {
        return Math.log(wrongX);
    }

    @Benchmark
    public double measureRight() {
        return Math.log(x);
    }

}
