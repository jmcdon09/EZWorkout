package cisc.teamnine.eztrain;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class PreviewDesign extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Bundle info = getIntent().getExtras();
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_preview_design);

    	String workout = info.getString("WORKOUT_NAME");
    	String muscle = info.getString("MUSCLE_GROUP");
    	
    	ArrayList<String> exercises = info.getStringArrayList("EXERCISES");
    	ArrayList<String> sets = info.getStringArrayList("SETS");
    	ArrayList<String> reps = info.getStringArrayList("REPS");
		// Show the Up button in the action bar.
		setupActionBar();
		
		final TextView workout_name = (TextView) findViewById(R.id.preview_workout_name);
		workout_name.setText("Preview of " + workout);
		
		final TextView muscle_group = (TextView) findViewById(R.id.preview_muscle_group);
		muscle_group.setText("Targetting: " + muscle);
		
		
		TableLayout workout_design = (TableLayout) findViewById(R.id.preview_workout_table);
		TextView exercise = (TextView) findViewById(R.id.preview_exercise);
		exercise.setText("Exercises");
		TextView set = (TextView) findViewById(R.id.preview_set);
		set.setText("Sets");
		TextView rep = (TextView) findViewById(R.id.preview_rep);
		rep.setText("Reps");
		
		TableLayout.LayoutParams row_params = new TableLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT, 100);
		
		TableRow.LayoutParams col1_params = new TableRow.LayoutParams(
				LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT, 50);
		
		TableRow.LayoutParams col2_params = new TableRow.LayoutParams(
				LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT, 25);
		// Create the table
		for (int i=0; i < exercises.size(); i++){
			TableRow tr = new TableRow(this);

			
			TextView exercise_name = new TextView(this);
			exercise_name.setText(exercises.get(i));
			exercise_name.setTextAppearance(getBaseContext(), android.R.style.TextAppearance_Medium_Inverse);
			exercise_name.setLayoutParams(col1_params);
			
			TextView set_num = new TextView(this);
			set_num.setText(sets.get(i));
			set_num.setTextAppearance(getBaseContext(), android.R.style.TextAppearance_Medium_Inverse);
			set_num.setLayoutParams(col2_params);

			TextView rep_num = new TextView(this);
			rep_num.setText(reps.get(i));
			rep_num.setTextAppearance(getBaseContext(), android.R.style.TextAppearance_Medium_Inverse);
			rep_num.setLayoutParams(col2_params);
			
			tr.addView(exercise_name);
			tr.addView(set_num);
			tr.addView(rep_num);
			
			workout_design.addView(tr, row_params);
		}
		
		Button save_workout = (Button) findViewById(R.id.save_workout);
		save_workout.setOnClickListener(handler);
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
	
	   View.OnClickListener handler = new View.OnClickListener() {
		  	  public void onClick(View v) {
		  	      switch(v.getId()) {
		  	        case R.id.design_workout_begin:
		  	          // it was the first button
		  	        	Intent workout_save = new Intent(PreviewDesign.this, HomeScreen.class);
		  	        	startActivity(workout_save);
		  	        	//datamanager, read and write to file
		  	          break;
		  	      }
	 
		  	  }
	};

}
