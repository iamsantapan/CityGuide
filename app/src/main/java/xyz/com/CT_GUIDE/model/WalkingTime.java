package xyz.com.CT_GUIDE.model;


public class WalkingTime {
    String time="";

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }



    @Override
    public String toString() {
        return "WalkingTime{" +
                "time='" + time + '\'' +
                '}';
    }
}