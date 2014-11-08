package com.example.voice_rcd;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import com.avos.avoscloud.AVAnalytics;
import com.avos.avoscloud.AVUser;

public class AnnoChatLoginActivity extends Activity {

	public AnnoChatLoginActivity activity;
	private String userId;
	private ProgressDialog progressDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		activity = this;
		userId = null;
		AVUser currentUser = AVUser.getCurrentUser();
		if (currentUser != null) {
			this.userId = getUserId(currentUser);
		}

	}

	public String getUserId() {
		return this.userId;
	}

	public String getUserId(AVUser user) {
		return user.getObjectId();
	}

	public String getUserName(AVUser user) {
		return user.getUsername();
	}

	protected void showError(String errorMessage) {
		showError(errorMessage, activity);
	}

	public void showError(String errorMessage, Activity activity) {
		new AlertDialog.Builder(activity)
				.setTitle(
						activity.getResources().getString(
								R.string.error_dialog_title))
				.setMessage(errorMessage)
				.setNegativeButton(android.R.string.ok,
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int which) {
								dialog.dismiss();
							}
						}).show();
	}

	public void progressDialogDismiss() {
		if (progressDialog != null)
			progressDialog.dismiss();
	}

	public void progressDialogShow() {

		progressDialog = new ProgressDialog(this);
		progressDialog.setContentView(R.layout.progressdialog_login_wait);
		progressDialog.setIndeterminate(true);
		progressDialog.setCancelable(false);
		// progressDialog.setMessage(activity.getResources().getText(R.string.dialog_login_text_wait));
		progressDialog.show();
	}

	protected void onPause() {
		super.onPause();
		AVAnalytics.onPause(this);
	}

	protected void onResume() {
		super.onResume();
		AVAnalytics.onResume(this);
	}

}
