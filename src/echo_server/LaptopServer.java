package echo_server;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Logger;

import javax.xml.bind.DatatypeConverter;


public class LaptopServer implements Runnable{
    @Override
    public void run() {
    	String base64="";
    	  FileReader f = null;
		try {
			f = new FileReader("/home/diego/Scrivania/app.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	    BufferedReader b;
    	    b=new BufferedReader(f);
    	    String app1="";
    	    do{
    	    	base64+=app1;
    	    	try {
					app1=b.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    	    }while (app1!=null);
    	    
   	    	//byte[] pdfAsBytes = //new byDatatypeConverter.parseBase64Binary(base64);
   	    	
   	    	// File filePath = new File("/home/diego/Scrivania/grepsrl-ft-7_2014.pdf");
//   	    	 FileOutputStream os1;
//   			try {
//   				os1 = new FileOutputStream(filePath, true);
//   				 os1.write(pdfAsBytes);
//   		    	 os1.flush();
//   		    	 os1.close();
//   			} catch (FileNotFoundException e) {
//   				// TODO Auto-generated catch block
//   				e.printStackTrace();
//   			} catch (IOException e) {
//   				// TODO Auto-generated catch block
//   				e.printStackTrace();
//   			}
   			
        try{
            System.out.println("Waiting for client...");
            ServerSocket ss = new ServerSocket(32323);
//            while (true)
//            {
            Socket client = ss.accept();
            try{
                System.out.println("Connection established !");
                InputStream os = client.getInputStream();
                String appoggio="";
                BufferedReader data = new BufferedReader(new InputStreamReader(os));
                
                String app;
               // do{
                	app=data.readLine();
//                	try{ 
//                		System.out.println(app.toString());
//                	if(app.substring(0, 1).equals("<")){
//                       appoggio=""+app;
//                       System.out.println(appoggio.replace(">", "> \n"));}
//                	   
//                	}
//                	catch (Exception e){}
                	
                	BufferedWriter out=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
                    out.write("<s:Envelope xmlns:s=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:a=\"http://www.w3.org/2005/08/addressing\"><s:Header><a:Action s:mustUnderstand=\"1\">http://tempuri.org/IComponentService/AuthenticateCustomerAccountResponse</a:Action><ActivityId CorrelationId=\"46d78735-1d6b-432f-8738-043c1bb54a0f\" xmlns=\"http://schemas.microsoft.com/2004/09/ServiceModel/Diagnostics\">4c80122d-f3ff-4fa1-a488-79b8b33bd937</ActivityId></s:Header><s:Body><AuthenticateCustomerAccountResponse xmlns=\"http://tempuri.org/\"><AuthenticateCustomerAccountResult xmlns:b=\"http://schemas.datacontract.org/2004/07/Grep.ManagementPlatform.Contracts.Dto\" xmlns:i=\"http://www.w3.org/2001/XMLSchema-instance\"><b:Carts><b:CartHeaderDto><b:CreationDate>2014-04-01T15:01:31</b:CreationDate><b:Id>237aead8-dd33-4866-8222-a30000f79c49</b:Id><b:TotalPrice>30.72132</b:TotalPrice></b:CartHeaderDto><b:CartHeaderDto><b:CreationDate>2014-04-01T16:27:46</b:CreationDate><b:Id>6e817d81-2c12-452f-8977-a300010f4d3d</b:Id><b:TotalPrice>30.72132</b:TotalPrice></b:CartHeaderDto></b:Carts><b:Customer i:type=\"b:PersonDto\"><b:Id>5049</b:Id><b:Name>Diego Lagana</b:Name><b:Address><b:Area><b:Id>5325</b:Id><b:Name>Grottaferrata</b:Name><b:Parent><b:Id>317</b:Id><b:Name>Roma</b:Name><b:Parent><b:Id>251</b:Id><b:Name>Lazio</b:Name><b:Parent><b:Id>105</b:Id><b:Name>Italia</b:Name><b:Parent i:nil=\"true\"/></b:Parent></b:Parent></b:Parent></b:Area><b:PostalCode>00046</b:PostalCode><b:StreetName>via roma</b:StreetName><b:StreetNumber>23</b:StreetNumber></b:Address><b:NationalIdentifier>LGNDGI91R09D773L</b:NationalIdentifier><b:VATNumber/><b:CompanyName i:nil=\"true\"/><b:ContactEmailAddress>lgn.diego@gmail.com</b:ContactEmailAddress><b:ContactPhoneNumber i:nil=\"true\"/><b:FirstName>Diego</b:FirstName><b:LastName>Lagana</b:LastName><b:Position i:nil=\"true\"/><b:Title i:nil=\"true\"/></b:Customer><b:MainProfile><b:Id>5099</b:Id><b:Name>Diego Lagana</b:Name><b:ContactPerson><b:EmailAddress>lgn.diego@gmail.com</b:EmailAddress><b:FirstName>Diego</b:FirstName><b:LastName>Lagana</b:LastName><b:PhoneNumber i:nil=\"true\"/></b:ContactPerson><b:IsMainProfile>true</b:IsMainProfile><b:Locked>false</b:Locked><b:NewPassword i:nil=\"true\"/><b:Username>diego</b:Username></b:MainProfile><b:Stats><b:ActualMonthlyCost>58.470012500000000000000000001</b:ActualMonthlyCost><b:TotalAboutToExpireComponents>4</b:TotalAboutToExpireComponents><b:TotalActiveComponents>5</b:TotalActiveComponents></b:Stats></AuthenticateCustomerAccountResult></AuthenticateCustomerAccountResponse></s:Body></s:Envelope>");
             //   }while (!app.equals(null));
               
                client.close();  
                
//                OutputStream os1 = client.getOutputStream();
//                PrintWriter pw = new PrintWriter(os1,true);
//                pw.println("I'm the Server.");
//                
            }finally{}
            System.out.println("Connection terminated !");
//            }
          
        }catch (IOException ioe){ioe.printStackTrace();}
       
    }
    /**
     * @param args (empty arguments)
     */
    public static void main(String[] args) {
        Thread t = new Thread(new LaptopServer());
        t.start();
    }
}