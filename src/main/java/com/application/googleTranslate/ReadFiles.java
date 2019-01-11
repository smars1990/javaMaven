package com.application.googleTranslate;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
public class ReadFiles {
	private List<File> files = new ArrayList<File>();
    private File dir;
    public ReadFiles(String directoryPath){
    	dir=new File(directoryPath);
    }
	public void listFiles(File dir) {
		File file[] = dir.listFiles();
		for (int i = 0; i < file.length; i++) {
			if (file[i].isDirectory()) {
				this.listFiles(file[i]);                //迭代遍历
			} else {
				//迭代选择txt文件
				if (file[i].getName().lastIndexOf(".txt") != -1){
					files.add(file[i]);
				}
			}
		}
	}
	public List<File> getFiles(){
		this.listFiles(dir);
		return files;
	}
}