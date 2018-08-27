package com.antogian.Entities;

import java.util.List;

public class Item
{
    private String filename;
    private String name;
    private int index;
    private double[] cost;
    private Size size;
    private List<Modifier> modifiers;
    private int[] freeModEntries;
    private int[][] inclusions;
    private int[] requiredModEntries;

    public Item()
    {
    }

    public Item(String filename, String name, double[] cost, Size size, List<Modifier> modifiers, int[] freeModEntries,
                int[] requiredModEntries)
    {
        this.filename = filename;
        this.name = name;
        this.cost = cost;
        this.size = size;
        this.modifiers = modifiers;
        this.freeModEntries = freeModEntries;
        this.requiredModEntries = requiredModEntries;
    }

    public int getIndex()
    {
        return index;
    }

    public void setIndex(int index)
    {
        this.index = index;
    }

    public String getFilename()
    {
        return filename;
    }

    public void setFilename(String filename)
    {
        this.filename = filename;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double[] getCost()
    {
        return cost;
    }

    public void setCost(double[] cost)
    {
        this.cost = cost;
    }

    public Size getSize()
    {
        return size;
    }

    public void setSize(Size size)
    {
        this.size = size;
    }

    public List<Modifier> getModifiers()
    {
        return modifiers;
    }

    public void setModifiers(List<Modifier> modifiers)
    {
        this.modifiers = modifiers;
    }


    public int[] getFreeModEntries()
    {
        return freeModEntries;
    }

    public void setFreeModEntries(int[] freeModEntries)
    {
        this.freeModEntries = freeModEntries;
    }

    public int[] getRequiredModEntries()
    {
        return requiredModEntries;
    }

    public void setRequiredModEntries(int[] requiredModEntries)
    {
        this.requiredModEntries = requiredModEntries;
    }

    public int[][] getInclusions()
    {
        return inclusions;
    }

    public void setInclusions(int[][] inclusions)
    {
        this.inclusions = inclusions;
    }
}
