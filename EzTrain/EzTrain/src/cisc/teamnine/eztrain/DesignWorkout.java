package cisc.teamnine.eztrain;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class DesignWorkout extends Activity {


	Button START_DESIGN;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_design_workout);
		// Show the Up button in the action bar.
		setupActionBar();
		
		Spinner muscle_groups = (Spinner) findViewById(R.id.muscle_group_spinner);
		String muscles[] =  getResources().getStringArray(R.array.muscle_groups);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, muscles);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		muscle_groups.setAdapter(adapter);
		
		START_DESIGN = (Button) findViewById(R.id.design_workout_begin);
		START_DESIGN.setOnClickListener(handler);
 	}


	
	
	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

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

    View.OnClickListener handler = new View.OnClickListener() {
  	  public void onClick(View v) {
  	      switch(v.getId()) {
  	        case R.id.design_workout_begin:
  	          // it was the first button
  	        	Intent workout_select = new Intent(DesignWorkout.this, AddExercises.class);
  	        	Bundle info = new Bundle();
  	        	EditText name = (EditText) findViewById(R.id.design_name_enter);
				String workout =  name.getText().toString();
				info.putString("WORKOUT_NAME", workout);
				
				Spinner muscle_spinner = (Spinner) findViewById(R.id.muscle_group_spinner);
				String muscle = muscle_spinner.getSelectedItem().toString();
				info.putString("MUSCLE_GROUP", muscle);
				
				workout_select.putExtras(info);
  	        	startActivity(workout_select);
  	          break;
  	      }
  	  }
  	  
  };
}
