package se.kth.csc.iprog.dinnerplanner.android;


import android.view.View;
import android.widget.AdapterView;

import se.kth.csc.iprog.dinnerplanner.android.view.course.CourseTopView;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

/**
 * Created by sudarson on 25/02/16.
 */
public class CourseSelectionController implements AdapterView.OnItemSelectedListener {
    private CourseTopView view;
    private DinnerModel model;

    public CourseSelectionController(CourseTopView view, DinnerModel model){
        this.view = view;
        this.model = model;
        view.spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String num_guests = this.view.spinner.getSelectedItem().toString();
        int guests = Integer.parseInt(num_guests);
        model.setNumberOfGuests(guests);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
