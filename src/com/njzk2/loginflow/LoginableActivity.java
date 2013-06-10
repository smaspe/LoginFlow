package com.njzk2.loginflow;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.njzk2.loginflow.login.LoginActivity;

public abstract class LoginableActivity extends NavigableActivity {
	private static final int LOGIN = 42;
	public static boolean loggedIn = false;

	public void login(View target) {
		startActivityForResult(new Intent(this, LoginActivity.class), LOGIN);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == LOGIN) {
			if (resultCode == RESULT_OK) {
				loggedIn = true;
			} else {
				loggedIn = false;
			}
			View loginStatus = findViewById(R.id.login_status);
			if (loginStatus != null && loginStatus instanceof TextView) {
				((TextView) loginStatus).setText(loggedIn ? R.string.logged_in : R.string.not_logged_in);
			}
			View loginBtn = findViewById(R.id.login_button);
			if (loginBtn != null) {
				loginBtn.setVisibility(loggedIn ? View.GONE : View.VISIBLE);
			}
		}
	}
}
