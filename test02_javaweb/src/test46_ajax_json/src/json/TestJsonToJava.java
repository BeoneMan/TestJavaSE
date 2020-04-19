package json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.User;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;

public class TestJsonToJava {
    @Test
    public void test01() throws IOException {
        String json="{\"name\":\"张三\",\"age\":18}";
        ObjectMapper om = new ObjectMapper();
        User user = om.readValue(json, User.class);
        System.out.println(user);
    }

    @Test
    public void test02() throws JsonProcessingException {
        User driveMan = new User("DriveMan", 25,new Date());
        ObjectMapper om = new ObjectMapper();
        String s = om.writeValueAsString(driveMan);
        System.out.println(s);
    }

}
