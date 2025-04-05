package ca.mcmaster.se2aa4.island.teamXXX;

class EchoCommand implements DroneCommand {

    private Drone drone;
    private Direction direction;

    public EchoCommand(Drone drone, Direction direction) {
        this.drone = drone;
        this.direction = direction;
    }

    @Override
    public void execute() {
        drone.echo(direction);
    }
}