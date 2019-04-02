package study.quangtrung.self;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AndroidSelfStudy extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {
    private Button currentListenerBtn;
    private Button separateListenerBtn;
    private Button anonymousListenerBtn;
    private Button innerAnonymousListenerBtn;

    private ButtonEventHandler buttonEventHandler;
    private View.OnClickListener anonymousListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (R.id.anonymousClassListenerBtn == v.getId()) {
                showToast(getString(R.string.anonymousToast));
            } else {
                showToast(getString(R.string.errorToast) + "\t 0x003");
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Catch event on current class
        currentListenerBtn = findViewById(R.id.currentClassListenerBtn);
        currentListenerBtn.setOnClickListener(this);

        //Catch event on separate class
        separateListenerBtn = findViewById(R.id.separateClassListenerBtn);
        buttonEventHandler = new ButtonEventHandler(this);
        separateListenerBtn.setOnClickListener(buttonEventHandler);

        //Catch event on anonymous class
        anonymousListenerBtn = findViewById(R.id.anonymousClassListenerBtn);
        anonymousListenerBtn.setOnClickListener(anonymousListener);

        //Catch event on anonymous class
        innerAnonymousListenerBtn = findViewById(R.id.innerAnonymousClassListenerBtn);
        innerAnonymousListenerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (R.id.innerAnonymousClassListenerBtn == v.getId()) {
                    showToast(getString(R.string.innerAnonymousToast));
                } else {
                    showToast(getString(R.string.errorToast) + "\t 0x004");
                }
            }
        });

        //Catch low-level touch event from parent pane
        LinearLayout parentLayout = findViewById(R.id.parentPanel);
        parentLayout.setOnTouchListener(this);
    }

    @Override
    public void onClick(View v) {
        if (R.id.currentClassListenerBtn == v.getId()) {
            showToast(getString(R.string.currentToast));
        } else {
            showToast(getString(R.string.errorToast) + "\t 0x001");
        }
    }

    /**
     * Called when a touch event is dispatched to a view. This allows listeners to
     * get a chance to respond before the target view.
     *
     * @param v     The view the touch event has been dispatched to.
     * @param event The MotionEvent object containing full information about
     *              the event.
     * @return True if the listener has consumed the event, false otherwise.
     */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        showToast(event.toString());
        return false;
    }

    private void showToast(String content) {
        Utility.getInstance(this).showToast(content, Toast.LENGTH_LONG);
    }
}

class ButtonEventHandler implements View.OnClickListener {

    private Context context;

    public ButtonEventHandler(Context context) {
        this.context = context;
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        if (R.id.separateClassListenerBtn == v.getId()) {
            Utility.getInstance(context).showToast(context.getString(R.string.separateToast), Toast.LENGTH_LONG);
        } else {
            Utility.getInstance(context).showToast(context.getString(R.string.errorToast) + "\t 0x002", Toast.LENGTH_LONG);
        }
    }
}