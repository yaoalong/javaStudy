package org.lab.mars.jmhtest;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author:yaoalong.
 * Date:2016/5/18.
 * Email:yaoalong@foxmail.com
 */
@State(Scope.Group)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class JMHSample_Asymmetric {

    private AtomicInteger count;

    @Setup
    public void up(){
        count=new AtomicInteger(0);
    }
    @Benchmark
    @Group("g")
    @GroupThreads(3)
    public int inc() {
        return count.incrementAndGet();
    }

    @Benchmark
    @Group("g")
    @GroupThreads(1)
    public int get() {
        return count.get();
    }


    @Benchmark
    @Group("f")
    @GroupThreads(3)
    public int incf() {
        return count.incrementAndGet();
    }

    @Benchmark
    @Group("f")
    @GroupThreads(1)
    public int getf() {
        return count.get();
    }

    /*
     * ============================== HOW TO RUN THIS TEST: ====================================
     *
     * You will have the distinct metrics for inc() and get() from this run.
     *
     * You can run this test:
     *
     * a) Via the command line:
     *    $ mvn clean install
     *    $ java -jar target/benchmarks.jar JMHSample_15 -wi 5 -i 5 -f 1
     *    (we requested 5 warmup/measurement iterations, single fork)
     *
     * b) Via the Java API:
     *    (see the JMH homepage for possible caveats when running from IDE:
     *      http://openjdk.java.net/projects/code-tools/jmh/)
     */

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(JMHSample_Asymmetric.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

}
