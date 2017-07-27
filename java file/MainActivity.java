package com.example.com;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import java.net.URL;
import android.util.Log;
import com.example.com.model.ApiResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, RatingBar.OnRatingBarChangeListener {
    ImageView img_taste_a, img_taste_b, img_taste_c, img_variety_a, img_variety_b, img_variety_c, img_service_a, img_service_b, img_service_c, img_clean_a, img_clean_b,
            img_clean_c, img_price_a, img_price_b, img_price_c,img_ins_a, img_ins_b, img_ins_c;
    RatingBar rating;
    EditText et_name, et_phone, et_email, et_suggestion;
    TextView tv_submit;

    String tasteStatus = "", varietyStatus = "", serviceStatus = "", cleanStatus = "", priceStatus = "",insStatus = "", ratings = "", msg = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        rating = (RatingBar) findViewById(R.id.rating);
        et_name = (EditText) findViewById(R.id.et_name);
        et_phone = (EditText) findViewById(R.id.et_phone);
        et_email = (EditText) findViewById(R.id.et_email);
        et_suggestion = (EditText) findViewById(R.id.et_suggestion);
        tv_submit = (TextView) findViewById(R.id.tv_submit);

        img_taste_a = (ImageView) findViewById(R.id.img_taste_a);
        img_taste_b = (ImageView) findViewById(R.id.img_taste_b);
        img_taste_c = (ImageView) findViewById(R.id.img_taste_c);
        img_variety_a = (ImageView) findViewById(R.id.img_variety_a);
        img_variety_b = (ImageView) findViewById(R.id.img_variety_b);
        img_variety_c = (ImageView) findViewById(R.id.img_variety_c);
        img_service_a = (ImageView) findViewById(R.id.img_service_a);
        img_service_b = (ImageView) findViewById(R.id.img_service_b);
        img_service_c = (ImageView) findViewById(R.id.img_service_c);
        img_clean_a = (ImageView) findViewById(R.id.img_clean_a);
        img_clean_b = (ImageView) findViewById(R.id.img_clean_b);
        img_clean_c = (ImageView) findViewById(R.id.img_clean_c);
        img_price_a = (ImageView) findViewById(R.id.img_price_a);
        img_price_b = (ImageView) findViewById(R.id.img_price_b);
        img_price_c = (ImageView) findViewById(R.id.img_price_c);


        img_ins_a = (ImageView) findViewById(R.id.img_ins_a);
        img_ins_b = (ImageView) findViewById(R.id.img_ins_b);
        img_ins_c = (ImageView) findViewById(R.id.img_ins_c);


        img_taste_a.setOnClickListener(this);
        img_taste_b.setOnClickListener(this);
        img_taste_c.setOnClickListener(this);
        img_variety_a.setOnClickListener(this);
        img_variety_b.setOnClickListener(this);
        img_variety_c.setOnClickListener(this);
        img_service_a.setOnClickListener(this);
        img_service_b.setOnClickListener(this);
        img_service_c.setOnClickListener(this);
        img_clean_a.setOnClickListener(this);
        img_clean_b.setOnClickListener(this);
        img_clean_c.setOnClickListener(this);
        img_price_a.setOnClickListener(this);
        img_price_b.setOnClickListener(this);
        img_price_c.setOnClickListener(this);

        img_ins_a.setOnClickListener(this);
        img_ins_b.setOnClickListener(this);
        img_ins_c.setOnClickListener(this);

        tv_submit.setOnClickListener(this);
        rating.setOnRatingBarChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_taste_a:
                tasteStatus = "good";
                img_taste_a.setImageDrawable(getResources().getDrawable(R.drawable.good_selected));
                img_taste_b.setImageDrawable(getResources().getDrawable(R.drawable.average_normal));
                img_taste_c.setImageDrawable(getResources().getDrawable(R.drawable.poor_normal));
                break;
            case R.id.img_taste_b:
                tasteStatus = "average";
                img_taste_a.setImageDrawable(getResources().getDrawable(R.drawable.good_normal));
                img_taste_b.setImageDrawable(getResources().getDrawable(R.drawable.average_selected));
                img_taste_c.setImageDrawable(getResources().getDrawable(R.drawable.poor_normal));
                break;
            case R.id.img_taste_c:
                tasteStatus = "poor";
                img_taste_a.setImageDrawable(getResources().getDrawable(R.drawable.good_normal));
                img_taste_b.setImageDrawable(getResources().getDrawable(R.drawable.average_normal));
                img_taste_c.setImageDrawable(getResources().getDrawable(R.drawable.poor_selected));
                break;
            case R.id.img_variety_a:
                varietyStatus = "good";
                img_variety_a.setImageDrawable(getResources().getDrawable(R.drawable.good_selected));
                img_variety_b.setImageDrawable(getResources().getDrawable(R.drawable.average_normal));
                img_variety_c.setImageDrawable(getResources().getDrawable(R.drawable.poor_normal));
                break;
            case R.id.img_variety_b:
                varietyStatus = "average";
                img_variety_a.setImageDrawable(getResources().getDrawable(R.drawable.good_normal));
                img_variety_b.setImageDrawable(getResources().getDrawable(R.drawable.average_selected));
                img_variety_c.setImageDrawable(getResources().getDrawable(R.drawable.poor_normal));
                break;
            case R.id.img_variety_c:
                varietyStatus = "poor";
                img_variety_a.setImageDrawable(getResources().getDrawable(R.drawable.good_normal));
                img_variety_b.setImageDrawable(getResources().getDrawable(R.drawable.average_normal));
                img_variety_c.setImageDrawable(getResources().getDrawable(R.drawable.poor_selected));
                break;
            case R.id.img_service_a:
                serviceStatus = "good";
                img_service_a.setImageDrawable(getResources().getDrawable(R.drawable.good_selected));
                img_service_b.setImageDrawable(getResources().getDrawable(R.drawable.average_normal));
                img_service_c.setImageDrawable(getResources().getDrawable(R.drawable.poor_normal));
                break;
            case R.id.img_service_b:
                serviceStatus = "average";
                img_service_a.setImageDrawable(getResources().getDrawable(R.drawable.good_normal));
                img_service_b.setImageDrawable(getResources().getDrawable(R.drawable.average_selected));
                img_service_c.setImageDrawable(getResources().getDrawable(R.drawable.poor_normal));
                break;
            case R.id.img_service_c:
                serviceStatus = "poor";
                img_service_a.setImageDrawable(getResources().getDrawable(R.drawable.good_normal));
                img_service_b.setImageDrawable(getResources().getDrawable(R.drawable.average_normal));
                img_service_c.setImageDrawable(getResources().getDrawable(R.drawable.poor_selected));
                break;
            case R.id.img_clean_a:
                cleanStatus = "good";
                img_clean_a.setImageDrawable(getResources().getDrawable(R.drawable.good_selected));
                img_clean_b.setImageDrawable(getResources().getDrawable(R.drawable.average_normal));
                img_clean_c.setImageDrawable(getResources().getDrawable(R.drawable.poor_normal));
                break;
            case R.id.img_clean_b:
                cleanStatus = "average";
                img_clean_a.setImageDrawable(getResources().getDrawable(R.drawable.good_normal));
                img_clean_b.setImageDrawable(getResources().getDrawable(R.drawable.average_selected));
                img_clean_c.setImageDrawable(getResources().getDrawable(R.drawable.poor_normal));
                break;
            case R.id.img_clean_c:
                cleanStatus = "poor";
                img_clean_a.setImageDrawable(getResources().getDrawable(R.drawable.good_normal));
                img_clean_b.setImageDrawable(getResources().getDrawable(R.drawable.average_normal));
                img_clean_c.setImageDrawable(getResources().getDrawable(R.drawable.poor_selected));
                break;
            case R.id.img_price_a:
                priceStatus = "good";
                img_price_a.setImageDrawable(getResources().getDrawable(R.drawable.good_selected));
                img_price_b.setImageDrawable(getResources().getDrawable(R.drawable.average_normal));
                img_price_c.setImageDrawable(getResources().getDrawable(R.drawable.poor_normal));
                break;
            case R.id.img_price_b:
                priceStatus = "average";
                img_price_a.setImageDrawable(getResources().getDrawable(R.drawable.good_normal));
                img_price_b.setImageDrawable(getResources().getDrawable(R.drawable.average_selected));
                img_price_c.setImageDrawable(getResources().getDrawable(R.drawable.poor_normal));
                break;
            case R.id.img_price_c:
                priceStatus = "poor";
                img_price_a.setImageDrawable(getResources().getDrawable(R.drawable.good_normal));
                img_price_b.setImageDrawable(getResources().getDrawable(R.drawable.average_normal));
                img_price_c.setImageDrawable(getResources().getDrawable(R.drawable.poor_selected));
                break;
            case R.id.img_ins_a:
                insStatus = "good";
                img_ins_a.setImageDrawable(getResources().getDrawable(R.drawable.good_selected));
                img_ins_b.setImageDrawable(getResources().getDrawable(R.drawable.average_normal));
                img_ins_c.setImageDrawable(getResources().getDrawable(R.drawable.poor_normal));
                break;
            case R.id.img_ins_b:
                insStatus = "average";
                img_ins_a.setImageDrawable(getResources().getDrawable(R.drawable.good_normal));
                img_ins_b.setImageDrawable(getResources().getDrawable(R.drawable.average_selected));
                img_ins_c.setImageDrawable(getResources().getDrawable(R.drawable.poor_normal));
                break;
            case R.id.img_ins_c:
                insStatus = "poor";
                img_ins_a.setImageDrawable(getResources().getDrawable(R.drawable.good_normal));
                img_ins_b.setImageDrawable(getResources().getDrawable(R.drawable.average_normal));
                img_ins_c.setImageDrawable(getResources().getDrawable(R.drawable.poor_selected));
                break;
            case R.id.tv_submit:
                if (validateFields()) {
                    callApi();
                }

                break;
        }
    }

    private void callApi() {
        final ProgressDialog pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.show();
        Call<ApiResponse> call = Utils.getApi().postFeedBack("insert", et_name.getText().toString().trim(), et_phone.getText().toString().trim(),
                et_email.getText().toString().trim(), tasteStatus, serviceStatus, varietyStatus, cleanStatus, priceStatus,insStatus, ratings, et_suggestion.getText().toString().trim());
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                pDialog.hide();
                if (response.body() != null) {
                    if (response.body().getSuccess() == 1)
                    {


                        Log.d("myTag", ratings);


                        if (tasteStatus == "good" && serviceStatus == "good" && varietyStatus == "good" && cleanStatus == "good" && priceStatus == "good" && insStatus == "good") {

                            ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1);
                            adapter.add("Facebook");
                            adapter.add("Zomanto");
                            adapter.add("No Thanks");
                            new AlertDialog.Builder(MainActivity.this, android.R.style.Theme_Holo_Light_Dialog_NoActionBar_MinWidth)
                                    .setAdapter(adapter, new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int item) {
                                            switch (item) {
                                                case 0:
                                                    //Toast.makeText(getApplicationContext(), "Shared via Facebook", Toast.LENGTH_LONG).show();
                                                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com"));
                                                    startActivity(myIntent);
                                                    dialog.dismiss();
                                                    clearFields();
                                                    break;
                                                case 1:
                                                    //Toast.makeText(getApplicationContext(), "Shared via Zomanto", Toast.LENGTH_LONG).show();
                                                    Intent myIntentNew = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                                                    startActivity(myIntentNew);
                                                    dialog.dismiss();
                                                    clearFields();
                                                    break;
                                                case 2:
                                                    dialog.dismiss();
                                                    clearFields();
                                                    break;
                                            }
                                        }
                                    }).show();
                        }
                        else
                        {
                            if (response.body().getMsg() != null)
                            {
                                msg = response.body().getMsg();
                            } else {
                                msg = "Successfully Sent";
                            }
                               showDialog(msg);
                        }


                    }
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                pDialog.hide();
                msg = "Failed to submit";
//                showDialog(msg);
            }
        });
    }

    private void clearFields() {
        img_taste_a.setImageDrawable(getResources().getDrawable(R.drawable.good_normal));
        img_taste_b.setImageDrawable(getResources().getDrawable(R.drawable.average_normal));
        img_taste_c.setImageDrawable(getResources().getDrawable(R.drawable.poor_normal));
        img_variety_a.setImageDrawable(getResources().getDrawable(R.drawable.good_normal));
        img_variety_b.setImageDrawable(getResources().getDrawable(R.drawable.average_normal));
        img_variety_c.setImageDrawable(getResources().getDrawable(R.drawable.poor_normal));
        img_service_a.setImageDrawable(getResources().getDrawable(R.drawable.good_normal));
        img_service_b.setImageDrawable(getResources().getDrawable(R.drawable.average_normal));
        img_service_c.setImageDrawable(getResources().getDrawable(R.drawable.poor_normal));
        img_clean_a.setImageDrawable(getResources().getDrawable(R.drawable.good_normal));
        img_clean_b.setImageDrawable(getResources().getDrawable(R.drawable.average_normal));
        img_clean_c.setImageDrawable(getResources().getDrawable(R.drawable.poor_normal));
        img_price_a.setImageDrawable(getResources().getDrawable(R.drawable.good_normal));
        img_price_b.setImageDrawable(getResources().getDrawable(R.drawable.average_normal));
        img_price_c.setImageDrawable(getResources().getDrawable(R.drawable.poor_normal));
        img_ins_a.setImageDrawable(getResources().getDrawable(R.drawable.good_normal));
        img_ins_b.setImageDrawable(getResources().getDrawable(R.drawable.average_normal));
        img_ins_c.setImageDrawable(getResources().getDrawable(R.drawable.poor_normal));
        rating.setRating(0);
        et_name.setText("");
        et_email.setText("");
        et_phone.setText("");
        et_suggestion.setText("");
    }

    private boolean validateFields() {
        if (tasteStatus.equals("")) {
            Toast.makeText(this, "Select Taste Opinion", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (varietyStatus.equals("")) {
            Toast.makeText(this, "Select Variety Opinion", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (serviceStatus.equals("")) {
            Toast.makeText(this, "Select Service Opinion", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (cleanStatus.equals("")) {
            Toast.makeText(this, "Select Cleanliness Opinion", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (priceStatus.equals("")) {
            Toast.makeText(this, "Select Price Opinion", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (et_name.getText().toString().equals("")) {
            Toast.makeText(this, "Enter Name", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (et_phone.getText().toString().equals("")) {
            Toast.makeText(this, "Enter Phone", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (et_email.getText().toString().equals("")) {
            Toast.makeText(this, "Enter Email", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (et_suggestion.getText().toString().equals("")) {
            Toast.makeText(this, "Enter Suggestion", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (ratings.equals("")) {
            Toast.makeText(this, "Select Rating", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void showDialog(String msg)
    {
        new AlertDialog.Builder(this, R.style.AppDialogTheme).setMessage(msg).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                clearFields();
            }
        }).show();
    }

    @Override
    public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
        ratings = v + "";
    }
}
