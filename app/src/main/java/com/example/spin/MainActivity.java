package com.example.spin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bottle) ImageView spinBottle;
    private Random random = new Random();
    private int lastDir;
    private boolean spinning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    public void spin(View view) {
        if (!spinning) {
            int newDir = random.nextInt(1800);

            //to get the middle of the imageView
            float pivotX = spinBottle.getWidth() / 2;
            float pivotY = spinBottle.getHeight() / 2;

            //rotating anaimation
            Animation rotate = new RotateAnimation(lastDir, newDir, pivotX, pivotY);
            rotate.setDuration(5000);
            rotate.setFillAfter(true);

            lastDir = newDir;
            spinBottle.startAnimation(rotate);
        }

    }
}
