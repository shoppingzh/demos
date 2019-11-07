/**
 * 
 */
package com.xpzheng.http.tool;

import org.apache.http.Header;

/**
 * @author Admin
 *
 */
public class HttpUtils {

    /**
     * 打印响应
     * @param headers
     */
    public static void printHeaders(Header[] headers) {
        if (headers != null) {
            for (Header header : headers) {
                System.out.println(header);
            }
        }
    }
    
}
