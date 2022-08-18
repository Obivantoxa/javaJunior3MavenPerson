package lesson22;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        CopyWithIo copyWithIo = new CopyWithIo();

        long star = System.currentTimeMillis();
        try {
            copyWithIo.copy("E:\\java_instal\\VSCodeUserSetup-x64-1.67.2.exe", "qwe.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("copy io " + (System.currentTimeMillis() - star));


    }
}
