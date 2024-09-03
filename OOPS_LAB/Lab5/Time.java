public class Time {
    private int hours;
    private int minutes;
    private int seconds;

    // Constructor to initialize time to zero
    public Time() {
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
    }

    // Constructor to initialize time with provided values
    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    // Display time in hh:mm:ss format
    public void displayTime() {
        System.out.printf("%02d:%02d:%02d%n", hours, minutes, seconds);
    }

    // Add two Time objects and return a new Time object
    public Time addTime(Time otherTime) {
        int totalHours = this.hours + otherTime.hours;
        int totalMinutes = this.minutes + otherTime.minutes;
        int totalSeconds = this.seconds + otherTime.seconds;

        // Handle carry-over
        if (totalSeconds >= 60) {
            totalMinutes += totalSeconds / 60;
            totalSeconds %= 60;
        }
        if (totalMinutes >= 60) {
            totalHours += totalMinutes / 60;
            totalMinutes %= 60;
        }

        return new Time(totalHours, totalMinutes, totalSeconds);
    }

    public static void main(String[] args) {
        // Create Time objects and display them
        Time time1 = new Time(1, 30, 45);
        Time time2 = new Time(); // Initialized to zero
        Time time3 = new Time(2, 45, 15);

        System.out.println("Time 1:");
        time1.displayTime();
        System.out.println("Time 2 (Zero Initialized):");
        time2.displayTime();
        System.out.println("Time 3:");
        time3.displayTime();

        // Add two Time objects and display the result
        Time sumTime = time1.addTime(time3);
        System.out.println("Time 1 + Time 3:");
        sumTime.displayTime();
    }
}
