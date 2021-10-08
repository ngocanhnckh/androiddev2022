package vn.edu.usth.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.widget.TextView;

import android.os.Bundle;

public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("Weather","onCreate");
        setContentView(R.layout.activity_weather);

        ForecastFragment firstFragment = new ForecastFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.container, firstFragment).commit();

    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.i("Weather", "On Start");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i("Weather", "On Resume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i("Weather", "On Pause");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i("Weather", "On Stop");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("Weather", "On Destroy");
    }
}

