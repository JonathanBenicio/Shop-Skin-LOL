package br.edu.ifsp.prova;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Carrinho implements Serializable {
    private List<ItemSkin> itemCarrinhoSkin = new ArrayList<>();

    public List<ItemSkin> getItemCarrinhoSkin() {
        return itemCarrinhoSkin;
    }

    public void setItemCarrinhoSkin(List<ItemSkin> itemCarrinhoSkin) {
        this.itemCarrinhoSkin = itemCarrinhoSkin;
    }

    public Carrinho(List<ItemSkin> temCarrinhoSkin) {
        this.itemCarrinhoSkin = temCarrinhoSkin;
    }

    public double obterValorTotal(){
        double valorTotal = 0;
        for (ItemSkin skin: itemCarrinhoSkin) {
            valorTotal += skin.preco * skin.getQuantidade();
        }

        return valorTotal;
    }

    public int obterQuantTotal(){
        int quant=0;
        for (ItemSkin skin: itemCarrinhoSkin) {
            quant += skin.getQuantidade();

        }

        return quant;
    }



}
