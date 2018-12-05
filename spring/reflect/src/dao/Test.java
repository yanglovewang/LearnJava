package dao;

import model.User;
import util.ProxyFactory;

public class Test {
	
	public static void main(String[] args) {
		ProxyFactory pf = new ProxyFactory();
		UserDaoImpro ui = new UserDaoImpro();
		UserDao userdao = (UserDao)pf.createProxyFactory(ui);
		userdao.find(1);
	}

}