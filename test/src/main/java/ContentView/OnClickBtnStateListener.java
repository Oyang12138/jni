package ContentView;

public interface OnClickBtnStateListener {
    void powerChange(boolean isOn);

    void inLoopChange(boolean isOn);

    void coolAcChange(boolean isOn);

    void autoChange(boolean isOn);

    void syncChange(boolean isOn);

    void rearChange(boolean isOn);

    void ecoChange(boolean isOn);

    void chairLeftChange(int level);

    void chairRightChange(int level);

    void fanSpeedChange(int speed);

    void directionChange(int direction);

    void tempLeftChange(int temp);

    void tempRightChange(int temp);
}
