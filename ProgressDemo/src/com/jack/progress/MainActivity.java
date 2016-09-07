package com.jack.progress;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;

public class MainActivity extends FragmentActivity {
	private RoundProgressBar mRoundProgressBar;
	private int progress = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		mRoundProgressBar = (RoundProgressBar) findViewById(R.id.roundProgressBar);
		startProgressBar();

	}

	public void startProgressBar() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (progress <= 99) {
					progress += 1;

					mRoundProgressBar.setProgress(progress);
					System.out.println("aaaaaaaa" + progress);
					// mRoundProgressBar.setProgress(progress, (float) 7.5);

					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
}
