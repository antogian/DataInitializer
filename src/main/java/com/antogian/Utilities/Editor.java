package com.antogian.Utilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONObject;
import org.json.XML;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

public final class Editor
{
    public static void toJSON(String sourcePath, String resultPath)
    {
        int PRETTY_PRINT_INDENT_FACTOR = 4;

        File folder = new File(sourcePath);
        File[] listOfFiles = folder.listFiles();
        for(int i = 0; i < listOfFiles.length; i++)
        {
            String filename = listOfFiles[i].getName();
            if(filename.endsWith(".xml")||filename.endsWith(".XML"))
            {
                String xmlString;
                JSONObject xmlJSONObj;

                String xmlFile = folder.getAbsolutePath() + "\\" + filename;

                fixXMLEncoding(xmlFile);

                try
                {
                    xmlString = new String(Files.readAllBytes(Paths.get(xmlFile)));

                    xmlJSONObj = XML.toJSONObject(xmlString);

                    String jsonFilename = filename;
                    String jsonFile = resultPath + filename.substring(0, jsonFilename.lastIndexOf('.')) + ".json";

                    FileWriter fileWriter = new FileWriter(jsonFile);
                    String str = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
                    fileWriter.write(str);
                    fileWriter.close();

                    System.out.println(1+i + " of " + listOfFiles.length +  " files completed.");
                }
                catch(Exception e)
                {
                    System.out.println("Exception was thrown at toJSON Method.");
                }
            }
        }
    }

    private static void fixXMLEncoding(String filepath)
    {
        try
        {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(filepath);

            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

            StreamResult result = new StreamResult(new File(filepath));
            DOMSource source = new DOMSource(doc);
            transformer.transform(source, result);
        }
        catch(Exception e)
        {
            System.out.println("Exception was caught at fixXMLEncoding Method.");
        }

    }

    public static void writeJsonToFile(String absPath, String json)
    {
        try
        {
            FileWriter fileWriter = new FileWriter(absPath);
            fileWriter.write(json);
            fileWriter.close();
        }
        catch(Exception e)
        {
            System.out.println("Exception was thrown at writeJsonToFile Method.");
        }
    }
}
