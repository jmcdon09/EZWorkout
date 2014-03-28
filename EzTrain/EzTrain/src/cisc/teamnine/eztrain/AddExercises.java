package cisc.teamnine.eztrain;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class AddExercises extends Activity {

	ArrayList<String> exercise_names;
	ArrayList<String> sets;
	ArrayList<String> reps;
	String workout_name;
	String muscle_group;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Bundle get_info = getIntent().getExtras();
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_exercises);
		
		String workout = get_info.getString("WORKOUT_NAME");
		String muscle = get_info.getString("MUSCLE_GROUP");
		workout_name = workout;
		muscle_group = muscle;
		
		exercise_names = get_info.getStringArrayList("EXERCISES");
	    sets = get_info.getStringArrayList("REPS");
	    reps = get_info.getStringArrayList("SETS");
	    
		String exercise_name = get_info.getString("EXERCISE_NAME");
		String set_num = get_info.getString("SET_NUM");
		String rep_num = get_info.getString("REP_NUM");
		
		if (!(exercise_name.equalsIgnoreCase("")))
			updateWorkout(exercise_name, set_num, rep_num);
		
		final TextView workout_design = (TextView) findViewById(R.id.workout_name);
		workout_design.setText(" " + workout);
		
		final TextView muscle_design = (TextView) findViewById(R.id.muscle_group);
		muscle_design.setText(muscle);
		
		final ListView list_view = (ListView) findViewById(R.id.exercise_list);
		String exercises[] = listExercises(muscle);
        list_view.setAdapter(new ArrayAdapter<String>(this, R.layout.list_row, exercises));
		
        // Show the Up button in the action bar.
		setupActionBar();

		list_view.setOnItemClickListener(new OnItemClickListener(){
		public void onItemClick(AdapterView<?> arg0, View v, int position,
				long id) {
			Intent preview = new Intent(AddExercises.this, PreviewExercise.class);
			Bundle send_info = new Bundle();
			String exercise = list_view.getItemAtPosition(position).toString();
			send_info.putString("EXERCISE_NAME", exercise);
			send_info.putString("WORKOUT_NAME", workout_name);
			send_info.putStringArrayList("EXERCISES", exercise_names);
			send_info.putStringArrayList("SETS", reps);
			send_info.putStringArrayList("REPS", sets);
			
			preview.putExtras(send_info);
			startActivity(preview);
		}
    });    
	}
	
	public String[] listExercises(String muscle){
		String exercises[];
		final TextView test = (TextView) findViewById(R.id.spinner_result);
		test.setText(muscle);
		if (muscle.equalsIgnoreCase("Chest")){
			exercises =  getResources().getStringArray(R.array.chest);			
		}
		else if(muscle.equalsIgnoreCase("Abdominals")){
			exercises =  getResources().getStringArray(R.array.abdominals);			
		}
		else if(muscle.equalsIgnoreCase("Arms")){
			exercises =  getResources().getStringArray(R.array.arms);			
		}
		else if(muscle.equalsIgnoreCase("Back")){
			exercises =  getResources().getStringArray(R.array.back);			
		}
		else if(muscle.equalsIgnoreCase("Legs")){
			exercises =  getResources().getStringArray(R.array.legs);			
		}
		else{
			exercises =  getResources().getStringArray(R.array.shoudlers);			
		}
		return exercises;
	}
	
	private void updateWorkout(String exercise, String set, String rep){
		exercise_names.add(exercise);
		sets.add(set);
		reps.add(rep);
	}
	
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

}
