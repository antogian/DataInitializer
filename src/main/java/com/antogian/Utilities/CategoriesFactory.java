package com.antogian.Utilities;

import com.antogian.Entities.Category;
import com.antogian.Entities.Item;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class CategoriesFactory
{
    public static List<Category> getAllCategories(String jsonPath, List<Item> allItems)
    {
        List<Category> allCategories = new ArrayList<Category>();
        try
        {
            File folder = new File(jsonPath);
            File[] listOfFiles = folder.listFiles();
            for(int i = 0; i < listOfFiles.length; i++)
            {
                String filename = listOfFiles[i].getName();
                if (filename.endsWith(".json") || filename.endsWith(".JSON"))
                {
                    String jsonFilePath = folder.getAbsolutePath() + "\\" + filename;
                    String jsonFilename = filename.substring(0, filename.lastIndexOf('.'));

                    JsonObject jsonObject = Parser.generateJsonFromFile(jsonFilePath);
                    JsonArray arrayNode = Parser.getJsonArray(jsonObject, jsonFilename);

                    for (int j = 1; j < arrayNode.size(); j++)
                    {
                        Category cat = new Category();
                        JsonElement elementNode = arrayNode.get(j);
                        JsonObject objectNode = elementNode.getAsJsonObject();
                        String name = objectNode.get("Col2").getAsString();
                        if(name == null || name.equals(""))
                            continue;
                        cat.setName(name);
                        String itemsFilename = objectNode.get("Col5").getAsString();
                        itemsFilename = itemsFilename.substring(0, itemsFilename.lastIndexOf('.'));
                        for(int k=0; k<allItems.size(); k++)
                            if(allItems.get(k).getFilename().equalsIgnoreCase(itemsFilename))
                                cat.getAllItems().add(allItems.get(k));
                        allCategories.add(cat);
                    }
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("WARNING!!! EXCEPTION CAUGHT on CategoriesFactory Method");
        }

        return allCategories;
    }
}
