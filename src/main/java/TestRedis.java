import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by yangjianzhou on 15-8-8.
 */
public class TestRedis {

    private static Integer maxActive = 20;

    private static Integer maxIdle = 1000;

    private static Integer maxWait = 5;

    private static String host = "127.0.0.1";

    private static Integer port = 6379;

    private static Jedis jedis;

    private static JedisPool jedisPool;

    public static void main(String[] args) {

        setup();

        testString();
    }

    public static void setup() {
        jedis = new Jedis(host, port);
        //jedis.auth("");
    }

    public static void testString() {
        jedis.set("name", "xinxin");//向key-->name中放入了value-->xinxin
        System.out.println(jedis.get("name"));//执行结果：xinxin

        jedis.append("name", " is my lover"); //拼接
        System.out.println(jedis.get("name"));

        jedis.del("name");  //删除某个键
        System.out.println(jedis.get("name"));
        //设置多个键值对
        jedis.mset("name", "liuling", "age", "23", "qq", "476777389");
        jedis.incr("age"); //进行加1操作
        System.out.println(jedis.get("name") + "-" + jedis.get("age") + "-" + jedis.get("qq"));
    }
}
