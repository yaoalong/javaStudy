package org.yeming.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * Author:yaoalong.
 * Date:2016/5/12.
 * Email:yaoalong@foxmail.com
 */
public class RedisTest {
    @Test
    public void testRedisString(){
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("192.168.10.124");
        System.out.println("Connection to server sucessfully");
        //查看服务是否运行
        System.out.println("Server is running: "+jedis.ping());
    }
}
