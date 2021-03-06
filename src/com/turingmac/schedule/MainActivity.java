package com.turingmac.schedule;

import com.turingmac.schedule.ScheduleView.OnItemClassClickListener;
import com.turingmac.schedule.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

	static ScheduleView scheduleView;
	static UserInfo currentUser = new UserInfo("", "", "");

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		scheduleView = (ScheduleView) this.findViewById(R.id.scheduleView);
		scheduleView
				.setOnItemClassClickListener(new OnItemClassClickListener() {

					@Override
					public void onClick(ClassInfo classInfo) {
						Toast.makeText(
								MainActivity.this,
								"课程详情：" + classInfo.getClassName() + " / "
										+ classInfo.getClassRoom() + " / "
										+ classInfo.getTeacher(),
								Toast.LENGTH_SHORT).show();

					}
				});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent intent;
		switch (item.getItemId()) {
		case R.id.action_settings:
			break;
		case R.id.action_register:
			intent = new Intent(this, RegisterActivity.class);
			startActivity(intent);
			break;
		case R.id.action_login:
			intent = new Intent(this, LoginActivity.class);
			startActivity(intent);
			break;
		case R.id.action_addclass:
			intent = new Intent(this, AddClassActivity.class);
			startActivity(intent);
			break;
		}
		return true;
	}

}
