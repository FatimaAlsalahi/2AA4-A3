package ca.mcmaster.se2aa4.island.teamXXX;

import ca.mcmaster.se2aa4.island.teamXXX.Direction;

import java.io.StringReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eu.ace_design.island.bot.IExplorerRaid;
import org.json.JSONObject;
import org.json.JSONTokener;

public class Explorer implements IExplorerRaid {

    private final Logger logger = LogManager.getLogger();
    private Drone drone;
    private DecisionMaker decisionMaker;
    private EmergencySite emergencySite;

    @Override
    public void initialize(String s) {
        logger.info("** Initializing the Exploration Command Center");
        JSONObject info = new JSONObject(new JSONTokener(new StringReader(s)));
        logger.info("** Initialization info:\n {}",info.toString(2));
        String direction = info.getString("heading");
        int batteryLevel = info.getInt("budget");
        this.drone = new Drone(batteryLevel, Direction.EAST);
        this.decisionMaker = new PhaseDecisionMaker();
        logger.info("The drone is facing {}", direction);
        logger.info("Battery level is {}", batteryLevel);
    }

    @Override
    public String takeDecision() {

        Decision decision = decisionMaker.decideAction(drone);
        decisionMaker.setPrevDecision(decision);
        logger.info("** Decision: {}", decision);
        return decision.toString();
    }

    @Override
    public void acknowledgeResults(String s) {
        JSONObject responseJSON = new JSONObject(new JSONTokener(new StringReader(s)));
        Response response = new Response(responseJSON);
        logger.info("** Response received:\n"+response.toString());
        Integer cost = response.getCost();
        logger.info("The cost of the action was {}", cost);
        drone.decreaseBattery(cost);
        String status = response.getStatus();
        logger.info("The status of the drone is {}", status);
        JSONObject extraInfo = response.getExtras();
        logger.info("Additional information received: {}", extraInfo);
        decisionMaker.setPrevResponse(response);
        logger.info("Battery level is now {}", drone.getBatteryLevel()); //not needed
    }

    @Override
    public String deliverFinalReport() {
        return "no creek found";
    }

}
