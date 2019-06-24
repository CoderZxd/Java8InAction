package com.zxd.java8.test;

import java.io.File;
import java.io.FileFilter;

/**
 * @Title: HiddenFiles
 * @Description: TODO
 * @Author xiaodong.zou
 * @Date 2019/6/24 14:50
 */
public class HiddenFiles {

	public static void main(String[] args) {
		File[] hiddenFiles = new File("C:/").listFiles(new FileFilter() {

			@Override public boolean accept(File pathname) {
				return pathname.isHidden();
			}
		});
		int length = hiddenFiles.length;
		System.out.println(String.format("隐藏文件个数为:%d",length));
		for(int i=0;i<length;i++){
			System.out.println(String.format("文件名:%s,是否是文件夹:%s",hiddenFiles[i].getAbsolutePath(),hiddenFiles[i].isDirectory()));
		}

		File[] hfiles = new File("C:/").listFiles(File::isHidden);
		System.out.println(hfiles.length);
	}

}
