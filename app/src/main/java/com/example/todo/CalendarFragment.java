package com.example.todo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import android.widget.Button;
import android.widget.CalendarView;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarFragment extends Fragment implements View.OnClickListener {

    private CalendarView calendarView;
    private EditText editText;
    private String stringDateSelected;
    private TextView dateTimeDisplay;
    private Calendar calendar;
    private SimpleDateFormat dateFormat;
    private String date;
    private DatabaseReference databaseReference;
    private Button saveEvent;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calendar, container, false);
        calendarView = view.findViewById(R.id.calendarView);
        editText = view.findViewById(R.id.editEvent);
        saveEvent = view.findViewById(R.id.saveEvent);
        dateTimeDisplay = (TextView) view.findViewById(R.id.TextDate);
        calendar = Calendar.getInstance();
        dateFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
        /**
        //Using the time July 10, 1996 at 12:08:56 PM:
        "MM-dd-yyyy HH:mm:ss"             ->> 07-10-1996 12:08:56
        "EEE, MMM d, ''yy"                ->>  Wed, July 10, '96
        "h:mm a"                          ->>  12:08 PM
        "hh 'o''clock' a, zzzz"           ->>  12 o'clock PM, Pacific Daylight Time
        "yyyyy.MMMMM.dd GGG hh:mm aaa"    ->>  01996.July.10 AD 12:08 PM
         **/
        date = dateFormat.format(calendar.getTime());
        dateTimeDisplay.setText(date);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener()
        {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2)
            {
                stringDateSelected = Integer.toString(i) + Integer.toString(i1+1) + Integer.toString(i2);
                calendarClicked();
            }
        });
              databaseReference = FirebaseDatabase.getInstance().getReference("Calendar");
              saveEvent.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                      buttonSaveEvent(view);
                  }
              });
        return view;
    }

            private void calendarClicked()
            {
                databaseReference.child(stringDateSelected).addListenerForSingleValueEvent(new ValueEventListener()
                {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot)
                    {
                        if (snapshot.getValue() != null)
                        {
                            editText.setText(snapshot.getValue().toString());
                        }else
                        {
                            editText.setText("null");
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error)
                    {

                    }
                });
            }



            public void buttonSaveEvent(View view)
            {
                databaseReference.child(stringDateSelected).setValue(editText.getText().toString()).addOnSuccessListener(new OnSuccessListener<Void>() {
                                                                                                                             @Override
                                                                                                                             public void onSuccess(Void unused) {
                                                                                                                                 Toast.makeText(getActivity(), "Successful save", Toast.LENGTH_SHORT).show();
                                                                                                                             }
                                                                                                                         }
                );
            }
    @Override
    public void onClick(View view) {
    }

}