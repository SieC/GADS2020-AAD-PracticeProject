package sc.gads2020_aadpp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;

public class LaunchActivity extends AppCompatActivity {
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

         CountDownTimer timer = new CountDownTimer(2000, 2000)
            {
                public void onTick(long millisUntilFinished)
                {
                }

                public void onFinish()
                {
              startActivity(new Intent(LaunchActivity.this,MainActivity.class));
              finish();
                }
            };
            timer.start();

    }
}