package se.kth.csc.iprog.dinnerplanner.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import se.kth.csc.iprog.dinnerplanner.android.view.course.CourseSelectionActivity;
import se.kth.csc.iprog.dinnerplanner.android.view.StartView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Default call to load previous state
        super.onCreate(savedInstanceState);

        // Set the view for the main activity screen
        // it must come before any call to findViewById method
        setContentView(R.layout.activity_main);

        // Creating the view class instance
        StartView mainView = new StartView(findViewById(R.id.this_is_start_view_id));
    }

    public void callCourseSelection(View view) {
        Intent intent = new Intent(this, CourseSelectionActivity.class);
        startActivity(intent);
    }
}
