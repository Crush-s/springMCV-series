package com.javacode2018.springmvcseries.httpClients;

import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HttpContext;

/**
 * @author crush
 */
public class InterceptorsExample {

    public static void main(String[] args) throws IOException {
        //Creating an HttpRequestInterceptor
        HttpRequestInterceptor requestInterceptor = new HttpRequestInterceptor() {
            @Override
            public void process(HttpRequest request, HttpContext context) throws
                    HttpException, IOException {
                if (request.containsHeader("sample-header")) {
                    System.out.println("Contains header sample-header, removing it..");
                    request.removeHeaders("sample-header");
                }
                //Printing remaining list of headers
                Header[] headers = request.getAllHeaders();
                for (int i = 0; i < headers.length; i++) {
                    System.out.println(headers[i].getName());
                }
            }
        };

        //Creating an HttpRequestInterceptor
        HttpResponseInterceptor responseInterceptor = new HttpResponseInterceptor() {
            @Override
            public void process(HttpResponse response, HttpContext context) throws
                    HttpException, IOException {
                System.out.println(
                        "Adding header sample_header, demo-header, test_header to the response");
                response.setHeader("sample-header1", "My first header");
                response.setHeader("demo-header1", "My second header");
                response.setHeader("test-header1", "My third header");
            }
        };

        //Creating a CloseableHttpClient object
        CloseableHttpClient httpclient =
                HttpClients.custom()
                        .addInterceptorFirst(requestInterceptor)
                        .addInterceptorFirst(responseInterceptor)
                        .build();

        //Creating a request object
        HttpGet httpget1 = new HttpGet("http://www.yiidian.com/");

        //Setting the header to it
        httpget1.setHeader(new BasicHeader("sample-header", "My first header"));
        httpget1.setHeader(new BasicHeader("demo-header", "My second header"));
        httpget1.setHeader(new BasicHeader("test-header", "My third header"));

        //Executing the request
        HttpResponse httpresponse = httpclient.execute(httpget1);

        //Printing the status line
        System.out.println(httpresponse.getStatusLine());

        //Printing remaining list of headers
        Header[] headers = httpresponse.getAllHeaders();

        for (int i = 0; i<headers.length;i++) {
            System.out.println(headers[i].getName());
        }
    }

}
