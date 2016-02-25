package se.kth.csc.iprog.dinnerplanner.android;


import android.view.View;
import android.widget.AdapterView;

import java.util.Observable;
import java.util.Observer;

import se.kth.csc.iprog.dinnerplanner.android.view.course.CourseDownView;
import se.kth.csc.iprog.dinnerplanner.android.view.course.CourseTopView;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

/**
 * Created by sudarson on 25/02/16.
 */
public class CourseSelectionController implements AdapterView.OnItemSelectedListener {
    private CourseTopView topView;
    private DinnerModel model;
    private CourseDownView downView;

    public CourseSelectionController(CourseTopView topView, CourseDownView downView, DinnerModel model){
        this.topView = topView;
        this.downView = downView;
        this.model = model;
        topView.spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String num_guests = this.topView.spinner.getSelectedItem().toString();
        int guests = Integer.parseInt(num_guests);
        model.setNumberOfGuests(guests);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
