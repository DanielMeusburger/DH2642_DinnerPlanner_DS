package se.kth.csc.iprog.dinnerplanner.android.view.course;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Set;

import se.kth.csc.iprog.dinnerplanner.android.R;
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

        //int[] drawables = {R.drawable.icecream, R.drawable.meatballs, R.drawable.toast, R.drawable.bakedbrie};

        if(items != null && !items.isEmpty()){
            for(Dish dish : items){
                LinearLayout childView = (LinearLayout) inflater.inflate(R.layout.horziontal_course_menu, null);
                ImageView menu_image = (ImageView) childView.findViewById(R.id.menu_image);
                String image_name = dish.getImage();
                int index = image_name.indexOf(".");
                image_name = image_name.substring(0,index);
                System.out.println(">>>>>>>>>>>>>>>>>"+image_name);
                menu_image.setImageResource(childView.getResources().getIdentifier(image_name, "drawable", childView.getContext().getPackageName()));

                TextView menu_text = (TextView) childView.findViewById(R.id.id_menu_text);
                menu_text.setText(dish.getName());
                innerLayout.addView(childView);
            }
        }
        /*for (int i = 0; i < drawables.length; i++) {
            LinearLayout childView = (LinearLayout) inflater.inflate(R.layout.horziontal_course_menu, null);
            ImageView menu_image = (ImageView) childView.findViewById(R.id.menu_image);
            menu_image.setImageResource(drawables[i]);

            TextView menu_text = (TextView) childView.findViewById(R.id.id_menu_text);
            menu_text.setText("LaIce");
            innerLayout.addView(childView);
        }*/
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