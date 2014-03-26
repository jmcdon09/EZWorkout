package cisc.teamnine.eztrain;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PreviewWorkout extends Activity {
	
	Button start_workout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Intent intent = getIntent();
		String workout = intent.getStringExtra(MyWorkouts.WORKOUT_NAME);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_preview_workout);
		// Show the Up button in the action bar.
		setupActionBar();
		
		TextView workout_name = (TextView) findViewById(R.id.preview_workout_name);
		workout_name.setText(workout);
		
		start_workout = (Button) findViewById(R.id.preview_to_start);
		start_workout.setOnClickListener(handler);
	}
	
    View.OnClickListener handler = new View.OnClickListener() {
  	  public void onClick(View v) {
  	      Intent intent = new Intent(PreviewWorkout.this, ActiveWorkout.class);
  	      startActivity(intent);
  	  }
  };
	
	

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_activity_actions, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		case R.id.action_home:
			Intent home = new Intent(this, HomeScreen.class);
			startActivity(home);
			return true;
		}
		
		return super.onOptionsItemSelected(item);
	}

}
