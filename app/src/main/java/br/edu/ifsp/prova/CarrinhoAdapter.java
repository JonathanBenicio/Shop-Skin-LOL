package br.edu.ifsp.prova;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CarrinhoAdapter  extends BaseAdapter implements Serializable {
    private Context context;
    public List<ItemSkin> skin = new ArrayList<>();

    public CarrinhoAdapter(Context context, List<ItemSkin> skin) {
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
        View v = inflater.inflate(R.layout.carrinho_skin, parent, false);

        ImageView imgItem = (ImageView) v.findViewById(R.id.imgSkin);
        TextView txtNome = (TextView) v.findViewById(R.id.nomeItem);
        TextView txtPreco = (TextView) v.findViewById(R.id.precoItem);
        final NumberPicker numQ = (NumberPicker) v.findViewById(R.id.numQuant);


        final ItemSkin itemSkin = skin.get(position);

        imgItem.setImageResource(itemSkin.img);
        txtNome.setText(itemSkin.nome);
        txtPreco.setText(" R$ "+String.format("%.2f", itemSkin.preco).replace(".",","));

        numQ.setMaxValue(50);
        numQ.setMinValue(0);
        numQ.setValue(itemSkin.getQuantidade());
        numQ.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                int valuePicker1 = numQ.getValue();
                itemSkin.setQuantidade(numQ.getValue());
            }
        });




        return v;
    }


}
