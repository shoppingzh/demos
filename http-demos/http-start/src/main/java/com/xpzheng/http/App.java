/**
 * 
 */
package com.xpzheng.http;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.xpzheng.http.tool.HttpUtils;

/**
 * @author Admin
 *
 */
public class App {

    public static void main(String[] args) throws Exception {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpUriRequest get = new HttpGet("http://localhost");
        CloseableHttpResponse resp = client.execute(get);
        System.out.println(" =================== 请求头 ========================= ");
        HttpUtils.printHeaders(get.getAllHeaders());
        System.out.println(" =================== 响应头 ========================= ");
        HttpUtils.printHeaders(resp.getAllHeaders());
    }

}
