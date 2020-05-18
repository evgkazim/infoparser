package com.parser.infoparser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ParsingData {
	public static ArrayList<ParsingDataGetSet> parsing() throws IOException {
		ArrayList<ParsingDataGetSet> result = new ArrayList<ParsingDataGetSet>();
		String mvideo = "https://mvmonitor.ru/template/view_product_mvideo.php?sku=30030151";
		String eldarado = "https://mvmonitor.ru/template/view_product_eldo.php?sku=71364098";
		String goods = "https://mvmonitor.ru/template/view_product_goods.php?sku=100022845879";
		String svyaznoy = "https://mvmonitor.ru/template/view_product_svyaznoy.php?sku=3808997";
		String citylink = "https://mvmonitor.ru/template/view_product_city.php?sku=499055";
		String pleer = "https://mvmonitor.ru/template/view_product_pleer.php?sku=447058";
		Document doc = Jsoup.connect(pleer).get();  
    	Elements c1 = doc.select("tr.table-default,tr.table-danger,tr.table-success");
    	Elements c2 = doc.select("div.col-md-12");
    	Elements c3 = c2.select("script");
    	String c4 = c3.toString();
    	c4 = c4.split("data:")[1].split("point:")[0].replace(" ", "").replace("\n", "");
    	c4="{data:"+c4+"}";
    	
    	
    	JSONObject userJson = new JSONObject(c4.toString());
    	JSONArray jsonArray = (JSONArray) userJson.get("data");
    	Iterator<Object> iterator = jsonArray.iterator();
    	while(iterator.hasNext()) {
    		ParsingDataGetSet list = new ParsingDataGetSet();
    		String item = iterator.next().toString();
    		String year = item.split(",")[0].replaceAll("[^0-9]", "");
    		String mouth= item.split(",")[1].replaceAll("[^0-9]", "");
    		String day  = item.split(",")[2].replaceAll("[^0-9]", "");
    		String price= item.split(",")[3].replaceAll("[^0-9]", "");
    		String date = year+"-"+mouth+"-"+day;
    		String shop = "pleer";
    		list.setDate(date);
    		list.setPrice(price);
    		list.setShop(shop);
    		result.add(list);
    	}
    	/*
    	for(int i=0;i<c1.size();i++) {
    		ParsingDataGetSet list = new ParsingDataGetSet();
    		String text = c1.get(i).select("span").text();
    		int length = text.length();
    		String date = text.substring(0, 10);
    		String price = text.substring(24, length-5);
    		String shop = "pleer";
    		System.out.println(date+","+price);
    		list.setDate(date);
    		list.setPrice(price);
    		list.setShop(shop);
    		result.add(list);
    	}
    	*/
    	return result;
	}

}
