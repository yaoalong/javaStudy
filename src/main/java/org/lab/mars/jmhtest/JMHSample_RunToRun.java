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
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class JMHSample_RunToRun {


    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(JMHSample_RunToRun.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .build();

        new Runner(opt).run();
    }

    @Benchmark

    public void baseLine(SleepyState s) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(s.sleepTime);
    }

    @State(Scope.Thread)
    public static class SleepyState {
        public long sleepTime;

        @Setup
        public void setUp() {

        }
    }
    @Benchmark
    @Fork(1)
    public void fork_1(SleepyState s) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(s.sleepTime);
    }
}
