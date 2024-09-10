package Pro;

public class Treasure {
    String TreasureName;//藏品名
    int TreasurePrice;//藏品分数

    public String getTreasureName() {
        return TreasureName;
    }

    public void setTreasureName(String treasureName) {
        TreasureName = treasureName;
    }

    public int getTreasurePrice() {
        return TreasurePrice;
    }

    public void setTreasurePrice(int treasurePrice) {
        TreasurePrice = treasurePrice;
    }

    public Treasure(String treasureName, int treasurePrice) {
        TreasureName = treasureName;
        TreasurePrice = treasurePrice;
    }
}
