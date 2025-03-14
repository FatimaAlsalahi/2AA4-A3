package ca.mcmaster.se2aa4.island.teamXXX;

import ca.mcmaster.se2aa4.island.teamXXX.Action;
import ca.mcmaster.se2aa4.island.teamXXX.Direction;

import org.json.JSONObject;

public class Decision {
    
    private JSONObject decision;

    public Decision() {
        this.decision = new JSONObject();
    }

    public Action getAction() {
        Action action = Action.valueOf(decision.optString("action", "").toUpperCase());
        return action;
    }

    public void setAction(Action action) {
        decision.put("action", action.toString());
        //decision.remove("parameters");
    }


    public void setParameters(JSONObject parameters) {
        decision.put("parameters", parameters);
    }

    public JSONObject getDecision() {
        return decision;
    }

    @Override
    public String toString() {
        return decision.toString();
    }
}