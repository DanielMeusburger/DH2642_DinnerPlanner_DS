package se.kth.csc.iprog.dinnerplanner.android.view.selectedcourse;

import android.view.View;
import android.widget.TextView;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

/**
 * Created by sudarson on 09/02/16.
 */
public class SelectedCourseDownView {
    View view;
    DinnerModel model;

    public SelectedCourseDownView(View view, DinnerModel model) {
        this.view = view;
        this.model = model;
        TextView numberOfGuest = (TextView) view.findViewById(R.id.id_numberofpersons);
        numberOfGuest.setText(model.getNumberOfGuests()+" pers");
    }
}
