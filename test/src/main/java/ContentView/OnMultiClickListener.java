package ContentView;

import android.view.View;

public abstract class OnMultiClickListener implements View.OnClickListener {
    private long lastClickTime;

    public abstract void onMultiClick(View v);

    @Override
    public void onClick(View view) {
        long curClickTime = System.currentTimeMillis();
        if((curClickTime-lastClickTime)>=200){
            lastClickTime = curClickTime;
            onMultiClick(view);
        }
    }
}
