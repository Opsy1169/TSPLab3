package Model;

public class InvalidTask {
    private String wrongString;
    private String wrongNum;

    public InvalidTask(String wrongString, String wrongNum){
        this.wrongString = wrongString;
        this.wrongNum = wrongNum;
    }

    public String getWrongString() {
        return wrongString;
    }

    public void setWrongString(String wrongString) {
        this.wrongString = wrongString;
    }

    public String getWrongNum() {
        return wrongNum;
    }

    public void setWrongNum(String wrongNum) {
        this.wrongNum = wrongNum;
    }
}
