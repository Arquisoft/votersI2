package es.uniovi.asw.dbmanagement.persistence.util;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Jpa {
    private static EntityManagerFactory emf = null;
    private static ThreadLocal<EntityManager> emThread =
            new ThreadLocal<>();

    public static EntityManager createEntityManager() {
        EntityManager entityManager = getEmf().createEntityManager();
        emThread.set(entityManager);
        return entityManager;
    }

    public static EntityManager getManager() {
        return emThread.get();
    }

    private static EntityManagerFactory getEmf() {
        if (emf == null) {
            String persistenceUnitName = loadPersistentUnitName();
            emf = Persistence.createEntityManagerFactory(persistenceUnitName);
        }
        return emf;
    }

    private static String loadPersistentUnitName() {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(
                    Jpa.class.getResourceAsStream("/META-INF/persistence.xml"));

            doc.getDocumentElement().normalize();
            NodeList nl = doc.getElementsByTagName("persistence-unit");

            return ((Element) nl.item(0)).getAttribute("name");

        } catch (ParserConfigurationException | SAXException | IOException e1) {
            throw new RuntimeException(e1);
        }
    }
}
