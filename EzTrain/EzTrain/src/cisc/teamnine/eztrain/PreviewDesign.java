package cisc.teamnine.eztrain;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class PreviewDesign extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Bundle info = getIntent().getExtras();
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_preview_design);

    	String workout = info.getString("WORKOUT_NAME");
    	info.getString("MUSCLE_GROUP");
    	
    	ArrayList<String> exercises = info.getStringArrayList("EXERCISES");
    	info.getStringArrayList("SETS");
    	info.getStringArrayList("REPS");
		// Show the Up button in the action bar.
		setupActionBar();
		
		final TextView workout_name = (TextView) findViewById(R.id.preview_workout_name);
		workout_name.setText(workout);
		
		final ListView list_view = (ListView) findViewById(R.id.exercise_list);
		String exercise_list[] = listExercises(exercises);
        list_view.setAdapter(new ArrayAdapter<String>(this, R.layout.list_row, exercise_list));
	}
	
	public String[] listExercises(ArrayList<String> exercises){
		String exercise_list[] = new String[exercises.size()];
		for (int i=0; i < exercises.size(); i ++){
			exercise_list[i]= exercises.get(i);
		}
		return exercise_list;
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
		getMenuInflater().inflate(R.menu.preview_design, menu);
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
