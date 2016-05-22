package org.lab.mars.jmhtest;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * Author:yaoalong.
 * Date:2016/5/17.
 * Email:yaoalong@foxmail.com
 */
public class JMHSample_States {

    public static void main(String args[]) throws RunnerException {
        Options opt = new OptionsBuilder().include(JMHSample_States.class.getSimpleName()).warmupIterations(5).measurementIterations(5).threads(4).forks(1).build();

        new Runner(opt).run();
    }

    @Benchmark
    @Warmup(time=1)
    @Measurement(time =1)
    public void measureUnshared(ThreadState state) {
        System.out.println("aha");
        state.x++;

    }

    @Benchmark
    public void measureShared(ThreadState state) {
        state.x++;
    }

    @State(Scope.Benchmark)
    public static class BenchmarkState {
        volatile double x = Math.PI;
    }

    @State(Scope.Thread)
    public static class ThreadState {
        volatile double x = Math.PI;

    }
}
