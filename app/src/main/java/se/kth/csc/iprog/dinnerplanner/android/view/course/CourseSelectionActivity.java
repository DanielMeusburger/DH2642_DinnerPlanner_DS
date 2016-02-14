package se.kth.csc.iprog.dinnerplanner.android.view.course;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import se.kth.csc.iprog.dinnerplanner.android.R;

public class CourseSelectionActivity extends Activity implements OnItemSelectedListener {

    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_selection);
        setSpinnerValues();
        setStarterScroll();
    }

    private void setStarterScroll(){
        int[] drawables = {R.drawable.icecream,R.drawable.meatballs,R.drawable.toast,R.drawable.bakedbrie};

        LinearLayout layout = (LinearLayout) findViewById(R.id.linear_starter);
        for (int i = 0; i < drawables.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setId(i);
            imageView.setPadding(5, 5, 5, 5);
            imageView.setImageBitmap(BitmapFactory.decodeResource(
                    getResources(), drawables[i]));

            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            layout.addView(imageView);
        }
    }

    private void setSpinnerValues() {
        spinner = (Spinner) findViewById(R.id.participants_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.participants_spinner, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setSelection(1);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_course_selection, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        System.out.print("Inside OnItemSelected :"+ i);
        spinner.setSelection(i);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
