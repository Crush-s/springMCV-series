package com.javacode2018.springmvcseries.httpClients;

import java.io.IOException;
import java.util.Scanner;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * @author crush
 */
public class HttpPostExample {

    public static void main(String[] args) throws IOException {
        // create a new instance of the HttpPostExample
        CloseableHttpClient aDefault = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost("http://www.yiidian.com");

        //Printing the method used
        System.out.println("Request Type: "+httpPost.getMethod());

        //Executing the Get request
        HttpResponse httpresponse = aDefault.execute(httpPost);

        Scanner sc = new Scanner(httpresponse.getEntity().getContent());

        //Printing the status line
        System.out.println(httpresponse.getStatusLine());
        while(sc.hasNext()) {
            System.out.println(sc.nextLine());
        }
    }

}
