package com.example.mydemos.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.mydemos.R;

import java.util.ArrayList;

public class AnimationCloning extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_cloning);
        LinearLayout container = findViewById(R.id.container);
        final MyAnimationView animView = new MyAnimationView(this);
        container.addView(animView);
        Button starter = (Button) findViewById(R.id.startButton);
        starter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animView.startAnimation();
            }
        });

    }

    //动画视图内部类
    public class MyAnimationView extends View implements ValueAnimator.AnimatorUpdateListener{
        public final ArrayList<ShapeHolder> balls = new ArrayList<>();

        AnimatorSet animation = null;
        private float mDensity;
        public MyAnimationView(Context context){
            super(context);
            mDensity = getContext().getResources().getDisplayMetrics().density;
            ShapeHolder ball0 = addBall(50f,25f);
            ShapeHolder ball1 = addBall(150f,25f);
            ShapeHolder ball2 = addBall(250f,25f);
            ShapeHolder ball3 = addBall(350f,25f);
        }
        private void createAnimation(){
            if(animation == null){
                ObjectAnimator anim1 = ObjectAnimator.ofFloat(balls.get(0),"y",0f,getHeight()-balls.get(0).getHeigth()).setDuration(500);
                ObjectAnimator anim2 = anim1.clone();
                anim2.setTarget(balls.get(1));
                anim1.addUpdateListener(this);

                ShapeHolder ball2 = balls.get(2);
                //持续时间
                ObjectAnimator animDown = ObjectAnimator.ofFloat(ball2,"y",0f,getHeight()-ball2.getHeigth()).setDuration(500);
                //加速差值器
                animDown.setInterpolator(new AccelerateInterpolator());
                ObjectAnimator animUp = ObjectAnimator.ofFloat(ball2,"y",0f,getHeight()-ball2.getHeigth()).setDuration(500);
                //减速差值器
                animUp.setInterpolator(new DecelerateInterpolator());
                AnimatorSet s1 =new  AnimatorSet();
                //顺序播放
                s1.playSequentially(animDown,animUp);
                animDown.addUpdateListener(this);
                animUp.addUpdateListener(this);
                AnimatorSet s2 = s1.clone();
                s2.setTarget(balls.get(3));
                animation = new AnimatorSet();
                animation.playTogether(anim1,anim2,s1);
                animation.playSequentially(s1,s2);

            }
        }

        private ShapeHolder addBall(float x, float y) {
            //椭圆形
            OvalShape circle = new OvalShape();

            //调整大小
            circle.resize(50f *mDensity,50f*mDensity);

            //绘制形状
            ShapeDrawable drawable = new ShapeDrawable(circle);

            //形状支架（自建类）
            ShapeHolder shapeHolder = new ShapeHolder(drawable);

            //位置
            shapeHolder.setX(x-25f);
            shapeHolder.setY(y-25f);

            int red = (int)(100+Math.random()*155);
            int green = (int)(Math.random()*155);
            int blue = (int)(100+Math.random()*155);
            int color =  0xff000000 | red << 16 | green << 2 | blue;
            Paint paint = drawable.getPaint();
            int darkColor =  0xff000000 | red/4 << 16 | green/4 << 8 | blue/4;
            //渐变
            RadialGradient gradient = new RadialGradient(37.5f,12.5f,50f,color,darkColor, Shader.TileMode.CLAMP);
            paint.setShader(gradient);
            shapeHolder.setPaint(paint);
            balls.add(shapeHolder);
            return shapeHolder;
        }


        @Override
        protected void onDraw(Canvas canvas) {
            for(int i = 0;i<balls.size();i++){
                ShapeHolder shapeHolder = balls.get(i);
                canvas.save();
                canvas.translate(shapeHolder.getX(),shapeHolder.getY());
                shapeHolder.getShape().draw(canvas);
                //恢复画布
                canvas.restore();
            }
        }
        private void startAnimation(){
            //创建
            createAnimation();
            //开始
            animation.start();
        }
        public  void onAnimationUpdate(ValueAnimator animation){
            invalidate();
        }
    }

}