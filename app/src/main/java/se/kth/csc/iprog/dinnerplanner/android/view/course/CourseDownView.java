package se.kth.csc.iprog.dinnerplanner.android.view.course;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Set;

import se.kth.csc.iprog.dinnerplanner.android.PopupSelectedItemActivity;
import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.android.SelectedMenuActivity;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;

/**
 * Created by sudarson on 09/02/16.
 */
public class CourseDownView {
    View view;
    DinnerModel model;

    public CourseDownView(View view, DinnerModel model) {
        this.view = view;
        this.model = model;

        setHorizontalCourseMenuScroll(R.id.id_linear_outer_starter, model.getDishesOfType(Dish.STARTER));
        setHorizontalCourseMenuScroll(R.id.id_linear_outer_main_course, model.getDishesOfType(Dish.MAIN));
        setHorizontalCourseMenuScroll(R.id.id_linear_outer_dessert, model.getDishesOfType(Dish.DESERT));
    }

    /**
     * Inflates horziontal_course_menu.xml layout and add images and text dynamically in the inner linear layout
     * Finally it is added to the outer linear layout in horizontal scroll view
     * @param linearId
     */
    private void setHorizontalCourseMenuScroll(int linearId, Set<Dish> items) {
        LinearLayout innerLayout = (LinearLayout) view.findViewById(linearId);
        LayoutInflater inflater = (LayoutInflater) view.getContext().getSystemService(view.getContext().LAYOUT_INFLATER_SERVICE);

        if(items != null && !items.isEmpty()){
            for(final Dish dish : items){
                final LinearLayout childView = (LinearLayout) inflater.inflate(R.layout.horziontal_course_menu, null);
                final ImageView menuImage = (ImageView) childView.findViewById(R.id.menu_image);
                String imageName = dish.getImage();
                int index = imageName.indexOf(".");
                imageName = imageName.substring(0,index);
                menuImage.setImageResource(childView.getResources().getIdentifier(imageName, "drawable", childView.getContext().getPackageName()));
                menuImage.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        //menuImage.setBackgroundResource(R.drawable.rect_border_magenta);
                        /*if(model.getFullMenu().contains(dish)){
                            System.out.println(">>><<<<><><><><><><><>"+dish.getName());
                            menuImage.setBackgroundColor(Color.parseColor("#800000"));
                            model.removeDishFromMenu(dish);
                        }else{*/
                            //childView.setBackgroundColor(Color.parseColor("#00800000"));
                            Activity courseSelectionActivity = (Activity) view.getContext();
                            Intent intent = new Intent(courseSelectionActivity, PopupSelectedItemActivity.class);
                            intent.putExtra(Dish.KEY, dish);
                            courseSelectionActivity.startActivity(intent);
                        //}
                    }
                });
                TextView menu_text = (TextView) childView.findViewById(R.id.id_menu_text);
                menu_text.setText(dish.getName());
                innerLayout.addView(childView);
            }
        }
    }

    public void setBorderForDish(Dish dish){
        LinearLayout linearLayout = null;
        if(dish.getType() == Dish.STARTER){
            linearLayout = (LinearLayout) view.findViewById(R.id.id_linear_outer_starter);
        }else if(dish.getType() == Dish.MAIN){
            linearLayout = (LinearLayout) view.findViewById(R.id.id_linear_outer_main_course);
        }else if(dish.getType() == Dish.DESERT){
            linearLayout = (LinearLayout) view.findViewById(R.id.id_linear_outer_dessert);
        }
        if(linearLayout != null) {
            for (int i = 0; i < linearLayout.getChildCount(); ++i) {
                View nextChild = linearLayout.getChildAt(i);
                TextView menuText = (TextView) nextChild.findViewById(R.id.id_menu_text);
                if (menuText.getText().equals(dish.getName())) {
                    ((ImageView) nextChild.findViewById(R.id.menu_image)).setBackgroundColor(Color.parseColor("#800000"));
                } else {
                    ((ImageView) nextChild.findViewById(R.id.menu_image)).setBackgroundColor(Color.parseColor("#00800000"));
                }
            }
        }
    }
    /*private void setStarterScroll(int linearId){
        int[] drawables = {R.drawable.icecream,R.drawable.meatballs,R.drawable.toast,R.drawable.bakedbrie};
        LinearLayout layout = (LinearLayout) view.findViewById(linearId);
        for (int i = 0; i < drawables.length; i++) {
            ImageView imageView = new ImageView(view.getContext());
            imageView.setId(i);
            imageView.setPadding(5, 5, 5, 5);
            imageView.setImageBitmap(BitmapFactory.decodeResource(
                    view.getResources(), drawables[i]));

            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            layout.addView(imageView);
        }

    }*/
}