package test21_buffered_others.bufferinputsream_bufferoutputstream;

import java.io.*;

public class BufferedInPut1Stream_BufferedOutPutStream {
    public static void main(String[] args) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            long start = System.currentTimeMillis();
            File srcFile = new File("C:\\Users\\Administrator\\Desktop\\玩转火车采集器，你一定要听的9节课\\第一节课-熟悉火车采集器\\第一节课-熟悉火车采集器.avi");
            File getFile = new File("C:\\Users\\Administrator\\Desktop\\"+start+".avi");
            bis = new BufferedInputStream(new FileInputStream(srcFile));
            bos = new BufferedOutputStream(new FileOutputStream(getFile));
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(getFile);
            int len = 0;
            byte[] bytes = new byte[1024];

            //太久太久
          /*  while((len=fis.read())!=-1){
                fos.write(len);
            }*/
            //3846毫秒
        /*    while((len=fis.read(bytes))!=-1){
                fos.write(len);
            }*/
            //26965毫秒
            /*while ((len = bis.read()) != -1) {
                bos.write(len);
            }*/
            //694毫秒
            while ((len = bis.read(bytes)) != -1) {
                bos.write(len);
            }
            long end = System.currentTimeMillis();
            System.out.println(end-start);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (bos != null) bos.close();
                if (bis != null) bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}