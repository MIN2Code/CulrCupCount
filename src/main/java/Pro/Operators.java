package Pro;

public class Operators {
    String operatorName;//干员名称
    String level;//干员星级
    String operatorCount;//干员分数
    String limit;//干员限制水平(0:1:2,绝对限制：相对限制：非限制）
    Boolean temp;//是否临时招募

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public Boolean getTemp() {
        return temp;
    }

    public void setTemp(Boolean temp) {
        this.temp = temp;
    }

    public String getOperatorCount() {
        return operatorCount;
    }

    public void setOperatorCount(String operatorCount) {
        this.operatorCount = operatorCount;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Operators() {
    }

    public Operators(String operatorName, String level, String operatorCount, String limit) {
        this.operatorName = operatorName;
        this.level = level;
        this.operatorCount = operatorCount;
        this.limit = limit;
    }

    public Operators(String operatorName, String level, String operatorCount, String limit, Boolean temp) {
        this.operatorName = operatorName;
        this.level = level;
        this.operatorCount = operatorCount;
        this.limit = limit;
        this.temp = temp;
    }
}
