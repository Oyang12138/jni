package selectbutton;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.example.carseting.R;

public class RearLampselect extends LinearLayout implements View.OnClickListener{
    private static Button rear_lamp;
    private int selectid = 1;


    public RearLampselect(Context context) {
        super(context);
    }

    public RearLampselect(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.rear_lamp_select,this);
        rear_lamp = findViewById(R.id.RearLamp);
        rear_lamp.setSelected(false);
        rear_lamp.setBackgroundResource(R.drawable.round_dark);
        rear_lamp.setClickable(false);
        rear_lamp.setEnabled(false);
        rear_lamp.setFocusable(false);
        rear_lamp.setTextColor(Color.parseColor("#FFBCBCBC"));
    }
    public void setSelectid(int selectid){
        this.selectid = selectid;
        invalidate();
    }
    public static void setWhiteOpen(){
        rear_lamp.setClickable(true);
        rear_lamp.setEnabled(true);
        rear_lamp.setFocusable(true);
        rear_lamp.setBackgroundResource(R.drawable.shape_button_blue);
        rear_lamp.setTextColor(Color.parseColor("#FFFFFFFF"));
        rear_lamp.getBackground().setAlpha(255);//设置不透明度100%
    }
    public static void setWhiteClose(){
        rear_lamp.setClickable(true);
        rear_lamp.setEnabled(true);
        rear_lamp.setFocusable(true);
        rear_lamp.setBackgroundResource(R.drawable.round_dark);
        rear_lamp.setTextColor(Color.parseColor("#FF000000"));
        rear_lamp.getBackground().setAlpha(255);//设置不透明度100%
    }
    public static void setGrery(){
        rear_lamp.setClickable(false);
        rear_lamp.setEnabled(false);
        rear_lamp.setFocusable(false);
        rear_lamp.setBackgroundResource(R.drawable.round_dark);
        rear_lamp.setTextColor(Color.parseColor("#4D000000"));
        rear_lamp.getBackground().setAlpha(68);//设置不透明度30%
    }
    public void onClick(View paramView){

    }
    public interface onClickButtonListener{
        void rearLamp();
    }
    public RearLampselect(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public RearLampselect(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
