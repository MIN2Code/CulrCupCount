package Pro;

public class Operators {
    String operatorName;//干员名称
    int level;//干员星级
    int operatorCount;//干员分数
    int limit;//干员限制水平(0:1:2,绝对限制：相对限制：非限制）
    int temp;//是否临时招募

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public int getOperatorCount() {
        return operatorCount;
    }

    public void setOperatorCount(int operatorCount) {
        this.operatorCount = operatorCount;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public Operators(String operatorName, int temp, int limit, int operatorCount, int level) {
        this.operatorName = operatorName;
        this.temp = temp;
        this.limit = limit;
        this.operatorCount = operatorCount;
        this.level = level;
    }
}
