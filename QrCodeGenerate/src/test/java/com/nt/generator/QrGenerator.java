package com.nt.generator;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.encoder.ByteMatrix;


public class QrGenerator {
	 private static final String QR_CODE_IMAGE_PATH = "./MyQRCode.JPG";

	   /* private static void generateQRCodeImage(String text, int width, int height, String filePath)
	            throws WriterException, IOException {
	        QRCodeWriter qrCodeWriter = new QRCodeWriter();
	         BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

	        File f=new File("D:\\my-folder\\myqr.jpg");
			FileOutputStream fos=new FileOutputStream(f);
			fos.write(bitMatrix.getBottomRightOnBit());
			fos.flush();
	        Path path = FileSystems.getDefault().getPath(filePath);
	        
	       
	    }*/
	 private static byte[] getQRCodeImage(String text, int width, int height) throws WriterException, IOException {
		    QRCodeWriter qrCodeWriter = new QRCodeWriter();
		    BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
		    
		    ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
		    MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
		    byte[] pngData = pngOutputStream.toByteArray(); 
		    return pngData;
		}

	    public static void main(String[] args) {
	        try {
	        	byte[] qrCodeImage = getQRCodeImage("Name:Md Wasim Haider"+"\n"+"Desg :Software Engeeneer"+"\n "
	        			+ "Address: Bighar", 350, 350);
	        	File f=new File("D:\\my-folder\\myqr.jpg");
	    		FileOutputStream fos=new FileOutputStream(f);
	    		fos.write(qrCodeImage);
	    		fos.flush();
	        } catch (WriterException e) {
	            System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
	        } catch (IOException e) {
	            System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
	        }
	    }
}
