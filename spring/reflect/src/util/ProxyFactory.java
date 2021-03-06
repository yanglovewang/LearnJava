package util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProxyFactory {

	public Object createProxyFactory(Object ta) {
		ClassLoader classLoader = this.getClass().getClassLoader();
		Class[] interfaces = ta.getClass().getInterfaces();
		InvocationHandler h = new SonInvocationHandler(ta);
		Object proxy = Proxy.newProxyInstance(classLoader, interfaces, h);
		return proxy;
	}
}

class SonInvocationHandler implements InvocationHandler {
	private Object targetObject;
	public SonInvocationHandler() {
		
	}
	public SonInvocationHandler(Object ta) {
		this.targetObject = ta;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Object obj = null;
		try {
			 obj = method.invoke(targetObject, args);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
				conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return obj;
	}
	
}
