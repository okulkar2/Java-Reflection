package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.server.SerStrategy;
import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.util.XMLDeserialization;
import genericCheckpointing.util.XMLSerialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StoreRestoreHandler implements InvocationHandler{

	FileProcessor fileProcessor;
	
	public StoreRestoreHandler(){		
	}
	
	/**
	 * openFileWrite(String filenameIn) is used to open the file 
	 * in write mode with the passed filenameIn.
	 * 	
	 * @param filenameIn
	 *          
	 */
	public void openFileWrite(String filenameIn){
		
		try {
			FileOutputStream outputStream= new FileOutputStream(filenameIn);
			fileProcessor = new FileProcessor(outputStream);
		} catch (FileNotFoundException e) {
			System.err.println("Error opening file. Please check if the file name is valid !!");
			System.exit(1);
		}	
	}
	
	/**
	 * openFileRead(String filenameIn) is used to open the file 
	 * in read mode with the passed filenameIn.
	 * 	
	 * @param filenameIn
	 *          
	 */
	public void openFileRead(String filenameIn){
		
		try {
			FileInputStream inputStream= new FileInputStream(filenameIn);
			fileProcessor = new FileProcessor(inputStream);
			
		} catch (FileNotFoundException e) {
			System.err.println("Error opening file. Please check if the file name is valid !!");
			System.exit(1);
		}	
	}
	
	/**
	 *
	 *invoke() - Processes a method invocation on a proxy instance and returns the result. 	
	 *
	 * @param proxy - the proxy instance that the method was invoked on
	 * 		  method - the Method instance corresponding to the interface method invoked on the proxy instance. 
	 * 		  args - an array of objects containing the values of the arguments passed in the method invocation 
	 * 				 on the proxy instance, or null if interface method takes no arguments.
	 *          
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		String methName = method.getName();
		//System.out.println("Method called is:"+methName);
		
		if(methName.equals("writeObj")){
			
			String wireFormat = args[1].toString();
			
			if(wireFormat.equals("XML")){
				serializeData((SerializableObject)args[0], new XMLSerialization());
			}

		}
		
		if(methName.equals("readObj")){
			
			String wireFormat = args[0].toString();
			
			if(wireFormat.equals("XML")){
				SerializableObject sObject = deserializeData(new XMLDeserialization());
				return sObject;
			}
		}
		return null;
	}
	
	/**
	 *
	 *serializeData() - This method is used call serialize the Objects. 	
	 *
	 * @param sObject - the SerializableObject Object which is to be Serialized
	 * 		  sStrategy - Determines the strategy class at runtime to Serialize. 
	 *          
	 */
	public void serializeData(SerializableObject sObject, SerStrategy sStrategy) {
        sStrategy.processInput(sObject,fileProcessor);
	}
	
	/**
	 *
	 *deserializeData() - This method is used to return SerializableObject object 
	 *					  which is formed after reading from Xml File. 	
	 *
	 * @param sStrategy - Determines the strategy class at runtime to DeSerialize. 
	 * @return SerializableObject created from deserializing the Xml File.
	 *          
	 */
	public SerializableObject deserializeData(SerStrategy sStrategy) {
         return sStrategy.processInput(fileProcessor);
	}
	
	/**
	 * closeFile() is used to close the given file 
	 *          
	 */
	public void closeFile(){
		
		if(fileProcessor!=null){
			fileProcessor.closeStream();
		}
		
	}

}
