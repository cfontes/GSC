package br.com.gsc.controller;

import org.hibernate.proxy.HibernateProxy;
import org.hibernate.proxy.LazyInitializer;

public class PostControllerServ implements HibernateProxy {

	@Override
	public Object writeReplace() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LazyInitializer getHibernateLazyInitializer() {
		// TODO Auto-generated method stub
		return null;
	}

}
