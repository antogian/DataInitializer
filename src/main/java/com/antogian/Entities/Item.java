package com.antogian.Entities;

import java.util.List;

public class Item
{
    private String filename;
    private String name;
    private double[] cost;
    private Size size;
    private List<Modifier> modifiers;
    private List<Integer> inclusions1;
    private List<Integer> inclusions2;
    private List<Integer> inclusions3;
    private List<Integer> inclusions4;
    private List<Integer> inclusions5;
    private List<Integer> inclusions6;
    private int[] freeModEntries;
    private int[] requiredModEntries;

    public Item()
    {
    }

    public Item(String filename, String name, double[] cost, Size size, List<Modifier> modifiers,
                List<Integer> inclusions1, List<Integer> inclusions2, List<Integer> inclusions3,
                List<Integer> inclusions4, List<Integer> inclusions5, List<Integer> inclusions6,
                int[] freeModEntries, int[] requiredModEntries)
    {
        this.filename = filename;
        this.name = name;
        this.cost = cost;
        this.size = size;
        this.modifiers = modifiers;
        this.inclusions1 = inclusions1;
        this.inclusions2 = inclusions2;
        this.inclusions3 = inclusions3;
        this.inclusions4 = inclusions4;
        this.inclusions5 = inclusions5;
        this.inclusions6 = inclusions6;
        this.freeModEntries = freeModEntries;
        this.requiredModEntries = requiredModEntries;
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

    public List<Integer> getInclusions1()
    {
        return inclusions1;
    }

    public void setInclusions1(List<Integer> inclusions1)
    {
        this.inclusions1 = inclusions1;
    }

    public List<Integer> getInclusions2()
    {
        return inclusions2;
    }

    public void setInclusions2(List<Integer> inclusions2)
    {
        this.inclusions2 = inclusions2;
    }

    public List<Integer> getInclusions3()
    {
        return inclusions3;
    }

    public void setInclusions3(List<Integer> inclusions3)
    {
        this.inclusions3 = inclusions3;
    }

    public List<Integer> getInclusions4()
    {
        return inclusions4;
    }

    public void setInclusions4(List<Integer> inclusions4)
    {
        this.inclusions4 = inclusions4;
    }

    public List<Integer> getInclusions5()
    {
        return inclusions5;
    }

    public void setInclusions5(List<Integer> inclusions5)
    {
        this.inclusions5 = inclusions5;
    }

    public List<Integer> getInclusions6()
    {
        return inclusions6;
    }

    public void setInclusions6(List<Integer> inclusions6)
    {
        this.inclusions6 = inclusions6;
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
}
