package com.green.util;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import com.google.zxing.WriterException;

public class UtilMtdTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	@Test
	public void uuidTest(){
		System.out.println(UUIDGenerator.uuid());
	}
	@Test
	public void QrCodeTest() throws IOException, WriterException{
		System.out.println(QrCodeGenerator.build("客户编号:wjhrpjwqtr4jtgapj455jgeg手机串号:24535533553").toString());
	}

}
