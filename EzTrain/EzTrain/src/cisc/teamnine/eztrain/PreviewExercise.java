package cisc.teamnine.eztrain;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class PreviewExercise extends Activity {

	String exercise; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_preview_exercise);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.preview_exercise, menu);
		return true;
	}

}
