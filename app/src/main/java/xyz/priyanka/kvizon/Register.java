package xyz.priyanka.kvizon;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Register extends AppCompatActivity {
    String name,email,cpass,pass,mobile,json;
    EditText tvname,tvemail,tvpass,tvmobile,tvcpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        tvname=(EditText)findViewById(R.id.name);
        tvemail=(EditText)findViewById(R.id.email);
        tvpass=(EditText)findViewById(R.id.pass);
        tvmobile=(EditText)findViewById(R.id.mobile);
        tvcpass=(EditText)findViewById(R.id.conpass);
        Button btn_submit=(Button)findViewById(R.id.submit);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name=tvname.getText().toString();
                email=tvemail.getText().toString();
               pass=tvpass.getText().toString();
                cpass=tvcpass.getText().toString();
                mobile=tvmobile.getText().toString();
              if(cpass.equals(pass)){
                if(name.length()!=0&&email.length()!=0&&mobile.length()!=0)
                {
                    new userRegister().execute();
                }
                else
                    Snackbar.make(view,"Fill in all the details",Snackbar.LENGTH_LONG).setAction("",null).show();
            }
            else{
                Snackbar.make(view,"passwords do not match",Snackbar.LENGTH_LONG).setAction("",null).show();

            }
        }
    });
    }
    private class userRegister extends AsyncTask<Void,Void,Void>
    {
        ProgressDialog progressDialog;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(Register.this);
            progressDialog.setMessage("Loading please wait....");
            progressDialog.setTitle("Workshops");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }
        @Override
        protected Void doInBackground(Void... params) {
            try {
                HttpPost post = new HttpPost("http://smallbang.hol.es/quiz/register.php");
                List<NameValuePair> params1 = new ArrayList<NameValuePair>();
                params1.add(new BasicNameValuePair("email", email.toLowerCase()));
                params1.add(new BasicNameValuePair("name", name));
                params1.add(new BasicNameValuePair("pass",pass));
                params1.add(new BasicNameValuePair("mobile",mobile));
                post.setHeader("Accept","application/json");
                HttpClient httpclient = new DefaultHttpClient();
                post.setEntity(new UrlEncodedFormEntity(params1));
                HttpResponse response = httpclient.execute(post);

                json = EntityUtils.toString(response.getEntity());
                Log.e("json", json);

            }catch(Exception e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result ) {
            super.onPostExecute(result);

            try{
                progressDialog.dismiss();
                JSONObject jsonObject=new JSONObject(json);
                String s=jsonObject.getString("success");
                if(s.equals("1")) Snackbar.make(getCurrentFocus(),"success",Snackbar.LENGTH_LONG).setAction("okay", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(Register.this,LoginActivity.class);
                        startActivity(intent);

                    }
                }).show();
                else Snackbar.make(getCurrentFocus(),"Failure, try agian",Snackbar.LENGTH_LONG).show();

            }
            catch (Exception e){}


        }
    }}
