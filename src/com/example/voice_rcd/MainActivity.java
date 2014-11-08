package com.example.voice_rcd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.avos.avoscloud.AVAnalytics;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.LogInCallback;

/* Login activity */
public class MainActivity extends AnnoChatLoginActivity {

	private Button loginButton;
	private Button registerButton;
	private EditText userNameEditText;
	private EditText userPasswordEditText;

	private final String ERROR_MSG_USERNAME_EMPTY = "User name cannot be empty";
	private final String ERROR_MSG_PASSWORD_EMPTY = "Password cannot be empty";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		// Avos cloud analytics & push service set up
		AVAnalytics.trackAppOpened(getIntent());
		AVService.initPushService(this);

		if (getUserId() != null) {
			// Intent mainIntent = new Intent(activity, MainActivity.class);
			// startActivity(mainIntent);
			activity.finish();
		}

		loginButton = (Button) findViewById(R.id.btn_login);
		registerButton = (Button) findViewById(R.id.btn_register);
		// forgetPasswordButton = (Button)
		// findViewById(R.id.button_forget_password);
		userNameEditText = (EditText) findViewById(R.id.et_username_input);
		userPasswordEditText = (EditText) findViewById(R.id.et_password_input);

		loginButton.setOnClickListener(loginListener);
		registerButton.setOnClickListener(registerListener);
		// forgetPasswordButton.setOnClickListener(forgetPasswordListener);

	}

	private OnClickListener loginListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			String username = userNameEditText.getText().toString();
			if (username.isEmpty()) {
				showErrorMessage(ERROR_MSG_USERNAME_EMPTY);
				return;
			}
			String password = userPasswordEditText.getText().toString();
			if (password.isEmpty()) {
				showErrorMessage(ERROR_MSG_PASSWORD_EMPTY);
				return;
			}
			progressDialogShow();
			AVUser.logInInBackground(username, password, logInCallback);
		}
	};

	private OnClickListener registerListener = new OnClickListener() {

		@Override
		public void onClick(View v) {

		}
	};

	private OnClickListener forgetPasswordListener = new OnClickListener() {

		@Override
		public void onClick(View v) {

		}
	};
	
	@SuppressWarnings("unchecked")
	private LogInCallback<AVUser> logInCallback = new LogInCallback(){

		@Override
		public void done(AVUser arg0, AVException arg1) {
			// TODO Auto-generated method stub
			
		}
		
	};

	private void showErrorMessage(String msg) {
		this.showError(msg);
	}
}
