import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Bouquet implements /*Externalizable ,*/ Serializable {
    private static final String FILE = "prices";
    private Flower[] flowers;

    public void addFlowers(Flower...flowers) {
        this.flowers = flowers;
    }

    public void showFlowers() {
        if (flowers == null) return;
        for (Flower f: flowers) {
            System.out.println("Name: " + f.getName() + ", color: " + f.getColor() + ", price: " + f.getPrice());
        }
    }

/*    void writeObject(boolean toXML) {
        if (flowers == null) return;
        new RWObj().write(toXML, flowers);
        *//*try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE, false))) {
            oos.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }*//*
    }*/

   /* public Flower[] readObject(boolean fromXML) {
        Object[] objects = new RWObj().read(fromXML);
        flowers = new Flower[objects.length];
        for (int i=0; i<objects.length; i++) {
            flowers[i] = (Flower) objects[i];
        }
        return flowers;
    }*/
}
