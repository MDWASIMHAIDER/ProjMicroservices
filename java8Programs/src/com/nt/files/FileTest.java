package com.nt.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;



public class FileTest {

	public static void main(String[] args) throws Exception {
		//File f=new File("D:\\FileTesting","abc.txt");
		File f=new File("D:\\image");
		File f1=new File("D:\\FileTesting\\abc.txt");
		FileReader fr=new FileReader("D:\\FileTesting\\abc.txt");
		//f.mkdir();
		//f.createNewFile();
		char[] ch={'a','b','c'};
		FileWriter fw=new FileWriter(f1);
		fw.write(100);
		fw.write('\n');
		fw.write(ch);
		fw.write(110);
		//fw.flush();
		
		/*int read = fr.read();
		while(read!=-1) {
			System.out.println((char)read);
			read=fr.read();
		}*/
		
		
		//fw.close();
		/*String[] list = f.list();
		for(String name:list) {
			if(name.equals("filetest.jpg")) {
				boolean delete = f.delete();
				System.out.println("del called"+delete);
			}
			System.out.println(name);
		}*/
		
		/*char[] c=new char[(int)f1.length()];
		FileReader frd=new FileReader(f1);
		frd.read(c);
		for(char c1:c) {
			System.out.println(c1);
		}
		*/
		
		BufferedWriter bw=new BufferedWriter(fw);
		bw.newLine();
		bw.write("using buffred writer");
		bw.flush();
		bw.close();
		
		
		/*BufferedReader br=new BufferedReader(fr);
		int read = br.read();
		System.out.println((char)read);
		String readLine = br.readLine();
		while(readLine!=null) {
			System.out.println(readLine);
			readLine=br.readLine();
		}*/
		
		PrintWriter pw=new PrintWriter(fw);
		pw.println("wsa");
		pw.flush();
		System.out.println("executed");
	}

}
