package  com.example;


public class Time {

    private int hours;
    private int minutes;
    private int seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;

    }

    public void setTime(int hours, int minutes, int seconds) {
        if(hours < 0 || minutes < 0 || minutes >= 60 || seconds < 0 || seconds >= 60) {
            throw new IllegalArgumentException("Ej giltlig tid");
        }
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public double toHours() {
        return hours + (minutes / 60.0) + (seconds / 3600.0);
    }

    public double toMinutes() {
        return hours * 60 + minutes + seconds / 60.0;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }


    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
   
    
}
