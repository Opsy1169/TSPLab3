package Model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Task {
    private String inputString;
    private int num;
    private String result;

    public String getResult() {
        return result;
    }

    @XmlElement
    public void setResult(String result) {
        this.result = result;
    }

    public Task(){}

    public Task(String s, int num){
        inputString = s;
        this.num = num;
    }


    public String getInputString() {
        return inputString;
    }

    @XmlElement
    public void setInputString(String inputString) {
        this.inputString = inputString;
    }

    public int getNum() {
        return num;
    }

    @XmlElement
    public void setNum(int num) {
        this.num = num;
    }
}
