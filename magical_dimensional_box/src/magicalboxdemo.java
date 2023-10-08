public class magicalboxdemo {
    public magicalboxdemo() {
    }

    public static void main(String[] args) {
        box magicalBox = new box(5.0, 3.0, 2.0);
        magicalBox.addItem("one");
        magicalBox.addItem("two");
        magicalBox.addItem("three");
        magicalBox.printItems();
        magicalBox.removeItem("two");
    }
}
