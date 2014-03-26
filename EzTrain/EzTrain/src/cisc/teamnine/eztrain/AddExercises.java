package cisc.teamnine.eztrain;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
//import android.content.Intent;
import android.widget.TextView;

public class AddExercises extends Activity {

	String EXERCISE_NAME;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Bundle info = getIntent().getExtras();
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_exercises);
		
		String workout = info.getString("WORKOUT_NAME");
		String muscle = info.getString("MUSCLE_GROUP");
		
		TextView workout_name = (TextView) findViewById(R.id.workout_name);
		workout_name.setText(" " + workout);
		
		TextView muscle_group = (TextView) findViewById(R.id.muscle_group);
		muscle_group.setText(muscle);
		
		// Show the Up button in the action bar.
		setupActionBar();
	}

	
	
	public void onItemClick(AdapterView<?> arg0, View v, int position,
			long id) {
		Intent preview = new Intent(AddExercises.this, PreviewExercise.class);
		startActivity(preview);
		
	}
	

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_exercises, menu);
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
		}
		return super.onOptionsItemSelected(item);
	}

}
