package com.servlet.action.home;

import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class QueryParamExample implements Serializable{


    public static Map<String,String> getQueryParameters(String urlString) {

        try {
            URI uri = new URI(urlString);

            // Get query parameters as a map
            Map<String, String> queryParams = getQueryParams(uri);

            // Print the query parameters
            System.out.println("Query Parameters:");
            for (Map.Entry<String, String> entry : queryParams.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
            return queryParams;
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
        
    }

    private static Map<String, String> getQueryParams(URI uri) {
        String query = uri.getQuery();
        return parseQuery(query);
    }

    private static Map<String, String> parseQuery(String query) {
        // Split the query string into individual key-value pairs
        String[] queryParams = query.split("&");

        // Create a map to store the key-value pairs
        HashMap<String, String> paramMap = new HashMap<>();

        // Parse each key-value pair and add it to the map
        for (String param : queryParams) {
            String[] pair = param.split("=");
            if (pair.length == 2) {
                paramMap.put(pair[0], pair[1]);
            }
        }

        return paramMap;
    }
}

