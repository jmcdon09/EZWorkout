package cisc.teamnine.eztrain;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MyWorkouts extends Activity {

	public final static String WORKOUT_NAME = "ciscteamnine.ezworkout.WORKOUT";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_workouts);
		// Show the Up button in the action bar.
		setupActionBar();
		
		final ListView list_view = (ListView) findViewById(R.id.list_my_workouts);
		String workouts[] =  getResources().getStringArray(R.array.my_workouts);
	

        list_view.setAdapter(new ArrayAdapter<String>(this, R.layout.list_row, workouts));
        list_view.setOnItemClickListener(new OnItemClickListener(){
        	
			@Override
			public void onItemClick(AdapterView<?> arg0, View v, int position,
					long id) {
				Intent preview = new Intent(MyWorkouts.this, PreviewWorkout.class);
				String workout = list_view.getItemAtPosition(position).toString();
				preview.putExtra(WORKOUT_NAME, workout);
				startActivity(preview);
				
			}
        	
        });
		
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
		getMenuInflater().inflate(R.menu.main_activity_actions, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
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
