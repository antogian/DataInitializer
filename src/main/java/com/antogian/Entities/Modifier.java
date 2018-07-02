package com.antogian.Entities;

import java.util.List;

public class Modifier
{
    private String filename;
    private String name;
    private List<ModEntry> entries;
    private boolean isPlatter = false;
    private double platterPrice = 0.0;
    private boolean halfEnabled = false;
    private boolean qualifiersEnabled = true;

    public Modifier()
    {
    }

    public Modifier(String filename, String name, List<ModEntry> entries, boolean isPlatter, double platterPrice,
                    boolean halfEnabled, boolean qualifiersEnabled)
    {
        this.filename = filename;
        this.name = name;
        this.entries = entries;
        this.isPlatter = isPlatter;
        this.platterPrice = platterPrice;
        this.halfEnabled = halfEnabled;
        this.qualifiersEnabled = qualifiersEnabled;
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

    public List<ModEntry> getEntries()
    {
        return entries;
    }

    public void setEntries(List<ModEntry> entries)
    {
        this.entries = entries;
    }

    public boolean isPlatter()
    {
        return isPlatter;
    }

    public void setPlatter(boolean platter)
    {
        isPlatter = platter;
    }

    public double getPlatterPrice()
    {
        return platterPrice;
    }

    public void setPlatterPrice(double platterPrice)
    {
        this.platterPrice = platterPrice;
    }

    public boolean isHalfEnabled()
    {
        return halfEnabled;
    }

    public void setHalfEnabled(boolean halfEnabled)
    {
        this.halfEnabled = halfEnabled;
    }

    public boolean isQualifiersEnabled()
    {
        return qualifiersEnabled;
    }

    public void setQualifiersEnabled(boolean qualifiersEnabled)
    {
        this.qualifiersEnabled = qualifiersEnabled;
    }
}
