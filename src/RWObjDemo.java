import java.io.*;

public class RWObjDemo /*extends ObjectOutputStream.PutField*/ {
    private static final String FILE = "prices";

    public void write(Object obj) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE/*, true*/))) {
            //for(Object o: obj) {
                oos.writeObject(obj);
            //}
            oos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object read() {
        try (ObjectInputStream oin = new ObjectInputStream(new FileInputStream(FILE))) {
            /*Flower f;
            do {
                f = (Flower) oin.readObject();
                System.out.println("color: " + f.getColor() + ", name: " + f.getName() + ", price: " + f.getPrice());
            } while (f != null);*/
            return oin.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e) {
            System.out.println("EOF");
        } catch (StreamCorruptedException e) {
            System.err.println(e);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
