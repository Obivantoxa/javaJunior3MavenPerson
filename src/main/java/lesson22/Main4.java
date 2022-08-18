package lesson22;

public class Main4 {
    public static void main(String[] args) {
        // Сериализация
        try {
            java.io.ObjectOutputStream ois =
                    new java.io.ObjectOutputStream(
                            new java.io.FileOutputStream("state.bin"));
            ois.writeDouble(3.14159265D);
            ois.writeObject("The value of PI");
            ois.writeObject(new Point(10, 253)); //запись объекта класса Point
            ois.flush();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            // Десериализация
            java.io.ObjectInputStream ois =
                    new java.io.ObjectInputStream(
                            new java.io.FileInputStream("state.bin"));
            System.out.println("Double: " + ois.readDouble());
            System.out.println("String: " + ois.readObject().toString());
            System.out.println("Point: " + (Point) ois.readObject());
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
