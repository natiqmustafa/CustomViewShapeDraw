package com.natodriod.customview.shapescustomview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.natodriod.customview.shapescustomview.customview.ShapeDraw;

public class MainActivity extends AppCompatActivity {
    private ShapeDraw shapeDraw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shapeDraw = (ShapeDraw) findViewById(R.id.shape_draw);
        findViewById(R.id.bSwap_color).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shapeDraw.swapColor();
            }
        });
    }
}
