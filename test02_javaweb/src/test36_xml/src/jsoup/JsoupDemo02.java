package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/*
* 对象的使用：
        1. Jsoup：工具类，可以解析html或xml文档，返回Document
            * parse：解析html或xml文档，返回Document
            * parse​(File in, String charsetName)：解析xml或html文件的。
            * parse​(String html)：解析xml或html字符串
            * parse​(URL url, int timeoutMillis)：通过网络路径获取指定的html或xml的文档对象
        2. Document：文档对象。代表内存中的dom树
            * 获取Element对象
            * getElementById​(String id)：根据id属性值获取唯一的element对象
            * getElementsByTag​(String tagName)：根据标签名称获取元素对象集合
            * getElementsByAttribute​(String key)：根据属性名称获取元素对象集合
            * getElementsByAttributeValue​(String key, String value)：根据对应的属性名和属性值获取元素对象集合
        3. Elements：元素Element对象的集合。可以当做 ArrayList<Element>来使用
        4. Element：元素对象
            1. 获取子元素对象
                * getElementById​(String id)：根据id属性值获取唯一的element对象
                * getElementsByTag​(String tagName)：根据标签名称获取元素对象集合
                * getElementsByAttribute​(String key)：根据属性名称获取元素对象集合
                * getElementsByAttributeValue​(String key, String value)：根据对应的属性名和属性值获取元素对象集合
            2. 获取属性值
               * String attr(String key)：根据属性名称获取属性值
            3. 获取文本内容
                * String text():获取文本内容
                * String html():获取标签体的所有内容(包括字标签的字符串内容)
        5. Node：节点对象
            * 是Document和Element的父类*/

public class JsoupDemo02 {
    /*   1. Jsoup：工具类，可以解析html或xml文档，返回Document
     * parse：解析html或xml文档，返回Document
     * parse​(File in, String charsetName)：解析xml或html文件的。
     * parse​(String html)：解析xml或html字符串
     * parse​(URL url, int timeoutMillis)：通过网络路径获取指定的html或xml的文档对象*/
    @Test
    public void test01() throws IOException {
        //parse​(String html)：解析xml或html字符串
       /* String str = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                "\n" +
                "<students>\n" +
                "\t<student number=\"heima_0001\">\n" +
                "\t\t<name>tom</name>\n" +
                "\t\t<age>18</age>\n" +
                "\t\t<sex>male</sex>\n" +
                "\t</student>\n" +
                "\t<student number=\"heima_0002\">\n" +
                "\t\t<name>jack</name>\n" +
                "\t\t<age>18</age>\n" +
                "\t\t<sex>female</sex>\n" +
                "\t</student>\n" +
                "\n" +
                "</students>";
        Document document = Jsoup.parse(str);
        System.out.println(document);*/

//        parse​(URL url, int timeoutMillis)：通过网络路径获取指定的html或xml的文档对象
        URL url = new URL("https://baike.baidu.com/item/jsoup/9012509?fr=aladdin");//代表网络中的一个资源路径
        Document document = Jsoup.parse(url, 2000);
        System.out.println(document);
    }


    /*
      2. Document：文档对象。代表内存中的dom树
            * 获取Element对象
            * getElementById​(String id)：根据id属性值获取唯一的element对象
            * getElementsByTag​(String tagName)：根据标签名称获取元素对象集合
            * getElementsByAttribute​(String key)：根据属性名称获取元素对象集合
            * getElementsByAttributeValue​(String key, String value)：根据对应的属性名和属性值获取元素对象集合
    */
    @Test
    public void test02() throws IOException {
        String path = JsoupDemo02.class.getClassLoader().getResource("jsoup/students.xml").getPath();
        Document document = Jsoup.parse(new File(path), "UTF-8");
        //getElementById​(String id)：根据id属性值获取唯一的element对象
        Element ele1 = document.getElementById("1");

//        getElementsByTag​(String tagName)：根据标签名称获取元素对象集合
        Elements ele2 = document.getElementsByTag("student");

//        getElementsByAttribute​(String key)：根据属性名称获取元素对象集合
        Elements ele3 = document.getElementsByAttribute("bie");

//        getElementsByAttributeValue​(String key, String value)：根据对应的属性名和属性值获取元素对象集合
        Elements ele4 = document.getElementsByAttributeValue("id", "2");


        System.out.println(ele4);
    }


    //    3. Elements：元素Element对象的集合。可以当做 ArrayList<Element>来使用
    @Test
    public void test03() throws IOException {
        String path = JsoupDemo02.class.getClassLoader().getResource("jsoup/students.xml").getPath();
        Document document = Jsoup.parse(new File(path), "UTF-8");
        Elements allElements = document.getElementsByTag("student");
        for (Element allElement : allElements) {
            System.out.println(allElement);
        }
    }


    /*
     4. Element：元素对象
            1. 获取子元素对象
                * getElementById​(String id)：根据id属性值获取唯一的element对象
                * getElementsByTag​(String tagName)：根据标签名称获取元素对象集合
                * getElementsByAttribute​(String key)：根据属性名称获取元素对象集合
                * getElementsByAttributeValue​(String key, String value)：根据对应的属性名和属性值获取元素对象集合
            2. 获取属性值
               * String attr(String key)：根据属性名称获取属性值
            3. 获取文本内容
                * String text():获取文本内容
                * String html():获取标签体的所有内容(包括字标签的字符串内容)
*/
    @Test
    public void test04() throws IOException {
        String path = JsoupDemo02.class.getClassLoader().getResource("jsoup/students.xml").getPath();
        Document document = Jsoup.parse(new File(path), "UTF-8");
        Element ele = document.getElementById("2");
//        getElementById​(String id)：根据id属性值获取唯一的element对象
        Element ageEle = ele.getElementById("age2");
        System.out.println(ageEle);

//        String attr(String key)：根据属性名称获取属性值
        String idAtrr = ageEle.attr("id");
        System.out.println("id属性值:" + idAtrr);

//         String text():获取文本内容
        String text = ageEle.text();
        System.out.println("文本内容为:" + text);

//        String html():获取标签体的所有内容(包括字标签的字符串内容)
        String html = ageEle.html();
        System.out.println("html为:"+html);

    }


/*
     5. Node：节点对象
            * 是Document和Element的父类*/




}
