package com.generation.json;




import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.generation.json.model.Appendixes;
import com.generation.json.model.AppendixesList;
import com.generation.json.model.Items;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@SpringBootApplication
public class JsonApplication {

	public static void main(String[] args)  {
		SpringApplication.run(JsonApplication.class, args);
		
		
		try {
        
        ObjectMapper objectMapper = new ObjectMapper();
        AppendixesList appendixesList = objectMapper.readValue(new File("contract.json"), AppendixesList.class);

        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("teste.pdf"));
        document.open();

        
        for(Appendixes appendixes: appendixesList.getAppendixes()){
                document.add(new Paragraph( appendixes.getTitle()));
        document.add(new Paragraph(appendixes.getDescription()));
        document.add(new Paragraph(appendixes.getPosition().getReadable()));
        document.add(new Paragraph(appendixes.getPosition().getNumeric()));


        for (Items items : appendixes.getItems()) {
        	document.add(new Paragraph(items.getContent()));
        	document.add(new Paragraph(items.getEnumerationType()));
        	//document.add(new Paragraph(String.valueOf(items.isHasSub())));
        }

        document.add(new Paragraph("\n\n"));

        }
        
        
     
   
        System.out.println("JSON Desserializado: " + objectMapper.writeValueAsString(appendixesList));
        System.out.println("PDF criado com sucesso!");
        document.close();
    } catch (IOException | DocumentException e) {
        e.printStackTrace();
    }

	}
}
