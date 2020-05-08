package cn.driveman.travel.web.servlet;

import cn.driveman.travel.entity.Category;
import cn.driveman.travel.service.ICategoryService;
import cn.driveman.travel.service.impl.CategoryServiceImpl;
import cn.driveman.travel.util.JedisUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@WebServlet("/category/*")
public class CategoryServlet extends BaseServlet {
    ICategoryService categoryService = new CategoryServiceImpl();
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Jedis jedis = JedisUtil.getJedis();
        Set<String> categorySet = jedis.zrange("categorySet", 0, -1);
        List<Category> categoryList=new ArrayList<>();
        if(categorySet!=null&&categorySet.size()>0){
            //从redis中查询
            System.out.println("category从redis中查询");
            int i =0;
            for (String categoryName : categorySet) {
                int score = jedis.zscore("categorySet", categoryName).intValue();
                Category category = new Category();
                category.setCname(categoryName);
                category.setCid(score);
                categoryList.add(category);
                i++;
            }
        }else{
            //数据库中查询
            System.out.println("category从数据库中查询");
            categoryList = categoryService.findAll();
            for (Category category : categoryList) {
                jedis.zadd("categorySet",category.getCid(),category.getCname());
            }
        }
        ObjectMapper objectMapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        objectMapper.writeValue(response.getOutputStream(),categoryList);
    }
    
}
