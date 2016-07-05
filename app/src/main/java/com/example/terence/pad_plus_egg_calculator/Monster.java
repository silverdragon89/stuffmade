package com.example.terence.pad_plus_egg_calculator;

/**
 * Created by Terence on 7/4/2016.
 */
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

public class Monster {


    private String name;
    private int id;
    private int hp;
    private int atk;
    private int rcv;

    public void setName(String input){
        name = input;

    }
    public Monster(String name, int id, int hp, int atk, int rcv){
        setName(name);
        setId(id);
        setHp(hp);
        setAtk(atk);
        setRcv(rcv);
    }
    public void setId(int input){
        id = input;
    }

    public void setHp(int input){
        hp = input;
    }
    public void setAtk (int input) {
        atk = input;
    }

    public void setRcv(int input){
        rcv = input;
    }

    public String getName(){
        return name;
    }

    public int getId() {
        return id;
    }
    public int getAtk() {
        return atk;
    }

    public int getHp() {
        return hp;
    }

    public int getRcv() {
        return rcv;
    }

}