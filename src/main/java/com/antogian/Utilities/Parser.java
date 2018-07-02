package com.antogian.Utilities;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.FileReader;
import java.util.Set;

public final class Parser
{
    public static JsonObject generateJsonFromFile(String jsonFilePath)
    {
        try
        {
            Gson gson = new Gson();
            File jsonFile = new File(jsonFilePath);
            JsonObject jsonObject = gson.fromJson(new FileReader(jsonFile), JsonObject.class);
            return jsonObject;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return new JsonObject();
    }

    public static JsonArray getJsonArray(JsonObject jsonObject, String jsonFilename)
    {
        /*JsonArray arrayNode;
        try
        {
            arrayNode = jsonObject.getAsJsonObject("NewDataSet").getAsJsonArray(jsonFilename + ".xml");
            if (arrayNode.size() > 0)
            {
                return arrayNode;
            }
        }
        catch(Exception e)
        {
            try
            {
                arrayNode = jsonObject.getAsJsonObject("NewDataSet").getAsJsonArray(jsonFilename + ".XML");
                if (arrayNode.size() > 0)
                {
                    return arrayNode;
                }
            }
            catch(Exception ex)
            {
                try
                {
                    arrayNode = jsonObject.getAsJsonObject("myDataSet").getAsJsonArray("myDataTable");
                    if (arrayNode.size() > 0)
                    {
                        return arrayNode;
                    }
                }
                catch(Exception exc)
                {
                    System.out.println(e.getMessage());
                }
            }
        }
        return new JsonArray();*/
        try
        {
            Set<String> keySet = jsonObject.keySet();
            String[] allKeys = keySet.toArray(new String[keySet.size()]);
            JsonObject objectNode = jsonObject.getAsJsonObject(allKeys[0]);
            keySet = objectNode.keySet();
            allKeys = keySet.toArray(new String[keySet.size()]);
            JsonArray arrayNode = objectNode.getAsJsonArray(allKeys[0]);
            //String arrayKey = allJsonKeys.ge
            return arrayNode;
        }
        catch(Exception e)
        {
            System.out.println("!!! Something is wrong with file " + jsonFilename);
            return new JsonArray();
        }
    }
}
