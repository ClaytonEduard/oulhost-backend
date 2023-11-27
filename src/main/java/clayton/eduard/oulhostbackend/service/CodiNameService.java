package clayton.eduard.oulhostbackend.service;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import jakarta.annotation.PostConstruct;
import lombok.Getter;

@Service
@Getter
public class CodiNameService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private Environment env; // para acessar o application.proprerties

    private List<String> avangersCodiNameList = new ArrayList<>();
    private List<String> justiceLeagueList = new ArrayList<>();

    ObjectMapper objectMapper = new ObjectMapper();

    // * Metodo para ler api em JSON do UOL
    @PostConstruct // anotacao para fazer com que, toda vez que a aplicacao iniciar essa chaamda
                   // tambem ira ser iniciada
    public void loadJsonData() {
        try {

            String codiNameReponse = restTemplate.getForObject(env.getProperty("avangers"), String.class);
            JsonNode jsonNode = objectMapper.readTree(codiNameReponse);

            ArrayNode avangers = (ArrayNode) jsonNode.get("vingadores");

            for (JsonNode item : avangers) {
                this.avangersCodiNameList.add(item.get("codinome").asText());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // * Metodo para ler a api em XML do UOL
    @PostConstruct
    public void loadXmlData() {
        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(env.getProperty("justice.league"));

            NodeList codiNameList = document.getElementsByTagName("codinome");

            for (int i = 0; i < codiNameList.getLength(); i++) {
                Element codiNameElement = (Element) codiNameList.item(i);
                String codiname = codiNameElement.getTextContent();
                this.justiceLeagueList.add(codiname);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
