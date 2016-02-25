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
        final ImageView starterImg = (ImageView) view.findViewById(R.id.starter_selected_item_img);
        final ImageView mainImg = (ImageView) view.findViewById(R.id.menu_selected_item_img);
        final ImageView desertImg = (ImageView) view.findViewById(R.id.dessert_selected_item_img);
        addIngredientsToView();
        imgIngredients.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setColorForBorder("#800000", "#00800000", "#00800000", "#00800000");
                addIngredientsToView();
            }
        });

        starterImg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setColorForBorder("#00800000","#800000","#00800000","#00800000");
                Set<Dish> dishes = model.getFullMenu();
                for (Dish dish : dishes) {
                    if (dish.getType() == Dish.STARTER) {
                        addDescriptionToView(dish.getDescription());
                        break;
                    }
                }
            }
        });

        mainImg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setColorForBorder("#00800000","#00800000","#800000","#00800000");
                Set<Dish> dishes = model.getFullMenu();
                for (Dish dish : dishes) {
                    if (dish.getType() == Dish.MAIN) {
                        addDescriptionToView(dish.getDescription());
                        break;
                    }
                }
            }
        });

        desertImg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setColorForBorder("#00800000", "#00800000", "#00800000", "#800000");
                Set<Dish> dishes = model.getFullMenu();
                for (Dish dish : dishes) {
                    if (dish.getType() == Dish.DESERT) {
                        addDescriptionToView(dish.getDescription());
                        break;
                    }
                }
            }
        });
    }

    public void addIngredientsToView(){
        LayoutInflater inflater = (LayoutInflater) view.getContext().getSystemService(view.getContext().LAYOUT_INFLATER_SERVICE);
        LinearLayout outerView = (LinearLayout) view.findViewById(R.id.id_linear_outer_ingredients);
        Set<Ingredient> ingredients = model.getAllIngredients();
        outerView.removeAllViews();
        for(Ingredient ingredient : ingredients){
            LinearLayout childView = (LinearLayout) inflater.inflate(R.layout.horziontal_ingredients, null);
            TextView name = (TextView) childView.findViewById(R.id.id_names_ingredients);
            name.setText(ingredient.getName());
            TextView value = (TextView) childView.findViewById(R.id.id_quantity_ingredients);
            value.setText(ingredient.getQuantity()+" "+ingredient.getUnit());
            outerView.addView(childView);
        }
    }

    public void addDescriptionToView(String description){
        LayoutInflater inflater = (LayoutInflater) view.getContext().getSystemService(view.getContext().LAYOUT_INFLATER_SERVICE);
        LinearLayout outerView = (LinearLayout) view.findViewById(R.id.id_linear_outer_ingredients);
        LinearLayout childView = (LinearLayout) inflater.inflate(R.layout.horziontal_description, null);
        TextView desc = (TextView) childView.findViewById(R.id.id_course_description);
        desc.setText(description);
        outerView.removeAllViews();
        outerView.addView(childView);
    }

    public void setColorForBorder(String ingredients, String stater, String main, String desert){
        ((LinearLayout) view.findViewById(R.id.border_ingredients)).setBackgroundColor(Color.parseColor(ingredients));
        ((LinearLayout) view.findViewById(R.id.id_border_starter)).setBackgroundColor(Color.parseColor(stater));
        ((LinearLayout) view.findViewById(R.id.border_main)).setBackgroundColor(Color.parseColor(main));
        ((LinearLayout) view.findViewById(R.id.border_desert)).setBackgroundColor(Color.parseColor(desert));
    }
}
