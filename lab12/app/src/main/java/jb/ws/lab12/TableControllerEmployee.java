package jb.ws.lab12;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by geomathe on 11/20/2017.
 */

public class TableControllerEmployee extends DatabaseHandler {


    public TableControllerEmployee(Context context) {
        super(context);
    }


    public boolean create(ObjectEmployee objectEmployee) {

        ContentValues contentValues = new ContentValues();

        contentValues.put("firstname", objectEmployee.firstname);
        contentValues.put("email", objectEmployee.email);

        SQLiteDatabase db = this.getWritableDatabase();

        boolean createSuccessfull = db.insert("employees", null, contentValues) > 0;

        db.close();

        return createSuccessfull;


    }


    public int count() {

        SQLiteDatabase db = this.getWritableDatabase();

        String sql = "SELECT * FROM employees";
        int recordCount = db.rawQuery(sql, null).getCount();
        db.close();

        return recordCount;

    }


    public List<ObjectEmployee> read() {

        List<ObjectEmployee> recordsList = new ArrayList<ObjectEmployee>();

        String sql = "SELECT * FROM employees ORDER BY id";

        SQLiteDatabase db=this.getWritableDatabase();

        Cursor cursor=db.rawQuery(sql,null);


        if (cursor.moveToFirst())
        {

            do {
                {
                    int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex("id")));
                    String employeeFirstname = cursor.getString(cursor.getColumnIndex("firstname"));
                    String employeeEmail = cursor.getString(cursor.getColumnIndex("email"));

                    ObjectEmployee objectEmployee = new ObjectEmployee();
                    objectEmployee.id = id;
                    objectEmployee.firstname = employeeFirstname;
                    objectEmployee.email = employeeEmail;

                    recordsList.add(objectEmployee);
                }
            }while (cursor.moveToNext());

        }

        cursor.close();
        db.close();

        return recordsList;
    }


    public ObjectEmployee readSingleRecord(int employeeId) {

        ObjectEmployee objectEmployee = null;

        String sql = "SELECT * FROM employees WHERE id = " + employeeId;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {

            int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex("id")));
            String firstname = cursor.getString(cursor.getColumnIndex("firstname"));
            String email = cursor.getString(cursor.getColumnIndex("email"));

            objectEmployee = new ObjectEmployee();
            objectEmployee.id = id;
            objectEmployee.firstname = firstname;
            objectEmployee.email = email;

        }

        cursor.close();
        db.close();

        return objectEmployee;

    }



    public boolean update(ObjectEmployee objectEmployee) {

        ContentValues values = new ContentValues();

        values.put("firstname", objectEmployee.firstname);
        values.put("email", objectEmployee.email);

        String where = "id = ?";

        String[] whereArgs = { Integer.toString(objectEmployee.id) };

        SQLiteDatabase db = this.getWritableDatabase();

        boolean updateSuccessful=false;
        updateSuccessful= db.update("employees", values, where, whereArgs) > 0;
        db.close();

        return updateSuccessful;

    }



    public boolean delete(int id) {
        boolean deleteSuccessful = false;

        SQLiteDatabase db = this.getWritableDatabase();
        deleteSuccessful = db.delete("employees", "id ='" + id + "'", null) > 0;
        db.close();

        return deleteSuccessful;

    }






}
