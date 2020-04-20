package com.gd.common.utils.convert;

import java.io.*;

public class ObjectToByte {
	
	/**
	 * 对象转流
	 * @param obj
	 * @return
	 */
	public static byte[] getByte(Object obj){
		byte[] bytes = null;      
		ByteArrayOutputStream bos = new ByteArrayOutputStream();      
		try {        
			ObjectOutputStream oos = new ObjectOutputStream(bos);         
			oos.writeObject(obj);        
			oos.flush();         
			bytes = bos.toByteArray ();      
			oos.close();         
			bos.close();        
		} catch (IOException ex) {        
			ex.printStackTrace();   
		}      
		return bytes;    
	}

	/**
	 * 流转对象
	 * @param bytes
	 * @return
	 */
	public static <T> T toObject(byte[] bytes){
		T t = null;
		if (bytes != null) {
			try {
				ByteArrayInputStream bis = new ByteArrayInputStream (bytes);        
				ObjectInputStream ois = new ObjectInputStream (bis);        
				t = (T) ois.readObject();      
				ois.close();   
				bis.close();   
			} catch (IOException ex) {        
				ex.printStackTrace();   
			} catch (ClassNotFoundException ex) {        
				ex.printStackTrace();   
			}
		}
		return t;
	}
}
