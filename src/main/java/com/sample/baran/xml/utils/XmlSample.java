package com.sample.baran.xml.utils;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.*;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Optional;

public class XmlSample {
    public static void main(String[] args) throws Exception {
        // Get DOM Node for XML
        String fileName = "employees.xml";
        Document document = getDocument(fileName);

        String xpathExpression = "";

        // Get all employee names
        xpathExpression = "/employees/employee/firstName";
        System.out.println(checkIfNodeExists(document, xpathExpression));   //true

        Document updateDocument = updateDocument(document, xpathExpression, "Abc");
        System.out.println(documentToString(updateDocument));

        // Get all employee ids
        xpathExpression = "/employees/employee/@id";

        checkIfNodeExists(document, xpathExpression);

        updateDocument = updateDocument(document, xpathExpression, "3");
        System.out.println(documentToString(updateDocument));

        // Get all employee age
        xpathExpression = "/employees/employee/@age";
        System.out.println(checkIfNodeExists(document, xpathExpression));   //false
        XPathDetails xPathDetails = addTagUsingXpath(document, xpathExpression, "myVal");

        System.out.println("Added :" + documentToString(addTagToDocument(document, xPathDetails)));


        // Get all department names
        xpathExpression = "/employees/employee/department/name";
        System.out.println(checkIfNodeExists(document, xpathExpression));   //true

        updateDocument = updateDocument(document, xpathExpression, "CS");
        System.out.println(documentToString(updateDocument));


        // Get department locations
        xpathExpression = "/employees/employee/department/location";
        System.out.println(checkIfNodeExists(document, xpathExpression));   //false


    }

    private static boolean checkIfNodeExists(Document document, String xpathExpression) throws Exception {
        boolean matches = false;

        // Create XPathFactory object
        XPathFactory xpathFactory = XPathFactory.newInstance();

        // Create XPath object
        XPath xpath = xpathFactory.newXPath();

        try {
            // Create XPathExpression object
            XPathExpression expr = xpath.compile(xpathExpression);

            // Evaluate expression result on XML document
            NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);

            if (nodes != null && nodes.getLength() > 0) {
                matches = true;
            }

        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return matches;
    }

    private static Document getDocument(String fileName) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(fileName);
        return doc;
    }

    private static Document updateDocument(Document document, String xpathExpression, String value) {
        System.out.println("XPath " + xpathExpression + " Value " + value);

        // Create XPathFactory object
        XPathFactory xpathFactory = XPathFactory.newInstance();

        // Create XPath object
        XPath xpath = xpathFactory.newXPath();

        try {
            // Create XPathExpression object
            XPathExpression expr = xpath.compile(xpathExpression);

            // Evaluate expression result on XML document
            NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);

            if (nodes != null && nodes.getLength() > 0) {
                for (int i = 0; i < nodes.getLength(); i++) {
                    if (xpathExpression.contains("@")) {
                        nodes.item(i).setNodeValue(value);
                    } else {
                        nodes.item(i).setTextContent(value);
                    }
                }
            }

        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return document;
    }

    private static String documentToString(Document newDoc) throws Exception {
        DOMSource domSource = new DOMSource(newDoc);
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        StringWriter sw = new StringWriter();
        StreamResult sr = new StreamResult(sw);
        transformer.transform(domSource, sr);
        return sw.toString();
    }


    private static XPathDetails addTagUsingXpath(Document document, String xPath, String value) throws XPathExpressionException {
        System.out.println("FullXpath " + xPath);
        boolean isTag = true;
        String tagOrAttributeName = null;

        System.out.println("isTag " + isTag);
        int lastIndexOfSlash = xPath.lastIndexOf("/");

        if (xPath.contains("@")) {
            isTag = false;
            tagOrAttributeName = xPath.substring(lastIndexOfSlash + 2, xPath.length());
        }else{
            tagOrAttributeName = xPath.substring(lastIndexOfSlash + 1, xPath.length());
        }
        System.out.println("Tag name " + tagOrAttributeName);
        System.out.println("last index " + lastIndexOfSlash);
        String newXpath = xPath.substring(0, lastIndexOfSlash);
        System.out.println("Process for parent " + newXpath);

        return XPathDetails.builder().newXPath(newXpath).tagOrAttributeName(tagOrAttributeName).isTag(isTag).value(value).build();
    }

    public static Document addTagToDocument(Document document, XPathDetails details) {
        NodeList nodeList = getNodeListToAddTag(document, details.getNewXPath());
        for (int i = 0; i < nodeList.getLength(); i++) {
            if (details.isTag()) {
                Element childElement = document.createElement(details.getTagOrAttributeName());
                childElement.setTextContent(details.getValue());
                nodeList.item(i).appendChild(childElement);
            } else {
                ((Element) nodeList.item(i)).setAttribute(details.getTagOrAttributeName(), details.getValue());


            }
        }

        return document;
    }

    public static NodeList getNodeListToAddTag(Document document, String xpathExpression) {
        // Create XPathFactory object
        XPathFactory xpathFactory = XPathFactory.newInstance();

        // Create XPath object
        XPath xpath = xpathFactory.newXPath();
        NodeList nodes = null;
        try {
            // Create XPathExpression object
            XPathExpression expr = xpath.compile(xpathExpression);

            // Evaluate expression result on XML document
            nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);

        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return nodes;
    }

}

