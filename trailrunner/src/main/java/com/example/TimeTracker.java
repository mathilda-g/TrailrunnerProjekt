package  com.example;


public class TimeTracker {

    private int hours;
    private int minutes;
    private int seconds;

    public TimeTracker(int hours, int minutes, int seconds)  {
        if(hours < 0 || minutes < 0 || minutes >= 60 || seconds < 0 || seconds >= 60) {
            throw new IllegalArgumentException("Ogiltlig tid, timmar, minuter och sekunder måste vara inom tillåtet intervall");
        }

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

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    //metod för att omvandla tiden till sekunder
    public int toSeconds() {
        return hours * 3600 + minutes * 60 + seconds;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }



    
}
