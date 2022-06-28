package com.javacode2018.springmvcseries.httpClients;

import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @author crush
 */
public class ResponseHandlerExample {

    public static void main(String[] args) throws IOException {

        CloseableHttpClient aDefault = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet("http://www.yiidian.com/");
        String execute = aDefault.execute(httpGet, new MyResponseHandler());
        System.out.println(execute);
    }

}

class MyResponseHandler implements ResponseHandler<String> {

    @Override
    public String handleResponse(HttpResponse httpResponse)
            throws ClientProtocolException, IOException {
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (statusCode >= 200 && statusCode < 300) {
            HttpEntity entity = httpResponse.getEntity();
            if (entity == null) {
                return "";
            } else {
                return EntityUtils.toString(entity);
            }

        } else {
            return "" + statusCode;
        }
    }
}
