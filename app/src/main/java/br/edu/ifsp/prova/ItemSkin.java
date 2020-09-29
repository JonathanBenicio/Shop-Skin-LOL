package br.edu.ifsp.prova;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ItemSkin implements Serializable {

    public String nome;
    public int img;
    public double preco;
    private int quantidade=0;

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public ItemSkin(String nome, int img, double preco) {
        this.nome = nome;
        this.img = img;
        this.preco = preco;
    }

    public static List<ItemSkin> getSkin(){
        List<ItemSkin> skin = new ArrayList<ItemSkin>();
        skin.add(new ItemSkin("Nunu Inverno Magico", R.drawable.nunu,15.70));
        skin.add(new ItemSkin("Yasuo Florecer Espiritual", R.drawable.yasuo,19.90));
        skin.add(new ItemSkin("Hecarim Fliperama", R.drawable.hecarim,45.00));
        skin.add(new ItemSkin("Udyr Dragonico", R.drawable.udyr,97.00));
        skin.add(new ItemSkin("Sett Reino Mecha", R.drawable.sett,61.10));
        skin.add(new ItemSkin("Thresh Lua Sangrenta", R.drawable.thresh,35.75));
        skin.add(new ItemSkin("Jax  Cajado Divino", R.drawable.jax,100.00));
        skin.add(new ItemSkin("Tahm Kech Imperador Lunar", R.drawable.tahmkench,18.50));
        skin.add(new ItemSkin("Irelia Gelida", R.drawable.irelia,10.80));
        skin.add(new ItemSkin("Skarner Maquina de Combate", R.drawable.skarner,23.50));
        return skin;
    }
}
