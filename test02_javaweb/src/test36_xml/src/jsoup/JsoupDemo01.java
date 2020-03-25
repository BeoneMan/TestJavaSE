package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.IOException;

/**
 *  快速入门：
 * 			* 步骤：
 * 				1. 导入jar包
 * 				2. 获取Document对象
 * 				3. 获取对应的标签Element对象
 * 				4. 获取数据
 */
public class JsoupDemo01 {
    public static void main(String[] args) throws IOException {
        String path = JsoupDemo01.class.getClassLoader().getResource("jsoup/students.xml").getPath();
        System.out.println(path);
        //获取Document对象
        Document document = Jsoup.parse(new File(path), "utf-8");
        System.out.println(document);
        //获取对应的标签Element对象
        Element elementById = document.getElementById("2");
        //获取数据
        Element ageEle = elementById.child(1);
        String text = ageEle.text();
        System.out.println(text);


    }
}
