package com.generation.json;




import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.generation.json.model.Contract;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@SpringBootApplication
public class JsonApplication {

	public static void main(String[] args)  {
		SpringApplication.run(JsonApplication.class, args);
		
		//new Pdf("teste");
		
		/*try {
            // Criar um documento PDF
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("teste.pdf"));
            document.open();

            // Exemplo de JSON com estrutura aninhada
            String jsonString = "{\"appendixes\": [{\"title\": \"Partes\", \"items\": [" +
                    "{\"content\": \"Inquilino(s): Neuber Oliveira, RG: 123.456.789-10, CPF: 470.634.960-50, Dev, Estado Civil: Casado\"}," +
                    "{\"content\": \"Locador(es): Nathan Gabriel, RG: 987.654.321-0, CPF: 938.617.580-08, Dev, Estado Civil: solteiro\"}" +
                    "]}]}";

            // Analisar o JSON usando JSON-Simple
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(jsonString);
            JSONArray appendixes = (JSONArray) jsonObject.get("appendixes");

            for (int i = 0; i < appendixes.size(); i++) {
                JSONObject appendix = (JSONObject) appendixes.get(i);
                String title = (String) appendix.get("title");
                JSONArray items = (JSONArray) appendix.get("items");

                // Adicionar título ao PDF
                Paragraph titleParagraph = new Paragraph(title);
                document.add(titleParagraph);

                // Adicionar itens ao PDF
                for (int j = 0; j < items.size(); j++) {
                    JSONObject item = (JSONObject) items.get(j);
                    String content = (String) item.get("content");

                    // Adicionar conteúdo ao PDF
                    Paragraph contentParagraph = new Paragraph(content);
                    document.add(contentParagraph);
                }
            }

            // Fechar o documento
            document.close();
            System.out.println("PDF criado com sucesso.");
        } catch (Exception e) {
        	 e.printStackTrace();
	}*/try {
        // Passo 1: Ler o arquivo JSON
        ObjectMapper objectMapper = new ObjectMapper();
        Contract contract = objectMapper.readValue(new File("contract.json"), Contract.class);

        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("output.pdf"));
        document.open();

        String name = contract.getNome();
        document.add(new Paragraph("Nome: " + name));
        String age = contract.getIdade();
        document.add(new Paragraph("Idade: " + age));
        

      
        document.close();
    } catch (IOException | DocumentException e) {
        e.printStackTrace();
    }

	}
}
