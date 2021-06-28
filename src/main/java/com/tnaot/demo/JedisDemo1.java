package com.tnaot.demo;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisDemo1 {

//    static{
//
//    }

    @Test
    /**
     * 单实例的测试
     */
    public void demo1(){
        // 1. 设置IP地址和端口
        Jedis jedis = new Jedis("192.168.1.248",7379);
        jedis.auth("sadfhis$oi#vj");
        // 2. 保存数据
        jedis.set("name","imooc");
        // 3. 获取数据
        String value = jedis.get("name");
        String value2 = jedis.get("TNAOT_PHONE:VERIFICATION:NUM:8613250719420:2");
        System.out.println(value);
        System.out.println(value2);
        // 4.释放资源
        jedis.close();

        demo3("TNAOT_PHONE:VERIFICATION:NUM:8618054320001:2");
    }

    @Test
    /**
     * 连接池连接方式
     */
    public void demo2(){
        // 获取连接池配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        // 设置最大连接数
        config.setMaxTotal(30);
        // 设置最大的空闲连接数
        config.setMaxIdle(10);

        // 获得连接池: JedisPool jedisPool = new JedisPool(poolConfig,host,port);
        JedisPool jedisPool = new JedisPool(config,"192.168.1.248",7379);

        // 获得核心对象：jedis
        Jedis jedis = null;
        try{
            // 通过连接池来获得连接
            jedis = jedisPool.getResource();
            jedis.auth("sadfhis$oi#vj");
            // 设置数据
            jedis.set("name","张三");
            // 获取数据
            String value = jedis.get("name");
            System.out.println(value);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            // 释放资源
            if(jedis != null){
                jedis.close();
            }
            // 释放连接池
            if(jedisPool != null){
                jedisPool.close();
            }
        }
//        demo3("TNAOT_PHONE:VERIFICATION:NUM:8613250719420:2");
        demo3("TNAOT_PHONE:VERIFICATION:NUM:8618054320001:2");

    }

//    @Test
//    /**
//     * 单实例的测试
//     */
    public void demo3(String key){
        // 1. 设置IP地址和端口
        Jedis jedis = new Jedis("192.168.1.248",7379);
        jedis.auth("sadfhis$oi#vj");
        // 2. 保存数据
        jedis.set("name","imooc");
        // 3. 获取数据
        String value = jedis.get("name");
        String value2 = jedis.get(key);
        System.out.println(value);
        System.out.println("成功获取之后的验证码为：" + value2);
        // 4.释放资源
        jedis.close();
    }
/**
 *连接池使用总结
 *
 * ➀ 获取连接池配置对象
 *
 * ➁ 设置最大连接数和最大空闲连接数
 *
 * ➂ 获得连接池
 *
 * ➃ 获得核心对象
 *
 * ➄ 通过连接池获得链接
 *
 * ➅ 设置数据
 *
 * ➆ 获取数据
 *
 * ➇ 释放Jedis资源
 *
 * ➈ 释放jedisPool资源
 */



}
