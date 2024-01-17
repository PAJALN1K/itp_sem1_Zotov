public class Product {
    private int weight;

    public Product(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return String.format("Product %s", weight);
    }

    public int getWeight() {
        return weight;
    }
}
