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
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class GameActivity extends Activity {
	private AdView mAdView;

	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout linear5;
	private TextView textview1;
	private LinearLayout linear4;
	private ImageView imageview1;
	private TextView textview2;
	private Button button3;
	private Button button6;
	private Button button4;
	private Button button5;
	private Button button7;
	private TextView textview4;
	private TextView textview3;

	private double rot = 0;
	private double cd = 0;
	private double a = 0;
	private double rand = 0;
	private double cnt = 0;
	private double textcolno = 0;
	private double ab = 0;
	private double abs = 0;
	private double wrong = 0;


	private Timer _timer = new Timer();
	private TimerTask tim;
	private MediaPlayer med;
	private Intent intent = new Intent();
	private SoundPool son;
	private SharedPreferences x;
	private Vibrator vib;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game);
		MobileAds.initialize(this, "ca-app-pub-6219959047239432~3581854505");
		mAdView = (AdView) findViewById(R.id.adView);
		AdRequest adRequest = new AdRequest.Builder().build();
		mAdView.loadAd(adRequest);
		initialize();
		initializeLogic();
	}

	private void  initialize() {
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		textview1 = (TextView) findViewById(R.id.textview1);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		textview2 = (TextView) findViewById(R.id.textview2);
		button3 = (Button) findViewById(R.id.button3);
		button6 = (Button) findViewById(R.id.button6);
		button4 = (Button) findViewById(R.id.button4);
		button5 = (Button) findViewById(R.id.button5);
		button7 = (Button) findViewById(R.id.button7);
		textview4 = (TextView) findViewById(R.id.textview4);
		textview3 = (TextView) findViewById(R.id.textview3);





		x = getSharedPreferences("file", Activity.MODE_PRIVATE);
		vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 

			}
		});
		button3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				if (String.valueOf((long)(textcolno)).equals("1")) {
					cnt++;
					abs = son.play((int)(ab), 1.0f, 1.0f, 1, (int)(0), 1.0f);
				}
				else {
					cnt--;
					abs = son.play((int)(wrong), 1.0f, 1.0f, 1, (int)(0), 1.0f);
					showMessage("-1");
					vib.vibrate((long)(1000));
				}
				rand = getRandom((int)(1), (int)(12));
				_pick(rand);
				textview3.setText(String.valueOf((long)(cnt)));
			}
		});
		button4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				if (String.valueOf((long)(textcolno)).equals("3")) {
					cnt++;
					abs = son.play((int)(ab), 1.0f, 1.0f, 1, (int)(0), 1.0f);
				}
				else {
					cnt--;
					abs = son.play((int)(wrong), 1.0f, 1.0f, 1, (int)(0), 1.0f);
					showMessage("-1");
					vib.vibrate((long)(1000));
				}
				rand = getRandom((int)(1), (int)(12));
				_pick(rand);
				textview3.setText(String.valueOf((long)(cnt)));
			}
		});
		button5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				if (String.valueOf((long)(textcolno)).equals("4")) {
					cnt++;
					abs = son.play((int)(ab), 1.0f, 1.0f, 1, (int)(0), 1.0f);
				}
				else {
					cnt--;
					abs = son.play((int)(wrong), 1.0f, 1.0f, 1, (int)(0), 1.0f);
					showMessage("-1");
					vib.vibrate((long)(1000));
				}
				rand = getRandom((int)(1), (int)(12));
				_pick(rand);
				textview3.setText(String.valueOf((long)(cnt)));
			}
		});
		button6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				if (String.valueOf((long)(textcolno)).equals("2")) {
					cnt++;
					abs = son.play((int)(ab), 1.0f, 1.0f, 1, (int)(0), 1.0f);
				}
				else {
					cnt--;
					abs = son.play((int)(wrong), 1.0f, 1.0f, 1, (int)(0), 1.0f);
					showMessage("-1");
					vib.vibrate((long)(1000));
				}
				rand = getRandom((int)(1), (int)(12));
				_pick(rand);
				textview3.setText(String.valueOf((long)(cnt)));
			}
		});
		button7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				if (String.valueOf((long)(textcolno)).equals("5")) {
					cnt++;
					abs = son.play((int)(ab), 1.0f, 1.0f, 1, (int)(0), 1.0f);
				}
				else {
					cnt--;
					abs = son.play((int)(wrong), 1.0f, 1.0f, 1, (int)(0), 1.0f);
					showMessage("-1");
					vib.vibrate((long)(1000));
				}
				rand = getRandom((int)(1), (int)(12));
				_pick(rand);
				textview3.setText(String.valueOf((long)(cnt)));
			}
		});

	}

	private void  initializeLogic() {
		rot = 0;
		tim = new TimerTask() {
					@Override
						public void run() {
							runOnUiThread(new Runnable() {
							@Override
								public void run() {
										imageview1.setRotation((float)(rot));
								rot++;
								}
							});
						}
					};
					_timer.scheduleAtFixedRate(tim, (int)(0), (int)(5));
		cd = 90;
		tim = new TimerTask() {
					@Override
						public void run() {
							runOnUiThread(new Runnable() {
							@Override
								public void run() {
										cd--;
								textview1.setText(String.valueOf((long)(cd)));
								}
							});
						}
					};
					_timer.scheduleAtFixedRate(tim, (int)(0), (int)(1000));
		med = MediaPlayer.create(getApplicationContext(), R.raw.time);
		med.start();
		cnt = 0;
		rand = getRandom((int)(1), (int)(12));
		_pick(rand);
		tim = new TimerTask() {
					@Override
						public void run() {
							runOnUiThread(new Runnable() {
							@Override
								public void run() {
										med.pause();
								x.edit().putString("score", String.valueOf((long)(cnt))).commit();
								intent.setClass(getApplicationContext(), OverActivity.class);
								startActivity(intent);
								}
							});
						}
					};
					_timer.schedule(tim, (int)(90000));
		tim = new TimerTask() {
					@Override
						public void run() {
							runOnUiThread(new Runnable() {
							@Override
								public void run() {
										linear1.setVisibility(View.INVISIBLE);
								tim = new TimerTask() {
											@Override
												public void run() {
													runOnUiThread(new Runnable() {
													@Override
														public void run() {
																						linear1.setVisibility(View.VISIBLE);
														}
													});
												}
											};
											_timer.scheduleAtFixedRate(tim, (int)(125), (int)(250));
								}
							});
						}
					};
					_timer.scheduleAtFixedRate(tim, (int)(75000), (int)(250));
		son = new SoundPool((int)(3), AudioManager.STREAM_MUSIC, 0);
		ab = son.load(getApplicationContext(), R.raw.tru, 1);
		wrong = son.load(getApplicationContext(), R.raw.wroong, 1);
	}


	private void _pick (double _rand) {
		if (String.valueOf((long)(_rand)).equals("1")) {
			textview2.setText("YELLOW");
			textview2.setTextColor(0xFF43A047);
			textcolno = 1;
		}
		if (String.valueOf((long)(_rand)).equals("2")) {
			textview2.setText("BLUE");
			textview2.setTextColor(0xFFD32F2F);
			textcolno = 3;
		}
		if (String.valueOf((long)(_rand)).equals("3")) {
			textview2.setText("ORANGE");
			textview2.setTextColor(0xFF2196F3);
			textcolno = 5;
		}
		if (String.valueOf((long)(_rand)).equals("4")) {
			textview2.setText("BLACK");
			textview2.setTextColor(0xFFFFEB3B);
			textcolno = 2;
		}
		if (String.valueOf((long)(_rand)).equals("5")) {
			textview2.setText("RED");
			textview2.setTextColor(0xFF1E88E5);
			textcolno = 5;
		}
		if (String.valueOf((long)(_rand)).equals("6")) {
			textview2.setText("GREEN");
			textview2.setTextColor(0xFF000000);
			textcolno = 4;
		}
		if (String.valueOf((long)(_rand)).equals("7")) {
			textview2.setText("PURPLE");
			textview2.setTextColor(0xFFE53935);
			textcolno = 3;
		}
		if (String.valueOf((long)(_rand)).equals("8")) {
			textview2.setText("YELLOW");
			textview2.setTextColor(0xFF1976D2);
			textcolno = 5;
		}
		if (String.valueOf((long)(_rand)).equals("9")) {
			textview2.setText("RED");
			textview2.setTextColor(0xFF43A047);
			textcolno = 1;
		}
		if (String.valueOf((long)(_rand)).equals("10")) {
			textview2.setText("ORANGE");
			textview2.setTextColor(0xFF000000);
			textcolno = 4;
		}
		if (String.valueOf((long)(_rand)).equals("11")) {
			textview2.setText("GREEN");
			textview2.setTextColor(0xFFD32F2F);
			textcolno = 3;
		}
		if (String.valueOf((long)(_rand)).equals("12")) {
			textview2.setText("BLACK");
			textview2.setTextColor(0xFFFFEB3B);
			textcolno = 2;
		}
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
