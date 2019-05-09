package jb.ws.lab12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonCreateEmployee=(Button) findViewById(R.id.buttonCreateEmployee);
        buttonCreateEmployee.setOnClickListener(new OnClickListenerCreateEmployee());

        countRecords();
        readRecords();
    }

    public void countRecords()
    {
        int recordCount = new TableControllerEmployee(this).count();

        TextView textViewRecordCount = (TextView) findViewById(R.id.textViewRecordCount);
        textViewRecordCount.setText(recordCount + " records found.");


    }


    public void readRecords()
    {
        LinearLayout linearLayoutRecords=(LinearLayout) findViewById(R.id.linearLayoutRecords);
        linearLayoutRecords.removeAllViews();


        List<ObjectEmployee> employees=new TableControllerEmployee(this).read();

        if (employees.size()>0)
        {

            for (ObjectEmployee obj : employees) {

                int id = obj.id;
                String employeeFirstname = obj.firstname;
                String employeeEmail = obj.email;

                String textViewContents = employeeFirstname + " - " + employeeEmail;

                TextView textViewEmployeeItem= new TextView(this);
                textViewEmployeeItem.setPadding(0, 10, 0, 10);
                textViewEmployeeItem.setText(textViewContents);
                textViewEmployeeItem.setTag(Integer.toString(id));

                textViewEmployeeItem.setOnLongClickListener(new OnLongClickListenerEmployeeRecord());



                linearLayoutRecords.addView(textViewEmployeeItem);
            }


        }
        else
        {

            TextView locationItem = new TextView(this);
            locationItem.setPadding(8, 8, 8, 8);
            locationItem.setText("No records yet.");

            linearLayoutRecords.addView(locationItem);

        }

    }



}
