package se.kth.csc.iprog.dinnerplanner.android.view.course;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
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
            for(Dish dish : items){
                LinearLayout childView = (LinearLayout) inflater.inflate(R.layout.horziontal_course_menu, null);
                ImageView menuImage = (ImageView) childView.findViewById(R.id.menu_image);
                String imageName = dish.getImage();
                int index = imageName.indexOf(".");
                imageName = imageName.substring(0,index);
                menuImage.setImageResource(childView.getResources().getIdentifier(imageName, "drawable", childView.getContext().getPackageName()));
                final String finalImageName = imageName;
                menuImage.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        //menuImage.setBackgroundResource(R.drawable.rect_border_magenta);
                        Activity courseSelectionActivity = (Activity) view.getContext();
                        Intent intent = new Intent(courseSelectionActivity, PopupSelectedItemActivity.class);
                        courseSelectionActivity.startActivity(intent);
                        System.out.println("-----PRESSED-----" + finalImageName);
                    }
                });
                TextView menu_text = (TextView) childView.findViewById(R.id.id_menu_text);
                menu_text.setText(dish.getName());
                innerLayout.addView(childView);
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