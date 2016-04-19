package org.yeming.falsesharing;

/**
 * Author:yaoalong.
 * Date:2016/4/6.
 * Email:yaoalong@foxmail.com
 */
public final class FalseSharing2 implements Runnable
{
    public final static int NUM_THREADS = 4; // change
    public final static long ITERATIONS = 500L * 1000L * 1000L;
    private static VolatileLong2[] longs = new VolatileLong2[NUM_THREADS];
    static
    {
        for (int i = 0; i < longs.length; i++)
        {
            longs[i] = new VolatileLong2();
        }
    }
    private final int arrayIndex;
    public FalseSharing2(final int arrayIndex)
    {
        this.arrayIndex = arrayIndex;
    }
    public static void main(final String[] args) throws Exception
    {
        final long start = System.nanoTime();
        runTest();
        System.out.println("duration = " + (System.nanoTime() - start));
    }
    private static void runTest() throws InterruptedException
    {
        Thread[] threads = new Thread[NUM_THREADS];
        for (int i = 0; i < threads.length; i++)
        {
            threads[i] = new Thread(new FalseSharing2(i));
        }
        for (Thread t : threads)
        {
            t.start();
        }
        for (Thread t : threads)
        {
            t.join();
        }
    }
    public void run()
    {
        long i = ITERATIONS + 1;
        while (0 != --i)
        {
            longs[arrayIndex].value = i;
        }
    }
    public final static class VolatileLong2 {

        public volatile long value = 0L;


    }

}
