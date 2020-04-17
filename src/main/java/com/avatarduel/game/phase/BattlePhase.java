package com.avatarduel.game.phase;

import com.avatarduel.gui.controller.GameController;
import com.avatarduel.gui.event.Event;
import com.avatarduel.model.Player;

import java.util.List;

public class BattlePhase extends Phase {
    Player opponent;

    public BattlePhase(Player playerNow, Player opponent) throws Exception {
        super(playerNow);
        this.opponent = opponent;
    }

    @Override
    public void run() throws Exception {
        System.out.println(playerNow.getName() + "BATTLE PHASE");
        initPhase();
        List<String> test = controller.getP1FieldController().getDisabledInBattle();
        for (String o : test) {
            System.out.println(o);
        }
    }


    public void initPhase() {
        if (playerNow.equals(controller.getP1())) {
            controller.setStageTextP1("battle");
            controller.getP1HandController().setEnableClick(false);
            controller.getP1HandController().setViewEnabled(false);
            controller.disable(controller.battlePhaseP1, true);
            controller.disable(controller.endPhaseP1, false);
            controller.getP1FieldController().setEnableClick(true);
            controller.getP2FieldController().setEnableClick(false);
            controller.getP1FieldController().setOnClick("selectCard");
           
        } else {
            controller.setStageTextP2("battle");
            controller.getP2HandController().setEnableClick(false);
            controller.getP2HandController().setViewEnabled(false);
            controller.disable(controller.battlePhaseP2, true);
            controller.disable(controller.endPhaseP2, false);
            controller.getP2FieldController().setEnableClick(true);
            controller.getP1FieldController().setEnableClick(false);
            controller.getP2FieldController().setOnClick("selectCard");
        }
    }
}
