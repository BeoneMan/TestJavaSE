package test20_inputstream_outputstream_reader_writer.properties;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo02 {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try (FileReader fr = new FileReader("C:\\Users\\Administrator\\Desktop\\b.properties")) {
            properties.load(fr);
            System.out.println(properties);
            String filename = properties.getProperty("filename");
            String length = properties.getProperty("length");
            String location = properties.getProperty("location");
            System.out.println("filename:" + filename);
            System.out.println("length:" + length);
            System.out.println("location:" + location);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
