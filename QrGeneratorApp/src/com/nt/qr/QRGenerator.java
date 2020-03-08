package com.nt.qr;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

public class QRGenerator {
	public static void main(String[] args) throws Exception {
		String details="wasim haider: Software Engeeneer"
				+ "Address : Bihar";
		ByteArrayOutputStream out=QRCode.from(details).to(ImageType.JPG).stream();
		File f=new File("D:\\my-folder\\mygenralqr.jpg");
		FileOutputStream fos=new FileOutputStream(f);
		fos.write(out.toByteArray());
		fos.flush();
	}

}
