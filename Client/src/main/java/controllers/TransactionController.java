package controllers;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class TransactionController {
    private String rootURL = "http://zipcode.rocks:8085";
    private CloseableHttpClient httpClient;

    public TransactionController(){
        this.httpClient = HttpClients.createDefault();
    }

    public String MakeURLCall(String mainurl, String method, String jpayload) {
        try {if (method.equals("GET")){
            return get(mainurl);
        }}
        catch(Exception e){
            e.printStackTrace();
        }
        return "nada";
    }

    public String get(String mainurl) throws IOException {
        CloseableHttpResponse response1 = null;
// The underlying HTTP connection is still held by the response object
// to allow the response content to be streamed directly from the network socket.
// In order to ensure correct deallocation of system resources
// the user MUST call CloseableHttpResponse#close() from a finally clause.
// Please note that if response content is not fully consumed the underlying
// connection cannot be safely re-used and will be shut down and discarded
// by the connection manager.
        try {
            HttpGet httpGet = new HttpGet(rootURL + mainurl);
            response1 = httpClient.execute(httpGet);
            System.out.println(response1.getStatusLine());
            HttpEntity entity1 = response1.getEntity();
            String result = new BufferedReader(new InputStreamReader(entity1.getContent()))
                    .lines().collect(Collectors.joining("\n"));
            // do something useful with the response body
            // and ensure it is fully consumed
            EntityUtils.consume(entity1);
            return result;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            response1.close();
        }
        return null;
    }

}
