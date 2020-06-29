package pl.restauracja.tacos.main;

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

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

import pl.restauracja.tacos.BuildConfig;
import pl.restauracja.tacos.R;
import pl.restauracja.tacos.lokal.Lokale;
import pl.restauracja.tacos.usefull.Lista;
import pl.restauracja.tacos.usefull.ListaDwaAdapter;

public class Info extends AppCompatActivity {

    Intent intent;
    ListView listView;
    private ArrayList<Lista> data;
    private ArrayAdapter<Lista> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.List_info);

        data = new ArrayList<>();
        data.add(new Lista(R.drawable.baseline_email_white_18dp, getString(R.string.info)));
        adapter = new ListaDwaAdapter(this, data);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:krzysiek3155@gmail.com"));
                        startActivity(intent);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "smacznego", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    void share() {

        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Tacos");
        String shareMessage= "https://play.google.com/store/apps/details?id=pl.restauracja.tacos";
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
        startActivity(Intent.createChooser(shareIntent, "Tacos"));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    public void mail(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:p.szkopinski@wp.pl"));
        startActivity(intent);
    }

    public void udospenij(View view) {
        share();
    }
}
