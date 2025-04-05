package ca.mcmaster.se2aa4.island.teamXXX;

class HeadingCommand implements DroneCommand {

    private Drone drone;
    private Direction direction;

    public HeadingCommand(Drone drone, Direction direction) {
        this.drone = drone;
        this.direction = direction;
    }

    @Override
    public void execute() {
        drone.heading(direction);
    }
}