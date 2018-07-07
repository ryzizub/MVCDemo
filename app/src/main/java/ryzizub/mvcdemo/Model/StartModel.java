package ryzizub.mvcdemo.Model;

public class StartModel extends BaseModel {

    private Integer clickCounter = 0;

    public void setClickCounter(Integer clickCounter) {
        this.clickCounter = clickCounter;
    }

    public Integer getClickCounter() {
        return clickCounter;
    }
}
