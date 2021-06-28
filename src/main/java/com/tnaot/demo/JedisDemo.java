package com.tnaot.demo;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author Susanna
 * @date 2021/3/23 9:51
 */
public class JedisDemo {

    private static Jedis redis = null;

    static {
       redis = new Jedis("192.168.1.248",7379);
       redis.auth("sadfhis$oi#vj");
    }

    public void quitConnection() {
        if (redis != null) {
            redis.close();
            //pool.returnResource(redis);
        }
    }

    public String getValue(String key) {
        return redis.get(key);
    }

    public static void main(String[] args) {
        JedisDemo jedisDemo = new JedisDemo();
        String value = jedisDemo.getValue("TNAOT_PHONE:VERIFICATION:NUM:8618054320001:2");
        System.out.println("成功获取之后的验证码为：" + value);
        jedisDemo.quitConnection();


    }
}
