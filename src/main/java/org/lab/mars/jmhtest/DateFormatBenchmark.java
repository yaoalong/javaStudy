package org.lab.mars.jmhtest;

/**
 * Author:yaoalong.
 * Date:2016/5/18.
 * Email:yaoalong@foxmail.com
 */
import org.apache.commons.lang3.time.FastDateFormat;
import org.openjdk.jmh.annotations.*;

import java.text.DateFormat;
import java.text.Format;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class DateFormatBenchmark {
    // This is the date that will be formatted in the benchmark methods
    @State(Scope.Benchmark)
    public static class DateToFormat {
        final Date date = new Date();
    }

    // These are the three benchmark candidates

    @State(Scope.Thread)
    public static class JdkDateFormatHolder {
        final Format format = DateFormat.getDateInstance(DateFormat.MEDIUM);

        public String format(Date d) {
            return format.format(d);
        }
    }

    @State(Scope.Benchmark)
    public static class SyncJdkDateFormatHolder {
        final Format format = DateFormat.getDateInstance(DateFormat.MEDIUM);

        public synchronized String format(Date d) {
            return format.format(d);
        }
    }

    @State(Scope.Benchmark)
    public static class CommonsDateFormatHolder {
        final Format format = FastDateFormat.getDateInstance(FastDateFormat.MEDIUM);

        public String format(Date d) {
            return format.format(d);
        }
    }
    @Benchmark
    public String measureJdkFormat_1(JdkDateFormatHolder df, DateToFormat date) {
        return df.format(date.date);
    }
    @Benchmark
    @Threads(2)
    public String measureJdkFormat_2(JdkDateFormatHolder df, DateToFormat date) {
        return df.format(date.date);
    }
}