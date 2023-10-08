public class DoraemonPocketDemo {
    public DoraemonPocketDemo() {
    }

    public static void main(String[] args) {
        DoraemonPocket doraemonPocket = new DoraemonPocket();
        doraemonPocket.addItem("one");
        doraemonPocket.addItem("two");
        doraemonPocket.addItem("three");
        System.out.println("Items are in the Pocket:");
        doraemonPocket.printItems();
        doraemonPocket.removeItem("two");
        System.out.println("Items are in the pocket; after remove item 'Two':");
        doraemonPocket.printItems();
        int numItems = doraemonPocket.getNumItems();
        System.out.println("Number of items in the Pocket: " + numItems);
    }
}
