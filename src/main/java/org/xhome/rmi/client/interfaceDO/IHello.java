package org.xhome.rmi.client.interfaceDO;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IHello extends Remote  {
	public String helloWorld() throws RemoteException;
	
	/**
	 * 
	 */
	public String sayHelloToSomeBody(String someBodyName)throws RemoteException;
}
