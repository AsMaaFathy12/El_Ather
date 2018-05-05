package com.example.asmaa.el_ather.newIdea;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.asmaa.el_ather.Controller;
import com.example.asmaa.el_ather.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by AsMaa on 3/3/2018.
 */

public class ideaFrragment extends Fragment {
    EditText name,email,phone,idea;
    Button add;
    AlertDialog.Builder mdialog;
    ProgressDialog progressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.add,container,false);
        name=(EditText)view.findViewById(R.id.edit_Name);
        email=(EditText)view.findViewById(R.id.edit_email);
        phone=(EditText)view.findViewById(R.id.edit_phone);
        idea=(EditText)view.findViewById(R.id.edit_idea);
        add=(Button) view.findViewById(R.id.btn_Send);

        final String client_name = name.getText().toString();
        final String client_phone = phone.getText().toString();
        final String client_mail = email.getText().toString();
        final String ititle = idea.getText().toString();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (client_name.equals("") || client_phone.equals("") || ititle.equals("") || client_mail.equals("")) {
                    Toast.makeText(getActivity(), "Please make sure to fill all the fields", Toast.LENGTH_SHORT).show();
                } else {
                    Add_call(client_name, client_phone, client_mail, ititle);
                }
            }
        });

               return view;

        }
                    private void Add_call(final String c_name, final String c_phone,final String c_mail, final String idea_title)
                    {

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
                                                Toast.makeText(getContext(), "موافق", Toast.LENGTH_SHORT).show();
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
                                Toast.makeText(getContext(),
                                        error.getMessage(), Toast.LENGTH_LONG).show();
                                Log.e("MMM",error.getMessage().toString());

                                mdialog.setMessage(error.getMessage() );
                                mdialog.setNegativeButton("موافق", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Toast.makeText(getContext(), "موافق", Toast.LENGTH_SHORT).show();
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
                        Controller.getInstance().addToRequestQueue(strReq,"re");
                    }
                }







//    private boolean Check_Network()
//    {
//        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
//        boolean wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnectedOrConnecting();
//        boolean mobile_data = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).isConnectedOrConnecting();
//
//        if (!wifi&&!mobile_data)
//        {
//            return false;
//        }
//        else
//        {
//            return true;
//        }



