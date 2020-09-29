package br.edu.ifsp.prova;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SkinAdapter extends BaseAdapter {
    private Context context;
    private List<ItemSkin> skin = new ArrayList<>();

    public SkinAdapter(Context context, List<ItemSkin> skin) {
        this.context = context;
        this.skin = skin;
    }

    @Override
    public int getCount() {
        return skin.size();
    }

    @Override
    public Object getItem(int position) {
        return skin.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.item_skin, parent, false);

        ImageView imgItem = (ImageView) v.findViewById(R.id.imgSkin);
        TextView txtNome = (TextView) v.findViewById(R.id.nomeItem);
        TextView txtPreco = (TextView) v.findViewById(R.id.precoItem);
        TextView txtQuant = (TextView) v.findViewById(R.id.quantItem);

        ItemSkin itemSkin = skin.get(position);

        imgItem.setImageResource(itemSkin.img);
        txtNome.setText(itemSkin.nome);

        if(itemSkin.getQuantidade() > 0 )  {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams( LinearLayout.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            txtQuant.setLayoutParams(layoutParams);
            txtQuant.setText(String.valueOf("Quantidade: "+itemSkin.getQuantidade()));
        }

        txtPreco.setText("R$ "+String.format("%.2f", itemSkin.preco).replace(".",","));

        return v;
    }



}
