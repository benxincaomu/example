package org.sft.sample.common.error;

import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AssertUtil {
	private static final Logger log=LogManager.getLogger();

	public static void error(ApplicationErrorCode errorCode,Object... formats) {
		if(formats.length>0){
		    if(formats.length==0) {
		        errorCode.setMessage(errorCode.getMessage());
		    }else {
		        errorCode.setMessage(String.format(errorCode.getMessage(), formats));
		    }
		}
		RuntimeException exception=new ApplicationException(errorCode);
		log.error(errorCode.getMessage(),exception);
		throw exception;
	}
	
	public static void isTrue(boolean cnd,ApplicationErrorCode errorCode,Object... formats){
		if(!cnd){
			error(errorCode, formats);
		}
	}
	public static void isNull(Object cnd,ApplicationErrorCode errorCode,Object... formats){
		isTrue(Objects.isNull(cnd), errorCode, formats);
	}
	public static void isNotNull(Object cnd,ApplicationErrorCode errorCode,Object... formats){
		isTrue(Objects.nonNull(cnd), errorCode, formats);
	}
	
	
	
	
	
}
