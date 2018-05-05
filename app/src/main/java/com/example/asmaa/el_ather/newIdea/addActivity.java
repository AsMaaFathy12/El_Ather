package com.example.asmaa.el_ather.newIdea;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.asmaa.el_ather.Controller;
import com.example.asmaa.el_ather.NetworkController;
import com.example.asmaa.el_ather.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class addActivity extends AppCompatActivity {
    EditText name,email,phone,idea;
    Button add;
    AlertDialog.Builder mdialog;
    ProgressDialog progressDialog;
    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        name=(EditText)findViewById(R.id.edit_Name);
        email=(EditText)findViewById(R.id.edit_email);
        phone=(EditText)findViewById(R.id.edit_phone);
        idea=(EditText)findViewById(R.id.edit_idea);
        add=(Button)findViewById(R.id.btn_Send);







        mdialog       = new AlertDialog.Builder(this);
        mdialog.setCancelable(false);
        mdialog.setNegativeButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        progressDialog=new ProgressDialog(this);
        progressDialog.setCancelable(false);
add.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String client_name          = name.getText().toString();
        String client_phone         =phone.getText().toString();
        String client_mail        = email.getText().toString();
        String ititle      = idea.getText().toString();

        if(TextUtils.isEmpty(client_name))
        {
            mdialog.setMessage("تاكد من ادخال الاسم");
            mdialog.show();
        }
        else if (TextUtils.isEmpty(client_phone))
        {
            mdialog.setMessage("تاكد من ادخال رقم المحمول");
            mdialog.show();
        }

        else if (TextUtils.isEmpty(client_mail))
        {
            mdialog.setMessage("تاكد من ادخال رقم الايميل");
            mdialog.show();
        }
        else if (TextUtils.isEmpty(ititle))
        {
            mdialog.setMessage("تاكد من ادخال hguk,hk ");
            mdialog.show();
        }

        else
        {
            progressDialog.setMessage("sending "+ name.getText().toString()+" data to server");
            progressDialog.show();
            Add_call(client_name,client_phone,client_mail,ititle);
        }
        mdialog.show();
    }
});

    }


    private void Add_call(final String c_name, final String c_phone,final String c_mail, final String idea_title)
    {
        queue=  NetworkController.getInstance(this).getRequestQueue();

        StringRequest strReq = new StringRequest(Request.Method.POST,
                "https://alatheertech.com/api/idea", new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    String msg = jsonResponse.get("message").toString();
                    if (msg.equals("1"))
                    {
                        progressDialog.dismiss();
                        mdialog.setMessage("تم ارسال الطلب بنجاح");
                        mdialog.setNegativeButton("موافق", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        });
                        mdialog.show();

                    }
                    else
                    {
                        progressDialog.dismiss();
                        mdialog.setMessage("خطا اثناء ارسال البيانات ");
                        mdialog.setNegativeButton("موافق", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(addActivity.this, "موافق", Toast.LENGTH_SHORT).show();
                            }
                        });
                        mdialog.show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    progressDialog.dismiss();
                }
                Log.e("response",response.toString());

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
//                Log.e("MMM",error.getMessage().toString());

                mdialog.setMessage(error.getMessage() );
                mdialog.setNegativeButton("موافق", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(addActivity.this, "موافق", Toast.LENGTH_SHORT).show();
                    }
                });
                mdialog.show();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting params to register url
                Map<String, String> params = new HashMap<String, String>();
                params.put("client_name",c_name);
                params.put("client_phone",c_phone);
                params.put("client_mail",c_mail);
                params.put("idea_title",idea_title);

                return params;
            }

        };
        // Adding request to request queue
    //    Controller.getInstance().addToRequestQueue(strReq,"re");
        queue.add(strReq);

    }
}






