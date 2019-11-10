package JsonReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import UtilityClasses.Password;

public class JsonDataReader {
//	ClassLoader classLoader = getClass().getClassLoader();
//	File file = new File(classLoader.getResource("data.json").getFile());
	
	InputStream in = getClass().getResourceAsStream("/data.json"); 
	BufferedReader reader = new BufferedReader(new InputStreamReader(in));
	
	 private List<Password> passwordList;
	 
	 public JsonDataReader(){
		 passwordList = getPasswordTestData();
	 }
	 
	 private List<Password> getPasswordTestData() {
	 Gson gson = new Gson();
	 BufferedReader bufferReader = null;
	 try {
	 bufferReader = new BufferedReader(reader);
	 Password[] passwords = gson.fromJson(bufferReader, Password[].class);
	 return Arrays.asList(passwords);
	 }finally {
	 try { if(bufferReader != null) bufferReader.close();}
	 catch (IOException ignore) {}
	 }
	 }
	 
	 public final List<Password> getJSONTestData(){
	 return passwordList;
	 }
	 
	 
	}