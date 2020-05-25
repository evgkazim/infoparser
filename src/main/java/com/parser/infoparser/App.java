package com.parser.infoparser;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


public class App {	
    public static void main( String[] args ) throws IOException, SQLException {
    	/*
    	ArrayList<ParsingDataGetSet> list = ParsingData.parsing();
    	for(int i=0;i<list.size();i++) {
    		String price= list.get(i).getPrice();
    		String date = list.get(i).getDate();
    		String shop= list.get(i).getShop();
    		InitSqlGetSet id = InitSql.sql_select_count("SELECT count(id) FROM `parsing`.`data`");
    		InitSql.sql_insert("INSERT INTO `parsing`.`data` (`id`,`date`, `price`,`shop`) VALUES ('"+id.getCount()+"','"+date+"','"+price+"','"+shop+"')");
    	}
    	*/
    	//String ai92_f = "C:\\Java\\py_nn\\src\\ai92_f.csv";
    	//ArrayList<InitSqlGetSet> ai92 = InitSql.sql_select("SELECT * FROM `parsing`.`ai92`");
    	/*
    	ArrayList<InitSqlGetSet> ai92full = InitSql.sql_select("SELECT * FROM `parsing`.`ai92full`");
    	ArrayList<InitSqlGetSet> ai95 = InitSql.sql_select("SELECT * FROM `parsing`.`ai95`");
    	ArrayList<InitSqlGetSet> ai95full = InitSql.sql_select("SELECT * FROM `parsing`.`ai95full`");
    	*/
    	String[] array_name = "ai92,ai92full,ai95,ai95full".split(",");
    	String[] array_path = "C:\\diplom\\data\\ai92_t.csv,C:\\diplom\\data\\ai92full_t.csv,C:\\diplom\\data\\ai95_t.csv,C:\\diplom\\data\\ai95full_t.csv".split(",");
    	for(int i=0;i<4;i++) {
    		ArrayList<InitSqlGetSet> a = InitSql.sql_select("SELECT * FROM `parsing`.`"+array_name[i]+"`");
   	 		try(FileWriter writer = new FileWriter(array_path[i], false))
   	 		{  	
   	 			writer.write("price");
   	 			writer.append('\n');
   	 			for(int j=0;j<a.size();j++) {
   	 				writer.write(a.get(j).getPrice_col());
   	 				writer.append('\n');
   	 				writer.flush();
   	 			}
   	 		}
   	 		catch(IOException ex){
   	 			System.out.println(ex.getMessage());
   	 		}
    	}
    }
}
