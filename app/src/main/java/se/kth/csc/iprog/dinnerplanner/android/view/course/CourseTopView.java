package se.kth.csc.iprog.dinnerplanner.android.view.course;

import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import se.kth.csc.iprog.dinnerplanner.android.R;

/**
 * Created by sudarson on 09/02/16.
 */
public class CourseTopView implements AdapterView.OnItemSelectedListener {
    View view;
    private Spinner spinner;

    public CourseTopView(View view) {
        this.view = view;
        setSpinnerValues();
    }

    private void setSpinnerValues() {
        spinner = (Spinner) view.findViewById(R.id.participants_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(view.getContext(),
                R.array.participants_spinner, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        //spinner.setSelection(1);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        spinner.setSelection(i);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
