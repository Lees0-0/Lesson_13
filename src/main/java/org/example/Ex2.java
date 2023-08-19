package org.example;

import com.google.gson.Gson;

import com.google.gson.JsonObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.FileOutputStream;
import java.io.IOException;


public class Ex2 extends Ex1 {
        public static void saveComments(int userId) throws IOException {

            String userPostsUrl = "https://jsonplaceholder.typicode.com/users/1/posts";

            Document userPostsDocument = Jsoup.connect(userPostsUrl)
                    .ignoreContentType(true)
                    .get();

            String userPostsJson = userPostsDocument.body().text();

            JsonObject[] userPosts = new Gson().fromJson(userPostsJson, JsonObject[].class);

            if (userPosts.length > 0) {
                JsonObject latestPost = userPosts[userPosts.length - 1];
                int postId = latestPost.get("id").getAsInt();

                String postCommentsUrl = "https://jsonplaceholder.typicode.com/posts/" + postId + "/comments";

                Document postCommentsDocument = Jsoup.connect(postCommentsUrl)
                        .ignoreContentType(true)
                        .get();

                String postCommentsJson = postCommentsDocument.body().text();

                try (FileOutputStream fileOutputStream = new FileOutputStream("./files/user-X-post-Y-comments.json")) {
                    fileOutputStream.write(postCommentsJson.getBytes());
                }
            }
        }

        public static void main(String[] args) throws IOException {
            int userId = 1;
            saveComments(userId);
        }
}
