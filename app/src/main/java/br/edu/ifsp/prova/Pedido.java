package br.edu.ifsp.prova;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Pedido extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);

        Intent it = this.getIntent();
        Carrinho carrinho = (Carrinho) it.getSerializableExtra("pedido");

        List<ItemSkin> pedido = new ArrayList<>();


        for (ItemSkin skin : carrinho.getItemCarrinhoSkin()) {
            if (skin.getQuantidade() != 0) {
                pedido.add(skin);
            }
        }

        carrinho = new Carrinho(pedido);

//
        SkinAdapter adapter = new SkinAdapter(this, carrinho.getItemCarrinhoSkin());


        ListView listView = (ListView) findViewById(R.id.listCarrinho);
        listView.setAdapter(adapter);

        TextView quantidade = (TextView) findViewById(R.id.pedidoTotal);
        TextView valor = (TextView) findViewById(R.id.valorTotal);



        quantidade.setText("Quantidade de Pedidos: "+String.valueOf(carrinho.obterQuantTotal()));
        valor.setText("Valor Total de Pedidos: R$ "+String.format("%.2f", carrinho.obterValorTotal()).replace(".",","));

    }


    public void comprar(View v){
        Intent intent = new Intent(getApplicationContext(), ListSkin.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    @Override
    public void finish() {
        super.finish();
    }
}