package org.lab.mars.jmhtest;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Author:yaoalong.
 * Date:2016/5/18.
 * Email:yaoalong@foxmail.com
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Group)
public class JMHSample_Interruptes {
    private BlockingQueue<Integer> q;

    @Setup
    public void setUp() {
        q = new ArrayBlockingQueue<Integer>(1);
    }

    @Benchmark
    @Group("Q")
    public Integer take() throws InterruptedException {
        return q.take();
    }

    @Benchmark
    @Group("Q")
    public void put() throws InterruptedException {
        q.put(42);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(JMHSample_Interruptes.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .threads(2)
                .forks(5)
                .timeout(TimeValue.seconds(5))
                .build();

        new Runner(opt).run();
    }
}
