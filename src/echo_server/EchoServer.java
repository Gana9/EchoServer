package echo_server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.util.List;

import static java.net.HttpURLConnection.HTTP_OK;




// EchoServer.java
import java.io.*;
import java.net.*;
public class EchoServer { 
	public static final int PORT =4444;
    static String s="<html><head><title>Benvenuto</title></head><body><div align=”center”><font size=\"6\">Hello World!</font></div></body></html>";
	static String appoggio="HTTP/1.1 200 OK\r\nContent-Length: 2877\r\nContent-Type: application/soap+xml; charset=utf-8\r\nServer: Microsoft-HTTPAPI/2.0\r\n\r\n"+s;

// porta al di fuori del range 1-1024 !
public static void main(String[] args) throws IOException {
	ServerSocket serverSocket = new ServerSocket(PORT);
	System.out.println("EchoServer: started ");
	System.out.println("Server Socket: "+ serverSocket);
	Socket clientSocket=null;
	BufferedReader in=null;
	PrintWriter out=null;
	
	try {
		UDPserver();
	} catch (Throwable e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	try
	{
		 do{
		clientSocket = serverSocket.accept();
		System.out.println("Connection accepted: "+ clientSocket);
		InputStreamReader isr =new InputStreamReader(clientSocket.getInputStream());
		in =new BufferedReader(isr);
		OutputStreamWriter osw = new OutputStreamWriter(clientSocket.getOutputStream());
		BufferedWriter bw =new BufferedWriter(osw);
		out =new PrintWriter(bw,true);
		String app;

		//String appoggio="HTTP/1.1 500 Internal Server Error\r\nContent-Length: 9051\r\nContent-Type: application/soap+xml; charset=utf-8\r\nServer: Microsoft-HTTPAPI/2.0\r\n\r\n<s:Envelope xmlns:s=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:a=\"http://www.w3.org/2005/08/addressing\"><s:Header><a:Action s:mustUnderstand=\"1\">http://schemas.microsoft.com/net/2005/12/windowscommunicationfoundation/dispatcher/fault</a:Action></s:Header><s:Body><s:Fault><s:Code><s:Value>s:Receiver</s:Value><s:Subcode><s:Value xmlns:a=\"http://schemas.microsoft.com/net/2005/12/windowscommunicationfoundation/dispatcher\">a:InternalServiceFault</s:Value></s:Subcode></s:Code><s:Reason><s:Text xml:lang=\"it-IT\">Unable to obtain service fault fromexception: System.ServiceModel.Security.SecurityAccessDeniedException: Provided credentials are not valid.&#xD;   at Grep.ManagementPlatform.Services.Business.Impl.ThrowOnFailureAuthenticationProvider.Throw() in e:\\Work\\Grep\\ManagementPlatform\\src\\Grep.ManagementPlatform\\Grep.ManagementPlatform.Services\\Business\\Impl\\ThrowOnFailureAuthenticationProvider.cs:line 42&#xD;   at Grep.ManagementPlatform.Services.Business.Impl.ThrowOnFailureAuthenticationProvider.ValidateCustomerCredentials(ServiceCredentialsDto credentials) in e:\\Work\\Grep\\ManagementPlatform\\src\\Grep.ManagementPlatform\\Grep.ManagementPlatform.Services\\Business\\Impl\\ThrowOnFailureAuthenticationProvider.cs:line 30&#xD;   at Grep.ManagementPlatform.Services.Impl.ComponentServiceImpl.AuthenticateCustomerAccount(ServiceCredentialsDto credentials) in e:\\Work\\Grep\\ManagementPlatform\\src\\Grep.ManagementPlatform\\Grep.ManagementPlatform.Services\\Impl\\ComponentServiceImpl.cs:line 104&#xD;   at Castle.Proxies.Invocations.IComponentService_AuthenticateCustomerAccount.InvokeMethodOnTarget()&#xD;   at Castle.DynamicProxy.AbstractInvocation.Proceed()&#xD;   at Grep.ManagementPlatform.Data.Impl.NHibernate.Integration.NHTransactionIntegration.NHibernateTransactionInterceptor.Intercept(IInvocation invocation) in e:\\Work\\Grep\\ManagementPlatform\\src\\Grep.ManagementPlatform\\Grep.ManagementPlatform.Data.Impl.NHibernate\\Integration\\NHTransactionIntegration\\NHibernateTransactionInterceptor.cs:line 62&#xD;   at Castle.DynamicProxy.AbstractInvocation.Proceed()&#xD;   at Castle.Facilities.AutoTx.TransactionInterceptor.SynchronizedCase(IInvocation invocation, ITransaction transaction) in d:\\BuildAgent-03\\work\\9844bdf039249947\\src\\Castle.Facilities.AutoTx\\TransactionInterceptor.cs:line 179&#xD;   at Castle.Facilities.AutoTx.TransactionInterceptor.Castle.DynamicProxy.IInterceptor.Intercept(IInvocation invocation) in d:\\BuildAgent-03\\work\\9844bdf039249947\\src\\Castle.Facilities.AutoTx\\TransactionInterceptor.cs:line 119&#xD;   at Castle.DynamicProxy.AbstractInvocation.Proceed()&#xD;   at Grep.ManagementPlatform.Commons.Integration.Interceptors.ServiceLoggingInterceptor.Intercept(IInvocation invocation) in e:\\Work\\Grep\\ManagementPlatform\\src\\Grep.ManagementPlatform\\Grep.ManagementPlatform.Commons\\Integration\\Interceptors\\ServiceLoggingInterceptor.cs:line 33&#xD;   at Castle.DynamicProxy.AbstractInvocation.Proceed()&#xD;   at Grep.ManagementPlatform.Commons.Integration.Interceptors.ServiceExceptionHandlingInterceptor.Intercept(IInvocation invocation) in e:\\Work\\Grep\\ManagementPlatform\\src\\Grep.ManagementPlatform\\Grep.ManagementPlatform.Commons\\Integration\\Interceptors\\ServiceExceptionHandlingInterceptor.cs:line 33</s:Text></s:Reason><s:Detail><ExceptionDetail xmlns=\"http://schemas.datacontract.org/2004/07/System.ServiceModel\" xmlns:i=\"http://www.w3.org/2001/XMLSchema-instance\"><HelpLink i:nil=\"true\"/><InnerException><HelpLink>groups.google.com/group/castle-project-users</HelpLink><InnerException i:nil=\"true\"/><Message>No component for supporting the service Grep.ManagementPlatform.Commons.ExceptionManagement.ServiceFaultAssemblers.DefaultServiceFaultAssembler was found</Message><StackTrace>   at Castle.MicroKernel.DefaultKernel.Castle.MicroKernel.IKernelInternal.Resolve(Type service, IDictionary arguments, IReleasePolicy policy)&#xD;   at Castle.Facilities.TypedFactory.TypedFactoryComponentResolver.Resolve(IKernelInternal kernel, IReleasePolicy scope)&#xD;   at Castle.Facilities.TypedFactory.Internal.TypedFactoryInterceptor.Resolve(IInvocation invocation)&#xD;   at Castle.Facilities.TypedFactory.Internal.TypedFactoryInterceptor.Intercept(IInvocation invocation)&#xD;   at Castle.DynamicProxy.AbstractInvocation.Proceed()&#xD;   at Castle.Proxies.IServiceFaultAssemblerFactoryProxy.GetServiceFaultAssembler(Exception e)&#xD;   at Grep.ManagementPlatform.Commons.ExceptionManagement.ServiceFaultAssemblerHelper.AssembleFault(IServiceFaultAssemblerFactory factory, Exception e) in e:\\Work\\Grep\\ManagementPlatform\\src\\Grep.ManagementPlatform\\Grep.ManagementPlatform.Commons\\ExceptionManagement\\ServiceFaultAssemblerHelper.cs:line 14</StackTrace><Type>Castle.MicroKernel.ComponentNotFoundException</Type></InnerException><Message>Unable to obtain service fault from exception: System.ServiceModel.Security.SecurityAccessDeniedException: Provided credentials are not valid.&#xD;   at Grep.ManagementPlatform.Services.Business.Impl.ThrowOnFailureAuthenticationProvider.Throw() in e:\\Work\\Grep\\ManagementPlatform\\src\\Grep.ManagementPlatform\\Grep.ManagementPlatform.Services\\Business\\Impl\\ThrowOnFailureAuthenticationProvider.cs:line 42&#xD;   at Grep.ManagementPlatform.Services.Business.Impl.ThrowOnFailureAuthenticationProvider.ValidateCustomerCredentials(ServiceCredentialsDto credentials) in e:\\Work\\Grep\\ManagementPlatform\\src\\Grep.ManagementPlatform\\Grep.ManagementPlatform.Services\\Business\\Impl\\ThrowOnFailureAuthenticationProvider.cs:line 30&#xD;   at Grep.ManagementPlatform.Services.Impl.ComponentServiceImpl.AuthenticateCustomerAccount(ServiceCredentialsDto credentials) in e:\\Work\\Grep\\ManagementPlatform\\src\\Grep.ManagementPlatform\\Grep.ManagementPlatform.Services\\Impl\\ComponentServiceImpl.cs:line 104&#xD;   at Castle.Proxies.Invocations.IComponentService_AuthenticateCustomerAccount.InvokeMethodOnTarget()&#xD;   at Castle.DynamicProxy.AbstractInvocation.Proceed()&#xD;   at Grep.ManagementPlatform.Data.Impl.NHibernate.Integration.NHTransactionIntegration.NHibernateTransactionInterceptor.Intercept(IInvocation invocation) in e:\\Work\\Grep\\ManagementPlatform\\src\\Grep.ManagementPlatform\\Grep.ManagementPlatform.Data.Impl.NHibernate\\Integration\\NHTransactionIntegration\\NHibernateTransactionInterceptor.cs:line 62&#xD;   at Castle.DynamicProxy.AbstractInvocation.Proceed()&#xD;   at Castle.Facilities.AutoTx.TransactionInterceptor.SynchronizedCase(IInvocation invocation, ITransaction transaction) in d:\\BuildAgent-03\\work\\9844bdf039249947\\src\\Castle.Facilities.AutoTx\\TransactionInterceptor.cs:line 179&#xD;   at Castle.Facilities.AutoTx.TransactionInterceptor.Castle.DynamicProxy.IInterceptor.Intercept(IInvocation invocation) in d:\\BuildAgent-03\\work\\9844bdf039249947\\src\\Castle.Facilities.AutoTx\\TransactionInterceptor.cs:line 119&#xD;   at Castle.DynamicProxy.AbstractInvocation.Proceed()&#xD;   at Grep.ManagementPlatform.Commons.Integration.Interceptors.ServiceLoggingInterceptor.Intercept(IInvocation invocation) in e:\\Work\\Grep\\ManagementPlatform\\src\\Grep.ManagementPlatform\\Grep.ManagementPlatform.Commons\\Integration\\Interceptors\\ServiceLoggingInterceptor.cs:line 33&#xD;   at Castle.DynamicProxy.AbstractInvocation.Proceed()&#xD;   at Grep.ManagementPlatform.Commons.Integration.Interceptors.ServiceExceptionHandlingInterceptor.Intercept(IInvocation invocation) in e:\\Work\\Grep\\ManagementPlatform\\src\\Grep.ManagementPlatform\\Grep.ManagementPlatform.Commons\\Integration\\Interceptors\\ServiceExceptionHandlingInterceptor.cs:line 33</Message><StackTrace>   at Grep.ManagementPlatform.Commons.ExceptionManagement.ServiceFaultAssemblerHelper.AssembleFault(IServiceFaultAssemblerFactory factory, Exception e) in e:\\Work\\Grep\\ManagementPlatform\\src\\Grep.ManagementPlatform\\Grep.ManagementPlatform.Commons\\ExceptionManagement\\ServiceFaultAssemblerHelper.cs:line 23&#xD;   at Grep.ManagementPlatform.Commons.Integration.Interceptors.ServiceExceptionHandlingInterceptor.Intercept(IInvocation invocation) in e:\\Work\\Grep\\ManagementPlatform\\src\\Grep.ManagementPlatform\\Grep.ManagementPlatform.Commons\\Integration\\Interceptors\\ServiceExceptionHandlingInterceptor.cs:line 64&#xD;   at Castle.DynamicProxy.AbstractInvocation.Proceed()&#xD;   at Castle.Proxies.IComponentServiceProxy.AuthenticateCustomerAccount(ServiceCredentialsDto credentials)&#xD;   at SyncInvokeAuthenticateCustomerAccount(Object , Object[] , Object[] )&#xD;   at System.ServiceModel.Dispatcher.SyncMethodInvoker.Invoke(Object instance, Object[] inputs, Object[]&amp; outputs)&#xD;   at System.ServiceModel.Dispatcher.DispatchOperationRuntime.InvokeBegin(MessageRpc&amp; rpc)&#xD;   at System.ServiceModel.Dispatcher.ImmutableDispatchRuntime.ProcessMessage5(MessageRpc&amp; rpc)&#xD;   at System.ServiceModel.Dispatcher.ImmutableDispatchRuntime.ProcessMessage31(MessageRpc&amp; rpc)&#xD;   at System.ServiceModel.Dispatcher.MessageRpc.Process(Boolean isOperationContextSet)</StackTrace><Type>System.InvalidOperationException</Type></ExceptionDetail></s:Detail></s:Fault></s:Body></s:Envelope>";

//		 do{
			 app = in.readLine();
         
//         		System.out.println(app.toString());
//         	if(app.substring(0, 1).equals("<")){
               // appoggio=""+app;
//                System.out.println(appoggio.replace(">", "> \n"));}
//         		System.out.println("0-loooop");
//       }while (!app.equals(null));
		 System.out.println("1-loooop");
		 out.println(appoggio);
//		while (true) {
//			String str = in.readLine();
//			if(str.equals("END"))
//				break;
//			System.out.println("Echoing: "+ str);
//			out.println(str);
//		}
		 clientSocket.close();
	 }while (true);
	}
	catch (IOException e) {
		System.err.println("Accept failed");
		System.exit(1);
	}
	
	System.out.println("EchoServer: closing...");
	
	out.close();
	in.close();
	clientSocket.close();
	serverSocket.close();
}
	public static void UDPserver() throws Throwable{
		 DatagramSocket serverSocket = new DatagramSocket(PORT);
         
         byte[] sendData = new byte[3000];
         while(true)
            {
        	 System.out.println("ACCEPTING\n");
        	 byte[] receiveData = new byte[3000];
               DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
               serverSocket.receive(receivePacket);
               //String sentence = new String( receivePacket.getData());
               
               System.out.println("RECEIVED: " + serverSocket+"  "+receivePacket.getAddress()+" / "+(new String(receiveData)));
               
               InetAddress IPAddress = receivePacket.getAddress();
           
               int port = receivePacket.getPort();
               sendData = appoggio.getBytes();
               DatagramPacket sendPacket =
               new DatagramPacket(sendData, appoggio.length(), IPAddress, port);
               serverSocket.send(sendPacket);
               
            } 
	}
}
