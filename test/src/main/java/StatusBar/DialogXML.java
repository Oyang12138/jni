package StatusBar;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Space;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.test.R;

public class DialogXML extends Dialog {
    ImageView mIconDismiss;
    TextView mTitle;
    LinearLayout mContentContainer;
    RelativeLayout mHeaderContainer;
    Button mButtonFirst;
    Button mButtonSecond;
    Space mCenterSpaceOfButton;
    public DialogXML(@NonNull Context context) {
        super(context);
    }

    public DialogXML(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected DialogXML(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_status_bar_base);
        Window window = getWindow();
        mIconDismiss = findViewById(R.id.icon_dismiss);
        mIconDismiss.setOnClickListener(v -> this.dismiss());
        mTitle = findViewById(R.id.dialog_title);
        mContentContainer = findViewById(R.id.center_content_container);
        mHeaderContainer = findViewById(R.id.header_content_container);
        mButtonFirst = findViewById(R.id.dialog_button_first);
        mButtonSecond = findViewById(R.id.dialog_button_second);
        mCenterSpaceOfButton = findViewById(R.id.space_of_center_button);
//        window.getDecorView().setBackgroundResource(R.color.black);

    }
    public void setDisableHeaderContainer(boolean visibility) {
        mHeaderContainer.setVisibility(visibility ? View.GONE : View.VISIBLE);
    }

    public void setCenterView(View view) {
        mContentContainer.removeAllViews();
        mContentContainer.addView(view);
    }

    public void setDisableButton(boolean first, boolean second) {
        mButtonFirst.setVisibility(first ? View.GONE : View.VISIBLE);
        mButtonSecond.setVisibility(second ? View.GONE : View.VISIBLE);
        mCenterSpaceOfButton.setVisibility(first || second ? View.GONE : View.VISIBLE);
    }

    public void setFristButtonEnable(boolean enable) {
        mButtonFirst.setEnabled(enable);
    }

    public void setSecondButtonEnable(boolean enable) {
        mButtonSecond.setEnabled(enable);
    }

    public void setupButtonFirst(int textResId, View.OnClickListener listener) {
        mButtonFirst.setText(textResId);
        mButtonFirst.setOnClickListener(listener);
    }

    public void setupButtonFirst(String text, View.OnClickListener listener) {
        mButtonFirst.setText(text);
        mButtonFirst.setOnClickListener(listener);
    }

    public void setupButtonSecond(int textResId, View.OnClickListener listener) {
        mButtonSecond.setText(textResId);
        mButtonSecond.setOnClickListener(listener);
    }

    public void setupButtonSecond(String text, View.OnClickListener listener) {
        mButtonSecond.setText(text);
        mButtonSecond.setOnClickListener(listener);
    }

    public void setupTitle(String text) {
        mTitle.setText(text);
    }

    public void setupTitleAndListener(String text, View.OnClickListener listener){
        mTitle.setText(text);
        mTitle.setOnClickListener(listener);
    }
}
