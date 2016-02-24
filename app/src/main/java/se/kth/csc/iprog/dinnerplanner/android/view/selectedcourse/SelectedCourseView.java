package se.kth.csc.iprog.dinnerplanner.android.view.selectedcourse;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Set;

import se.kth.csc.iprog.dinnerplanner.android.PopupSelectedItemActivity;
import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import se.kth.csc.iprog.dinnerplanner.model.Ingredient;

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

        final ImageView imgIngredients = (ImageView) view.findViewById(R.id.img_ingredients);
        final ImageView starterIngredients = (ImageView) view.findViewById(R.id.starter_selected_item_img);
        addIngredientsToView();
        imgIngredients.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ((LinearLayout)view.findViewById(R.id.border_ingredients)).setBackgroundColor(Color.parseColor("#800000"));
                ((LinearLayout)view.findViewById(R.id.id_border_starter)).setBackgroundColor(Color.parseColor("#00800000"));
                addIngredientsToView();
            }
        });

        starterIngredients.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ((LinearLayout)view.findViewById(R.id.border_ingredients)).setBackgroundColor(Color.parseColor("#00800000"));
                ((LinearLayout)view.findViewById(R.id.id_border_starter)).setBackgroundColor(Color.parseColor("#800000"));
                addDescriptionToView();
            }
        });
    }

    public void addIngredientsToView(){
        LayoutInflater inflater = (LayoutInflater) view.getContext().getSystemService(view.getContext().LAYOUT_INFLATER_SERVICE);
        LinearLayout outerView = (LinearLayout) view.findViewById(R.id.id_linear_outer_ingredients);
        Set<Ingredient> ingredients = model.getAllIngredients1();
        outerView.removeAllViews();
        for(Ingredient ingredient : ingredients){
            LinearLayout childView = (LinearLayout) inflater.inflate(R.layout.horziontal_ingredients, null);
            TextView name = (TextView) childView.findViewById(R.id.id_listofingredients);
            name.setText(ingredient.getName());
            TextView value = (TextView) childView.findViewById(R.id.id_price_ingredients);
            value.setText((int) (ingredient.getQuantity() * model.getNumberOfGuests())+" "+ingredient.getUnit());
            outerView.addView(childView);
        }
    }

    public void addDescriptionToView(){
        LayoutInflater inflater = (LayoutInflater) view.getContext().getSystemService(view.getContext().LAYOUT_INFLATER_SERVICE);
        LinearLayout outerView = (LinearLayout) view.findViewById(R.id.id_linear_outer_ingredients);
        Dish dish = model.getDescription();
        LinearLayout childView = (LinearLayout) inflater.inflate(R.layout.horziontal_description, null);
        TextView description = (TextView) childView.findViewById(R.id.id_course_description);
        description.setText(dish.getDescription());
        outerView.removeAllViews();
        outerView.addView(childView);
    }
}
