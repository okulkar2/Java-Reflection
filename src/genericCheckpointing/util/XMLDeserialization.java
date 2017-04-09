package genericCheckpointing.util;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import genericCheckpointing.server.SerStrategy;
import genericCheckpointing.xmlStoreRestore.DeserializeTypes;

public class XMLDeserialization implements SerStrategy{
	
	@Override
	public void processInput(SerializableObject sObject, FileProcessor fileProcessor) {
		//Nothing to be done as method is for Serialization
	}

	/**
	 *
	 *processInput() - This method is used to create Objects from the given Xml file passed to it. 	
	 *
	 * @param fileProcessor - Contains a pointer to Xml File which is parsed to create Objects.
	 * @return SerializableObject
	 * @throws NoSuchMethodException, SecurityException, IOException, IllegalAccessException, 
	 * 		   IllegalArgumentException, InvocationTargetException and NullPointerException.
	 *          
	 */
	@Override
	public SerializableObject processInput(FileProcessor fileProcessor) {
		try{
			DeserializeTypes deserial = new DeserializeTypes();
			String inputLine = fileProcessor.readLineFromFile();
			String elementTag = "<complexType";
			while((inputLine.contains(elementTag)) != true){
				inputLine = fileProcessor.readLineFromFile();
			}
		
			String className = inputLine.substring(inputLine.indexOf("\"")+1,inputLine.lastIndexOf("\""));
			Class<?> cls = Class.forName(className);
			Object obj = cls.newInstance(); 
			Class<?>[] signature = new Class<?>[1];
			Object[] params = new Object[1];
		
			while((inputLine = fileProcessor.readLineFromFile()).contains("/complexType") != true){
			
				inputLine = inputLine.trim();
			
				if(inputLine.contains("myInt")){
					String fieldName = inputLine.substring(inputLine.indexOf("<")+1,inputLine.indexOf(" "));
					signature[0] = int.class; 
					Method meth= cls.getMethod("set_"+fieldName,signature);
					int value = deserial.deSerializeInt(inputLine); 
					params[0] = value; 
					meth.invoke(obj, params);
				}
				else if(inputLine.contains("myDoubleT")){
					String fieldName = inputLine.substring(inputLine.indexOf("<")+1,inputLine.indexOf(" "));
					signature[0] = double.class; 
					Method meth = cls.getMethod("set_"+fieldName,signature);
					double value = deserial.deSerializeDouble(inputLine); 
					params[0] = value; 
					meth.invoke(obj, params);
				}
				else if(inputLine.contains("myLong")){
					String fieldName = inputLine.substring(inputLine.indexOf("<")+1,inputLine.indexOf(" "));
					signature[0] = long.class; 
					Method meth = cls.getMethod("set_"+fieldName,signature);
					long value = deserial.deSerializeLong(inputLine); 
					params[0] = value; 
					meth.invoke(obj, params);
				}
				else if(inputLine.contains("myFloatT")){
					String fieldName = inputLine.substring(inputLine.indexOf("<")+1,inputLine.indexOf(" "));
					signature[0] = float.class; 
					Method meth = cls.getMethod("set_"+fieldName,signature);
					float value = deserial.deSerializeFloat(inputLine); 
					params[0] = value; 
					meth.invoke(obj, params);
				}
				else if(inputLine.contains("myString")){
					String fieldName = inputLine.substring(inputLine.indexOf("<")+1,inputLine.indexOf(" "));
					signature[0] = String.class; 
					Method meth = cls.getMethod("set_"+fieldName,signature);
					String value = deserial.deSerializeString(inputLine); 
					params[0] = value; 
					meth.invoke(obj, params);
				}
				else if(inputLine.contains("myShortT")){
					String fieldName = inputLine.substring(inputLine.indexOf("<")+1,inputLine.indexOf(" "));
					signature[0] = short.class; 
					Method meth = cls.getMethod("set_"+fieldName,signature);
					short value = deserial.deSerializeShort(inputLine); 
					params[0] = value; 
					meth.invoke(obj, params);
				}
				else if(inputLine.contains("myBool")){
		    	  	String fieldName = inputLine.substring(inputLine.indexOf("<")+1,inputLine.indexOf(" "));
		    	  	signature[0] = boolean.class; 
		    	  	Method meth = cls.getMethod("set_"+fieldName,signature);
		    	  	boolean value = deserial.deSerializeBoolean(inputLine); 
		    	  	params[0] = value; 
		    	  	meth.invoke(obj, params);
				}
				else if(inputLine.contains("myCharT")){
					String fieldName = inputLine.substring(inputLine.indexOf("<")+1,inputLine.indexOf(" "));
					signature[0] = char.class; 
					Method meth = cls.getMethod("set_"+fieldName,signature);
					char value = deserial.deSerializeChar(inputLine); 
					params[0] = value; 
					meth.invoke(obj, params);
				}
			}
			return (SerializableObject)obj;
		}
		catch (NoSuchMethodException e) {
			System.err.println("There is no such method in class");
			System.exit(-1);
		} 
		catch (SecurityException e) {
			System.err.println("There is a Security Issue");
			System.exit(-1);
		}
		catch (IOException e){
			System.err.println("Could not Read a line from the File");
			System.exit(-1);
		} 
		catch (IllegalAccessException e) {
			System.err.println("Application trying to create an instance, set or get a field, or invoke a method, but the currently executing method does not have the access right.Details:"+e.getMessage());
			System.exit(-1);
		} 
		catch (IllegalArgumentException e) {
			System.err.println("Method has been passed an illegal or inappropriate argument and details:"+e.getMessage());
			System.exit(-1);
		} 
		catch (InvocationTargetException e) {
			System.err.println("InvocationTargetException caught and Details:"+e.getMessage());
			System.exit(-1);
		} 
		catch (InstantiationException e) {
			System.err.println("Sorry, The given Class could not be found");
			System.exit(-1);
		} 
		catch (ClassNotFoundException e) {
			System.err.println("Sorry, The given Class could not be found");
			System.exit(-1);
		}
		catch (NullPointerException e) {
		}
		return null;
	}
}
