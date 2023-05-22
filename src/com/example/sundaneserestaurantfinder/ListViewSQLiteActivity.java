package com.example.sundaneserestaurantfinder;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Window;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ListViewSQLiteActivity extends Activity {
	
	private DatabaseHelper myDH;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.daftarlist);
		ListView listContent = (ListView)findViewById(R.id.restoranlist);
		
		myDH = new DatabaseHelper(this);
		myDH.openToWrite();
		myDH.deleteAll();
		
		myDH.insert("RM. Joglo Sumedang", "Jl. Cimalaka, No. 333", "Sumedang", "Telp. (0261) 210254", "-6.817899", "107.946208");
		myDH.insert("RM. Ponyo Sumedang", "Jl. Bandung-Sumedang KM.38", "Sumedang", "Telp. (0261) 205300", "-6.869224", "107.874450");
		
		myDH.close();
		
		myDH = new DatabaseHelper(this);
		myDH.openToRead();
		
		Cursor cursor = myDH.queueAll();
		startManagingCursor(cursor);
		
		String[] from = new String[]{DatabaseHelper.NAMA};
		int[] to = new int[]{R.id.txtrestoran};
		
		SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(this, R.layout.row, cursor, from, to);
		
		listContent.setAdapter(cursorAdapter);
		
		myDH.close();
	}
	

}
