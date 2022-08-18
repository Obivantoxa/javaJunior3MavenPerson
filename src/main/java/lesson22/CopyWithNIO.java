package lesson22;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class CopyWithNIO {

    public static void main(String[] args) {

        try {
            // Запись в файл:
            FileChannel fc = new FileOutputStream("data.txt").getChannel();
            fc.write(ByteBuffer.wrap("asdqwqwe sad asd asd asd asd ТАТАТАТАТАА".getBytes()));
            fc.close(); // закрыли канал
            // Добавление в конец файла:
            fc = new RandomAccessFile("data.txt", "rw").getChannel();
            fc.position(fc.size()); // Переходим в конец
            fc.write(ByteBuffer.wrap("qwe1".getBytes()));
            fc.close();
            // Чтение файла:
            fc = new FileInputStream("data.txt").getChannel();
            ByteBuffer buff = ByteBuffer.allocate(1024);// размер буфера
            fc.read(buff);
            buff.flip();
            while (buff.hasRemaining())
                System.out.print((char) buff.get());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
