package org.lab.mars.jmhtest;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * Author:yaoalong.
 * Date:2016/5/17.
 * Email:yaoalong@foxmail.com
 */
@State(Scope.Thread)
public class JMHSample_StateFixtures {

    double x;
    @Setup
    public void prepare(){
        x=Math.PI;
    }
    @TearDown
    public void check(){
        assert  x>Math.PI;
    }
    @Benchmark
    public void measureRight(){
        x++;
    }
    @Benchmark
    public void measureWrong(){
        double x=0;

        x++;
    }
    @Benchmark
    public void measure(Blackhole hb){
         double y=0;
        hb.consume(y);
    }
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(JMHSample_StateFixtures.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .jvmArgs("-ea")
                .build();

        new Runner(opt).run();
    }

}
