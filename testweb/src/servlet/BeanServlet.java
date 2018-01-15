package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BeanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public BeanServlet() {
        super();
        
    }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		super.service(request, response);
		/*
		 * ���÷��������÷���
		 * �жϴ���
		 */
		String methodName = request.getParameter("method");
		if(methodName == null || methodName.trim().isEmpty()) {
			throw new RuntimeException("��û�д������ , ���߲���ֵ����method");
		}
		/*
		 * �жϷ���
		 */
		Class c = this.getClass();
		Method method = null;
		try {
			method = c.getMethod(methodName, 
					HttpServletRequest.class , HttpServletResponse.class);
		} catch (Exception e) {
			throw new RuntimeException("����ҵķ���������");
		} 
		
		/*
		 * ������õ��÷���
		 */
		
		try {
			method.invoke(this, request , response);
		} catch (Exception e) {
			System.out.println("����õķ����ڲ������쳣");
			throw new RuntimeException(e);
			
		} 
 
	}
	/*
	 * ͨ�����������÷���
	 */
	protected void function1(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.print("this is function1");

	}
	
	protected void function2(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.print("this is function1");

	}
}




