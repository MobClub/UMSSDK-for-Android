package com.mob.ums.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.mob.ums.OperationCallback;
import com.mob.ums.User;
import com.mob.ums.gui.UMSGUI;

public class MainActivity extends Activity implements OnClickListener {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void onClick(View v) {
		switch(v.getId()) {
			case R.string.show_login: {
				UMSGUI.showLogin(new OperationCallback<User>() {
					public void onSuccess(User myInfo) {
						Toast.makeText(MainActivity.this, R.string.login_success, Toast.LENGTH_SHORT).show();
					}

					public void onFailed(Throwable t) {
						Toast.makeText(MainActivity.this, R.string.login_failed, Toast.LENGTH_SHORT).show();
					}
				});
			} break;
			case R.string.show_profile: {
				UMSGUI.showProfilePage();
				finish();
			} break;
			case R.string.show_recommendation: {
				UMSGUI.showRecommendationPage();
				finish();
			} break;
		}
	}
}