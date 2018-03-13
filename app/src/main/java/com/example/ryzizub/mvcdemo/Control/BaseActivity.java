package com.example.ryzizub.mvcdemo.Control;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.ryzizub.mvcdemo.MainApplication;
import com.example.ryzizub.mvcdemo.Model.BaseModel;
import com.example.ryzizub.mvcdemo.View.BaseView;

/**
 * Created by simonikd on 14.08.2017.
 *
 * Hlavní aktivita, se které všechny dědí
 * @param <M> - Model - Uložiště dat
 * @param <V> - View - Práce s UI
 */
public abstract class BaseActivity<M extends BaseModel, V extends BaseView<M, ? extends BaseView.IViewCallbackBase>> extends Activity {
    private MainApplication application;
    private V view;
    private M model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.application = (MainApplication) getApplication();
        this.model = createNewModel();
        this.view = createView();

        LayoutInflater li = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View root = li.inflate(view.getLayoutRes(), null);
        setContentView(root);

        view.initializeView(root);
        refreshView();
    }

    /**
     * Abstraktní metoda, ve které se inicializuje View
     * @return - vrací nastavené view
     */
    protected abstract V createView();

    /**
     * Abstraktní metoda, ve které se inicializuje model
     * @return - vrací nastavený model
     */
    protected abstract M createNewModel();

    /**
     * Metoda která refreshne view podle nového modelu
     */
    protected void refreshView() {
        view.refresh(model);
    }

    /*** getters and setters ***/

    public V getView() {
        return view;
    }

    public M getModel() {
        return model;
    }

    protected MainApplication getMainApplication() {
        return application;
    }
}