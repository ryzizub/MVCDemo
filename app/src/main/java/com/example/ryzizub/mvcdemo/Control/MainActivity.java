package com.example.ryzizub.mvcdemo.Control;


import com.example.ryzizub.mvcdemo.Model.MainModel;
import com.example.ryzizub.mvcdemo.View.MainView;

/**
 * Created by simonikd on 14.08.2017.
 */

public class MainActivity extends BaseActivity<MainModel, MainView> {

    @Override
    protected MainModel createNewModel() {
        return new MainModel();
    }

    @Override
    protected MainView createView() {
        return new MainView(new MainView.IViewCallback() {
        });
    }
}
