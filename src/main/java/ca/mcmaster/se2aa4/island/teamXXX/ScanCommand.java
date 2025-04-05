package ca.mcmaster.se2aa4.island.teamXXX;

class ScanCommand implements DroneCommand {

    private Drone drone;

    public ScanCommand(Drone drone) {
        this.drone = drone;
    }

    @Override
    public void execute() {
        drone.scan();
    }
}