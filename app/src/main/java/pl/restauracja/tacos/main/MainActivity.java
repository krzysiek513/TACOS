package pl.restauracja.tacos.main;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

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
import pl.restauracja.tacos.jesc.Meni;
import pl.restauracja.tacos.lokal.Lokale;
import pl.restauracja.tacos.usefull.Lista;
import pl.restauracja.tacos.usefull.ListaDwaAdapter;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    ListView listView;
    private ArrayList<Lista> data;
    private ArrayAdapter<Lista> adapter;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listView = findViewById(R.id.menu_view);

        data = new ArrayList<>();
        data.add(new Lista(R.drawable.main_restauracje, getString(R.string.main_lokale)));
        data.add(new Lista(R.drawable.main_tel, getString(R.string.main_zadwon)));
        data.add(new Lista(R.drawable.main_menu, getString(R.string.main_jadlospis)));
        data.add(new Lista(R.drawable.main_fb , getString(R.string.main_facebook)));
        data.add(new Lista(R.drawable.baseline_room_white_18dp, getString(R.string.main_mapa)));
        data.add(new Lista(R.drawable.baseline_drafts_white_18dp, getString(R.string.main_kontakt)));
        data.add(new Lista(R.drawable.baseline_camera_alt_white_18dp, getString(R.string.main_zdjecia)));
        adapter = new ListaDwaAdapter(this, data);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("naciesnoles: ", String.valueOf(position));
                switch(position){
                    case 0:
                        intent = new Intent(getApplicationContext(), Lokale.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.tel_glowny)));
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(getApplicationContext(), Meni.class);
                        startActivity(intent);
                        break;
                    case 3:
                        Uri uri = Uri.parse("https://www.facebook.com/TACOS-1496782210393949/");
                        intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(android.content.Intent.ACTION_VIEW,
                            Uri.parse("https://www.google.com/maps/@51.8010742,19.7485205,19z"));
                        startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:p.szkopinski@wp.pl"));
                        startActivity(intent);
                        break;
                    case 6:
                        intent = new Intent(getApplicationContext(), Galeria.class);
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
