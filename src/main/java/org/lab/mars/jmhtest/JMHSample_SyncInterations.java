package org.lab.mars.jmhtest;

import org.junit.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;
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
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class JMHSample_SyncInterations {
    private double src;

    @Benchmark
    public double test() {
        double s = src;
        for (int i = 0; i < 1000; i++) {
            s = Math.sin(s);
        }
        return s;
    }

    @Test
    public void testA() throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(JMHSample_SyncInterations.class.getSimpleName())
                .warmupIterations(1)
                .measurementIterations(20)
                .threads(Runtime.getRuntime().availableProcessors() * 16)
                .forks(1)
                .syncIterations(true) // try to switch to "false"
                .build();

        new Runner(opt).run();
    }

}
