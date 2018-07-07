package ryzizub.mvcdemo.View;

import android.view.View;

import ryzizub.mvcdemo.Model.BaseModel;

public abstract class BaseView<M extends BaseModel, C extends BaseView.IViewCallbackBase> {

    private final int layoutRes;
    private final C viewCallback;

    protected BaseView(int layoutRes, C viewCallback) {
        this.layoutRes = layoutRes;
        this.viewCallback = viewCallback;
    }

    protected C getViewCallback() {
        return viewCallback;
    }

    public int getLayoutRes() {
        return layoutRes;
    }

    public abstract void initializeView(View parentView);

    public abstract void refresh(M model);

    public interface IViewCallbackBase {
    }
}
