package ryzizub.mvcdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import ryzizub.mvcdemo.Model.BaseModel;
import ryzizub.mvcdemo.View.BaseView;

public abstract class BaseActivity<M extends BaseModel, V extends BaseView<M, ? extends BaseView.IViewCallbackBase>> extends AppCompatActivity {

    private BaseApplication application;
    private V view;
    private M model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.application = (BaseApplication) getApplication();
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

    protected BaseApplication getMainApplication() {
        return application;
    }
}
