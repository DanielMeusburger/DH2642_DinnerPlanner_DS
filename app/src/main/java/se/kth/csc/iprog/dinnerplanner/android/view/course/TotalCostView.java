package se.kth.csc.iprog.dinnerplanner.android.view.course;

import android.view.View;
import android.widget.TextView;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

public class TotalCostView {

	View view;
	DinnerModel model;

	public TotalCostView(View view, DinnerModel model) {

		// store in the class the reference to the Android View
		this.view = view;
		this.model = model;
		TextView example = (TextView) view.findViewById(R.id.id_totalCost);
		example.setText("Total Cost : "+(int)model.getTotalMenuPrice()+" kr");

		// Setup the rest of the view layout
	}

}
