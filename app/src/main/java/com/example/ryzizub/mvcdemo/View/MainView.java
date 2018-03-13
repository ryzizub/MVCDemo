package com.example.ryzizub.mvcdemo.View;

import android.view.View;

import com.example.ryzizub.mvcdemo.Model.MainModel;
import com.example.ryzizub.mvcdemo.R;


/**
 * Created by simonikd on 14.08.2017.
 */

public class MainView extends BaseView<MainModel, MainView.IViewCallback> {

    public MainView(IViewCallback callback){
        super(R.layout.activity_main, callback);
    }

    @Override
    public void initializeView(View parentView) {

    }

    @Override
    public void refresh(MainModel model) {

    }

    public interface IViewCallback extends BaseView.IViewCallbackBase{

    }
}
