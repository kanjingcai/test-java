package com.test.timer;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 需求：在指定的时间删除指定目录
 * 
 * @date 2016-5-8
 * @author kanjc
 */
public class TimerTest {

	public static void main(String[] args) throws Exception {
		Timer t = new Timer();
		
		String s = "2016-05-08 20:19:00";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d = sdf.parse(s);
		t.schedule(new DeleteFolder(), d);
	}
	
}

class DeleteFolder extends TimerTask{

	@Override
	public void run() {
		File srcFolder = new File("demo");
		deleteFolder(srcFolder);
	}

	/**
	 * 递归删除文件
	 * @param src
	 */
	private void deleteFolder(File src) {
		File[] listFiles = src.listFiles();
		if(listFiles != null) {
			for (File file : listFiles) {
				if(file.isDirectory()) {
					deleteFolder(file);
				} else {
					System.out.println(file.getName() + "：" + file.delete());
				}
			}
			System.out.println(src.getName() + "：" + src.delete());
			
		}
	}
}