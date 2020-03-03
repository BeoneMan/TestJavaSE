package test20_inputstream_outputstream_reader_writer.reader;

import javax.print.DocFlavor;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 构造方法
 * FileReader(File file) ： 创建一个新的 FileReader ，给定要读取的File对象。
 * FileReader(String fileName) ： 创建一个新的 FileReader ，给定要读取的文件的名称。
 * <p>
 * 读取字符
 * 1.读取字符： read 方法，每次可以读取一个字符的数据，提升为int类型，读取到文件末尾，返回 -1 ，循环读取
 * 2.使用字符数组读取： read(char[] cbuf) ，每次读取b的长度个字符到数组中，返回读取到的有效字符个数，读取到末尾时，返回 -1 ，
 */
public class FileReaderDemo01 {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Administrator\\Desktop\\新建文本文档.txt");
        try (FileReader fr1 = new FileReader(file);
             FileReader fr2 = new FileReader("C:\\Users\\Administrator\\Desktop\\b.txt")) {

//            System.out.println(fr1);
//            System.out.println(fr2);

            int len = 0;
            char[] chars = new char[1024];
            Long start = System.currentTimeMillis();
//            读取时间75毫秒
           /* while ((len = fr1.read()) != -1) {
                System.out.print((char) len);
            }
*/

            //读取时间8毫秒
        /*    while ((len = fr1.read(chars)) != -1) {
                System.out.println(new String(chars, 0, len));
            }*/


            Long end = System.currentTimeMillis();
            System.out.println(end - start);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
