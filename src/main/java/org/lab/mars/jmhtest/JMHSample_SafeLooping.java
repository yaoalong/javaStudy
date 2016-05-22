package org.lab.mars.jmhtest;

import org.openjdk.jmh.annotations.*;
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
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(3)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class JMHSample_SafeLooping {

    static final int BASE=42;
    static int work(int x){
        return BASE+x;
    }
    @Param({"1","10","100","1000"})
    int size;

    int[] xs;
    @Setup
    public void setup(){
        xs=new int[size];
        for(int i=0;i<size;i++){
            xs[i]=i;
        }
    }
    @Benchmark
    public int measureWrong_1(){
        int acc=0;
        for(int x:xs){
            acc=work(x);
        }
        return acc;
    }
    @Benchmark
    public int measureWrong_2() {
        int acc = 0;
        for (int x : xs) {
            acc += work(x);
        }
        return acc;
    }
    @Benchmark
    public void measureRight_1(Blackhole bh) {
        for (int x : xs) {
            bh.consume(work(x));
        }
    }
    @Benchmark
    public void measureRight_2() {
        for (int x : xs) {
            sink(work(x));
        }
    }

    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    public static void sink(int v) {
        // IT IS VERY IMPORTANT TO MATCH THE SIGNATURE TO AVOID AUTOBOXING.
        // The method intentionally does nothing.
    }
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(JMHSample_SafeLooping.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(3)
                .build();

        new Runner(opt).run();
    }


}
