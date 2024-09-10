package Pro;

public class Level {
    String levelName;//关卡名
    int level;//是否为紧急作战(0为普通，1为紧急)
    int count;//关卡分数
    int loseCount;//漏怪情况(0为无漏，1为漏怪)

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public int getLoseCount() {
        return loseCount;
    }

    public void setLoseCount(int loseCount) {
        this.loseCount = loseCount;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Level(String levelName, int loseCount, int count, int level) {
        this.levelName = levelName;
        this.loseCount = loseCount;
        this.count = count;
        this.level = level;
    }
}
