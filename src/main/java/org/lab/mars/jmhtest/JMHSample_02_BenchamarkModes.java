package org.lab.mars.jmhtest;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
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
public class JMHSample_02_BenchamarkModes {
    @Benchmark
    @BenchmarkMode(Mode.SampleTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void mearseAll() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(10);
    }

    public static void main(String args[]) throws RunnerException {
        Options opt=new OptionsBuilder().include(JMHSample_02_BenchamarkModes.class.getSimpleName()).warmupIterations(5).measurementIterations(5).threads(4).forks(1).build();
        new Runner(opt).run();

    }
}
