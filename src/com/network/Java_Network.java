package com.network;

import java.io.*;
import java.io.IOException; 

import org.apache.*;
import org.apache.http.HttpConnection;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.entity.mime.Header;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

public class Java_Network
{
	public static void main(String[] args) throws IOException
	{
		System.out.println("========= Java Network ==========");		
		
		HttpClient httpClient=new DefaultHttpClient();
		
		try
		{			
			HttpGet httpGet=new HttpGet("http://www.baidu.com");
			System.out.println(httpGet.getURI());
			
			HttpResponse httpResponse=httpClient.execute(httpGet);
			
			HttpEntity httpEntity=httpResponse.getEntity();
			
			System.out.println("==========================================");
			
			System.out.println("===========getStatusLine============");
			System.out.println(httpResponse.getStatusLine());
			
			if(httpEntity!=null)
			{
				System.out.println("===========getContentLength============");
				System.out.println(httpEntity.getContentLength());
				System.out.println("===========getContent============");
				System.out.println(httpEntity.getContent());
				System.out.println("===========getEntity============");
				System.out.println(EntityUtils.toString(httpEntity));				
			}
			
			System.out.println("==========================================");			
		} catch (Exception e)
		{
			// TODO: handle exception
		} finally
		{
			httpClient.getConnectionManager().shutdown();
		}

	}
}


