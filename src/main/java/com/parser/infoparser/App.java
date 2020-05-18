package com.parser.infoparser;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class App {	
    public static void main( String[] args ) throws IOException, SQLException {
    	ArrayList<ParsingDataGetSet> list = ParsingData.parsing();
    	for(int i=0;i<list.size();i++) {
    		String price= list.get(i).getPrice();
    		String date = list.get(i).getDate();
    		String shop= list.get(i).getShop();
    		InitSqlGetSet id = InitSql.sql_select_count("SELECT count(id) FROM `parsing`.`data`");
    		InitSql.sql_insert("INSERT INTO `parsing`.`data` (`id`,`date`, `price`,`shop`) VALUES ('"+id.getCount()+"','"+date+"','"+price+"','"+shop+"')");
    	}
    }
}
