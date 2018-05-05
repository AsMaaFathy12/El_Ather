package com.example.asmaa.el_ather;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by AsMaa on 3/12/2018.
 */

public class CallUs extends Fragment {
    ImageView face, whats, gmail;
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.call_us,container,false);
        face = (ImageView) view.findViewById(R.id.facebook);
        whats = (ImageView) view.findViewById(R.id.whats);
        gmail = (ImageView) view.findViewById(R.id.gmail);
face.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/profile.php?id=1478663585679350"));
        startActivity(intent);

    }
});
whats.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent sendIntent = new Intent("android.intent.action.MAIN");
        sendIntent.setComponent(new ComponentName("com.whatsapp","com.whatsapp.Conversation"));
        sendIntent.putExtra("jid", PhoneNumberUtils.stripSeparators("01091121486")+"@s.whatsapp.net");
        startActivity(sendIntent);
    }
});
gmail.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        sendEmail();
    }
});


        return view;
    }

    protected void sendEmail() {
        Log.i("Send email", "");

        String[] TO = {"it.alatheertech@gmail.com","alatheertech@gmail.com","hr2.alatheertech@gmail.com"};
        String[] CC = {"alatheertech@gmail.com"};


        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");


        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
           // finish();
            Log.i("Finish sending email..", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getContext(),
                    "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
    }

