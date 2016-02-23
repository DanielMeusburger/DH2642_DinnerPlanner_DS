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
public class SelectedCourseView {
    View view;
    DinnerModel model;

    public SelectedCourseView(View view, DinnerModel model) {
        this.view = view;
        this.model = model;
        setSelectedItemsInView();
        SetIngredients();
    }
    private void setSelectedItemsInView() {
        Set<Dish> selectedDishes = model.getFullMenu();
        if(selectedDishes != null){
            for(Dish dish : selectedDishes){
                if(dish.getType() == Dish.STARTER)
                {
                    setImageAndText(R.id.starter_selected_item_img, R.id.starter_selected_item_text, dish);
                }else if(dish.getType() == Dish.MAIN)
                {
                    setImageAndText(R.id.menu_selected_item_img, R.id.menu_selected_item_text, dish);
                }else if(dish.getType() == Dish.DESERT)
                {
                    setImageAndText(R.id.dessert_selected_item_img, R.id.dessert_selected_item_text, dish);
                }
            }
        }
    }

    private void setImageAndText(int selected_item_img, int selected_item_text, Dish dish) {
        TextView txtView = (TextView) view.findViewById(selected_item_text);
        txtView.setText(dish.getName());

        ImageView img = (ImageView) view.findViewById(selected_item_img);
        String imageName = dish.getImage();
        int index = imageName.indexOf(".");
        imageName = imageName.substring(0,index);
        img.setImageResource(view.getResources().getIdentifier(imageName, "drawable", view.getContext().getPackageName()));
    }

    private void SetIngredients(){
        TextView numberOfGuest = (TextView) view.findViewById(R.id.id_numberofpersons);
        numberOfGuest.setText(model.getNumberOfGuests() + " pers");
    }
}
