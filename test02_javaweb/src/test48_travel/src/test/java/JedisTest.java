import cn.driveman.travel.util.JedisUtil;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.io.IOException;

public class JedisTest {
    @Test
    public void test01() throws IOException {

        Jedis jedis = JedisUtil.getJedis();
        System.out.println(jedis.get("name"));
    }
}
