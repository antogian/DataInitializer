package com.antogian.Entities;

import java.util.ArrayList;
import java.util.List;

public class Category
{
    private String name;
    private List<Item> allItems;
    private int index;

    public Category()
    {
        name = "";
        allItems = new ArrayList<Item>();
    }

    public Category(String name, List<Item> allItems)
    {
        this.name = name;
        this.allItems = new ArrayList<Item>();
        this.allItems = allItems;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<Item> getAllItems()
    {
        return allItems;
    }

    public void setAllItems(List<Item> allItems)
    {
        this.allItems = allItems;
    }

    public int getIndex()
    {
        return index;
    }

    public void setIndex(int index)
    {
        this.index = index;
    }
}
