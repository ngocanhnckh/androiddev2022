package vn.edu.usth.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.os.Bundle;

public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("Weather","onCreate");
        setContentView(R.layout.activity_weather);

        ForecastFragment secondFragment = new ForecastFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.forecast_fr,secondFragment).commit();
        WeatherFragment firstFragment = new WeatherFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.weather_fr, firstFragment).commit();

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

