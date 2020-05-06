package com.parser.infoparser;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class App {	
    public static void main( String[] args ) throws IOException, SQLException {
    	ArrayList<ParsingDataGetSet> list = ParsingData.parsing();
    	for(int i=0;i<list.size();i++) {
    		String name = list.get(i).getName();
    		String price= list.get(i).getPrice();
    		String date = list.get(i).getDate();
    		String link = list.get(i).getLink();
    		
    		InitSqlGetSet select_count = InitSql.sql_select_count("SELECT count(name) FROM avito_data.data WHERE name ='"+name+"' AND price='"+price+"' AND date ='"+date+"' AND link ='"+link+"'");
    		if(select_count.getCount()==0) {
    			InitSql.sql_insert("INSERT INTO `avito_data`.`data` (`name`, `price`, `date`, `link`) VALUES ('"+name+"', '"+price+"', '"+date+"', '"+link+"')");
    		}
    	}
    }
}
