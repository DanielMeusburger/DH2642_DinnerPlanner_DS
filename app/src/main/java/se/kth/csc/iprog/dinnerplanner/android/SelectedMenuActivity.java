package se.kth.csc.iprog.dinnerplanner.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import se.kth.csc.iprog.dinnerplanner.android.view.course.TotalCostView;
import se.kth.csc.iprog.dinnerplanner.android.view.selectedcourse.SelectedCourseView;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

public class SelectedMenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_menu);
        DinnerModel model = ((DinnerPlannerApplication) this.getApplication()).getModel();
        new SelectedCourseView((findViewById(R.id.this_is_selected_course_top_view_id)), model);
        //new SelectedCourseDownView((findViewById(R.id.this_is_selected_course_down_view_id)), model);
        new TotalCostView(findViewById(R.id.this_is_total_cost_id), model);

        findViewById(R.id.ll_leftarrow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
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
