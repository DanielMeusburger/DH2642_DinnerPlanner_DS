package se.kth.csc.iprog.dinnerplanner.android.view.selectedcourse;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Set;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;

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
        numberOfGuest.setText(model.getNumberOfGuests() + " pers");
    }
}
