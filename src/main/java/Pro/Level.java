package Pro;

public class Level {
    String levelName;//关卡名
    String level;//是否为紧急作战(0为普通，1为紧急)
    String count;//关卡分数
    String loseCount;//漏怪情况(0为无漏，1为漏怪)

    public Level() {
    }

    public Level(String levelName, String count) {
        this.levelName = levelName;
        this.count = count;
    }

    public Level(String levelName, String level, String count, String loseCount) {
        this.levelName = levelName;
        this.level = level;
        this.count = count;
        this.loseCount = loseCount;
    }

    public String getLoseCount() {
        return loseCount;
    }

    public void setLoseCount(String loseCount) {
        this.loseCount = loseCount;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }
}
