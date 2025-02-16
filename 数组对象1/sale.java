package 数组对象1;

public class sale {
    private String id;
    private String name;
    private double price;
    private int storage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public sale(){}
    public sale(String id, String name, double price, int storage) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.storage = storage;
    }
}
