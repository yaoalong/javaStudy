package org.lab.mars.jmhtest;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Group;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Control;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Author:yaoalong.
 * Date:2016/5/18.
 * Email:yaoalong@foxmail.com
 */
@State(Scope.Group)
public class JMHSample_Control {

    public final AtomicBoolean flag=new AtomicBoolean();

    @Benchmark
    @Group("pingpong")
    public void ping(Control control){
        while(!control.stopMeasurement&&!flag.compareAndSet(false,true)){

        }
    }
    @Benchmark
    @Group("pingpong")
    public void pong(Control control){
        while(!control.stopMeasurement&&!flag.compareAndSet(true,false)){

        }
    }
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(JMHSample_Control.class.getSimpleName())
                .warmupIterations(1)
                .measurementIterations(5)
                .threads(2)
                .forks(1)
                .build();

        new Runner(opt).run();
    }

}
