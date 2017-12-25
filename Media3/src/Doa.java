import java.net.URI;

import org.json.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.*;
public class Doa {

	public static String getall() {
		
		 StringBuilder builder = new StringBuilder();
		 JSONObject jsonObject = new JSONObject();
        
        try {
 
           
            String surl = "http://media3.co.in/webservices/mobile/list/"; 
            URL url = new URL(surl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
             /*conn.setRequestMethod("POST");
             conn.setRequestProperty("Accept", "application/json");*/

            OutputStream os = conn.getOutputStream();
            os.write(jsonObject.toString().getBytes());
            os.flush();     
            
            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Failed : HTTP error code : "
                    + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            
            
            String line;
            while ((line = br.readLine()) != null) {
                builder.append(line + "\n");
                }
            conn.disconnect();
            JSONObject jsonObject2 = new JSONObject(builder.toString());
            JSONArray jsonArray = new JSONArray(jsonObject2.getString("result"));
            System.out.println(jsonArray.toString());
             //jsonArray = jsonArray.getJSONArray(0);
               // System.out.println(jsonArray.toString());

            for (int i = 0; i < jsonArray.length(); i++) {
                 JSONObject json = jsonArray.getJSONObject(i);

                System.out.println(json.get("reciever"));
                System.out.println(json.get("dob"));
                System.out.println(json.get("created_at"));
                System.out.println(json.get("phone_number"));
                System.out.println(json.get("id"));
                System.out.println("=============");


            }


            
            

             
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
           
        }
	return builder.toString();
}	
	
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

