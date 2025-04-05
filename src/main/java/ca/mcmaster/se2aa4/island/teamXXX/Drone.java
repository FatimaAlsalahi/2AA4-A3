package ca.mcmaster.se2aa4.island.teamXXX;

public class Drone implements Observer{
    
    private int batteryLevel;
    private Direction direction = Direction.EAST;
    private int x = 1;
    private int y = 1; 

    public Drone(int batteryLevel, Direction direction) {
        this.batteryLevel = batteryLevel;
        this.direction = direction;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void decreaseBattery(int cost) {
        this.batteryLevel -= cost;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override 
    public void updateCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void fly() {
        // Implement the logic to make the drone fly
        System.out.println("Drone is flying.");
    }

    public void stop() {
        // Implement the logic to stop the drone
        System.out.println("Drone has stopped.");
    }

    public void scan() {
        // Implement the logic for scanning
        System.out.println("Drone is scanning the surroundings.");
    }

    public void echo(Direction direction) {
        // Implement the logic for echoing in a specific direction
        System.out.println("Drone is echoing in direction: " + direction);
    }

    public void heading(Direction direction) {
        // Implement the logic for changing heading
        System.out.println("Drone heading changed to: " + direction);
    }

    public void setBattery(int batteryLevel) {
        // Implement battery level update logic
        System.out.println("Battery level set to: " + batteryLevel);
    }

}