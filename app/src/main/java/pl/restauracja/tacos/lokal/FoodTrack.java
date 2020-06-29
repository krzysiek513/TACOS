package pl.restauracja.tacos.lokal;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import pl.restauracja.tacos.R;
import pl.restauracja.tacos.main.Info;
import pl.restauracja.tacos.usefull.Lista;
import pl.restauracja.tacos.usefull.ListaDwaAdapter;

public class FoodTrack extends AppCompatActivity {


    Intent intent;
    ListView listView;
    private ArrayList<Lista> data;
    private ArrayAdapter<Lista> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_track);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        listView = findViewById(R.id.foodtackid);

        data = new ArrayList<>();
        data.add(new Lista(R.drawable.baseline_room_white_18dp, getString(R.string.lokal_ul_jeden)));
        data.add(new Lista(R.drawable.baseline_schedule_white_18dp, getString(R.string.lokal_godziny_jeden)));
        data.add(new Lista(R.drawable.baseline_email_white_18dp , getString(R.string.lokal_email_jeden)));
        data.add(new Lista(R.drawable.main_fb, getString(R.string.lokal_fb_jeden)));
        data.add(new Lista(R.drawable.baseline_phone_enabled_white_18dp, getString(R.string.lokal_tel_jeden)));
        data.add(new Lista(R.drawable.baseline_camera_alt_white_18dp, getString(R.string.lokal_galeria_jeden)));


        adapter = new ListaDwaAdapter(this, data);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("naciesnoles: ", String.valueOf(position));
                switch (position) {
                    case 0:
                        intent = new Intent(android.content.Intent.ACTION_VIEW,
                                Uri.parse("https://www.google.com/maps/place/Tacos/@51.7438827,19.8058346,21z/data=!4m5!3m4!1s0x471bd565426e4ff7:0xce0922c0528c58b9!8m2!3d51.7439271!4d19.8055883"));
                        startActivity(intent);
                        break;
                    case 1:
                        Toast.makeText(getApplicationContext(), "Otwarte wiosna, lato!", Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        intent = new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.tel_glowny)));
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:p.szkopinski@wp.pl"));
                        startActivity(intent);
                        break;
                    case 3:
                        Uri uri = Uri.parse("https://www.facebook.com/TACOS-1496782210393949/");
                        intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent(getApplicationContext(), FoodTrackGaleria.class);
                        startActivity(intent);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "smacznego", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_info) {
            Intent intent = new Intent(this, Info.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
