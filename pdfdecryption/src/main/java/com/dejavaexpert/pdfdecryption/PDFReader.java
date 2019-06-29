package com.dejavaexpert.pdfdecryption;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.logging.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;
/**
 * Read password encrypted pdf document using apache pdfbox
 * @author Sephin George
 *
 */
public class PDFReader extends PDFTextStripper {
	private final static Logger logger = Logger.getLogger("logger");
	
	public PDFReader() throws IOException {
		super();
		
	}

	public static void main(String args[])  {
		final String FILE_PATH = "<<path to file>>";
		final String password = "<<password>>";
		try(PDDocument doc = PDDocument.load(new File(FILE_PATH),password);
			Writer writer = new BufferedWriter(new OutputStreamWriter(System.out))){
			
			PDFTextStripper reader = new PDFReader();
			reader.writeText(doc, writer);
			
		}catch(InvalidPasswordException p) {
			logger.severe(p.getMessage());
		}
		catch(IOException e) {
			logger.severe(e.getMessage());
		}
		
	}
}
