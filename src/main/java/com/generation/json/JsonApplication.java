package com.generation.json;



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;






@SpringBootApplication
public class JsonApplication {

	public static void main(String[] args)  {
		SpringApplication.run(JsonApplication.class, args);
		
		//new Pdf("teste");
		
		try {
            // Passo 1: Ler o arquivo JSON
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(new File("contract.json"));

            // Passo 2: Inicializar o documento PDF
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("output.pdf"));
            document.open();

            // Passo 3: Extrair os dados do JSON e adicioná-los ao PDF
            String name = jsonNode.get("name").asText();
            document.add(new Paragraph("Nome: " + name));
            String age = jsonNode.get("age").asText();
            document.add(new Paragraph("Idade: " + age));

            // Adicione mais campos conforme necessário

            // Passo 4: Fechar o documento PDF
            document.close();
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        }
	}

}
