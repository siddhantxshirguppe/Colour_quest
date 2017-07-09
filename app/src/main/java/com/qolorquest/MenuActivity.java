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



public class MenuActivity extends Activity {

	private AdView mAdView;

	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private LinearLayout linear5;
	private LinearLayout linear6;
	private ImageView imageview1;
	private Button button5;
	private ImageView imageview2;
	private Button button1;
	private Button button2;
	private Button button4;
	private Button button3;

	private double u = 0;
	private double u1 = 0;
	private double v = 0;
	private double v1 = 0;
	private double w = 0;
	private double x = 0;
	private String q = "";


	private Timer _timer = new Timer();
	private MediaPlayer med;
	private Intent intent = new Intent();
	private SoundPool son;
	private SharedPreferences y;
	private TimerTask timer;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		MobileAds.initialize(this, "ca-app-pub-6219959047239432~3581854505");

		mAdView = (AdView) findViewById(R.id.adView);
		AdRequest adRequest = new AdRequest.Builder().build();
		mAdView.loadAd(adRequest);
		initialize();
		initializeLogic();
	}

	public void onBackPressed() {
		super.onBackPressed();
		finishAffinity();
		System.exit(0);
	}

	private void  initialize() {
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		button5 = (Button) findViewById(R.id.button5);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		button1 = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);
		button4 = (Button) findViewById(R.id.button4);
		button3 = (Button) findViewById(R.id.button3);




		y = getSharedPreferences("file", Activity.MODE_PRIVATE);


		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 

			}
		});
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				v1 = son.play((int)(v), 1.0f, 1.0f, 1, (int)(0), 1.0f);
				med.pause();
				intent.setClass(getApplicationContext(), CountdownActivity.class);
				startActivity(intent);
			}
		});
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				u1 = son.play((int)(u), 1.0f, 1.0f, 1, (int)(0), 1.0f);
				intent.setClass(getApplicationContext(), HelpActivity.class);
				startActivity(intent);
			}
		});
		button3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				intent.setClass(getApplicationContext(), AboutActivity.class);
				startActivity(intent);
			}
		});
		button4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				showMessage("THE HIGH SCORE IS ".concat(y.getString("high", "")));
			}
		});
		button5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				showMessage("To confirm, press back button!");
			}
		});
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				intent.setData(Uri.parse("https://m.facebook.com/campaign/landing.php?campaign_id=587377734724779&placement&creative=163278884834&keyword=f+b%27&extra_1=1a01bc50-25b1-4e63-a9bf-37cafd174d7c&partner_id=googlesem&extra_2=network%3Dg%26matchtype%3De%26target%3D%26source%3Dmobile%26adposition%3D1t1%26aceid%3D&gclid=CjwKEAjwse7JBRCJ576SqoD7lCkSJABF-bKuDK1VVZIxAUMwzcGsdCbGqcI09s6wYA305g_xxTFNBRoCzn_w_wcB"));
				intent.setAction(Intent.ACTION_VIEW);
				startActivity(intent);
				med.pause();
			}
		});

	}

	private void  initializeLogic() {
		med = MediaPlayer.create(getApplicationContext(), R.raw.freee);
		med.start();
		son = new SoundPool((int)(3), AudioManager.STREAM_MUSIC, 0);
		u = son.load(getApplicationContext(), R.raw.unitselected, 1);
		v = son.load(getApplicationContext(), R.raw.countdown, 1);
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
