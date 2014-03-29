package cisc.teamnine.eztrain;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class AddExercises extends Activity {

	ArrayList<String> exercise_names = new ArrayList<String>();
	ArrayList<String> sets = new ArrayList<String>();
	ArrayList<String> reps = new ArrayList<String>();
	String workout_name;
	String muscle_group;
	Button add;
	Button preview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Bundle get_info = getIntent().getExtras();
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_exercises);
		
		String workout = get_info.getString("WORKOUT_NAME");
		String muscle = get_info.getString("MUSCLE_GROUP");
		workout_name = workout;
		muscle_group = muscle;
		
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
			String exercise = list_view.getItemAtPosition(position).toString();
			final TextView exercise_name = (TextView) findViewById(R.id.add_exercise_name);
			exercise_name.setText(exercise);
		}
    });    
		add = (Button) findViewById(R.id.add_exercise);
		add.setOnClickListener(handler);
		
		preview = (Button) findViewById(R.id.preview_workout);
		preview.setOnClickListener(handler);
	}
	
	public String[] listExercises(String muscle){
		String exercises[];
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
    	      	case R.id.add_exercise:
    	      		
    	      		//ArrayList<String> exercise_list = new ArrayList<String>();
    	      		//ArrayList<String> sets = new ArrayList<String>();
    	      		//ArrayList<String> reps = new ArrayList<String>();
    				final TextView exercise_name = (TextView) findViewById(R.id.add_exercise_name);
    	      		String exercise = exercise_name.getText().toString();
    	      		exercise_names.add(exercise);
    	      		
    	      		final EditText set_num = (EditText) findViewById(R.id.add_exercise_set_input);
    	      		String set = set_num.getText().toString();
    	      		sets.add(set);
    	      		
    	      		final EditText rep_num = (EditText) findViewById(R.id.add_exercise_rep_input);
    	      		String rep = rep_num.getText().toString();
    	      		reps.add(rep);
    	      		
    	      		resetFields();
    	      	break;
    	      		
    	      	
    	      	case R.id.preview_workout:
    	          // it was the first button
    	        	Intent workout_select = new Intent(AddExercises.this, PreviewDesign.class);
    	        	Bundle info = new Bundle();
    	        	
    	        	if(exercise_names.size() < 1){
    	        		break;
    	        	}
    	        	info.putString("WORKOUT_NAME", workout_name);
    	        	info.putString("MUSCLE_GROUP", muscle_group);
    	        	
    	        	info.putStringArrayList("EXERCISES", exercise_names);
    	        	info.putStringArrayList("SETS", sets);
    	        	info.putStringArrayList("REPS", reps);
    	        	
    	        	workout_select.putExtras(info);
    	        	startActivity(workout_select);
    	          break;
    	          
    	      }
    	  }
    	  
    };
    
    private void resetFields(){
  		TextView exercise_name = (TextView) findViewById(R.id.add_exercise_name);
  		exercise_name.setText("");
  		
  		EditText set_num = (EditText) findViewById(R.id.add_exercise_set_input);
  		set_num.setText("", TextView.BufferType.EDITABLE);

  		EditText rep_num = (EditText) findViewById(R.id.add_exercise_rep_input);
  		rep_num.setText("", TextView.BufferType.EDITABLE);
    }
    
}
