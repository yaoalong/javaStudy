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
@OutputTimeUnit(TimeUnit.SECONDS)
@Fork(1)
public class JMHSample_Annotations {

    double x1=Math.PI;

    @Benchmark
    @Warmup(iterations = 12,time=100,timeUnit = TimeUnit.MILLISECONDS)
    @Measurement(iterations = 5,time=100,timeUnit = TimeUnit.MILLISECONDS)
    public double measure(){
        return Math.log(x1);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(JMHSample_Annotations.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }


}
