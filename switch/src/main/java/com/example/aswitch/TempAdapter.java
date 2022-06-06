package com.example.aswitch;

public class TempAdapter implements PickAdapter{
    private float mMinValue;
    private float mMaxValue;
    private float[] select = new float[]{18f, 18.5f, 19f, 19.5f, 20f, 20.5f, 21f, 21.5f, 22f, 22.5f, 23f, 23.5f
            , 24f, 24.5f, 25f, 25.5f, 26f, 26.5f, 27f, 27.5f, 28f, 28.5f, 29f, 29.5f, 30f,30.5f, 31f,31.5f, 32f};
    @Override
    public int getCount() {
        return (int)((mMaxValue - mMinValue) *2)+ 1;
    }
    public TempAdapter(float minValue, float maxValue) {
        this.mMinValue = minValue;
        this.mMaxValue = maxValue;
    }

    @Override
    public String getItem(int position) {
        if (position >= 0 && position < getCount()) {
            return String.format("%s°", (mMaxValue - position*2));
        }
        return null;
    }
    public float getDate(int position) {
        if (position >= 0 && position < getCount()) {
            return (mMaxValue - position*2);
        }
        return 0;
    }
}
