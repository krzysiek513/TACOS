package pl.restauracja.tacos.jesc;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import pl.restauracja.tacos.R;
import pl.restauracja.tacos.usefull.Lista;
import pl.restauracja.tacos.usefull.ListaTrzyAdapter;

public class Jesc extends AppCompatActivity {

    Intent intent;
    ListView listView;
    private ArrayList<Lista> data;
    private ArrayAdapter<Lista> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jesc);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
       // listView = findViewById(R.id.List_dania);

        data = new ArrayList<>();
        data.add(new Lista(R.drawable.danie_jeden, getString(R.string.danie_jeden), getString(R.string.danie_opis_jeden)));
        data.add(new Lista(R.drawable.danie_dwa, getString(R.string.danie_dwa), getString(R.string.danie_opis_dwa)));
        data.add(new Lista(R.drawable.danie_trzy, getString(R.string.danie_trzy), getString(R.string.danie_opis_trzy)));
        data.add(new Lista(R.drawable.danie_cztery, getString(R.string.danie_cztery), getString(R.string.danie_opis_cztery)));
        data.add(new Lista(R.drawable.danie_piec, getString(R.string.danie_piec), getString(R.string.danie_opis_piec)));
        data.add(new Lista(R.drawable.danie_szesc, getString(R.string.danie_szesc), getString(R.string.danie_opis_szesc)));
        data.add(new Lista(R.drawable.danie_siedem, getString(R.string.danie_siedem), getString(R.string.danie_opis_siedem)));
        data.add(new Lista(R.drawable.danie_osiem, getString(R.string.danie_osiem), getString(R.string.danie_opis_osiem)));
        data.add(new Lista(R.drawable.danie_dziewienc, getString(R.string.danie_dziewiec), getString(R.string.danie_opis_dziewiec)));
        data.add(new Lista(R.drawable.danie_dziesiec, getString(R.string.danie_dziesiec), getString(R.string.danie_opis_dziesiec)));

        adapter = new ListaTrzyAdapter(this, data);
        listView.setAdapter(adapter);
    }
}
