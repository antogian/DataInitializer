package com.antogian.Entities;

import java.util.List;

public class Item
{
    private String filename;
    private String name;
    private int index;
    private List<Double> cost;
    private Size size;
    private List<Modifier> modifiers;
    private List<Integer> freeModEntries;
    private List<Integer> inclusions1;
    private List<Integer> inclusions2;
    private List<Integer> inclusions3;
    private List<Integer> inclusions4;
    private List<Integer> inclusions5;
    private List<Integer> inclusions6;
    private List<Integer> requiredModEntries;
    private boolean taxable;

    public Item()
    {
    }

    public Item(String filename, String name, List<Double> cost, Size size, List<Modifier> modifiers, List<Integer> freeModEntries,
                List<Integer> requiredModEntries)
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

    public List<Double> getCost()
    {
        return cost;
    }

    public void setCost(List<Double> cost)
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

    public List<Integer> getFreeModEntries()
    {
        return freeModEntries;
    }

    public void setFreeModEntries(List<Integer> freeModEntries)
    {
        this.freeModEntries = freeModEntries;
    }

    public List<Integer> getRequiredModEntries()
    {
        return requiredModEntries;
    }

    public void setRequiredModEntries(List<Integer> requiredModEntries)
    {
        this.requiredModEntries = requiredModEntries;
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

    public boolean isTaxable()
    {
        return taxable;
    }

    public void setTaxable(boolean taxable)
    {
        this.taxable = taxable;
    }
}
