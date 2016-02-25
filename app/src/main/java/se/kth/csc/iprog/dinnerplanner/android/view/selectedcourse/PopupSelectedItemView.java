package se.kth.csc.iprog.dinnerplanner.android.view.selectedcourse;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;

public class PopupSelectedItemView {

	View view;
	public Button button_choose;
	public Activity activity;

	public PopupSelectedItemView(View view, DinnerModel model, Dish dish) {
		// store in the class the reference to the Android View
		this.view = view;
		button_choose = (Button) view.findViewById(R.id.id_button_choose);
		activity = (Activity) view.getContext();
		setView(model, dish);
	}

    public void setView(DinnerModel model, Dish dish) {
		if (dish != null) {
			TextView selectedDishName = (TextView) view.findViewById(R.id.id_selected_dish_name);
			selectedDishName.setText(dish.getName());

			ImageView selectedImgView = (ImageView) view.findViewById(R.id.id_selected_dish_img);
			String imageName = dish.getImage();
			int index = imageName.indexOf(".");
			imageName = imageName.substring(0, index);
			selectedImgView.setImageResource(view.getResources().getIdentifier(imageName, "drawable", view.getContext().getPackageName()));

			TextView costPerSelectedItem = (TextView) view.findViewById(R.id.id_cost_per_person_selected_item);
			double pricePerPerson = model.getIndividualItemCost(dish);
			costPerSelectedItem.setText("(" + (int)pricePerPerson + "kr / Person)");

			TextView totalCostPerSelectedItem = (TextView) view.findViewById(R.id.id_total_cost_selected_item);
			totalCostPerSelectedItem.setText("Cost: " + (int) (pricePerPerson * model.getNumberOfGuests()) + "kr");

		}
	}



}
