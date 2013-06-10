package com.njzk2.loginflow;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

public abstract class NavigableActivity extends Activity {

	public void navigate(View targetView) {
		Class<? extends Activity> targetClass = null;
		switch (targetView.getId()) {
		case R.id.to_second:
			targetClass = SecondActivity.class;
			break;
		case R.id.to_first:
			targetClass = FirstActivity.class;
			break;
		case R.id.to_restricted:
			targetClass = RestrictedActivity.class;
			break;

		default:
			break;
		}
		if (targetClass != null) {
			Intent intent = new Intent(this, targetClass);
			// Reorder to front avoid launching a new activity
			intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
			startActivity(intent);
		}
	}
}
