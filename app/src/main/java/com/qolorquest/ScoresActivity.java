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


public class ScoresActivity extends Activity {

	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private TextView textview3;
	private TextView scr;
	private Button button1;

	private double max = 0;
	private String scoreh = "";
	private double score = 0;


	private Intent intent = new Intent();
	private SharedPreferences count;
	private SharedPreferences x;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.scores);
		initialize();
		initializeLogic();
	}

	private void  initialize() {
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		textview3 = (TextView) findViewById(R.id.textview3);
		scr = (TextView) findViewById(R.id.scr);
		button1 = (Button) findViewById(R.id.button1);


		count = getSharedPreferences("file", Activity.MODE_PRIVATE);
		x = getSharedPreferences("file", Activity.MODE_PRIVATE);

		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				intent.setClass(getApplicationContext(), HighscoresActivity.class);
				startActivity(intent);
			}
		});

	}

	private void  initializeLogic() {
		scr.setText(x.getString("score", ""));
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
