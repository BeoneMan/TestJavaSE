package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 *  选择器
 */
public class JsoupDemo03 {
    public static void main(String[] args) throws IOException {
        String path = JsoupDemo03.class.getClassLoader().getResource("jsoup/students.xml").getPath();
        //获取Document对象
        Document document = Jsoup.parse(new File(path), "utf-8");
        //获取对应的标签Element对象
        Elements student = document.select("student");
        System.out.println(student);

    }
}
