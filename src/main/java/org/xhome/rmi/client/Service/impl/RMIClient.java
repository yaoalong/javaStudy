package org.xhome.rmi.client.Service.impl;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xhome.rmi.client.interfaceDO.IHello;

import java.rmi.Naming;


public class RMIClient {
	private static final Logger logger=LoggerFactory.getLogger(RMIClient.class);
	@Test	
	public void test(){
			try{
				IHello rhello=(IHello)Naming.lookup("rmi://localhost:8888/RHello");
				logger.info(rhello.helloWorld());
				System.out.println(rhello.helloWorld());
				System.out.println(rhello.sayHelloToSomeBody("sunming"));
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
	public static void main(String args[]){
		new RMIClient().test();
	}
}
