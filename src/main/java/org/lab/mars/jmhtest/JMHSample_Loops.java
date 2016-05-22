package org.lab.mars.jmhtest;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * Author:yaoalong.
 * Date:2016/5/18.
 * Email:yaoalong@foxmail.com
 */
@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
public class JMHSample_Loops
{

    int x=1;
    int y=2;
    @Benchmark
    public int measureRight(){
        return x+y;
    }

    private int reps(int reps){
        int s=0;
        for(int i=0;i<reps;i++){
            s+=(x*y);
        }
        return s;
    }

    @Benchmark
    @OperationsPerInvocation(1)
    public int measureWrong_1(){
        return reps(1);
    }
    @Benchmark
    @OperationsPerInvocation(10)
    public int measureWrong_10(){
        return reps(1);
    }
    @Benchmark
    @OperationsPerInvocation(100)
    public int measureWrong_100(){
        return reps(1);
    }
    public static void main(String[] args) throws RunnerException {
        Options opt=new OptionsBuilder().include(JMHSample_Loops.class.getSimpleName()).warmupIterations(5).measurementIterations(5).forks(1).build();
        new Runner(opt).run();
    }
}
