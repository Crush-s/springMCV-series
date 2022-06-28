package com.javacode2018.springmvcseries.httpClients;

import java.io.IOException;
import java.util.Scanner;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * @author crush
 */
public class HttpGetExample {

    public static void main(String[] args) throws IOException {
        CloseableHttpClient aDefault = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet("http://www.yiidian.com");
        System.out.println("httpGet.getMethod() = " + httpGet.getMethod());

        CloseableHttpResponse execute = aDefault.execute(httpGet);

        Scanner scanner = new Scanner(execute.getEntity().getContent());
        System.out.println("execute.getStatusLine() = " + execute.getStatusLine());

        while (scanner.hasNext()) {
            System.out.println(scanner.nextLine());
        }
    }

}
