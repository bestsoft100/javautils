package de.b100.utils;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import de.b100.utils.err.FileException;

public abstract class FileUtils {
	
	public static String loadFile(String path) {
		return loadFile(new File(path));
	}
	
	public static String loadFile(File file) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String out = "";
			
			boolean firstLine = true;
			while(true) {
				try{
					out += (firstLine?"":"\n")+br.readLine();
				}catch (Exception e) {
					break;
				}
				firstLine = false;
			}
			
			br.close();
			return out;
		}catch (Exception e) {
			throw new FileException(e);
		}
	}
	
	public static List<File> getAllFiles(String path){
		return getAllFiles(new File(path));
	}
	
	public static List<File> getAllFiles(File path){
		return getAllFiles(new ArrayList<File>(), path);
	}
	
	public static List<File> getAllFiles(List<File> files, File path){
		if(!path.isDirectory()) {
			return files;
		}
		
		File[] listFiles = path.listFiles();
		
		for(File file : listFiles) {
			if(file.isDirectory()) {
				files = getAllFiles(files, file);
			}
		}
		
		return files;
	}
	
	public static BufferedImage loadImage(String path) {
		return loadImage(new File(path));
	}
	
	public static BufferedImage loadImage(File file) {
		try{
			return ImageIO.read(file);
		}catch (Exception e) {
			throw new FileException(e);
		}
	}
	
	public static List<File> toList(File[] files){
		List<File> list = new ArrayList<>();
		
		for(File file : files) {
			list.add(file);
		}
		
		return list;
	}
	
	public static File[] toArray(List<File> list) {
		File[] files = new File[list.size()];
		
		for(int i=0; i<list.size(); i++) {
			files[i] = list.get(i);
		}
		
		return files;
	}
	
}
