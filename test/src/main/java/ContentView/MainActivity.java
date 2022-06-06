package ContentView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.test.R;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.dialog);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ControlDialog controlDialog = new ControlDialog(MainActivity.this);
                controlDialog.setONListener(new OnClickBtnStateListener() {
                    @Override
                    public void powerChange(boolean isOn) {

                    }

                    @Override
                    public void inLoopChange(boolean isOn) {

                    }

                    @Override
                    public void coolAcChange(boolean isOn) {

                    }

                    @Override
                    public void autoChange(boolean isOn) {

                    }

                    @Override
                    public void syncChange(boolean isOn) {

                    }

                    @Override
                    public void rearChange(boolean isOn) {

                    }

                    @Override
                    public void ecoChange(boolean isOn) {

                    }

                    @Override
                    public void chairLeftChange(int level) {

                    }

                    @Override
                    public void chairRightChange(int level) {

                    }

                    @Override
                    public void fanSpeedChange(int speed) {

                    }

                    @Override
                    public void directionChange(int direction) {

                    }

                    @Override
                    public void tempLeftChange(int temp) {

                    }

                    @Override
                    public void tempRightChange(int temp) {

                    }
                });
                controlDialog.show();
            }
        });
    }
}