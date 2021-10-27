package vn.edu.usth.weather;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.os.Bundle;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import android.media.MediaPlayer;
import android.widget.Toast;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("Weather","onCreate");
        setContentView(R.layout.activity_weather);
        PagerAdapter adapter = new HomePagerAdapter(getSupportFragmentManager());
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        //Add tab controller
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab);
        tabLayout.setupWithViewPager(viewPager);

        //Add Media Player
        MediaPlayer player = MediaPlayer.create(WeatherActivity.this, R.raw.situvoismamere);
        player.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        switch (menuItem.getItemId()){
            case R.id.refresh:
                Toast.makeText(this, "Updating...", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.settings:
                Intent intent = new Intent(this, PrefActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    @Override
    protected void onStart(){
        super.onStart();
        copyFileToExternalStorage(R.raw.situvoismamere,"situvoismamere.mp3");
        Log.i("Weather", "On Start");
    }

    private void copyFileToExternalStorage(int resid, String resname){
        try{
            File file = new File(getExternalFilesDir(null),resname);
            InputStream s = getApplicationContext().getResources().openRawResource(resid);
            OutputStream o = new FileOutputStream(file);
            byte[] buff = new byte[1024*2];
            int read = 0;
            try{
                while ((read = s.read(buff)) > 0){
                    o.write(buff,0,read);
                }
            }
            finally {
                Toast toast = Toast.makeText(getApplicationContext(), file.getAbsolutePath(), Toast.LENGTH_LONG);
                toast.show();
                s.close();
                o.close();
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
            Toast toast = Toast.makeText(getApplicationContext(), "File not found", Toast.LENGTH_LONG);
            toast.show();
        }
        catch (IOException e){
            e.printStackTrace();
        }
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

