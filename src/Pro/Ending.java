package Pro;

public class Ending {
    String name;//结局名称
    int count;//结局分数

    public String getName() {
        return name;
    }
    public int getCount() {
        return count;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public Ending(String name, int count) {
        this.name = name;
        this.count = count;
    }
}
