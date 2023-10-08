import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DoraemonPocket {
    private List<String> pocketItems = new ArrayList();

    public DoraemonPocket() {
    }

    public void addItem(String itemName) {
        this.pocketItems.add(itemName);
    }

    public void removeItem(String itemName) {
        this.pocketItems.remove(itemName);
    }

    public void printItems() {
        Iterator var1 = this.pocketItems.iterator();

        while(var1.hasNext()) {
            String item = (String)var1.next();
            System.out.println(item);
        }

    }

    public int getNumItems() {
        return this.pocketItems.size();
    }
}
