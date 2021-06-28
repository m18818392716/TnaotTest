package com.tnaot.demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author Susanna
 * @date 2021/3/22 19:31
 */
public class RedisUtil {

    private static JedisPool pool = null;
    private static Jedis redis = null;
//    Log4jUtil log = new Log4jUtil(this.getClass().getName());

    //	3.这是配置信息
//	因为这些配置信息和获取jedisPool只需要执行一次 所以使用static代码块
    static {
//		4.通过类加载器获取输入流 路径是相对于src的
        InputStream in = RedisUtil.class.getClassLoader().getResourceAsStream("redis.properties");
//		5.通过properties进行转换
        Properties pro = new Properties();
        try {
            pro.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        6.设置缓存池的配置信息
        JedisPoolConfig config = new JedisPoolConfig();
//		将object类型转成字符串类型 然后在转成int类型
        config.setMaxIdle(Integer.parseInt(pro.get("redis.maxIdle").toString()));
        config.setMaxIdle(Integer.parseInt(pro.get("redis.minIdle").toString()));
        config.setMaxIdle(Integer.parseInt(pro.get("redis.maxTotal").toString()));
        //		7.创建缓存池
        pool = new JedisPool(config, pro.getProperty("redis.ip"), Integer.parseInt(pro.get("redis.port").toString()));

        redis = pool.getResource();
        redis.auth(pro.getProperty("redis.pwd"));
    }

//    //1.获得jedis的方法
//    public static Jedis getJedis(Jedis redis){
//        redis = pool.getResource();
//        return redis;
//    }



//    //构造函数,创建对象时进行初始化
//    public RedisUtil() {
//        if (pool == null) {
//			/*
//			// 池基本配置
//			//JedisPoolConfig config = new JedisPoolConfig();
//			// 最大连接数, 默认8个
//			config.setMaxTotal(20);
//			// 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例。
//			config.setMaxIdle(5);
//			// 表示当borrow(引入)一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；
//			config.setMaxWaitMillis(10000);
//			// 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
//			config.setTestOnBorrow(false);
//			*/
//
//            //创建redis连接池
//            //this.pool = new JedisPool(config,"172.18.173.188",6379);
//            this.pool = new JedisPool(new JedisPoolConfig(), pro.getProperty("redis.master.host"), Integer.parseInt(GlobalSettings.getProperty("redis.master.port")));
//            //获取Jedis实例
//            this.redis = pool.getResource();
//            log.info("Connection to redis server sucessfully");
//        }
//    }

    /**
     * 关闭连接
     *
     * @param redis
     */
    public void quitConnection(Jedis redis) {
        if (redis != null) {
            redis.quit();
            //pool.returnResource(redis);
        }
    }

    /**
     * 获取key对应的value
     * <p>
     * 说明：方法中目前只针对key数据类型为String和hash的情况作了处理，其他数据类型可根据需要进行扩展即可
     *
     * @param key
     * @return
     */
    public String getValue(String key) {
        String value = null;
        try {
            if (redis == null || !redis.exists(key)) {
//                log.info("key:" + key + " is not found");
                quitConnection(redis);
                return value;
            }
            //获取key对应的数据类型
            String type = redis.type(key);
//            log.info("key:" + key + " 的类型为：" + type);
            if (type.equals("string")) {
                //get(key)方法返回key所关联的字符串值
                value = redis.get(key);
            }
            if (type.equals("hash")) {
                //一下方法仅适用于list.size=1时，否者value将取集合中最后一个元素的值
                List<String> list = redis.hvals(key);//hvals(key)返回哈希表 key 中所有域的值
                //Set<String> set = redis.hkeys(key);
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    value = it.next();
//                    log.info("value:" + value);
                }
            }
            if (type.equals("list")) {
//                log.info(key + "类型为list暂未处理...");
            }
            if (type.equals("set")) {
//                log.info(key + "类型为list暂未处理...");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            //关闭连接
            quitConnection(redis);
        }
        return value;

    }

    public static void main(String[] args) {
        RedisUtil ru = new RedisUtil();
        //获取redis中对应的value值
        String value = ru.getValue("SMS_NODE_TIMES_13814528620");
        System.out.println(value);
//        log.info(value);

    }
}
