import org.junit.Test;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)

public class HelloWorld {
    int i;

    @Test
    @Benchmark
    public void noop() {
    }

    @Benchmark
    public void increment() {
        i++;
    }

    @Benchmark
    public int incrementConsume() {
        return i++;
    }

    @Benchmark
    public int consume() {
        return i;
    }

    @Benchmark
    public int consumeAdd() {
        return i + 1;
    }
}
