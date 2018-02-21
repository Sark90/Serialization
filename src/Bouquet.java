import java.io.*;

public class Bouquet implements Serializable {
    private static final String FILE = "prices";
    private Flower[] flowers;
    private final boolean xml; //== false - r/w to JSON

    public Bouquet(boolean toXml) {
        xml = toXml;
    }

    public void addFlowers(Flower...flowers) {
        this.flowers = flowers;
    }

    public void showFlowers() {
        if (flowers == null) return;
        for (Flower f: flowers) {
            System.out.println("Name: " + f.getName() + ", color: " + f.getColor() + ", price: " + f.getPrice());
        }
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        if (flowers == null) return;
        new RWObj().write(xml, flowers);
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        Object[] objects = new RWObj().read(xml);
        flowers = new Flower[objects.length];
        for (int i=0; i<objects.length; i++) {
            flowers[i] = (Flower) objects[i];
        }
    }

    public static void main(String[] args) {
        Flower rose1 = new Flower("rose", "red", 40);
        Flower rose2 = new Flower("rose", "blue", 100);
        Flower pink = new Flower("pink", "purple", 18);
        Flower tulip = new Flower("tulip", "yellow", 23);
        Bouquet bouquet1 = new Bouquet(true);
        bouquet1.addFlowers(tulip, pink, rose1, rose2);
        Bouquet bouquet2 = new Bouquet(false);
        bouquet2.addFlowers(rose1, rose1, pink);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE))) {
            System.out.println("R/W to XML:");
            oos.writeObject(bouquet1);
            ObjectInputStream oin = new ObjectInputStream(new FileInputStream(FILE));
            Bouquet bouquetFromFile = (Bouquet) oin.readObject();
            bouquetFromFile.showFlowers();

            System.out.println("\nR/W to JSON:");
            oos.writeObject(bouquet2);
            bouquetFromFile = (Bouquet) oin.readObject();
            bouquetFromFile.showFlowers();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
