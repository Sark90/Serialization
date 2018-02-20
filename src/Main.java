import java.io.*;

public class Main {
    public static void main(String[] args) {
        Flower rose1 = new Flower("rose", "red", 40);
        Flower rose2 = new Flower("rose", "blue", 100);
        Flower pink = new Flower("pink", "purple", 18);
        Flower tulip = new Flower("tulip", "yellow", 23);

/*        RWObj rwo = new RWObj();
        rwo.write(false, rose1, tulip, pink, rose2);
        Object[] flowers = rwo.read(false);
        for (int i=0; i<flowers.length; i++) {
            System.out.println("Flower " + (i+1) + ":");
            System.out.println("\tname: " + ((Flower) flowers[i]).getName());
            System.out.println("\tcolor: " + ((Flower) flowers[i]).getColor());
            System.out.println("\tprice: " + ((Flower) flowers[i]).getPrice());
        }*/

        Bouquet bouquet1 = new Bouquet();
        bouquet1.addFlowers(tulip, pink, rose1, rose2);
        /*bouquet1.writeObject(true);
        Flower[] flowers = bouquet1.readObject(true);
        for (int i=0; i<flowers.length; i++) {
            System.out.println("Flower " + (i+1) + ":");
            System.out.println("\tname: " + (flowers[i]).getName());
            System.out.println("\tcolor: " + (flowers[i]).getColor());
            System.out.println("\tprice: " + (flowers[i]).getPrice());
        }*/

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("prices"))) {
            oos.writeObject(bouquet1);
            oos.writeObject("TEST");
            oos.flush();
            ObjectInputStream oin = new ObjectInputStream(new FileInputStream("prices"));
            Bouquet bouquet2 = (Bouquet) oin.readObject();
            bouquet2.showFlowers();
            System.out.println(oin.readObject());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}