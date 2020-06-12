package com.mckesson.loyalty.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.imageio.ImageIO;
import javax.net.ssl.HttpsURLConnection;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.*;

import com.mckesson.loyalty.utils.HttpDownloadUtility;


/**
  * 
 */

public class downloadtandc {
		
			public static final String IMAGEPATH = "/webapps/entresto/img/";
			public static final String IMAGENAME = "t&cimage";
			public static final String IMAGEXTENSION = ".jpg";
			public static final String pdfurl  = "https://www.novartis.us/sites/www.novartis.us/files/entresto_ppi.pdf";
			
			public static void main(String[] args) {
				HttpDownloadUtility htpd = new HttpDownloadUtility();
				String savedir = System.getProperty("catalina.base") + "/webapps/entresto/pdf/downloadedPdf.pdf";
				Integer noofpages = 0;
					//logger.info("CATALINA_HOME" + System.getProperty("CATALINA_HOME"));
					HttpsURLConnection openConnection = null;
					
					try {
						 openConnection = (HttpsURLConnection) new URL(pdfurl).openConnection();
						 openConnection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
							try (InputStream in = openConnection.getInputStream()) {
									Files.copy(in, Paths.get(savedir), StandardCopyOption.REPLACE_EXISTING);
									in.close();

							} catch (Exception exc) {
								
							}
					}catch(Exception exc){
						
						
					}finally {
						if (openConnection != null) {
							openConnection.disconnect();
						}
					}
					
					try {
						File file = new File(savedir);
						PDDocument document = PDDocument.load(file);
						PDFRenderer renderer = new PDFRenderer(document);
						noofpages = document.getNumberOfPages();
						//activateFTOView.addObject("pagecount",document.getNumberOfPages() );
						int imageNumber = 0;
						if(document.getNumberOfPages() > 0) {
							BufferedImage[] image = new BufferedImage[document.getNumberOfPages()];
							for(int i=0; i<document.getNumberOfPages();i++) {
								image[i] = renderer.renderImageWithDPI(i, 400);
								imageNumber=i;
								ImageIO.write(image[i], "JPEG", new File(System.getProperty("catalina.base") + IMAGEPATH + IMAGENAME + (imageNumber+1) + IMAGEXTENSION));
							}
							document.close();
						}
					}catch(Exception exc){
						
						
					}
			}

}		