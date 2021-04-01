package com.example.kependudukan;

import com.example.kependudukan.pojo.ListKk;

import java.util.ArrayList;

public class KkData {

    public static String[][] data = new String[][] {
            {"2020001", "350001", "Lori Hewitt", "1263  Davis Street, LEMOYNE", "http://barokah-softdev.com/img/1.jpg"},
            {"2020002", "350002", "Jagdeep Millar", "2871  Walt Nuzum Farm Road, TROUTVILLE", "http://barokah-softdev.com/img/2.jpg"},
            {"2020003", "350003", "Rares Estrada", "267  Jerry Toth Drive, Mccarthy", "http://barokah-softdev.com/img/3.jpg"},
            {"2020004", "350004", "Tiya Bass", "4298  Gerald L. Bates Drive, Cambridge", "http://barokah-softdev.com/img/4.jpg"},
            {"2020005",	"350005", "Manpreet Garrison", "3109  Skips Lane, Winslow", "http://barokah-softdev.com/img/5.jpg"},
            {"2020006",	"350006", "Digby Hassan	175", "Filbert Street, PROPHETSTOWN", "http://barokah-softdev.com/img/6.jpg"},
            {"2020007",	"350007", "Sahara Hanson", "355  Elsie Drive, THOMASTOWN", "http://barokah-softdev.com/img/7.jpg"},
            {"2020008",	"350008", "Alice Christie", "4299  Nancy Street, Wake Forest", "http://barokah-softdev.com/img/8.jpg"},
            {"2020009",	"350009", "Amy Callaghan", "4961  Oak Lane, Burlington Junction", "http://barokah-softdev.com/img/9.jpg"},
            {"2020010",	"350010", "Evie-Grace Villegas", "3771  Pine Street, Washington", "http://barokah-softdev.com/img/10.png"}
    };

    public static ArrayList<ListKk> getListData() {
        ArrayList<ListKk> list = new ArrayList<>();
        for (String[] aData : data) {
            ListKk post = new ListKk();
            post.setId(Integer.parseInt(aData[0]));
            post.setNo_kk(Integer.parseInt(aData[1]));
            post.setAlamat(aData[2]);
            post.setImage(aData[3]);
            list.add(post);
        }
        return list;
    }

}
