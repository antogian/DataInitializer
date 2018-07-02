package com.antogian.Utilities;

import com.antogian.Entities.Size;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SizesFactory
{
    public static List<Size> getAllSizes(String sizesJSONPath)
    {
        List<Size> allSizes = new ArrayList<Size>();

        try
        {
            File folder = new File(sizesJSONPath);
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
                    Size newSize = new Size();
                    newSize.setFilename(jsonFilename);
                    String[] allNames = new String[5];
                    for (int j = 1; j < arrayNode.size(); j++)
                    {
                        JsonElement elementNode = arrayNode.get(j);
                        JsonObject objectNode = elementNode.getAsJsonObject();
                        String name = objectNode.get("Col2").getAsString();
                        if(name == null || name.equals(""))
                            continue;
                        allNames[j-1] = name;
                    }
                    newSize.setNames(allNames);
                    allSizes.add(newSize);
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("!!! Something is wrong with Size files or folder.");
        }

        return allSizes;
    }
}
