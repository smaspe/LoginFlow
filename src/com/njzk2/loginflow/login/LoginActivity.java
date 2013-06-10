package com.njzk2.loginflow.login;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.njzk2.loginflow.R;

public class LoginActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
	}

	public void login(View target) {
		// 30% chances to be logged in
		if (new Random().nextInt(100) < 30) {
			setResult(RESULT_OK);
			finish();
		} else {
			Toast.makeText(this, "Login failed, please try again", Toast.LENGTH_SHORT).show();
		}
	}
}
