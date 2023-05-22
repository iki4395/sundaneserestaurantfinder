package com.example.sundaneserestaurantfinder;

import android.app.Activity;
import android.graphics.Typeface;
import android.widget.TextView;

public class about extends Activity{
	
	Typeface tf = Typeface.createFromAsset(getAssets(),
            "fonts/Lobster-Regular.ttf");
    TextView tv = (TextView) findViewById(R.id.textView1);
    //tv.setTypeface(tf);

}
