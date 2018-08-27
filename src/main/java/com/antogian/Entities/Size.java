package com.antogian.Entities;

import java.util.List;

public class Size
{
    private String filename;
    private List<String> names;

    public Size()
    {
    }

    public Size(String filename, List<String> names)
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

    public List<String> getNames()
    {
        return names;
    }

    public void setNames(List<String> names)
    {
        this.names = names;
    }
}
