package jb.ws.firstdbapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    EditText eno, ename, esal;
    Button btninsert,btnshowall;
    TextView txtshowall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eno = (EditText) findViewById(R.id.txtno);
        ename = (EditText) findViewById(R.id.txtname);

        esal = (EditText) findViewById(R.id.txtsal);
        txtshowall=(TextView)findViewById(R.id.txtshowall);
        btninsert=(Button)findViewById(R.id.btninsert);
        btnshowall=(Button)findViewById(R.id.btnshowall);
    }

    public void onSave(View v) {

        String no, name, sal;

        no=eno.getText().toString();
        name=ename.getText().toString();
        sal=esal.getText().toString();
        EmployeeInsert obj=new EmployeeInsert(no,name,sal);
        obj.execute();


    }

    class EmployeeInsert extends AsyncTask<String, String, String> {
        String no, name, sal;

        public EmployeeInsert(String n, String na, String s) {
            no = n;
            name = na;
            sal = s;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... arg0) {
            // TODO Auto-generated method stub
            try {

                String link = "http://10.22.0.140/ems/save.php";
                link = link + "?t1=" + no + "&t2=" + name + "&t3=" + sal;

                URL url = new URL(link);
                HttpClient client = new DefaultHttpClient();
                HttpGet request = new HttpGet();
                request.setURI(new URI(link));
                HttpResponse response = client.execute(request);
                BufferedReader in = new BufferedReader(new
                        InputStreamReader(response.getEntity().getContent()));

                StringBuffer sb = new StringBuffer("");
                String line = "";

                while ((line = in.readLine()) != null) {
                    sb.append(line);
                    break;
                }
                in.close();

                return sb.toString();

            } catch (Exception e) {
                //Toast.makeText(getApplicationContext(), "error" + e.getMessage(), Toast.LENGTH_SHORT).show();
                return new String("Exception: " + e.getMessage());
            }
        }

        protected void onPostExecute(String result) {
            try {
                Toast.makeText(getApplicationContext(), "Saved" ,  Toast.LENGTH_SHORT).show();



            } catch (Exception ee) {
                Toast.makeText(getApplicationContext(), "error2" + ee.getMessage(),  Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void onShowAll(View v)
    {
        EmployeeShow obj=new EmployeeShow();
        obj.execute();
    }
    class EmployeeShow  extends AsyncTask<String, String, String>
    {

        public EmployeeShow() {
        }
        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
        }
        @Override
        protected String doInBackground(String... arg0) {
            // TODO Auto-generated method stub
            try{
                Log.d("B4 ","Saving");
                String link = "http://10.22.0.140/ems/showall.php";

                URL url = new URL(link);
                HttpClient client = new DefaultHttpClient();
                HttpGet request = new HttpGet();
                request.setURI(new URI(link));
                HttpResponse response = client.execute(request);
                BufferedReader in = new BufferedReader(new
                        InputStreamReader(response.getEntity().getContent()));

                StringBuffer sb = new StringBuffer("");
                String line="";

                while ((line = in.readLine()) != null) {
                    sb.append(line);
                    break;
                }
                in.close();
                Log.d("AFTER","Saving");
                return sb.toString();

            } catch(Exception e){
                Toast.makeText(getApplicationContext(),"error" + e.getMessage(),Toast.LENGTH_LONG).show();
                return new String("Exception: " + e.getMessage());
            }
        }

        protected void onPostExecute(String result)
        {
            try
            {
                JSONArray jsonArray;
                jsonArray = new JSONArray(result);
                String data = "";
                for(int i=0; i < jsonArray.length(); i++)
                {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    int id = Integer.parseInt(jsonObject.optString("no").toString());
                    String name = jsonObject.optString("name").toString();
                    float salary = Float.parseFloat(jsonObject.optString("sa").toString());

                    data += "\n id= "+ id +" \n Name= "+ name +" \n Salary= "+ salary +" \n ";
                }
                txtshowall.setText(data);
                Toast.makeText(getApplicationContext(),data,Toast.LENGTH_LONG).show();


            }
            catch(Exception ee)
            {
                Toast.makeText(getApplicationContext(),"error2" + ee.getMessage(),Toast.LENGTH_LONG).show();
            }
        }
    }
}

