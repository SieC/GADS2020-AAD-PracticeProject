package sc.gads2020_aadpp;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.ImageViewCompat;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sc.gads2020_aadpp.models.SubmitItem;

public class SubmitActivity extends AppCompatActivity {

    EditText email, name, surname, link;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Google Africa");
        getSupportActionBar().setSubtitle("Developer Scholarship");
        getSupportActionBar().setIcon(R.mipmap.ic_launcher_round);
         Button btn_submit = findViewById(R.id.btn_submit);

        email = findViewById(R.id.email);
        name = findViewById(R.id.name);
        surname = findViewById(R.id.surname);
        link  = findViewById(R.id.link);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if(email.getText().toString().isEmpty()|| name.getText().toString().isEmpty()|| surname.getText().toString().isEmpty()|| link.getText().toString().isEmpty())
                {
                    Snackbar.make(view, "No field should be empty", Snackbar.LENGTH_LONG).show();

                    return;
                }
                showConfirmDialog();
            }
        });
    }



  void showResultDialog(boolean success){
      // Create an alert builder
      int drawable = success?R.drawable.ic_done:R.drawable.ic_fail;
      int color = success?Color.GREEN:Color.RED;
      String msg = success?"Submission successful":"Submission not successful";
      AlertDialog.Builder builder
              = new AlertDialog.Builder(this);
    //  builder.setTitle("Name");

      // set the custom layout
      final View customLayout
              = getLayoutInflater()
              .inflate(
                      R.layout.result_dialog,
                      null);
      builder.setView(customLayout);

      ImageView imgView = customLayout.findViewById(R.id.imgView);
      ImageViewCompat.setImageTintList(imgView, ColorStateList.valueOf(color));
      TextView tv = customLayout.findViewById(R.id.tv);
      imgView.setImageResource(drawable);
      tv.setText(msg);
      AlertDialog dialog
              = builder.create();

      dialog.show();

  }


    void showConfirmDialog(){
            AlertDialog.Builder builder
                = new AlertDialog.Builder(this);
        //  builder.setTitle("Name");

        // set the custom layout
        final View customLayout
                = getLayoutInflater()
                .inflate(
                        R.layout.confirm_dialog,
                        null);
        builder.setView(customLayout);

        ImageButton closeBtn = customLayout.findViewById(R.id.closeBtn);
        Button confirmBtn = customLayout.findViewById(R.id.confirmBtn);

        AlertDialog dialog
                = builder.create();
        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });


        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                SubmitItem item = new SubmitItem(email.getText().toString(), name.getText().toString(), surname.getText().toString(), link.getText().toString());


                ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);



                   Call<SubmitItem> call =  apiService.submit(item);
                call.enqueue(new Callback<SubmitItem>() {
                    @Override
                    public void onResponse(Call<SubmitItem> call, Response<SubmitItem> response) {
                        Log.e("RESPONSE - ",""+response.body()) ;
                        Toast.makeText(SubmitActivity.this, ""+response.body(), Toast.LENGTH_SHORT).show();
                        showResultDialog(true);
                    }

                    @Override
                    public void onFailure(Call<SubmitItem> call, Throwable t) {
                        Log.e("FAILED ","Response = "+t.toString());
                        showResultDialog(false);
                              }
                });
            }
        });
        dialog.show();

    }




}