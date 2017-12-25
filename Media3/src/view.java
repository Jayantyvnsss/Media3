

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

/**
 * Servlet implementation class view
 */
@WebServlet("/view")
public class view extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public view() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try
		{
		        JSONObject jsonobject=new JSONObject(Doa.getall());
		        JSONArray jsonarray= new JSONArray(jsonobject.getString("result"));
		        
		        
		        
		        
		        List<Student> students=new ArrayList<Student>();
		        
                for(int i=0;i < jsonarray.length();i++) 		
                {
		        
                    Student student=new Student();		        
		           JSONObject jsonobject1=jsonarray.getJSONObject(i);
		           
		        student.setCreated_at(jsonobject1.get("created_at").toString());
		        student.setDob(jsonobject1.getString("dob").toString());
		       // String ss = jsonobject1.getString("receiver");
		       // if(ss != null) {
		       // 	ss= ss.toString();
		      //  }
		     //   student.setReceiver(ss);
		        student.setPhone_number(jsonobject1.getString("phone_number").toString());
		        student.setId(jsonobject1.getString("id").toString());
		        
		        students.add(student);
		        
		        
                }
		        request.setAttribute("students", students);
		        
		        request.getRequestDispatcher("NewFile.jsp").include(request,response);
		               
		        
		        
		        
		        
		        
	}
		catch(ParseException e){
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
