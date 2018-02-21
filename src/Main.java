public class Main {
    public static void main(String[] args) {
        Flower rose1 = new Flower("rose", "red", 40);
        Flower rose2 = new Flower("rose", "blue", 100);
        Flower pink = new Flower("pink", "purple", 18);
        Flower tulip = new Flower("tulip", "yellow", 23);

        Bouquet bouquet1 = new Bouquet(true);
        bouquet1.addFlowers(tulip, pink, rose1, rose2);
        System.out.println("R/W to XML:");
        bouquet1.serialize();

        Bouquet bouquet2 = new Bouquet(false);
        bouquet2.addFlowers(rose1, rose1, pink);
        System.out.println("\nR/W to JSON:");
        bouquet2.serialize();
    }
}
