package com.tv.automationtraining.helper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIHelper {
    
    // Send a GET request
    public static String sendGetRequest(String url) throws Exception {
        HttpURLConnection connection = null;
        BufferedReader in = null;
        StringBuilder response = new StringBuilder();

        try {
            // Create a URL object from the endpoint string
            URL obj = new URL(url);
            connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000); // Timeout in milliseconds
            connection.setReadTimeout(5000); // Timeout in milliseconds

            // Get the response code and the response message
            int responseCode = connection.getResponseCode();
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            System.out.println("GET Response Code :: " + responseCode);
            System.out.println("Response: " + response.toString());

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Failed to make GET request: " + e.getMessage());
        } finally {
            if (in != null) {
                in.close();
            }
            if (connection != null) {
                connection.disconnect();
            }
        }

        return response.toString();
    }

}
