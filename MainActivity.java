package com.example.atakanisik;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS =0 ;
    ImageView telefon;
    ImageView mesaj;
    ImageView mail;
    String telNo;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        telefon = (ImageView) findViewById(R.id.imageView1);
        mesaj = (ImageView) findViewById(R.id.imageView2);
        mail = (ImageView) findViewById(R.id.imageView3);






        telefon.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Vibrator degisken = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                degisken.vibrate(500);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:05550665334"));
                startActivity(intent);

            }
        });


        mesaj.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Vibrator degisken = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                degisken.vibrate(500);
              telNo = "05550665334";
              message ="ŞU AN KÖTÜ DURUMDAYIM, GEREKLİ KURTARMA SERVİSLERİNE HEMEN ULAŞIR MISIN ?";
                Intent mesajGonder = new Intent(Intent.ACTION_VIEW);
                mesajGonder.setData(Uri.parse("sms:"+ telNo));
                mesajGonder.putExtra("sms_body", message);
                startActivity(mesajGonder);

                // Intent intent=new Intent(getApplicationContext(),MainActivity.class);
               // PendingIntent pi= PendingIntent.getActivity(getApplicationContext(), 0, intent,0);

               // SmsManager sms = SmsManager.getDefault();
              //  sms.sendTextMessage(telNo, null, message, null, null);
                Toast.makeText(getApplicationContext(), "SMS Gönderildi!", Toast.LENGTH_LONG);

            }
        });




        mail.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Vibrator degisken = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                degisken.vibrate(500);

                Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                emailIntent.setType("plain/text");
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "ACİL ! ");

                emailIntent.putExtra(Intent.EXTRA_TEXT, "ŞU AN KÖTÜ DURUMDAYIM, GEREKLİ KURTARMA SERVİSLERİNE HEMEN ULAŞIR MISIN ?");

                String aEmailList[] = { "iatakan7@gmail.com", "atakanahmetisik@yandex.com" };

                emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, aEmailList);
                startActivity(emailIntent);


            }
        });


    }


}
