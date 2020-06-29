package pl.restauracja.tacos.usefull;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import pl.restauracja.tacos.R;
import pl.restauracja.tacos.usefull.Lista;

public class ListaDwaAdapter extends ArrayAdapter<Lista> {

private ArrayList<Lista> data;
private Context context;

public ListaDwaAdapter(Context context, ArrayList<Lista> data) {
        super(context, R.layout.layout_list_dwa);
        this.data = data;
        this.context = context;
        }

@Override
public int getCount() {
        return data.size();
        }

@Override
public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        LokalHolder holder = null;

        if(row == null) {
        LayoutInflater inflater =((Activity) context).getLayoutInflater();
        row = inflater.inflate(R.layout.layout_list_dwa, null);

        holder = new LokalHolder();
        holder.image = row.findViewById(R.id.list_dwa_id);
        holder.name = row.findViewById(R.id.list_dwa_nazwa);

        row.setTag(holder);
        } else {
        holder = (LokalHolder) row.getTag();
        }

        Lista list = data.get(position);
        holder.image.setImageResource(list.getListNameId());
        holder.name.setText(list.getNameId());

        return row;
        }

static class LokalHolder {
    ImageView image;
    TextView name;
}
}
