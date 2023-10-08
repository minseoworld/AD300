import java.util.ArrayList;
import java.util.Iterator;

class box {
    private double width;
    private double height;
    private double depth;
    private ArrayList<String> items;

    public box(double width, double height, double depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.items = new ArrayList();
    }

    public double volume() {
        return this.width * this.height * this.depth;
    }

    public void addItem(String item) {
        if (this.items.size() < 10) {
            this.items.add(item);
        } else {
            System.out.println("The box is full.");
        }

    }

    public void removeItem(String item) {
        if (this.items.contains(item)) {
            this.items.remove(item);
        } else {
            System.out.println("The item is not found");
        }

    }

    public void printItems() {
        if (this.items.isEmpty()) {
            System.out.println("The box is empty");
        } else {
            System.out.println("Items in the box");
            Iterator var1 = this.items.iterator();

            while(var1.hasNext()) {
                String item = (String)var1.next();
                System.out.println("- " + item);
            }
        }

    }
}
