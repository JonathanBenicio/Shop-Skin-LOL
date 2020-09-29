package br.edu.ifsp.prova;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListCarrinho extends AppCompatActivity  {
    Carrinho carrinho = null ;
    ListView listView;
    CarrinhoAdapter adapter;
    List<ItemSkin> listSkin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_carrinho);

        Intent it = this.getIntent();


        listSkin = (List<ItemSkin>) it.getSerializableExtra("carrinhoSkin");
        adapter = new CarrinhoAdapter(this, listSkin);
        listView = (ListView) findViewById(R.id.listCarrinho);
        listView.setAdapter(adapter);

        Button btnFecharPedido = (Button) findViewById(R.id.fecharCarrinho);
        btnFecharPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Iterator<ItemSkin> iter = listSkin.iterator();

                while (iter.hasNext()){
                    if(iter.next().getQuantidade() == 0){
                        iter.remove();
                    }
                }

                carrinho = new Carrinho(listSkin);



                Intent it = new Intent(v.getContext(), Pedido.class);
                it.putExtra("pedido", (Serializable) carrinho);
                startActivity(it);


            }
        });



    }

    @Override
    public void finish() {
        Iterator<ItemSkin> iter = listSkin.iterator();
        while (iter.hasNext()){
            if(iter.next().getQuantidade() == 0){
                iter.remove();
            }
        }
        Intent returnIntent = new Intent();
        returnIntent.putExtra("carrinhoSkin", (Serializable) listSkin);
        setResult(Activity.RESULT_OK,returnIntent);
        super.finish();
    }






    @Override
    protected void onStop() {
        listView.setAdapter(adapter);
        super.onStop();
    }
}