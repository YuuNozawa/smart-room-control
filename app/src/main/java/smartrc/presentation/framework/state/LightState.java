package smartrc.presentation.framework.state;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import smartrc.presentation.controller.LightController;
import smartrc.presentation.framework.Command;
import smartrc.presentation.framework.IAction;

@Component
public class LightState implements IState {
    @SuppressWarnings("unused")
    private final StateFactory stateFactory;
    private final LightController lightController;
    private final Map<Command, IAction> cmdMap;

    @Autowired
    public LightState(LightController lightController, StateFactory stateFactory) {
        this.lightController = lightController;
        this.stateFactory = stateFactory;

        Map<Command, IAction> cmdMap = new HashMap<>();
        cmdMap.put(new Command(1), () -> {
            lightController.save();
            return Optional.empty();
        });
        cmdMap.put(new Command(9), () -> stateFactory.createState(HomeState.class));
        
        this.cmdMap = cmdMap;
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
    public Optional<IState> next(Command cmd) throws Exception {
        if(cmdMap.containsKey(cmd)) return cmdMap.get(cmd).execute();
        return Optional.empty();
    }
}
