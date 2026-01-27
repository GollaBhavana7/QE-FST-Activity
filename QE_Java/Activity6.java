package javatraining;
import java.time.LocalDateTime;
import java.util.ArrayList;

class Plane {

    // private variables
    private int maxPassengers;
    private ArrayList<String> passengers;
    private LocalDateTime lastTimeLanded;

    // constructor
    public Plane(int maxPassengers) {
        this.maxPassengers = maxPassengers;
        this.passengers = new ArrayList<>();
    }

    // onboard method
    public void onboard(String passengerName) {
        if (passengers.size() < maxPassengers) {
            passengers.add(passengerName);
        } else {
            System.out.println("Plane is full. Cannot add: " + passengerName);
        }
    }

    // takeOff method
    public LocalDateTime takeOff() {
        return LocalDateTime.now();
    }

    // land method
    public void land() {
        lastTimeLanded = LocalDateTime.now();
        passengers.clear();
    }

    // getter for lastTimeLanded
    public LocalDateTime getLastTimeLanded() {
        return lastTimeLanded;
    }

    // getter for passengers
    public ArrayList<String> getPassengers() {
        return passengers;
    }
}
public class Activity6 {

    public static void main(String[] args) throws InterruptedException {

        // create Plane object
        Plane plane = new Plane(10);

        // onboard passengers
        plane.onboard("Alice");
        plane.onboard("Bob");
        plane.onboard("Charlie");
        plane.onboard("Diana");

        // print take-off time
        System.out.println("Take-off time: " + plane.takeOff());

        // print passengers list
        System.out.println("Passengers on board: " + plane.getPassengers());

        // pause for 5 seconds (simulate flight)
        Thread.sleep(5000);

        // land the plane
        plane.land();

        // print landing time
        System.out.println("Landing time: " + plane.getLastTimeLanded());

        // verify passengers cleared
        System.out.println("Passengers after landing: " + plane.getPassengers());
    }
}
 