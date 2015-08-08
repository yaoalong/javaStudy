package org.xhome.serviceImpl;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import org.junit.Test;
import org.xhome.rmi.client.impl.HelloImpl;
import org.xhome.rmi.client.interfaceDO.IHello;

public class HelloServiceImpl {
	@Test
	public void test(){
		
		try{
			IHello rhello=new HelloImpl();
			
			LocateRegistry.createRegistry(8888);
			
			Naming.rebind("rmi://localhost:8888/RHello", rhello);
			System.out.println("绑定成功");
//			while(true){
//				System.out.println("ff")
//			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void main(String args[]){
		new HelloServiceImpl().test();
	}
}
