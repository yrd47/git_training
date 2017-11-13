package xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XPathParserDemo {

	public static void main(String[] args) {
		try {
			File inputFile = new File("input.txt");
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(inputFile);
			document.getDocumentElement().normalize();
			
			XPath xPath = XPathFactory.newInstance().newXPath();
			
			String expression = "/class/student";
			NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);
			
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				System.out.println("\nCurrent Element : " + node.getNodeName());
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					System.out.println("Student roll no : " + element.getAttribute("rollno"));
					System.out.println("First Name : " + element.getElementsByTagName("firstname").item(0).getTextContent());
					System.out.println("Last Name : " + element.getElementsByTagName("lastname").item(0).getTextContent());
					System.out.println("Nick Name : " + element.getElementsByTagName("nickname").item(0).getTextContent());
					System.out.println("Marks : " + element.getElementsByTagName("marks").item(0).getTextContent());					
				}
			}
		} catch (Exception e) {
			
		}
	}
}
