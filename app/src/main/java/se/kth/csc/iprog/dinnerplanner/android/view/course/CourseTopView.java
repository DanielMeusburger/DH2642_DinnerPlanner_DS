package se.kth.csc.iprog.dinnerplanner.android.view.course;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

/**
 * Created by sudarson on 09/02/16.
 */
public class CourseTopView {
    View view;
    private Spinner spinner;
    private DinnerModel model;

    public CourseTopView(View view, DinnerModel model) {
        this.view = view;
        this.model = model;
        setSpinnerValues();
    }

    private void setSpinnerValues() {
        spinner = (Spinner) view.findViewById(R.id.participants_spinner);
        Integer[] items = new Integer[]{1,2,3,4};
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(view.getContext(),
                R.array.participants_spinner, android.R.layout.simple_spinner_item);
        //ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(view.getContext(),android.R.layout.simple_spinner_item, items);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3)
            {
                String num_guests = spinner.getSelectedItem().toString();
                int guests = Integer.parseInt(num_guests);
                model.setNumberOfGuests(guests);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });
    }
}
