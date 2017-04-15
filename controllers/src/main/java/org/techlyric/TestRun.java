package org.techlyric;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hsqldb.jdbc.JDBCDataSource;
import org.hsqldb.jdbc.pool.JDBCPooledDataSource;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.techlyric.service.MemberService;

public class TestRun {
    public static void main(String[] args) throws Exception {
	
	try {
	    Class.forName("org.hsqldb.jdbcDriver");
	} catch (ClassNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	
	Hashtable env = new Hashtable(11);
	System.setProperty(Context.INITIAL_CONTEXT_FACTORY, org.techlyric.InitialContextFactoryForTest.class.getName());

	//System.setProperty(Context.URL_PKG_PREFIXES, "org.hsqldb");
	InitialContext ic = new InitialContext(env);
	
	JDBCDataSource ds = new org.hsqldb.jdbc.JDBCDataSource();
	ds.setURL("jdbc:hsqldb:file:/home/sherwinp/domains/one/demodb");
	ds.setUser("sa");
	ic.bind("jdbc/demodb", (javax.sql.DataSource)ds);
	// Create Spring application context
	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:/META-INF/spring-context.xml");
 
	// Get service from context.
	MemberService memberService = ctx.getBean(MemberService.class);

	memberService.findOne("");
	ctx.close();
    }
}
