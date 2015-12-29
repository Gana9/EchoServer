package echo_server;

import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


public class prova {

	static String xml="<s:Envelope xmlns:s=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:a=\"http://www.w3.org/2005/08/addressing\"><s:Header><a:Action s:mustUnderstand=\"1\">http://tempuri.org/IComponentService/AuthenticateCustomerAccountResponse</a:Action><ActivityId CorrelationId=\"d332a721-7d4f-4986-bae1-72e3a4654836\" xmlns=\"http://schemas.microsoft.com/2004/09/ServiceModel/Diagnostics\">0ec8f2ab-b54c-4b6b-a997-54ba170d0afe</ActivityId></s:Header><s:Body><AuthenticateCustomerAccountResponse xmlns=\"http://tempuri.org/\"><AuthenticateCustomerAccountResult xmlns:b=\"http://schemas.datacontract.org/2004/07/Grep.ManagementPlatform.Contracts.Dto\" xmlns:i=\"http://www.w3.org/2001/XMLSchema-instance\"><b:Carts><b:CartHeaderDto><b:CreationDate>2014-04-01T15:01:31</b:CreationDate><b:Id>237aead8-dd33-4866-8222-a30000f79c49</b:Id><b:TotalPrice>30.72132</b:TotalPrice></b:CartHeaderDto><b:CartHeaderDto><b:CreationDate>2014-04-01T16:27:46</b:CreationDate><b:Id>6e817d81-2c12-452f-8977-a300010f4d3d</b:Id><b:TotalPrice>30.72132</b:TotalPrice></b:CartHeaderDto></b:Carts><b:Customer i:type=\"b:PersonDto\"><b:Id>5049</b:Id><b:Name>DiegoLagana</b:Name><b:Address><b:Area><b:Id>5325</b:Id><b:Name>Grottaferrata</b:Name><b:Parent><b:Id>317</b:Id><b:Name>Roma</b:Name><b:Parent><b:Id>251</b:Id><b:Name>Lazio</b:Name><b:Parent><b:Id>105</b:Id><b:Name>Italia</b:Name><b:Parent i:nil=\"true\"/></b:Parent></b:Parent></b:Parent></b:Area><b:PostalCode>00046</b:PostalCode><b:StreetName>viaroma</b:StreetName><b:StreetNumber>23</b:StreetNumber></b:Address><b:NationalIdentifier>LGNDGI91R09D773L</b:NationalIdentifier><b:VATNumber/><b:CompanyName i:nil=\"true\"/><b:ContactEmailAddress>lgn.diego@gmail.com</b:ContactEmailAddress><b:ContactPhoneNumber i:nil=\"true\"/><b:FirstName>Diego</b:FirstName><b:LastName>Lagana</b:LastName><b:Position i:nil=\"true\"/><b:Title i:nil=\"true\"/></b:Customer><b:MainProfile><b:Id>5099</b:Id><b:Name>DiegoLagana</b:Name><b:ContactPerson><b:EmailAddress>lgn.diego@gmail.com</b:EmailAddress><b:FirstName>Diego</b:FirstName><b:LastName>Lagana</b:LastName><b:PhoneNumber i:nil=\"true\"/></b:ContactPerson><b:IsMainProfile>true</b:IsMainProfile><b:Locked>false</b:Locked><b:NewPassword i:nil=\"true\"/><b:Username>diego</b:Username></b:MainProfile><b:Stats><b:ActualMonthlyCost>58.470012500000000000000000001</b:ActualMonthlyCost><b:TotalAboutToExpireComponents>0</b:TotalAboutToExpireComponents><b:TotalActiveComponents>5</b:TotalActiveComponents></b:Stats></AuthenticateCustomerAccountResult></AuthenticateCustomerAccountResponse></s:Body></s:Envelope>";
	private static String risposta=xml;
	private static  char variabile;
	
	public static void main(String[] args) {
		 MainProfile MP=(MainProfile) ParserRisposta.parsingClass("MainProfile", MainProfile.class, null).get(0);
		 ContactPerson CP=MP.getContactPerson().get(0);
		 MP.All();
		 CP.All();
	}
	
	public static class ParserRisposta {
	 
	public ParserRisposta() {}	
	@SuppressWarnings("null")
	static public List<Object> parsingClass(String elemento, Class<?> classe, Node RicorsiveNode) {
			Object restituito = null;		
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			Class<?> clas = null;
			List<Object> appList = new ArrayList<Object>();
			//System.out.println(classe.getName());
			int j,condizione,i;
			try {
		//		System.out.println("Classe:  "+classe.getName());			
				clas = Class.forName(classe.getName());
				boolean hasAttribute;
				String elementName;
				Node correntChild = null,firstChild=null;
				
				restituito =clas.newInstance();
				Method[] metodi = clas.getDeclaredMethods();//prende solo i metodi creati a "mano"
				//System.out.println("1");
				DocumentBuilder builder = dbf.newDocumentBuilder();
				Node currentNode;
				NodeList listaNodi = null;
				Document document = builder.parse(new InputSource(new java.io.StringReader(xml)));
				// ddp.printNodeInfo(document);
				System.out.println("2");
				if (RicorsiveNode == null){
					System.out.println("3");
					listaNodi = document.getElementsByTagName(getVariabile("=\"http://schemas.datacontract.org/2004/07/Grep.ManagementPlatform.Contracts.Dto\"")+ ":" + elemento);		
				}
			
				if (listaNodi == null && elemento!=null)
					return null;
				System.out.println("4");
				if (elemento==null)
					condizione=1;
				else 
					condizione=listaNodi.getLength();
				for (i = 0; i < condizione; i++) { // ciclo primario
					System.out.println("Primo Ciclo");
					if (elemento==null) 
						currentNode=RicorsiveNode; 
					else 
						currentNode = listaNodi.item(i);
					// NodeList nlChilds = currentNode.getChildNodes();
					for (int iChild = 0; iChild < currentNode.getChildNodes().getLength(); iChild++) {
						
						correntChild=currentNode.getChildNodes().item(iChild);
						hasAttribute=correntChild.hasAttributes();						
						firstChild=correntChild./*getTextContent().equals(null)*/getFirstChild();
						elementName=correntChild.getNodeName();
						elementName=elementName.replace(getVariabile("=\"http://schemas.datacontract.org/2004/07/Grep.ManagementPlatform.Contracts.Dto\"")+":", "");						
						
						//System.out.println(currentNode.getChildNodes().item(iChild).getPrefix());
//						System.out.println(iChild);
						//System.out.println(currentNode.getNodeType()==Node.TEXT_NODE);
//						System.out.println("Elemento: "+currentNode./*getChildNodes().item(iChild).*/getNodeName());
//    					System.out.println(currentNode.getChildNodes().item(iChild).hasAttributes());
						if (!hasAttribute ? !firstChild.hasChildNodes() : false) {
							//System.out.println("5 -entrato if-"+currentNode.getChildNodes().item(iChild).getNodeName());
							for(j=0; j<metodi.length ;j++){
								//System.out.println(metodi[j].getName());
								if (metodi[j].getName().equals("set"+elementName )){ // aggiustare il nome									
									metodi[j].invoke(restituito, correntChild.getTextContent());
									break;
								} 
							}
							//if (currentNode.getParentNode().getChildNodes().getLength()-1 == iChild	) // misa che questo va fuori dall'if
						} else{
							if (hasAttribute) continue;
							System.out.println("5 -entrato else");
							for(j=0; j<metodi.length ;j++){
								if (metodi[j].getName().equals("set"+ elementName)){ // aggiustare il nome
									metodi[j].invoke(restituito,parsingClass(null, Class.forName("echo_server."+elementName),correntChild).get(0));//da modificare cercare di togliere il "echoserver."
									break;
								}
							}
						}
					}
					
					appList.add(restituito);
					if (elemento==null)
						return appList;
				}
			} catch (Exception sxe) {
				sxe.printStackTrace();
				return null;
				//System.out.println(sxe.getMessage());
			}
		return appList;
	}
	  private static String getVariabile(String url){
		    int indice=risposta.indexOf(url);
		    String app="";
		    int i=1;
		    while (true){
		    	variabile=risposta.charAt(indice-i);
		    	if (Character.compare(variabile, ':')==0)
		    		break;
		    	app=app+variabile;
		    	i++;
		    }
			return app;
		}
	  public static <T> ArrayList<T> getArrayDati(ArrayList<ArrayList<String>> Element,Class<T> classe) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException{
		  int i;
		  ArrayList<T> app=new ArrayList<T>();
		  String[] appS=new String[Element.size()]; 
		  Class[] classi=new Class[Element.size()];
		  T appO=classe.newInstance();
		  for(i=0;i<Element.size();i++){
			  classi[i]=String.class;
		  }
		  for(i=0;i<Element.size();i++){
			  classi[i]=String.class;
		  }
		  
		  Method set= classe.getMethod("setValori",classi);
		 
		  return null;
	  }
//	  
	  static public  ArrayList<ArrayList<String>> parsing(String documento){
			risposta=documento;
			ParserRisposta ddp = new ParserRisposta();
	        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	        ArrayList<ArrayList<String>> elencoValori=null;
	        ArrayList<String> appArrayList=null;
	         try {
	                DocumentBuilder builder = dbf.newDocumentBuilder();
	                Node currentNode;
	                Document document = builder.parse(new InputSource(new java.io.StringReader(xml)));
	                //ddp.printNodeInfo(document);
	                NodeList listaNodi=document.getElementsByTagName(getVariabile("=\"http://schemas.datacontract.org/2004/07/Grep.ManagementPlatform.Contracts.Dto\"")+":ContactPerson");
	                if(listaNodi==null)
	                	return null;
	                elencoValori=new ArrayList<ArrayList<String>>();
	                appArrayList=new ArrayList<String>();
	                for (int i=0; i<listaNodi.getLength();i++)
	                {
	                	currentNode =listaNodi.item(i);
	                	appArrayList.clear();
	 	               // NodeList nlChilds = currentNode.getChildNodes();
	 	                for (int iChild = 0; iChild < currentNode.getChildNodes().getLength(); iChild++) {
	 	                	appArrayList.add(searchTextInElement(currentNode.getChildNodes().item(iChild)));
	 	                	System.out.println(currentNode.getChildNodes().item(iChild).getNodeName());
	 	                }
	 	                elencoValori.add(appArrayList);
	                }
	                
	                
	         }  catch (SAXException sxe) {
               Exception  x = sxe;
               if (sxe.getException() != null)
                      x = sxe.getException();
               x.printStackTrace();
        } catch (ParserConfigurationException pce) {
               pce.printStackTrace();
        } catch (IOException ioe) {
               ioe.printStackTrace();
        }
	         return elencoValori;
		}
		
	    public void printNodeInfo(Node currentNode) {
	        short sNodeType = currentNode.getNodeType();
	        //Se è di tipo Element ricavo le informazioni e le stampo
	        if (sNodeType == Node.ELEMENT_NODE) {
	               String sNodeName = currentNode.getNodeName();
	               String sNodeValue = searchTextInElement(currentNode);
	               NamedNodeMap nnmAttributes = currentNode.getAttributes();
	               System.out.println("Elemento: " + sNodeName);
	               System.out.println("Attributi: " + printAttributes(nnmAttributes));
	             //  if (!sNodeValue.equals("")) {
	                      System.out.println("Contenuto: " + sNodeValue);
	               //}
	               System.out.print("\n");
	        }
	        int iChildNumber = currentNode.getChildNodes().getLength();
	        //Se non si tratta di una foglia continua l'esplorazione
	        if (currentNode.hasChildNodes()) {
	               NodeList nlChilds = currentNode.getChildNodes();
	               for (int iChild = 0; iChild < iChildNumber; iChild++) {
	                      printNodeInfo(nlChilds.item(iChild));
	               }
	        }
	  }


	  private static String searchTextInElement(Node elementNode) {
	        String sText = "";
	        if (elementNode.hasChildNodes()) {
	               //Il child node di tipo testo è il primo
	               Node nTextChild = elementNode.getChildNodes().item(0);
	               sText = nTextChild.getNodeValue();
	        }
	        return sText;
	  }
	  private static String printAttributes(NamedNodeMap nnm) {
	        String sAttrList = new String();
	        if (nnm != null && nnm.getLength() > 0) {
	               for (int iAttr=0; iAttr < nnm.getLength(); iAttr++) {
	                      sAttrList += nnm.item(iAttr).getNodeName();
	                      sAttrList += "=";
	                      sAttrList += nnm.item(iAttr).getNodeValue();
	                      sAttrList += "; ";
	               }
	               return sAttrList;
	        }
	        else {
	               return "assenti";
	        }
	  }
}}
