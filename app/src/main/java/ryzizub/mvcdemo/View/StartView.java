package ryzizub.mvcdemo.View;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ryzizub.mvcdemo.Model.StartModel;
import ryzizub.mvcdemo.R;

public class StartView extends BaseView<StartModel, StartView.IViewCallback> {

    private TextView textView;
    private Button button;

    public StartView(IViewCallback callback){
        super(R.layout.activity_start, callback);
    }


    @Override
    public void initializeView(View parentView) {
        this.textView = parentView.findViewById(R.id.textView);
        this.button = parentView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getViewCallback().countButtonClicked();
            }
        });
    }

    @Override
    public void refresh(StartModel model) {
        textView.setText("Button Clicked: ");
        textView.append(model.getClickCounter().toString());
        textView.append("Times");
    }

    public interface IViewCallback extends BaseView.IViewCallbackBase{
        void countButtonClicked();
    }
}
