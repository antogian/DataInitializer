package com.antogian.Utilities;

import com.antogian.Entities.ModEntry;
import com.antogian.Entities.Modifier;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class ModifiersFactory
{
    public static List<Modifier> getAllModifiers(String modsJSONPath)
    {
        List<Modifier> allMods = new ArrayList<Modifier>();
        try
        {
            File folder = new File(modsJSONPath);
            File[] listOfFiles = folder.listFiles();
            for(int i = 0; i < listOfFiles.length; i++)
            {
                String filename = listOfFiles[i].getName();
                if(filename.endsWith(".json") || filename.endsWith(".JSON"))
                {
                    String jsonFilePath = folder.getAbsolutePath() + "\\" + filename;
                    String jsonFilename = filename.substring(0, filename.lastIndexOf('.'));

                    JsonObject jsonObject = Parser.generateJsonFromFile(jsonFilePath);
                    JsonArray arrayNode = Parser.getJsonArray(jsonObject, jsonFilename);

                    //Generation of Mod entries for each row
                    List<ModEntry> allModEntries = new ArrayList<ModEntry>();
                    for(int j=11; j<arrayNode.size(); j++)
                    {
                        try
                        {
                            ModEntry modEntry = new ModEntry();
                            JsonElement elementNode = arrayNode.get(j);
                            JsonObject objectNode = elementNode.getAsJsonObject();
                            String name = objectNode.get("Col2").getAsString();
                            if(name == null || name.equals(""))
                                continue;
                            modEntry.setName(name);
                            String price = objectNode.get("Col19").getAsString();
                            if(!(price == null || price.equals("")))
                                modEntry.setCost(objectNode.get("Col19").getAsDouble());
                            if(!isDuplicate(allModEntries, modEntry))
                                allModEntries.add(modEntry);
                        }
                        catch(Exception e)
                        {
                            System.out.println("Something is wrong with the " + j + " Entry of Modifier file " + jsonFilename);
                            continue;
                        }
                    }
                    try
                    {
                        //Generation of Modifier objects
                        Modifier mod = new Modifier();
                        mod.setFilename(jsonFilename);
                        mod.setEntries(allModEntries);
                        JsonObject objectNode = arrayNode.get(2).getAsJsonObject();
                        mod.setName(objectNode.get("Col2").getAsString());
                        objectNode = arrayNode.get(3).getAsJsonObject();
                        String halfEnabled = objectNode.get("Col2").getAsString();
                        if(halfEnabled == null || halfEnabled.equalsIgnoreCase(""))
                            mod.setHalfEnabled(false);
                        objectNode = arrayNode.get(5).getAsJsonObject();
                        String qualifier = objectNode.get("Col2").getAsString();
                        if(qualifier == null || qualifier.equalsIgnoreCase(""))
                            mod.setQualifiersEnabled(true);

                        allMods.add(mod);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Something is wrong with the Modifier file named " + jsonFilename);
                        continue;
                    }
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("WARNING!!! EXCEPTION CAUGHT on getAllModifiers Method");
        }
        return allMods;
    }

    private static boolean isDuplicate(List<ModEntry> allMods, ModEntry newMod)
    {
        for(int i=0; i < allMods.size(); i++)
        {
            if(allMods.get(i).getName().equalsIgnoreCase(newMod.getName()))
                return true;
        }
        return false;
    }

}
