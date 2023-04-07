package com.example.secondlessonschrdingerscat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView coordinatesOut;
    private float x;
    private float y;
    private String sDown;
    private String sMove;
    private String sUp;

    private final float xCat = 500;
    private final float yCat = 500;
    private final float deltaCat = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coordinatesOut = findViewById(R.id.coordinatesOut);

        coordinatesOut.setOnTouchListener(Listener);
    }

    private View.OnTouchListener Listener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {

            x = motionEvent.getX();
            y = motionEvent.getY();

            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    sDown = "нажатие: координата х = " + x + ", координата y = " + y;
                    sMove = "";
                    sUp = "";
                    break;
                case MotionEvent.ACTION_MOVE:
                    sMove = "движение: координата х = " + x + ", координата y = " + y;
                    if (x < (xCat + deltaCat) && x > (xCat - deltaCat) && y < (yCat + deltaCat)&& y > ( yCat - deltaCat)) {
                        //Toast toast = Toast.makeText(getApplicationContext(), "успешно найдено", Toast.LENGTH_SHORT);
                        Toast toast = Toast.makeText(getBaseContext(), "успешно найдено", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER,(int) 0, (int) 0);
                                //xCat, (int) yCat);
                        toast.setMargin(5,1000);
                        LinearLayout toastContainer = (LinearLayout) toast.getView();
                        //ImageView cat = new ImageView(getApplicationContext());
                        ImageView cat = new ImageView(getBaseContext());
                        cat.setImageResource(R.drawable.cat2);
                        //toastContainer.addView(cat, 1);
                        toast.setView(cat);
                        toast.show();
                    }
                    break;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL:
                    sMove = "";
                    sUp = "отпускание: координата х = " + x + ", координата y = " + y;
                    break;
            }
            coordinatesOut.setText(sDown + "\n" + sMove + "\n" + sUp);

            return true;
        }
    };
}