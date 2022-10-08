package ru.vsu.cs.tarantsov;

//import ru.vsu.cs.tarantsov.parsers.JSONParser;
import ru.vsu.cs.tarantsov.parsers.Parser;
import ru.vsu.cs.tarantsov.parsers.XMLParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Main {

    public static void main(String[] args) {

        //String contentJSON = new String(Files.readAllBytes(Paths.get("Q:\\IDE saves\\task1 num.17\\src\\ru\\vsu\\cs\\tarantsov\\test.json")));






        Parser parserXML = new XMLParser();
        //Parser parserJSON = new JSONParser();
        parserXML.parse("<root>\n" +
                "    <name>test file</name>\n" +
                "    <people>\n" +
                "        <element>\n" +
                "            <age>21</age>\n" +
                "            <name>Ivan</name>\n" +
                "        </element>\n" +
                "        <element>\n" +
                "            <age>19</age>\n" +
                "            <name>Fedor</name>\n" +
                "        </element>\n" +
                "        <element>\n" +
                "            <age>13</age>\n" +
                "            <name>Vasiliy</name>\n" +
                "        </element>\n" +
                "        <element>\n" +
                "            <age>32</age>\n" +
                "            <name>John</name>\n" +
                "        </element>\n" +
                "    </people>\n" +
                "</root>");
        //parserJSON.parse(contentJSON);

    }
}

