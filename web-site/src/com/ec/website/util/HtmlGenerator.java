package com.ec.website.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class HtmlGenerator {
	public static void generateHtml(List<String> urls) throws ClientProtocolException, IOException{
		for(String url : urls){
			InputStream instream = null;
			OutputStream outstream = null;
			try{
				HttpClient httpclient = new DefaultHttpClient();
	
				HttpGet httpget = new HttpGet("http://127.0.0.1:8080/web-site/"+url);
	
				HttpResponse response = httpclient.execute(httpget);
				
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					File file = new File("/Users/weisun/git/ec/web-site/WebContent/"+url);
					if(file.exists()){
						file.delete();
						file = new File("/Users/weisun/git/ec/web-site/WebContent/"+url);
						file.createNewFile();
					}
					outstream = new FileOutputStream(file);
					instream = entity.getContent();
					entity.writeTo(outstream);
					outstream.flush();
	
				}
			}finally{
				if(instream!=null)
				instream.close();
				if(outstream!=null)
				instream.close();
			}
		}
	}
	
	public static void main(String[] args) throws ClientProtocolException, IOException {
		List<String> urls = new ArrayList<String>();
		urls.add("index.html");
		
		urls.add("solution/military.html");
		urls.add("solution/chemica_industry.html");
		urls.add("solution/municipal_administration.html");
		urls.add("solution/medical_treatment.html");
		urls.add("solution/residence.html");
		urls.add("solution/hotel.html");
		urls.add("solution/stadium.html");
		urls.add("solution/overview.html");
		urls.add("solution/index.html");
		
		urls.add("about_us/summary.html");
		urls.add("about_us/news.html");
		urls.add("about_us/download.html");
		urls.add("about_us/certification.html");
		urls.add("about_us/global_map.html");
		urls.add("about_us/case_list.html");
		urls.add("about_us/index.html");
		
		urls.add("product/aps.html");
		urls.add("product/ag.html");
		urls.add("product/hds.html");
		urls.add("product/das.html");
		urls.add("product/usah.html");
		urls.add("product/multi_mix.html");
		urls.add("product/index.html");

		urls.add("technology/overview.html");
		urls.add("technology/scope.html");
		urls.add("technology/index.html");
		
		urls.add("contact_us/contact_info.html");
		urls.add("contact_us/tmall.html");
		urls.add("contact_us/dealer_list.html");
		urls.add("contact_us/index.html");
		HtmlGenerator.generateHtml(urls);
	}
}
