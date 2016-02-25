package se.kth.csc.iprog.dinnerplanner.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.Observable;
import java.util.Observer;

import se.kth.csc.iprog.dinnerplanner.android.view.course.CourseDownView;
import se.kth.csc.iprog.dinnerplanner.android.view.course.CourseTopView;
import se.kth.csc.iprog.dinnerplanner.android.view.course.TotalCostView;
import se.kth.csc.iprog.dinnerplanner.android.view.selectedcourse.PopupSelectedItemView;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

public class CourseSelectionActivity extends Activity implements Observer{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_selection);
        //setSpinnerValues();
        DinnerModel model = ((DinnerPlannerApplication) this.getApplication()).getModel();
        model.addObserver(this);
        CourseTopView topView = new CourseTopView(findViewById(R.id.this_is_course_top_view_id), model);
        new TotalCostView(findViewById(R.id.this_is_total_cost_id), model);
        new CourseDownView(findViewById(R.id.this_is_course_down_view_id), model);
        new CourseSelectionController(topView, model);
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

    public void callSelectedMenuActivity(View view) {
        Intent intent = new Intent(this, SelectedMenuActivity.class);
        startActivity(intent);
    }

    @Override
    public void update(Observable observable, Object o) {
        //Toast.makeText(this, "I am notified" + ((DinnerModel)o).getNumberOfGuests(),Toast.LENGTH_SHORT).show();
        new TotalCostView(findViewById(R.id.this_is_total_cost_id), (DinnerModel) o);
    }

    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 777)
        {
            String message=data.getStringExtra("MESSAGE");
            System.out.println(message +" >>>>>>>>>");
        }
    }
*/
}
