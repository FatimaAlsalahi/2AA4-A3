package ca.mcmaster.se2aa4.island.teamXXX;

class FlyCommand implements DroneCommand {

    private Drone drone;

    public FlyCommand(Drone drone) {
        this.drone = drone;
    }

    @Override
    public void execute() {
        drone.fly();
    }
}