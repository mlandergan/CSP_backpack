import java.util.ArrayList;

public class Bag {
    String name;
    int capacity;
    ArrayList<Item> items;

    public Bag(String name, int capacity, ArrayList<Item> items){
        this.name = name;
        this.capacity = capacity;
        this.items = items;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public int getCapacity() {return capacity; }
    public void setCapacity(int capacity) {this.capacity = capacity; }
    public ArrayList<Item> getItems() {return items; }
    public void setItems(ArrayList<Item> items) {this.items = items; }
}
