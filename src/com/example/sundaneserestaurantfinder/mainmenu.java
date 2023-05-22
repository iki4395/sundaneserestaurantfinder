package com.example.sundaneserestaurantfinder;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class mainmenu extends Activity{
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.mainmenu);
		
		Button btn_mulai = (Button) findViewById(R.id.buttonStart);
		Button btn_tentang = (Button) findViewById(R.id.buttonAbout);
		Button btn_keluar = (Button) findViewById(R.id.buttonExit);
		
		btn_mulai.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			Intent i = new Intent(mainmenu.this, pilihkota.class);
			startActivity(i);
			}
		});
		
		btn_tentang.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(mainmenu.this, about.class);
				startActivity(i);
			}
		});
		
		btn_keluar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				close();
			}
		});
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
	
	public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
	
	public void close(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are You Sure To Close The Apps?")
        .setCancelable(false)
        .setPositiveButton("Yes",
        new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog,
        int id) {
        	mainmenu.this.finish();
        		}
        	})
        .setNegativeButton("No",new DialogInterface.OnClickListener() {
        	public void onClick(DialogInterface dialog,
        			int id) {
        				dialog.cancel();

        					}
        			}).show();
    }
	
	public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
         close();
        }   
        return super.onKeyDown(keyCode, event);
    }

}
