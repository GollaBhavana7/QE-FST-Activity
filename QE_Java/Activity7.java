package javatraining;

interface BicycleParts {

    int tyres = 2; // number of tyres
    int maxSpeed = 40; // max speed of bicycle
}
interface BicycleOperations {

    void applyBrake(int decrement); // slow down
    void speedUp(int increment); // speed up
}

class Bicycle implements BicycleParts, BicycleOperations {

    int gears;
    int currentSpeed;

    // Constructor
    public Bicycle(int gears, int currentSpeed) {
        this.gears = gears;
        this.currentSpeed = currentSpeed;
    }

    // applyBrake: reduce speed
    @Override
    public void applyBrake(int decrement) {
        currentSpeed = currentSpeed - decrement;
        if (currentSpeed < 0) {
            currentSpeed = 0;
        }
    }

    // speedUp: increase speed
    @Override
    public void speedUp(int increment) {
        currentSpeed = currentSpeed + increment;
        if (currentSpeed > maxSpeed) {
            currentSpeed = maxSpeed;
        }
    }

    // bicycleDesc method
    public String bicycleDesc() {
        return ("No of gears are " + gears +
                "\nSpeed of bicycle is " + maxSpeed);
    }
}
class MountainBike extends Bicycle {

    public MountainBike(int gears,int speed,int maxspeed) {
        super(gears, 0); // initialize gears and currentSpeed
    }
}

public class Activity7 {

    public static void main(String args[]) {

        // Create object of MountainBike
        MountainBike mb = new MountainBike(3,0,25);

        // Access methods
        System.out.println(mb.bicycleDesc());

        mb.speedUp(20);
        mb.applyBrake(5);
    }
}

