package com.njzk2.loginflow;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class RestrictedActivity extends LoginableActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (!loggedIn) {
			login(null);
		} else {
			startup();
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (loggedIn) {
			startup();
		} else {
			Toast.makeText(this, "Login canceled", Toast.LENGTH_SHORT).show();
			finish();
		}
	}

	private void startup() {
		setContentView(R.layout.activity_restricted);
	}
}
