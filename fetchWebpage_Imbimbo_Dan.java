import java.io.*; 
import java.net.*; 

class fetchWebpage_Imbimbo_Dan { 

    public static void main(String argv[]) throws Exception 
    { 
        String getRequest; 
        String serverInput = "";

        //Client socket creation
        Socket clientSocket = new Socket("www.cs.montclair.edu", 80);

        //Client socket input & output streams
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); 

        //HTTP Get Request
        getRequest = "GET /~wangd/pubs.html HTTP/1.1\r\n"
                + "Host: www.cs.montclair.edu\r\n";
        outToServer.writeBytes(getRequest + "\r\n");
        
        //Creates the output file to be written to
        PrintWriter outputFile = new PrintWriter("output_Imbimbo_Dan.txt");
        
        outputFile.println("The returned HTTP file:\n");
        //Loops through and writes each line of the web page's HTML code
        //to the specified output file
        for(int i = 1; (serverInput = inFromServer.readLine()) != null; i++){
            outputFile.println("Line " + i + ":" + serverInput);
        }
        outputFile.println("\nClosing Socket...");
        
        //Closes the object's stream
        outputFile.close();
        //Closes the socket's connection
        clientSocket.close();              
     }
}
