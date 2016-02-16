package se.kth.csc.iprog.dinnerplanner.android.view.course;

import android.view.View;
import android.widget.TextView;

import se.kth.csc.iprog.dinnerplanner.android.R;

public class TotalCostView {

	View view;

	public TotalCostView(View view) {

		// store in the class the reference to the Android View
		this.view = view;

		TextView example = (TextView) view.findViewById(R.id.id_totalCost);
		example.setText("Total Cost : 1000 Kr");

		// Setup the rest of the view layout
	}

}
