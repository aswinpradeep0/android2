package example.sk.applicationtwelve;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etid,etname,etsalary;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etid=(EditText)findViewById(R.id.etid);
        etname=(EditText)findViewById(R.id.etname);
        etsalary=(EditText)findViewById(R.id.etsalary);
        db = openOrCreateDatabase("EmployeeDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS employee(eid VARCHAR,ename VARCHAR,esal double);");
    }
    public void onAddBtnClicked(View v)
    {
        if(etid.getText().toString().equals("")||etname.getText().toString().equals("")||etsalary.getText().toString().equals(""))
        {
            Toast.makeText(getApplicationContext(),"Fill All Fields",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Cursor c = db.rawQuery("SELECT * FROM employee WHERE eid='" + etid.getText().toString() + "'", null);
            if (c.moveToFirst()) {
                Toast.makeText(getApplicationContext(),"Already Exists",Toast.LENGTH_SHORT).show();
            }
            else {
                db.execSQL("INSERT INTO employee VALUES('" + etid.getText().toString() + "','" + etname.getText().toString() + "'," + Double.parseDouble(etsalary.getText().toString()) + ");");
                Toast.makeText(getApplicationContext(), "Record Added", Toast.LENGTH_SHORT).show();
                etid.setText("");
                etname.setText("");
                etsalary.setText("");
            }
        }
    }
    public void onReadBtnClicked(View v)
    {
        if(etid.getText().toString().equals(""))
        {
            Toast.makeText(getApplicationContext(),"Enter Employee ID",Toast.LENGTH_SHORT).show();
        }
        else {
            Cursor c=db.rawQuery("SELECT * FROM employee WHERE eid='"+etid.getText().toString()+"'", null);
            if(c.moveToFirst())
            {

                etname.setText(c.getString(1));
                etsalary.setText(c.getString(2));
            }
            else
            {

                Toast.makeText(getApplicationContext(),"No Record Exist",Toast.LENGTH_SHORT).show();
            }
        }


    }
    public void onUpdateBtnClicked(View v)
    {
        if(etid.getText().toString().equals("")||etname.getText().toString().equals("")||etsalary.getText().toString().equals(""))
        {
            Toast.makeText(getApplicationContext(),"Fill Fields",Toast.LENGTH_SHORT).show();
        }
        else {
            Cursor c = db.rawQuery("SELECT * FROM employee WHERE eid='" + etid.getText() + "'", null);
                if (c.moveToFirst()) {
                    db.execSQL("UPDATE employee SET ename='" + etname.getText() + "',esal=" + Double.parseDouble(etsalary.getText().toString()) +
                            " WHERE eid='" + etid.getText() + "'");
                    Toast.makeText(getApplicationContext(),"Record Updated",Toast.LENGTH_SHORT).show();
                    etid.setText("");
                    etsalary.setText("");
                    etname.setText("");
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"No Record Exist",Toast.LENGTH_SHORT).show();
                }

        }
    }





    public void onDeleteBtnClicked(View v)
    {
        if(etid.getText().toString().trim().length()==0)
        {
            Toast.makeText(getApplicationContext(),"Enter Employee ID",Toast.LENGTH_SHORT).show();
        }
        else {
            Cursor c = db.rawQuery("SELECT * FROM employee WHERE eid='" + etid.getText() + "'", null);
            if (c.moveToFirst()) {
                db.execSQL("DELETE FROM employee WHERE eid='" + etid.getText() + "'");
                Toast.makeText(getApplicationContext(),"Record Deleted",Toast.LENGTH_SHORT).show();
                etid.setText("");
                etsalary.setText("");
                etname.setText("");
            }
            else
            {
                Toast.makeText(getApplicationContext(),"Record Not Exist",Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void onViewAllClicked(View v)
    {
        Cursor c=db.rawQuery("SELECT * FROM employee", null);
        if(c.getCount()==0)
        {
            Toast.makeText(getApplicationContext(),"No records inserted yet",Toast.LENGTH_LONG).show();
            return;
        }
        StringBuffer buffer=new StringBuffer();
        while(c.moveToNext())
        {
            buffer.append("eid: "+c.getString(0)+"\n");
            buffer.append("ename: "+c.getString(1)+"\n");
            buffer.append("esal: "+c.getString(2)+"\n\n");
        }
        showMessage("Student Details", buffer.toString());
    }
    public void showMessage(String title,String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }


}
