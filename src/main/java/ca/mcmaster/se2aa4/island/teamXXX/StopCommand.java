package ca.mcmaster.se2aa4.island.teamXXX;

class StopCommand implements DroneCommand {

    private Drone drone;

    public StopCommand(Drone drone) {
        this.drone = drone;
    }

    @Override
    public void execute() {
        drone.stop();
    }
}