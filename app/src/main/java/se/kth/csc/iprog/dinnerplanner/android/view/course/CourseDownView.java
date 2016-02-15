package se.kth.csc.iprog.dinnerplanner.android.view.course;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import se.kth.csc.iprog.dinnerplanner.android.R;

/**
 * Created by sudarson on 09/02/16.
 */
public class CourseDownView {
    View view;

    public CourseDownView(View view) {
        this.view = view;
        setStarterScroll(R.id.linear_starter);
        setStarterScroll(R.id.linear_maincourse);
        setStarterScroll(R.id.linear_dessert);
    }

    private void setStarterScroll(int linearId){
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

    }
}
