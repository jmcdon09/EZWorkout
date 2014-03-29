package cisc.teamnine.eztrain;

import android.app.Activity;

import android.content.Intent;
//import android.content.res.Configuration;
import android.os.Bundle;
//import android.support.v4.app.ActionBarDrawerToggle;
//import android.support.v4.widget.DrawerLayout;
//import android.view.Menu;
//import android.view.MenuItem;
import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
import android.widget.Button;

public class HomeScreen extends Activity {
	
	Button start;
	Button progress;
	Button design;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        
        start = (Button) findViewById(R.id.start_workout);
        progress = (Button) findViewById(R.id.my_progress);
        design = (Button) findViewById(R.id.design_workout);
        start.setOnClickListener(handler);
        progress.setOnClickListener(handler);
        design.setOnClickListener(handler);

    }
    
    View.OnClickListener handler = new View.OnClickListener() {
    	  public void onClick(View v) {
    	      switch(v.getId()) {
    	        case R.id.start_workout:
    	           	Intent workout_select = new Intent(HomeScreen.this, MyWorkouts.class);
    	        	startActivity(workout_select);
    	          break;
    	        case R.id.my_progress:
    	        	Intent progress = new Intent(HomeScreen.this, MyProgress.class);
    	        	startActivity(progress);
    	          break;
    	        case R.id.design_workout:
    	        	Intent design_workout = new Intent(HomeScreen.this, DesignWorkout.class);
    	        	startActivity(design_workout);
    	          break;
    	      }
    	  }
    };
    
    

    
}
