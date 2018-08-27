package com.antogian.Utilities;

import com.antogian.Entities.Item;
import com.antogian.Entities.Modifier;
import com.antogian.Entities.Size;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.File;
import java.util.*;

public final class ItemsFactory
{
    public static List<Item> getAllItems(String itemsJSONPath, List<Size> sizeList, List<Modifier> modsList)
    {
        List<Item> allItems = new ArrayList<Item>();
        try
        {
            File folder = new File(itemsJSONPath);
            File[] listOfFiles = folder.listFiles();
            for(int i = 0; i < listOfFiles.length; i++)
            {
                String filename = listOfFiles[i].getName();
                if(filename.endsWith(".json") || filename.endsWith(".JSON"))
                {
                    String jsonFilePath = folder.getAbsolutePath() + "\\" + filename;
                    String jsonFilename = filename.substring(0, filename.lastIndexOf('.'));

                    JsonObject jsonObject = Parser.generateJsonFromFile(jsonFilePath);
                    //JsonArray arrayNode = jsonObject.entrySet("Col2", jsonObject);
                    JsonArray arrayNode = Parser.getJsonArray(jsonObject, jsonFilename);

                    for(int j=1; j<arrayNode.size(); j++)
                    {
                        Item itemRow = new Item();
                        itemRow.setFilename(jsonFilename);
                        JsonElement elementNode = arrayNode.get(j);
                        JsonObject objectNode = elementNode.getAsJsonObject();
                        String name = objectNode.get("Col2").getAsString();
                        if(name == null || name.equals(""))
                            continue;
                        itemRow.setName(name);
                        int index = objectNode.get("Col5").getAsInt();
                        itemRow.setIndex(index);
                        int[][] inclusions = new int[6][];
                        String inclusions1 = objectNode.get("Col16").getAsString();
                        inclusions[0] = getInclusionsAsArray(inclusions1);
                        String inclusions2 = objectNode.get("Col17").getAsString();
                        inclusions[1] = getInclusionsAsArray(inclusions2);
                        String inclusions3 = objectNode.get("Col18").getAsString();
                        inclusions[2] = getInclusionsAsArray(inclusions3);
                        String inclusions4 = objectNode.get("Col19").getAsString();
                        inclusions[3] = getInclusionsAsArray(inclusions4);
                        String inclusions5 = objectNode.get("Col20").getAsString();
                        inclusions[4] = getInclusionsAsArray(inclusions5);
                        String inclusions6 = objectNode.get("Col21").getAsString();
                        inclusions[5] = getInclusionsAsArray(inclusions6);
                        itemRow.setInclusions(inclusions);

                        int[] freeChoices = new int[6];
                        int[] requiredChoices = new int[6];
                        for(int x=0; x<5; x++)
                        {
                            String jsonChoices = objectNode.get("Col" +(28+x)).getAsString();
                            int[] choices = getChoices(jsonChoices);
                            requiredChoices[x] = choices[0];
                            freeChoices[x] = choices[1];
                        }
                        itemRow.setRequiredModEntries(requiredChoices);
                        itemRow.setFreeModEntries(freeChoices);

                        double[] cost = new double[5];
                        for(int x=0; x<5; x++)
                        {
                            String costString = objectNode.get("Col4" + x).getAsString();
                            if(!(costString == null || costString.equals("")))
                                cost[x] = objectNode.get("Col4" + x).getAsDouble();
                        }
                        itemRow.setCost(cost);

                        List<Modifier> itemMods = new ArrayList<Modifier>();
                        for(int k=1; k<=6; k++)
                        {
                            int modIndex = 21+k;
                            String modName = objectNode.get("Col" + modIndex).getAsString();
                            itemMods.add(getModifier(modName, modsList));
                        }
                        itemRow.setModifiers(itemMods);

                        String sizeFilename = objectNode.get("Col6").getAsString();
                        if(!(sizeFilename == null || sizeFilename.equalsIgnoreCase("")))
                        {
                            itemRow.setSize(getSize(sizeFilename, sizeList));
                        }

                        allItems.add(itemRow);
                    }
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("WARNING!!! EXCEPTION CAUGHT on while generating Items");
        }
        return allItems;
    }

    private static int[] getChoices(String jsonChoices)
    {
        int[] choices = new int[2];

        if(!(jsonChoices == null || jsonChoices.equalsIgnoreCase("")))
        {
            jsonChoices = jsonChoices.replaceAll("[^0-9]", "");
            int requiredChoice = Character.getNumericValue(jsonChoices.charAt(0));
            int freeChoice = Character.getNumericValue(jsonChoices.charAt(2));
            choices[0] = requiredChoice;
            choices[1] = freeChoice;
        }
        return choices;
    }

    private static List<Integer> getInclusions(String jsonInclusions)
    {
        List<Integer> inclusions = new ArrayList<Integer>();
        if(!(jsonInclusions == null || jsonInclusions.equals("")))
        {
            jsonInclusions = jsonInclusions.replaceAll("[^0-9]","");
            for(int i=0; i<jsonInclusions.length(); i++)
            {
                int newInclusion = Character.getNumericValue(jsonInclusions.charAt(i));
                inclusions.add(newInclusion);
            }
            return inclusions;
        }
        return inclusions;
    }

    private static int[] getInclusionsAsArray(String jsonInclusions)
    {
        if(!(jsonInclusions == null || jsonInclusions.equals("") || !jsonInclusions.matches(".*\\d+.*")))
        {
                String[] parts = jsonInclusions.split(",");
                List<Integer> ints = new ArrayList<Integer>();
                for (int i = 0; i < parts.length; i++)
                {
                    if(!(parts[i] == null || parts[i].equals("") || !parts[i].matches(".*\\d+.*")))
                    {
                        ints.add(Integer.parseInt(parts[i]));
                    }
                }
                int[] integers = new int[ints.size()];
                for (int i = 0; i < ints.size(); i++)
                {
                    integers[i] = ints.get(i);
                }
                return integers;
        }
        return new int[0];
    }

    private static Modifier getModifier(String modString, List<Modifier> allMods)
    {
        if(modString == null || modString.equalsIgnoreCase(""))
            return new Modifier();
        modString = modString.substring(0, modString.lastIndexOf('.'));
        for(int i=0; i<allMods.size(); i++)
        {
            if(allMods.get(i).getFilename().equalsIgnoreCase(modString))
            {
                return allMods.get(i);
            }
        }
        return new Modifier();
    }

    private static Size getSize(String sizeString, List<Size> allSizes)
    {
        if(sizeString == null || sizeString.equalsIgnoreCase(""))
            return new Size();
        sizeString = sizeString.substring(0, sizeString.lastIndexOf('.'));
        for(int i=0; i<allSizes.size(); i++)
        {
            if(allSizes.get(i).getFilename().equalsIgnoreCase(sizeString))
            {
                return allSizes.get(i);
            }
        }
        return new Size();
    }

}
