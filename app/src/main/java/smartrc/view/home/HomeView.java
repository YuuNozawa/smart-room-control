package smartrc.view.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import smartrc.model.Model;
import smartrc.view.AppFrame;
import smartrc.view.IView;

@Component
@Qualifier("HomeView")
public class HomeView implements IView {
    @Autowired
    private AppFrame appFrame;

    public void show() {
        HomePanel homePanel = new HomePanel();
        appFrame.next(homePanel);
    }
    
    public void setModel(Model model) {
        // no-op
    }
}