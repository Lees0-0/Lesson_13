package org.example;

import java.io.IOException;

public class Ex1Test extends Ex2 {
    public static void main(String[] args) throws IOException {
        String createdUser = "\"name\": \"Dmytro Zabolotniy\",\n" +
                "    \"username\": \"Moriah.Stanton\",\n" +
                "    \"email\": \"Rey.Padberg@karina.biz\",\n" +
                "    \"address\": {\n" +
                "        \"street\": \"Kattie Turnpike\",\n" +
                "        \"suite\": \"Suite 198\",\n" +
                "        \"city\": \"Lebsackbury\",\n" +
                "        \"zipcode\": \"31428-2261\",\n" +
                "        \"geo\": {\n" +
                "            \"lat\": \"-38.2386\",\n" +
                "            \"lng\": \"57.2232\"\n" +
                "        }\n" +
                "    },\n" +
                "    \"phone\": \"024-648-3804\",\n" +
                "    \"website\": \"ambrose.net\",\n" +
                "    \"company\": {\n" +
                "        \"name\": \"Hoeger LLC\",\n" +
                "        \"catchPhrase\": \"Centralized empowering task-force\",\n" +
                "        \"bs\": \"target end-to-end models\"\n" +
                "    }\n" +
                "}";
        createNewUser(createdUser);



        System.out.println("-------------------------------------");

        int userIdToUpdate = 1;
        String updatedJson = "\"name\": \"Anna Smishna\",\n" +
                "    \"username\": \"Moriah.Stanton\",\n" +
                "    \"email\": \"Rey.Padberg@karina.biz\",\n" +
                "    \"address\": {\n" +
                "        \"street\": \"Kattie Turnpike\",\n" +
                "        \"suite\": \"Suite 198\",\n" +
                "        \"city\": \"Lebsackbury\",\n" +
                "        \"zipcode\": \"31428-2261\",\n" +
                "        \"geo\": {\n" +
                "            \"lat\": \"-38.2386\",\n" +
                "            \"lng\": \"57.2232\"\n" +
                "        }\n" +
                "    },\n" +
                "    \"phone\": \"024-648-3804\",\n" +
                "    \"website\": \"ambrose.net\",\n" +
                "    \"company\": {\n" +
                "        \"name\": \"Hoeger LLC\",\n" +
                "        \"catchPhrase\": \"Centralized empowering task-force\",\n" +
                "        \"bs\": \"target end-to-end models\"\n" +
                "    }\n" +
                "}";
        updateExistingUser(userIdToUpdate, updatedJson);

        System.out.println("-------------------------------------");

        int userIdToDelete = 1;
        deleteUser(userIdToDelete);


        System.out.println("-------------------------------------");
        getAllUsers();


        System.out.println("-------------------------------------");
        getUserById(1);


        System.out.println("-------------------------------------");
        getUserByUsername("Moriah.Stanton");

        System.out.println("-------------------------------------");
    }
}
