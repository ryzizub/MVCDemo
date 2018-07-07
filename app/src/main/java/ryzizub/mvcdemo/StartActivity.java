package ryzizub.mvcdemo;

import ryzizub.mvcdemo.Model.StartModel;
import ryzizub.mvcdemo.View.StartView;

public class StartActivity extends BaseActivity<StartModel, StartView> {


    @Override
    protected StartView createView() {
        return new StartView(new StartView.IViewCallback() {

            @Override
            public void countButtonClicked() {
                getModel().setClickCounter(getModel().getClickCounter() + 1);
                refreshView();
            }
        });
    }

    @Override
    protected StartModel createNewModel() {
        return new StartModel();
    }
}
