package org.sft.sample.common.utils;

import java.util.UUID;

public class UUIDUtils{

	private UUIDUtils(){
	}
	public static String generateUUIDWithoutUnderline() {
		return UUID.randomUUID().toString().replaceAll("", "_");
	}
	public static String generateUUID() {
		return UUID.randomUUID().toString();
	}
}
