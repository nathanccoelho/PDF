package com.generation.json;




import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.generation.json.model.Clauses;
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

        // Appendixes
        for(Appendixes appendixes: appendixesList.getAppendixes()){
           document.add(new Paragraph( appendixes.getTitle()));
           document.add(new Paragraph(appendixes.getDescription()));
           document.add(new Paragraph(appendixes.getPosition().getReadable()));
           document.add(new Paragraph(appendixes.getPosition().getNumeric()));

            char currentChar = 'a';
            int currentInt = 1;
        for (Items items : appendixes.getItems()) {

            switch(items.getEnumerationType()){
                case "char":
                    items.setEnumerationType(String.valueOf(currentChar));
                    currentChar = (char) (currentChar + 1);
                    break;

                case "numeric":
                    items.setEnumerationType(String.valueOf(currentInt));
                    currentInt++;
                   break;


                case "roman-lower":

                    break;



                default:
                    break;
            }

            document.add(new Paragraph(items.getEnumerationType()+"."));
        	document.add(new Paragraph(items.getContent()));

            if (items.isHasSub()) {
                StringBuilder subItems = new StringBuilder();

               for(Items subItem : items.getItems()){
                   switch(subItem.getEnumerationType()){
                       case "char":
                           subItem.setEnumerationType(String.valueOf(currentChar));
                           currentChar = (char) (currentChar + 1);
                           break;

                       case "numeric":
                           subItem.setEnumerationType(String.valueOf(currentInt));
                           currentInt++;
                           break;


                       case "roman-lower":

                           break;



                       default:
                           throw new IllegalArgumentException("Tipo de enumeração desconhecido: " + subItem.getEnumerationType());

                   }

                   subItems.append(subItem.getEnumerationType()).append(".").
                           append(subItem.getContent());
               }

                document.add(new Paragraph(subItems.toString()));
            }
        }
        document.add(new Paragraph("\n\n"));
        }


        // Clauses
        for(Clauses clauses : appendixesList.getClauses()){
            document.add(new Paragraph(clauses.getTitle()));
            document.add(new Paragraph(clauses.getDescription()));
            document.add(new Paragraph(clauses.getPosition().getReadable()));
            document.add(new Paragraph(clauses.getPosition().getNumeric()));

            char currentChar = 'a';
            int currentInt = 1;

            for (Items items : clauses.getItems()) {

                switch(items.getEnumerationType()){
                    case "char":
                        items.setEnumerationType(String.valueOf(currentChar));
                        currentChar = (char) (currentChar + 1);
                        break;

                    case "numeric":
                        items.setEnumerationType(String.valueOf(currentInt));
                        currentInt++;
                        break;


                    case "roman-lower":

                        break;



                    default:
                        break;
                }

                document.add(new Paragraph(items.getEnumerationType()+"."));
                document.add(new Paragraph(items.getContent()));

                if (items.isHasSub()) {
                    StringBuilder subItems = new StringBuilder();

                    for(Items subItem : items.getItems()){
                        switch(subItem.getEnumerationType()){
                            case "char":
                                subItem.setEnumerationType(String.valueOf(currentChar));
                                currentChar = (char) (currentChar + 1);
                                break;

                            case "numeric":
                                subItem.setEnumerationType(String.valueOf(currentInt));
                                currentInt++;
                                break;


                            case "roman-lower":

                                break;



                            default:
                                throw new IllegalArgumentException("Tipo de enumeração desconhecido: " + subItem.getEnumerationType());

                        }

                        subItems.append(subItem.getEnumerationType()).append(".").
                                append(subItem.getContent());
                    }

                    document.add(new Paragraph(subItems.toString()));
                }
            }
            document.add(new Paragraph("\n\n"));

        }
        System.out.println("PDF criado com sucesso!");
        document.close();
    } catch (IOException | DocumentException e) {
        e.printStackTrace();
    }

	}

    private String convertToRomanLower(int number){
       Map<Integer, String> numberRomanLower = new HashMap<>();
       numberRomanLower.put(1, "i");
       numberRomanLower.put(5, "v");
       numberRomanLower.put(10, "x");
       numberRomanLower.put(50, "l");
       numberRomanLower.put(100, "c");
       numberRomanLower.put(500, "d");
       numberRomanLower.put(1000, "m");


       var resultado= 0;

       for (int i = 0; i <numberRomanLower.size(); i++){
           var atual = numberRomanLower.values(number);
       }
    }
}
