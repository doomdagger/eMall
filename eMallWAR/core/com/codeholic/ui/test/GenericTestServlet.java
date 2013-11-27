package com.codeholic.ui.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GenericTest
 */
@WebServlet("/test")
public class GenericTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected PrintWriter writer;
	protected HttpServletResponse response;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenericTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		response.setCharacterEncoding("utf8");
		this.writer = response.getWriter();
		this.response = response;
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void objectOutputToConsole(HttpServletResponse response, Object object) throws IOException{
		
		//PrintWriter writer = response.getWriter();
		StackTraceElement traceElement = ((new Exception()).getStackTrace())[1];
		String funName = traceElement.getMethodName();
		
		if(object == null)
		{
			writer.println(" Export Result("+funName+") :");
			writer.println(" 	Export Null object...");
			return;
		}
		if(object instanceof List){
			writer.println(" Export Result("+funName+") :");
			for(Object obj : (List)object){
				writer.println(obj.toString());
			}
		}else if(object instanceof Map){
			Map map = (Map)object;
			writer.println(" Export Result("+funName+") :");
			for(Entry entry : (Set<Entry>)map.entrySet()){
				writer.println("key: "+entry.getKey()+"  value: "+ entry.getValue());
			}
		}
			 
		else{
			writer.println(" Export Result("+funName+") :");
			writer.println(object.toString());
		}
	}
	
	
	protected void resultOut(boolean isSucc)
	{
		StackTraceElement traceElement = ((new Exception()).getStackTrace())[1];
		String funName = traceElement.getMethodName();
		if(isSucc)
		{
			writer.println("Method Success : "+funName);
			return;
		}
		writer.println("Method Error : "+funName);
	}

}
