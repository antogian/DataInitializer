package com.antogian.Entities;

public class ModEntry
{
    private String name;
    private double cost;
    private int index;

    public ModEntry()
    {
        name = "";
        cost = 0.00;
    }

    public ModEntry(String name, double cost)
    {
        this.name = name;
        this.cost = cost;
    }

    public int getIndex()
    {
        return index;
    }

    public void setIndex(int index)
    {
        this.index = index;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getCost()
    {
        return cost;
    }

    public void setCost(double cost)
    {
        this.cost = cost;
    }
}
