package main.com.sumit.coding.oops.basics;

public class MotorBikeRunner {

    public static void main(String[] args) {
        MotorBike honda = new MotorBike();
        MotorBike ducati = new MotorBike();

        honda.start();
        ducati.start();

        honda.setSpeed(100);
        System.out.println(honda.getSpeed());

        ducati.setSpeed(180);
        System.out.println(ducati.getSpeed());

        honda.increaseSpeed(20);
        ducati.decreaseSpeed(20);

        honda.run();
        ducati.run();
    }
}

class MotorBike {

    public MotorBike(){}

    public MotorBike(int speed) {
        this.speed = speed;
    }

    // Encapsulation
    // state
    private int speed; // member variable

    // Getter - Setter
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
//        System.out.println("speed - " +speed); // 100
//        System.out.println("this.speed - " + this.speed); //0
        if (speed > 0)
            this.speed = speed;
    }

    public void increaseSpeed(int howMuch) {
        this.speed = this.speed + howMuch;
    }

    public void decreaseSpeed(int howMuch) {
        setSpeed(this.speed - howMuch); // code reusable
    }

    // behaviour
    void run() {
        System.out.println("Bike Running at speed of " + speed + " KM/H");
    }

    void start() {
        System.out.println("Bike Started");
    }
}
