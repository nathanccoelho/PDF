package com.generation.json.model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class Json {

		public Json (String relatorio) throws DocumentException, FileNotFoundException {
				
				Document documentPDF = new Document();
				
				PdfWriter.getInstance(documentPDF, new FileOutputStream("Relatorio.pdf"));
				
				documentPDF.open();
				
				Paragraph paragrafo = new Paragraph(relatorio);
				
				documentPDF.add(paragrafo);
				
				documentPDF.close();
	}
}
