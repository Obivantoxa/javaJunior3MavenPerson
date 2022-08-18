package lesson22;

import java.io.File;
import java.io.FileFilter;

public class FileEx {
    public static void main(String[] args) {

        File fl = new File("E:\\java_instal");

        File[] list = fl.listFiles(pathname ->
        {
            if (pathname.isDirectory())
                return true;
            if (pathname.getName().endsWith(".exe"))
                return true;
            return false;
        });
        for (File file : list) {
            System.out.println(file);

        }
    }
}
