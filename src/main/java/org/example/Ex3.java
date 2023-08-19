package org.example;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://jsonplaceholder.typicode.com/users/1/todos");
        Scanner scanner = new Scanner(url.openStream());
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNext()) {
            sb.append(scanner.nextLine());
        }
        scanner.close();

        Gson gson = new Gson();
        List<Map<String, Object>> todos = gson.fromJson(sb.toString(), List.class);

        for (Map<String, Object> todo : todos) {
            if (!(Boolean) todo.get("completed")) {
                System.out.println(todo.get("title"));
            }
        }
    }
}
