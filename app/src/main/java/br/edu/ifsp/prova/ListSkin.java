package br.edu.ifsp.prova;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListSkin extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    /*
    Jonathan Oliveira - BT3000591
    Adonis Henrique Santos motta - BT3000567
    Gustavo Guedes -    BT3000249
    */
    List<ItemSkin> listSkinCarrinho;

    TextView itens;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skin);

        SkinAdapter adapter = new SkinAdapter(this, ItemSkin.getSkin());

        ListView listView = (ListView) findViewById(R.id.listSkin);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        listView.setOnItemLongClickListener(this);

        itens = findViewById(R.id.itens);

        itens.setText("0");

        listSkinCarrinho = new ArrayList<ItemSkin>();
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ItemSkin item = (ItemSkin) parent.getAdapter().getItem(position);

        Log.d("TESTE", listSkinCarrinho.toString());

        if(item.getQuantidade() == 0 ){
            item.setQuantidade(1);

            listSkinCarrinho.add(item);

            itens.setText(String.valueOf(listSkinCarrinho.size()));

            Toast.makeText(this, "Skin "+item.nome+ " adionada ao carrinho", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Skin "+item.nome+" já existe no carrinho", Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        ItemSkin item = (ItemSkin) parent.getAdapter().getItem(position);
        Log.d("TESTE", item.toString());
        if(!listSkinCarrinho.contains(item)){
            item.setQuantidade(1);

            listSkinCarrinho.add(item);

            itens.setText(String.valueOf(listSkinCarrinho.size()));


            Toast.makeText(this, "Skin "+item.nome+ " adionada ao carrinho", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Skin "+item.nome+" já existe no carrinho", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    public void abrirCarrinho(View v){


        final Intent it = new Intent(v.getContext(), ListCarrinho.class);
        it.putExtra("carrinhoSkin", (Serializable) listSkinCarrinho);
        startActivityForResult(it,1);
        Log.d("TESTE", listSkinCarrinho.toString());
        listSkinCarrinho.clear();
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                listSkinCarrinho = (List<ItemSkin>) data.getSerializableExtra("carrinhoSkin");
                itens.setText(String.valueOf(listSkinCarrinho.size()));
                Log.d("TESTE", listSkinCarrinho.toString());
            }
        }
    }
}