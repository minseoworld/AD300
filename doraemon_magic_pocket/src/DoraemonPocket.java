import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//DoraemonPocket; Space Complexity: O(n)
//The pocket needs space proportional to the number of items it contains.
public class DoraemonPocket {
    private List<String> pocketItems = new ArrayList();

    public DoraemonPocket() {
    }

    //addItem; Time Complexity: O(1)
    //Adding items is usually fast, taking a short amount of time.
    public void addItem(String itemName) {
        this.pocketItems.add(itemName);
    }

    //removeItem; Time Complexity: O(n)
    //Removing items might take longer, especially if many items are in the pocket.
    public void removeItem(String itemName) {
        this.pocketItems.remove(itemName);
    }

    //printItmes; Time Complexity: O(n)
    //Printing all items also takes time, and it depends on the number of items.
    public void printItems() {
        Iterator var1 = this.pocketItems.iterator();

        while(var1.hasNext()) {
            String item = (String)var1.next();
            System.out.println(item);
        }

    }

    //getNumItems; Time Complexity: O(1)
    //Checking the number of items is quick and doesn't take much time.
    public int getNumItems() {
        return this.pocketItems.size();
    }
}
