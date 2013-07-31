package com.shaz;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class notepad extends Activity 
{	public String shivam;
	Bean shaz = new Bean();
	String bansal=shaz.getValue();
	EditText textOut;
	TextView textIn;
@Override
 public void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_main);
     Button buttonSend = (Button)findViewById(R.id.send);
     textIn = (TextView)findViewById(R.id.textin);
     buttonSend.setOnClickListener(buttonSendOnClickListener);
 }
 Button.OnClickListener buttonSendOnClickListener
 = new Button.OnClickListener(){
@Override
public void onClick(View arg0) {
Toast.makeText(getApplicationContext(),bansal, Toast.LENGTH_SHORT).show();
Socket socket = null;
 DataOutputStream dataOutputStream = null;
 DataInputStream dataInputStream = null;
 try {
	 
	 Bundle extras = getIntent().getExtras();
		if (extras != null) 
		{
		String hello = extras.getString("id");
		if( hello.equals("notepad"))
		{
		shivam = "notepad"; 
		}
		else if ( hello.equals("browser"))
		{
			shivam = "browser";
		}
		else if ( hello.equals("cmd"))
		{
			shivam = "cmd";
		}
		else if( hello.equals("lib"))
		{
		shivam = "lib"; 
		}
		else if( hello.equals("vid"))
		{
		shivam = "vid"; 
		}
		else if( hello.equals("msword"))
		{
		shivam = "msword"; 
		}
		else if( hello.equals("wordpad"))
		{
		shivam = "wordpad"; 
		}
		else if( hello.equals("sticky"))
		{
		shivam = "sticky"; 
		}
		}
  socket = new Socket(bansal, 8888);
  dataOutputStream = new DataOutputStream(socket.getOutputStream());
  dataInputStream = new DataInputStream(socket.getInputStream());
  dataOutputStream.writeUTF(shivam);
  textIn.setText(dataInputStream.readUTF());
 } catch (UnknownHostException e) {
  e.printStackTrace();
 } catch (IOException e) {
  e.printStackTrace();
 }
 finally{
  if (socket != null){
   try {
    socket.close();
   } catch (IOException e) {
    e.printStackTrace();
   }
  }
  if (dataOutputStream != null){
   try {
    dataOutputStream.close();
   } catch (IOException e) {
       e.printStackTrace();
   }
  }
  if (dataInputStream != null){
   try {
    dataInputStream.close();
   } catch (IOException e) {
     e.printStackTrace();
   }
  }
  startActivity(new Intent("com.shaz.notewrite"));
 } 
}
};
}


