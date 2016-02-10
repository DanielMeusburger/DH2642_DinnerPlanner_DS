package se.kth.csc.iprog.dinnerplanner.android.view;

import android.content.Intent;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import se.kth.csc.iprog.dinnerplanner.android.MainActivity;
import se.kth.csc.iprog.dinnerplanner.android.R;

/**
 * Created by sudarson on 09/02/16.
 */
public class StartView{
    View view;

    private final String htmlText = "<body><br /> <br/> <br /><p>Welcome to Dinner Planner!</p>" +
            "<p>Here you will be able to easily plan your dinner.</p>" +
            "<p>On the next page start by selecting number of participants.Then select your courses.</p>" +
            "<p>Watch Magic Happen!</p></body>";


    public StartView(View view) {
        this.view = view;
        TextView textArea = (TextView) view.findViewById(R.id.start_text);
        textArea.setText(Html.fromHtml(htmlText));
    }

    public void callCourseSelection(View view) {
        //Intent intent = new Intent(se.kth.csc.iprog.dinnerplanner.android.this, CourseSelectionActivity.class);
        //startActivity(intent);
    }

}
