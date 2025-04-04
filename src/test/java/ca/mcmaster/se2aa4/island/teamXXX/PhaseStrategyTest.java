package ca.mcmaster.se2aa4.island.teamXXX;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PhaseStrategyTest {

    private Drone drone;
    private PhaseDecisionMaker decisionMaker;
    private Creeks creeks;
    private PreviousState previousState;
    private CurrentState currentState;
    private PhaseOneStrategy phaseOneStrategy;
    private PhaseTwoStrategy phaseTwoStrategy;

    @BeforeEach
    void setUp() {
        drone = new Drone(100, Direction.NORTH);
        decisionMaker = new PhaseDecisionMaker();
        creeks = new Creeks();
        currentState = new CurrentState();
        previousState = new PreviousState(new Decision(Action.ECHO), new Response(), Direction.NORTH);
        phaseOneStrategy = new PhaseOneStrategy();
        phaseTwoStrategy = new PhaseTwoStrategy();
    }

    @Test
    void testPhaseOneStrategy_LowBattery() {
        drone = new Drone(50, Direction.NORTH);
        Decision decision = phaseOneStrategy.decideAction(drone, decisionMaker, creeks, previousState, currentState);
        assertEquals(Action.STOP, decision.getAction());
    }

    @Test
    void testPhaseOneStrategy_FirstMove() {
        //previousState = null;
        Decision decision = phaseOneStrategy.decideAction(drone, decisionMaker, creeks, previousState, currentState);
        assertEquals(Action.STOP, decision.getAction());
    }

    @Test
    void testPhaseOneStrategy_EchoToFly() {
        previousState = new PreviousState(new Decision(Action.ECHO), new Response(), Direction.NORTH);
        previousState.setGround(false);
        previousState.setRange(0);
        Decision decision = phaseOneStrategy.decideAction(drone, decisionMaker, creeks, previousState, currentState);
        assertEquals(Action.STOP, decision.getAction());
    }

    @Test
    void testPhaseTwoStrategy_LowBattery() {
        drone.setBatteryLevel(10);
        Decision decision = phaseTwoStrategy.decideAction(drone, decisionMaker, creeks, previousState, currentState);
        assertEquals(Action.STOP, decision.getAction());
    }

    @Test
    void testPhaseTwoStrategy_ScanToEcho() {
        previousState = new PreviousState(new Decision(Action.SCAN), new Response(), Direction.NORTH);
        previousState.setCreekId("CREEK_123");
        Decision decision = phaseTwoStrategy.decideAction(drone, decisionMaker, creeks, previousState, currentState);
        assertEquals(Action.STOP, decision.getAction());
    }

    @Test
    void testPhaseTwoStrategy_EchoToStop() {
        previousState = new PreviousState(new Decision(Action.ECHO), new Response(), Direction.NORTH);
        previousState.setGround(false);
        previousState.setRange(1);
        Decision decision = phaseTwoStrategy.decideAction(drone, decisionMaker, creeks, previousState, currentState);
        assertEquals(Action.STOP, decision.getAction());
    }
}
