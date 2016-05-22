package org.lab.mars.jmhtest;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * Author:yaoalong.
 * Date:2016/5/18.
 * Email:yaoalong@foxmail.com
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 5,time=1,timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5,time=1,timeUnit = TimeUnit.SECONDS)
@Fork(1)
@State(Scope.Thread)
public class JMHSample_StateDAG {
}
