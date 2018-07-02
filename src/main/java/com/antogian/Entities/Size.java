package com.antogian.Entities;

public class Size
{
    private String filename;
    private String[] names;

    public Size()
    {
    }

    public Size(String filename, String[] names)
    {
        this.filename = filename;
        this.names = names;
    }

    public String getFilename()
    {
        return filename;
    }

    public void setFilename(String filename)
    {
        this.filename = filename;
    }

    public String[] getNames()
    {
        return names;
    }

    public void setNames(String[] names)
    {
        this.names = names;
    }
}
