        import java.net.*;  
    import java.io.*;  
    class Server{  
    public static void main(String args[])throws Exception{ 
    System.out.println("Waiting for connection"); 
    ServerSocket ss=new ServerSocket(3334);  
    Socket s=ss.accept();
    System.out.println("Connected");  
    DataInputStream din=new DataInputStream(s.getInputStream());  
    DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
    String str="",str2="";  
    while(!str.equals("stop")){  
    str=din.readUTF();     
    dout.writeUTF(str.toUpperCase());  
    dout.flush();  
    }  
    din.close();  
    s.close();  
    ss.close();  
    }}  


