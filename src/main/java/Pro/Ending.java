package Pro;

public class Ending {
    String name;//结局名称
    String count;//结局分数

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public Ending() {
    }

    public Ending(String name, String count) {
        this.name = name;
        this.count = count;
    }
}
