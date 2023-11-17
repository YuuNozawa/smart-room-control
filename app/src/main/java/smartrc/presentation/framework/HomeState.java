package smartrc.presentation.framework;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import smartrc.presentation.controller.HomeController;

@Component
public class HomeState implements State {
    @Autowired
    private HomeController homeController;

    @Autowired
    @Qualifier("homeCmdMap")
    private Map<Integer, State> cmdMap;

    @Override
    public void handle(int cmd) {
        // no-op
    }

    @Override
    public void display() {
        homeController.display();
    }

    @Override
    public String toString() {
        return "状態：ホーム";
    }

    @Override
    public State next(int cmd) {
        return cmdMap.get(cmd);
    }
}