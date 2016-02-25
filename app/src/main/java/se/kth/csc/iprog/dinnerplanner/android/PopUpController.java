package se.kth.csc.iprog.dinnerplanner.android;

import android.app.Activity;
import android.view.View;

import se.kth.csc.iprog.dinnerplanner.android.view.selectedcourse.PopupSelectedItemView;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;

/**
 * Created by sudarson on 25/02/16.
 */
public class PopUpController implements View.OnClickListener{

    private PopupSelectedItemView view;
    private DinnerModel model;
    private Dish selectedDish;

    public PopUpController(PopupSelectedItemView view, DinnerModel model, Dish selectedDish){
        this.view = view;
        this.model = model;
        this.selectedDish = selectedDish;
        view.button_choose.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        model.addDishToMenu(selectedDish);
        this.view.activity.finish();
    }
}
