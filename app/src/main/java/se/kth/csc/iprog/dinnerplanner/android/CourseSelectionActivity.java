package se.kth.csc.iprog.dinnerplanner.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Spinner;

import se.kth.csc.iprog.dinnerplanner.android.view.course.CourseDownView;
import se.kth.csc.iprog.dinnerplanner.android.view.course.CourseTopView;

public class CourseSelectionActivity extends Activity{

    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_selection_main);
        //setSpinnerValues();
        new CourseTopView(findViewById(R.id.this_is_course_top_view_id));
        new CourseDownView(findViewById(R.id.this_is_course_down_view_id));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_course_selection, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
