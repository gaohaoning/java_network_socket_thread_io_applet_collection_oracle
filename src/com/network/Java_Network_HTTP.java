package com.network;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class Java_Network_HTTP
{
	public static void main(String[] args)
	{
		System.out.println("========= Java Network ==========");		
		HttpClient httpClient=new DefaultHttpClient();		
		try
		{			
			//URI uri=URIUtils.createURI("http","www.google.com.hk", -1, "/search", "q=httpclient&btnG=Google+Search&aq=f&oq=", null);
			//URI uri=URIUtils.createURI("http","www.baidu.com", -1, "/s", "wd=httpclient&n=2", null);

			//=============================================================================
			List<NameValuePair> queryParam=new ArrayList<NameValuePair>();			
			queryParam.add(new BasicNameValuePair("q", "httpclient"));
			queryParam.add(new BasicNameValuePair("btnG", "Google Search"));
			queryParam.add(new BasicNameValuePair("aq", "f"));
			queryParam.add(new BasicNameValuePair("oq", null));			
			
			String strQuery=URLEncodedUtils.format(queryParam, "UTF-8");
			
			URI uri=URIUtils.createURI("http",
					"www.google.com.hk", 
					-1, "/search", 
					strQuery, //////////
					null);
			//=============================================================================
			
			HttpGet httpGet=new HttpGet(uri);
			System.out.println(httpGet.getURI());
			
			HttpResponse httpResponse=httpClient.execute(httpGet);
			
			HttpEntity httpEntity=httpResponse.getEntity();
			
			System.out.println("==========================================");			
			System.out.println("[getStatusLine]");
			System.out.println(httpResponse.getStatusLine());
			System.out.println(
					"[ProtocolVersion]"+
					httpResponse.getStatusLine().getProtocolVersion()+
					"[StatusCode]"+
					httpResponse.getStatusLine().getStatusCode()+
					"[ReasonPhrase]"+
					httpResponse.getStatusLine().getReasonPhrase());
			System.out.println("==========================================");
			
			if(httpEntity!=null)
			{
				System.out.println("[getContentLength]");
				System.out.println(httpEntity.getContentLength());
				System.out.println("[getContent]");
				System.out.println(httpEntity.getContent());
				System.out.println("[getEntity]");
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
