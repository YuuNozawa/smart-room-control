package smartrc.presentation.framework;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import smartrc.presentation.controller.LightController;

@Component
public class LightState implements IState {
    @Autowired
    private LightController lightController;

    @Autowired
    @Qualifier("lightCmdMap")
    private Map<Integer, IState> cmdMap;

    @Override
    public void handle(int cmd) throws Exception {
        if(cmd == 1) {
            lightController.save();
        }
        lightController.display();
    }

    @Override
    public void display() throws Exception {
        lightController.display();
    }

    @Override
    public String toString() {
        return "状態：メインライト";
    }

    @Override
    public IState next(int cmd) {
        return cmdMap.get(cmd);
    }
}
