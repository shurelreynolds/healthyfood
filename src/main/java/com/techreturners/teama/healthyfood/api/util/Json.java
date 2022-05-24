package com.techreturners.teama.healthyfood.api.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techreturners.teama.healthyfood.api.model.Diet;
import com.techreturners.teama.healthyfood.api.model.Meal;
import com.techreturners.teama.healthyfood.api.model.User;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class Json {
    public static User defaultUser = new User("1", "Shurel Reynolds", "shurel_reynolds@yahoo.com", 2500, 1600, 600, 900);


    private static ObjectMapper objectMapper = getDefaultObjectMapper();
    public static final String API_URL = "https://jzthb1gub2.execute-api.us-east-1.amazonaws.com/prod/";
    private static HttpClient client = HttpClient.newHttpClient();
    private static HttpRequest request;
    private static HttpResponse<String> response;

    private static ObjectMapper mapper = Json.getDefaultObjectMapper();

    public static int getHealth() throws IOException, InterruptedException {

        request = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(API_URL + "/health"))
                .build();
        response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.statusCode();
    }


    public static List<Meal> getMealList() throws IOException, InterruptedException {

        request = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(API_URL + "/meals"))
                .build();
        response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();
        if (body != null && body.indexOf(':') > -1)
            body = body.substring(body.indexOf(':') + 1);
        else body = defaultMeals();

        List<Meal> mealList = mapper.readValue(body, new TypeReference<List<Meal>>() {
        });
        return mealList;

    }

    public static ObjectMapper getDefaultObjectMapper() {
        ObjectMapper defaultObjectMapper = new ObjectMapper();
        defaultObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return defaultObjectMapper;
    }

    public static JsonNode parse(String str) throws JsonProcessingException {
        return objectMapper.readTree(str);
    }

    public static void saveMealToPlan(Meal meal) {

    }

    public static List<Diet> geDietList() throws IOException, InterruptedException {
        request = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(API_URL + "/diets"))
                .build();

        response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();
        if (body != null && body.indexOf(':') > -1)
            body = body.substring(body.indexOf(':') + 1);
        else body = defaultDiets();

        //body=body.substring(body.indexOf(':')+1);
        List<Diet> list = mapper.readValue(body, new TypeReference<List<Diet>>() {
        });
        return list;
    }

    public static String defaultDiets() {
        String body = "[\n" +
                " {\n" +
                "   \"dietid\": 1,\n" +
                "   \"name\": \"Lacto-Vegetarian\",\n" +
                "   \"photo\": null\n" +
                " },\n" +
                " {\n" +
                "   \"dietid\": 2,\n" +
                "   \"name\": \"Vegan\",\n" +
                "   \"photo\": null\n" +
                " },\n" +
                " {\n" +
                "   \"dietid\": 3,\n" +
                "   \"name\": \"Vegetarian\",\n" +
                "   \"photo\": null\n" +
                " },\n" +
                " {\n" +
                "   \"dietid\": 4,\n" +
                "   \"name\": \"Ketogenic\",\n" +
                "   \"photo\": null\n" +
                " },\n" +
                " {\n" +
                "   \"dietid\": 5,\n" +
                "   \"name\": \"Ovo-Vegetarian\",\n" +
                "   \"photo\": null\n" +
                " },\n" +
                " {\n" +
                "   \"dietid\": 6,\n" +
                "   \"name\": \"Pescetarian\",\n" +
                "   \"photo\": null\n" +
                " },\n" +
                " {\n" +
                "   \"dietid\": 7,\n" +
                "   \"name\": \"Paleo\",\n" +
                "   \"photo\": null\n" +
                " },\n" +
                " {\n" +
                "   \"dietid\": 8,\n" +
                "   \"name\": \"Primal\",\n" +
                "   \"photo\": null\n" +
                " },\n" +
                " {\n" +
                "   \"dietid\": 9,\n" +
                "   \"name\": \"Whole30\",\n" +
                "   \"photo\": null\n" +
                " },\n" +
                " {\n" +
                "   \"dietid\": 10,\n" +
                "   \"name\": \"Lactose-free\",\n" +
                "   \"photo\": null\n" +
                " }\n" +
                "]";
        return body;
    }

    public static String defaultMeals() {
        String body = "[\n" +
                " {\n" +
                "   \"mealId\": \"1\",\n" +
                "   \"name\": \"Orecchiette\",\n" +

                "   \"category\": \"\",\n" +
                "   \"preptime\": 45,\n" +
                "   \"servings\": 2,\n" +
                "   \"calories\": 2000,\n" +
                "   \"ingredient\": \"...\",\n" +
                "   \"diet\": \"2,3,10\",\n" +
                "   \"photo\": \"...\",\n" +
                "   \"url\": \"https://www.bing.com/th?id=AMMS_e9d758c253a0c9264d028db116575b97&w=197&h=118&c=7&rs=2&qlt=80&o=6&cdv=1&pid=16.1\"\n" +
                " },\n" +
                " {\n" +
                "   \"mealId\": \"1\",\n" +
                "   \"name\": \"Macaroni and Cheese\",\n" +
                "   \"shortdesc\": \"\",\n" +
                "   \"longdesc\": null,\n" +
                "   \"category\": null,\n" +
                "   \"preptime\": 50,\n" +
                "   \"servings\": 4,\n" +
                "   \"calories\": 500,\n" +
                "   \"ingredient\": \"...\",\n" +
                "   \"diet\": \"\",\n" +
                "   \"photo\": \"...\",\n" +
                "   \"url\": \"https://www.bing.com/th?id=OIP.EAIuPWN5-oaxOcsnv3-eUwHaE8&w=225&h=160&c=8&rs=1&qlt=90&o=6&pid=3.1&rm=2\"\n" +
                " },\n" +
                " {\n" +
                "   \"mealId\": \"1\",\n" +
                "   \"name\": \"Caribbean Grill\",\n" +
                "   \"shortdesc\": \"\",\n" +
                "   \"longdesc\": \"\",\n" +
                "   \"category\": \"\",\n" +
                "   \"preptime\": 33,\n" +
                "   \"servings\": 4,\n" +
                "   \"calories\": 1750,\n" +
                "   \"ingredient\": \"\",\n" +
                "   \"diet\": \"1,2\",\n" +
                "   \"photo\": \"...\",\n" +
                "   \"url\": \"https://www.bing.com/th?id=AMMS_18cf7b983460bf476310fe26d8c8d889&w=164&h=164&c=7&rs=2&qlt=80&o=6&cdv=1&pid=16.1\"\n" +
                " }\n" +

                "]";
        return body;
    }
}
