package com.antogian.Entities;

import java.util.List;

public class ModEntry
{
    private String name;
    private int index;
    private List<Double> halfCost;
    private List<Double> cost;
    private boolean taxable;

    public ModEntry()
    {
    }

    public ModEntry(String name)
    {
        this.name = name;
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

    public List<Double> getCost()
    {
        return cost;
    }

    public void setCost(List<Double> cost)
    {
        this.cost = cost;
    }

    public List<Double> getHalfCost()
    {
        return halfCost;
    }

    public void setHalfCost(List<Double> halfCost)
    {
        this.halfCost = halfCost;
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
