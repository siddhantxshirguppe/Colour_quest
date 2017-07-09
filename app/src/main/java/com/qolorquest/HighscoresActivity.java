package com.qolorquest;

import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.graphics.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.util.*;
import android.webkit.*;
import java.util.*;
import java.text.*;


public class HighscoresActivity extends Activity {

	private LinearLayout linear1;
	private LinearLayout linear6;
	private TextView textview3;
	private TextView hightxt;
	private Button button2;



	private SharedPreferences x;
	private Intent intent = new Intent();
	private SharedPreferences y;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.highscores);
		initialize();
		initializeLogic();
	}

	private void  initialize() {
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		textview3 = (TextView) findViewById(R.id.textview3);
		hightxt = (TextView) findViewById(R.id.hightxt);
		button2 = (Button) findViewById(R.id.button2);

		x = getSharedPreferences("file", Activity.MODE_PRIVATE);

		y = getSharedPreferences("file", Activity.MODE_PRIVATE);

		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				intent.setClass(getApplicationContext(), MenuActivity.class);
				startActivity(intent);
			}
		});

	}

	private void  initializeLogic() {
		if (Double.parseDouble(hightxt.getText().toString()) == 0) {
			x.edit().putString("high", x.getString("score", "")).commit();
		}
		else {
			if (Double.parseDouble(x.getString("score", "")) > Double.parseDouble(x.getString("high", ""))) {
				x.edit().putString("high", x.getString("score", "")).commit();
			}
			if (Double.parseDouble(x.getString("high", "")) > Double.parseDouble(x.getString("score", ""))) {
				hightxt.setText(x.getString("high", ""));
			}
		}
		hightxt.setText(x.getString("high", ""));
		y.edit().putString("high", x.getString("high", "")).commit();
		showMessage("                  GOOD GAME!\n\n\n\n\n");
	}




	// created automatically
	private void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}

	private int getRandom(int _minValue ,int _maxValue){
		Random random = new Random();
		return random.nextInt(_maxValue - _minValue + 1) + _minValue;
	}

	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
				_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}

}
