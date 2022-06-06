package ContentView;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.test.R;

public class ControlDialog extends Dialog implements View.OnClickListener{
    private OnClickBtnStateListener mStateListener;
    private ImageView btn;
    private boolean isInLoopOn;
    public ControlDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.activity_my_status_bar);
        Window window = getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.dimAmount = 0.0f;
        lp.height = WindowManager.LayoutParams.MATCH_PARENT;
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(lp);
//        window.addFlags(Window.FEATURE_ACTION_BAR);
        init();

//        clickInLoop();
    }

    public ControlDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    public ControlDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }
    public void init(){
        btn = findViewById(R.id.dialog_button_first);

    }
//    public void setLoopState(boolean isOn) {
//        isInLoopOn = isOn;
//        btn.setBackgroundResource(isOn ? R.color.white: R.color.black);
//    }
//
//    private void clickInLoop() {
//        btn.setOnClickListener(new OnMultiClickListener() {
//            @Override
//            public void onMultiClick(View v) {
//                isInLoopOn = !isInLoopOn;
//                setLoopState(isInLoopOn);
//
//            }
//        });
//    }
    public void setONListener(OnClickBtnStateListener listener){
        this.mStateListener = listener;
    }


    @Override
    public void onClick(View view) {

    }

}
