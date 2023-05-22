package com.example.sundaneserestaurantfinder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class pilihkota extends Activity{
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.pilihkota);
		
		Button btn_semua = (Button)findViewById(R.id.buttonAll);
		Button btn_kembali = (Button)findViewById(R.id.buttonBack);
		
		btn_semua.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(pilihkota.this, ListViewSQLiteActivity.class);
				startActivity(i);
				
			}
		});
		
		btn_kembali.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}

}
