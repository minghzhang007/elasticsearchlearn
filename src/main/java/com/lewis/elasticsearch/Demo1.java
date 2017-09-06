package com.lewis.elasticsearch;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;

import java.io.IOException;
import java.util.Collections;

public class Demo1 {

    public static void main(String[] args) throws IOException {
        RestClient restClient = RestClient.builder(new HttpHost("localhost", 9200, "http")).build();
        Response response = restClient.performRequest("GET", "/", Collections.singletonMap("pretty", "true"));
        System.out.println(EntityUtils.toString(response.getEntity()));

       /* HttpEntity entity = new NStringEntity(
                "{\n" +
                        "    \"user\" : \"kimchy\",\n" +
                        "    \"post_date\" : \"2009-11-15T14:12:12\",\n" +
                        "    \"message\" : \"trying out Elasticsearch\"\n" +
                        "}", ContentType.APPLICATION_JSON);
        Response indexResponse = restClient.performRequest("PUT", "/twitter/tweet/1", Collections.<String, String>emptyMap(), entity);
        System.out.println(EntityUtils.toString(indexResponse.getEntity()));*/
        Response get = restClient.performRequest("GET", "/twitter/tweet/1", Collections.<String, String>emptyMap());
        System.out.println(EntityUtils.toString(get.getEntity()));
        restClient.close();
    }
}
