package com.green.util;

import java.util.UUID;

public class UUIDGenerator {
	public static String uuid() {
		String uuid = UUID.randomUUID().toString().replace("-", "");
		return uuid.toString();
	}
}
