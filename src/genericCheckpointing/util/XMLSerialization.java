package genericCheckpointing.util;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import genericCheckpointing.server.SerStrategy;
import genericCheckpointing.xmlStoreRestore.SerializeTypes;

public class XMLSerialization implements SerStrategy {

	/**
	 *
	 *processInput() - This method is used to create Xml File from the objects passed to it. 	
	 *
	 * @param sObject - the SerializableObject Object's fields are used to create tags of Xml File
	 * 		  fileProcessor - Used to write tags into the File.
	 * @throws NoSuchMethodException, SecurityException, IOException, IllegalAccessException, 
	 * 		   IllegalArgumentException and InvocationTargetException.
	 *          
	 */
	@Override
	public void processInput(SerializableObject sObject,FileProcessor fileProcessor) {
		
		try{
		SerializeTypes serial = new SerializeTypes();
		fileProcessor.writeLineToFile("<DPSerialization>");
		Class<?> cls=sObject.getClass();
		fileProcessor.writeLineToFile(" <complexType xsi:type=\""+cls.getName()+"\">");
		
		Field fieldlist[] = cls.getDeclaredFields(); 
		for (int i = 0; i < fieldlist.length; i++) { 
		      Field fld = fieldlist[i]; 
		      if(fld.getType() == int.class){
		    	  String fieldName = fld.getName();
		    	  Method getMethod = cls.getMethod("get_"+fieldName);
		    	  Object returnValue = getMethod.invoke(sObject);
		    	  String input = serial.serializeInt((int)returnValue,fieldName);
		    	  fileProcessor.writeLineToFile(input);
		      }
		      else if(fld.getType() == double.class){
		    	  String fieldName = fld.getName();
		    	  Method getMethod = cls.getMethod("get_"+fieldName);
		    	  Object returnValue = getMethod.invoke(sObject);
		    	  String input = serial.serializeDouble((double)returnValue,fieldName);
		    	  fileProcessor.writeLineToFile(input);
		      }
		      else if(fld.getType() == long.class){
		    	  String fieldName = fld.getName();
		    	  Method getMethod = cls.getMethod("get_"+fieldName);
		    	  Object returnValue = getMethod.invoke(sObject);
		    	  String input = serial.serializeLong((long)returnValue,fieldName);
		    	  fileProcessor.writeLineToFile(input);
		      }
		      else if(fld.getType() == float.class){
		    	  String fieldName = fld.getName();
		    	  Method getMethod = cls.getMethod("get_"+fieldName);
		    	  Object returnValue = getMethod.invoke(sObject);
		    	  String input = serial.serializeFloat((float)returnValue,fieldName);
		    	  fileProcessor.writeLineToFile(input);
		      }
		      else if(fld.getType() == String.class){
		    	  String fieldName = fld.getName();
		    	  Method getMethod = cls.getMethod("get_"+fieldName);
		    	  Object returnValue = getMethod.invoke(sObject);
		    	  String input = serial.serializeString((String)returnValue,fieldName);
		    	  fileProcessor.writeLineToFile(input);
		      }
		      else if(fld.getType() == short.class){
		    	  String fieldName = fld.getName();
		    	  Method getMethod = cls.getMethod("get_"+fieldName);
		    	  Object returnValue = getMethod.invoke(sObject);
		    	  String input = serial.serializeShort((short)returnValue,fieldName);
		    	  fileProcessor.writeLineToFile(input);
		      }
		      else if(fld.getType() == boolean.class){
		    	  String fieldName = fld.getName();
		    	  Method getMethod = cls.getMethod("get_"+fieldName);
		    	  Object returnValue = getMethod.invoke(sObject);
		    	  String input = serial.serializeBoolean((boolean)returnValue,fieldName);
		    	  fileProcessor.writeLineToFile(input);
		      }
		      else if(fld.getType() == char.class){
		    	  String fieldName = fld.getName();
		    	  Method getMethod = cls.getMethod("get_"+fieldName);
		    	  Object returnValue = getMethod.invoke(sObject);
		    	  String input = serial.serializeChar((char)returnValue,fieldName);
		    	  fileProcessor.writeLineToFile(input);
		      }
	   }
		fileProcessor.writeLineToFile(" </complexType>");
		fileProcessor.writeLineToFile("</DPSerialization>");
		}
		catch (NoSuchMethodException e) {
			System.err.println("There is no such method in class"+sObject.getClass());
			System.exit(-1);
		} 
		catch (SecurityException e) {
			System.err.println("There is a Security Issue");
			System.exit(-1);
		}
		catch (IOException e){
			System.err.println("Could not Write a line to the File");
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
		
	}

	@Override
	public SerializableObject processInput(FileProcessor fileProcessor) {
		//Nothing to be done as method is for Deserialization
		return null;
	}

}
