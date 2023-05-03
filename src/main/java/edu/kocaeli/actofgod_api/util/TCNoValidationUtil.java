package edu.kocaeli.actofgod_api.util;

import edu.kocaeli.actofgod_api.dto.user.TcNoValidateDto;
import lombok.experimental.UtilityClass;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@UtilityClass
public class TCNoValidationUtil {
    public boolean validate(TcNoValidateDto dto) {
        try {
            URL url = new URL("https://tckimlik.nvi.gov.tr/Service/KPSPublic.asmx");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
            con.setRequestProperty("SOAPAction", "http://tckimlik.nvi.gov.tr/WS/TCKimlikNoDogrula");
            String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
                    "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" " +
                    "xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" " +
                    "xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">" +
                    "<soap:Body>" +
                    "<TCKimlikNoDogrula xmlns=\"http://tckimlik.nvi.gov.tr/WS\">" +
                    "<TCKimlikNo>" + dto.getTcNo() + "</TCKimlikNo>" +
                    "<Ad>" + dto.getFirstName() + "</Ad>" +
                    "<Soyad>" + dto.getLastName() + "</Soyad>" +
                    "<DogumYili>" + dto.getBirthYear() + "</DogumYili>" +
                    "</TCKimlikNoDogrula>" +
                    "</soap:Body>" +
                    "</soap:Envelope>";
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(xml);
            wr.flush();
            wr.close();
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(con.getInputStream());
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("TCKimlikNoDogrulaResult");
            Node nNode = nList.item(0);
            String result = nNode.getTextContent().trim();
            return result.equals("true");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
