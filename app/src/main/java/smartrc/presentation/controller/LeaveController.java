package smartrc.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import smartrc.view.IView;

@Component
public class LeaveController {
    
    @Autowired
    @Qualifier("LeaveView")
    private IView view;

    public void display() {
        view.show();
    }
}
