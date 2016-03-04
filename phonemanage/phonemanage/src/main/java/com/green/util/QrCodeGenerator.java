package com.green.util;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

/**
 * @author maybo
 *
 */
public class QrCodeGenerator {
	public static byte[] build(String content) throws IOException, WriterException {
	        int width = 300; 
	        int height = 300; 
	        //��ά���ͼƬ��ʽ 
	        String format = "gif"; 
	        Hashtable hints = new Hashtable(); 
	        //������ʹ�ñ��� 
	        hints.put(EncodeHintType.CHARACTER_SET, "utf-8"); 
	        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, 
	                BarcodeFormat.QR_CODE, width, height, hints); 
	       return MatrixToImageWriter.writeToStream(bitMatrix, format);
	}
}
