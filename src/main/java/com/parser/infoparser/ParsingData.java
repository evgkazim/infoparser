package com.parser.infoparser;

import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ParsingData {
	public static ArrayList<ParsingDataGetSet> parsing() throws IOException {
		ArrayList<ParsingDataGetSet> result = new ArrayList<ParsingDataGetSet>();
		String link = "https://www.avito.ru/ekaterinburg/telefony/iphone-ASgBAgICAUSeAt4J?s=104&user=1&q=iphone&p=1";
    	
		Document doc = Jsoup.connect(link).get();   
    	Elements c1 = doc.select("a.snippet-link");
    	Elements c2 = doc.select("span.snippet-price ");
    	Elements c3 = doc.select("div.snippet-date-info");

    	for(int i=0;i<c1.size();i++) {
    		ParsingDataGetSet list = new ParsingDataGetSet();
    		list.setName(c1.get(i).text());
    		list.setPrice(c2.get(i).text().replaceAll("[^0-9]", ""));
    		list.setDate(c3.get(i).attr("data-tooltip"));
    		list.setLink("https://www.avito.ru"+c1.get(i).attr("href"));
    		result.add(list);
    	}
    	return result;
	}

}
