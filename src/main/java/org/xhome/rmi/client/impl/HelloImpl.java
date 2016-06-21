package org.xhome.rmi.client.impl;

import org.xhome.rmi.client.interfaceDO.IHello;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloImpl extends UnicastRemoteObject implements IHello, Serializable{

	
	public HelloImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -9100181325018882223L;

	@Override
	public String helloWorld() throws RemoteException {
		// TODO Auto-generated method stub
		return "Hello World!";
	}

	@Override
	public String sayHelloToSomeBody(String someBodyName)
			throws RemoteException {
		// TODO Auto-generated method stub
		return "您好,"+someBodyName+"!";
	}

	
}
