public class Item {
    String name;
    int weight;

    public Item(String name, int weight){
        this.name = name;
        this.weight = weight;
    }
    
    public Item(String name, String weight){
        this.name = name;
        this.weight = Integer.parseInt(weight);
    }

    public String getName() {return name; }
    public int getWeight() {return weight;}
    public void setName(String name) {this.name = name;}
    public void setWeight(int weight) {this.weight = weight;}
}
