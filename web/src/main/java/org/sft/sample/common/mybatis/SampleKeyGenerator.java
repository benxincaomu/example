package org.sft.sample.common.mybatis;

import java.sql.Statement;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.keygen.KeyGenerator;
import org.apache.ibatis.mapping.MappedStatement;

/**
 * @author sunfutao
 *
 * @since 2018年8月24日
 */
public class SampleKeyGenerator implements KeyGenerator{

	/* (non-Javadoc)
	 * @see org.apache.ibatis.executor.keygen.KeyGenerator#processBefore(org.apache.ibatis.executor.Executor, org.apache.ibatis.mapping.MappedStatement, java.sql.Statement, java.lang.Object)
	 */
	@Override
	public void processBefore(Executor executor,MappedStatement ms,Statement stmt,Object parameter){
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.apache.ibatis.executor.keygen.KeyGenerator#processAfter(org.apache.ibatis.executor.Executor, org.apache.ibatis.mapping.MappedStatement, java.sql.Statement, java.lang.Object)
	 */
	@Override
	public void processAfter(Executor executor,MappedStatement ms,Statement stmt,Object parameter){
		// TODO Auto-generated method stub

	}

}
