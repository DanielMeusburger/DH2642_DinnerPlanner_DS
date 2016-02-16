package se.kth.csc.iprog.dinnerplanner.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import se.kth.csc.iprog.dinnerplanner.android.view.selectedcourse.SelectedCourseDownView;
import se.kth.csc.iprog.dinnerplanner.android.view.course.TotalCostView;
import se.kth.csc.iprog.dinnerplanner.android.view.selectedcourse.SelectedCourseTopView;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

public class SelectedMenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_menu);
        DinnerModel model = ((DinnerPlannerApplication) this.getApplication()).getModel();
        new SelectedCourseTopView((findViewById(R.id.this_is_selected_course_top_view_id)));
        new SelectedCourseDownView((findViewById(R.id.this_is_selected_course_down_view_id)));
        new TotalCostView(findViewById(R.id.this_is_total_cost_id), model);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_selected_menu, menu);
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
