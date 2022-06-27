package com.javacode2018.springmvcseries.httpClients;

import java.io.IOException;
import java.util.Scanner;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

/**
 * @author crush
 */
public class CloseConnectionExample {

    public static void main(String[] args) throws IOException {
        HttpGet httpget = new HttpGet("http://www.yiidian.com/");
        try (//Execute the Get request
                CloseableHttpResponse httpResponse = HttpClients.createDefault()
                        .execute(httpget);) {
            Scanner sc = new Scanner(httpResponse.getEntity().getContent());
            while (sc.hasNext()) {
                System.out.println(sc.nextLine());
            }
        }
    }

}
