package org.example;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;


public class Ex1 {
    static String baseUrl = "https://jsonplaceholder.typicode.com/users";

    public static void createNewUser(String createdUser) throws IOException {
        Connection.Response response = Jsoup.connect(baseUrl)
                .requestBody(createdUser)
                .followRedirects(false)
                .ignoreContentType(true)
                .method(Connection.Method.POST)
                .execute();

        int statusCode = response.statusCode();
        String responseBody = response.body();

        System.out.println("Status Code: " + statusCode);
        System.out.println("Response Body: " + responseBody);
    }

    public static void updateExistingUser(int userId, String updatedJson) throws IOException {
        String updateUserUrl = baseUrl + "/" + userId;

        Connection.Response response = Jsoup.connect(updateUserUrl)
                .requestBody(updatedJson)
                .followRedirects(false)
                .ignoreContentType(true)
                .method(Connection.Method.PUT)
                .execute();


        int statusCode = response.statusCode();

        System.out.println("Status Code: " + statusCode);

        String responseBody = response.body();

        System.out.println("Updated User Response Body: " + responseBody);
    }
    public static void deleteUser(int userId) throws IOException {
        String deleteUserUrl = baseUrl + "/" + userId;

        Connection.Response response = Jsoup.connect(deleteUserUrl)
                .followRedirects(false)
                .ignoreContentType(true)
                .method(Connection.Method.DELETE)
                .execute();

        int statusCode = response.statusCode();

        System.out.println("Delete User Status Code: " + statusCode);
    }
    public static void getAllUsers() throws IOException {
        Document document = Jsoup.connect(baseUrl)
                .ignoreContentType(true)
                .get();

        String responseBody = document.body().text();

        System.out.println("All Users: " + responseBody);
    }
    public static void getUserById(int userId) throws IOException {
        String getUserUrl = baseUrl + "/" + userId;

        Document document = Jsoup.connect(getUserUrl)
                .ignoreContentType(true)
                .get();

        String responseBody = document.body().text();

        System.out.println("User by ID " + userId + ": " + responseBody);
    }
    public static void getUserByUsername(String username) throws IOException {
        String getUserByUsernameUrl = baseUrl + "?username=" + username;

        Document document = Jsoup.connect(getUserByUsernameUrl)
                .ignoreContentType(true)
                .get();

        String responseBody = document.body().text();

        System.out.println("User by Username " + username + ": " + responseBody);
    }
}