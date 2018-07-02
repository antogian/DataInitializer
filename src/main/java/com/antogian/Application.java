package com.antogian;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.antogian.Entities.Category;
import com.antogian.Entities.Item;
import com.antogian.Entities.Modifier;
import com.antogian.Entities.Size;
import com.antogian.Utilities.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class Application
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Hello World!");
        System.out.print("Press any key to PROCEED:");
        br.readLine();
        System.out.println("Please wait.............");

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("XML to JSON process is about begin.");
        System.out.println("-----------------------------------------------------------------------------------------");

        String basePath = "D:\\Documents\\AthenaPOS Files\\Italian Kitchen\\";

        String modsJSONPath = basePath + "JSON\\Modifier\\";
        String sizesJSONPath =  basePath + "JSON\\Size\\";
        String itemsJSONPath = basePath + "JSON\\Item\\";
        String catJSONPath = basePath + "JSON\\Category\\";
        //--------------------------------------------------------------------------------------------------------------
        String modsXMLPath = basePath + "XML\\Modifier\\";
        String sizesXMLPath = basePath + "XML\\Size\\";
        String itemsXMLPath = basePath + "XML\\Item\\";
        String catXMLPath = basePath + "XML\\Category\\";

        System.out.println("Accesing Modifier folder:");
        Editor.toJSON(modsXMLPath, modsJSONPath);
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Accesing Size folder:");
        Editor.toJSON(sizesXMLPath, sizesJSONPath);
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Accesing Item folder:");
        Editor.toJSON(itemsXMLPath, itemsJSONPath);
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Accesing Category folder:");
        Editor.toJSON(catXMLPath, catJSONPath);
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("XML to JSON process has finished.");
        System.out.println("-----------------------------------------------------------------------------------------");

        //--------------------------------------------------------------------------------------------------------------

        List<Modifier> allMods;
        allMods = ModifiersFactory.getAllModifiers(modsJSONPath);
        System.out.println("Total Modifiers are: " + allMods.size());

        List<Size> allSizes;
        allSizes = SizesFactory.getAllSizes(sizesJSONPath);
        System.out.println("Total Sizes are: " + allSizes.size());

        List<Item> allItems;
        allItems = ItemsFactory.getAllItems(itemsJSONPath, allSizes, allMods);
        System.out.println("Total Items are: " + countItems(allItems));

        List<Category> allCategories;
        allCategories = CategoriesFactory.getAllCategories(catJSONPath, allItems);
        System.out.println("Total Categories are: " + allCategories.size());

        Gson gson = new Gson();
        Type allDataJson = new TypeToken<List<Category>>(){}.getType();
        String s = gson.toJson(allCategories, allDataJson);
        String path = "D:\\Documents\\data.json";
        Editor.writeJsonToFile(path, s);
    }

    private static int countItems(List<Item> allItems)
    {
        List<String> filenames = new ArrayList<String>();

        for(Item item : allItems)
        {
            if(!filenames.contains(item.getFilename()))
                filenames.add(item.getFilename());
        }

        return filenames.size();
    }

}
