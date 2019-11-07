/**
 * 
 */
package com.xpzheng.http;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.xpzheng.http.tool.HttpUtils;

/**
 * 演示HTTP获取部分资源
 * @author Admin
 *
 */
public class App {
    
    public static void main(String[] args) throws ClientProtocolException, IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpUriRequest get= new HttpGet("http://localhost");
        get.setHeader("Range", "bytes=0-100");
        CloseableHttpResponse resp = client.execute(get);
        System.out.println(resp.getStatusLine().toString());
        System.out.println(" ============== 响应头 START ==============");
        HttpUtils.printHeaders(resp.getAllHeaders());
        System.out.println(" ============== 响应头 END ==============");
        System.out.println("以下为部分内容:");
        System.out.println(EntityUtils.toString(resp.getEntity()));
    }

}
