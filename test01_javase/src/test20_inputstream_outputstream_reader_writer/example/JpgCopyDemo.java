package test20_inputstream_outputstream_reader_writer.example;

import java.io.*;

/**
 * 图片复制
 */
public class JpgCopyDemo {
    public static void main(String[] args) {
        File srcFile = new File("C:\\Users\\Administrator\\Desktop\\abc.jpg");
        String name = srcFile.getName();

        File getFile = new File("F:\\IdeaProjects\\testjava\\test01_javase\\src\\test20_inputstream_outputstream_reader_writer\\"+name);
        try (FileInputStream fis = new FileInputStream(srcFile);
             FileOutputStream fos= new FileOutputStream(getFile)
        ) {

            int len=0;
            byte[] bytes = new byte[1024];
            while((len=fis.read(bytes))!=-1){
                fos.write(bytes,0,len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
