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


public class MainActivity extends Activity {

	private LinearLayout linear1;
	private ImageView imageview3;
	private LinearLayout linear2;
	private TextView textview2;
	private TextView textview1;
	private TextView loadper;

	private double h = 0;


	private Timer _timer = new Timer();
	private MediaPlayer ooh;
	private Intent intent = new Intent();
	private TimerTask tim;
	private SharedPreferences var;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		initialize();
		initializeLogic();
	}

	private void  initialize() {
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		imageview3 = (ImageView) findViewById(R.id.imageview3);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		textview2 = (TextView) findViewById(R.id.textview2);
		textview1 = (TextView) findViewById(R.id.textview1);
		loadper = (TextView) findViewById(R.id.loadper);




		var = getSharedPreferences("exit", Activity.MODE_PRIVATE);

		imageview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 

			}
		});

	}

	private void  initializeLogic() {
		ooh = MediaPlayer.create(getApplicationContext(), R.raw.seingeser);
		ooh.start();
		tim = new TimerTask() {
					@Override
						public void run() {
							runOnUiThread(new Runnable() {
							@Override
								public void run() {
										intent.setAction(Intent.ACTION_VIEW);
								intent.setClass(getApplicationContext(), Main2Activity.class);
								startActivity(intent);
								}
							});
						}
					};
					_timer.schedule(tim, (int)(3300));
		h = 0;
		tim = new TimerTask() {
					@Override
						public void run() {
							runOnUiThread(new Runnable() {
							@Override
								public void run() {
										h++;
								loadper.setText(String.valueOf((long)(h)).concat("℅"));
								}
							});
						}
					};
					_timer.scheduleAtFixedRate(tim, (int)(500), (int)(30));
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
