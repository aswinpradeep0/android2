package jb.ws.lab12;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class OnLongClickListenerEmployeeRecord implements View.OnLongClickListener {

    Context context;
    String id;

    @Override
    public boolean onLongClick(View view) {

        context = view.getContext();
        id = view.getTag().toString();


        final CharSequence[] items = { "Edit", "Delete" };

        new AlertDialog.Builder(context).setTitle("Employee Record")
                .setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {



                        if (item == 0) {
                            editRecord(Integer.parseInt(id));
                        }
                        else if (item == 1) {

                            boolean deleteSuccessful = new TableControllerEmployee(context).delete(Integer.parseInt(id));

                            if (deleteSuccessful){
                                Toast.makeText(context, "Employee record was deleted.", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(context, "Unable to delete employee record.", Toast.LENGTH_SHORT).show();
                            }

                            ((MainActivity) context).countRecords();
                            ((MainActivity) context).readRecords();

                        }

                        dialog.dismiss();

                    }
                }).show();



        return false;
    }


    public void editRecord(final int employeeId) {


        final TableControllerEmployee tableControllerEmployee = new TableControllerEmployee(context);
        ObjectEmployee objectEmployee = tableControllerEmployee.readSingleRecord(employeeId);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View formElementsView = inflater.inflate(R.layout.employee_input_form, null, false);

        final EditText editTextEmployeeFirstname = (EditText) formElementsView.findViewById(R.id.editTextEmployeeFirstname);
        final EditText editTextEmployeeEmail = (EditText) formElementsView.findViewById(R.id.editTextEmployeeEmail);


        editTextEmployeeFirstname.setText(objectEmployee.firstname);
        editTextEmployeeEmail.setText(objectEmployee.email);







        new AlertDialog.Builder(context)
                .setView(formElementsView)
                .setTitle("Edit Record")
                .setPositiveButton("Save Changes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {



                                ObjectEmployee objectEmployee = new ObjectEmployee();
                                objectEmployee.id = employeeId;
                                objectEmployee.firstname = editTextEmployeeFirstname.getText().toString();
                                objectEmployee.email = editTextEmployeeEmail.getText().toString();


                                boolean updateSuccessful = tableControllerEmployee.update(objectEmployee);

                                if(updateSuccessful){
                                    Toast.makeText(context, "Employee record was updated.", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(context, "Unable to update employee record.", Toast.LENGTH_SHORT).show();
                                }

                                ((MainActivity) context).countRecords();
                                ((MainActivity) context).readRecords();

                                dialog.cancel();
                            }

                        }).show();





    }




}
