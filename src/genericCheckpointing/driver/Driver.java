package genericCheckpointing.driver;

import java.lang.reflect.InvocationHandler;
import java.util.Vector;

import genericCheckpointing.server.RestoreI;
import genericCheckpointing.server.StoreI;
import genericCheckpointing.server.StoreRestoreI;
import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;
import genericCheckpointing.util.ProxyCreator;
import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.xmlStoreRestore.StoreRestoreHandler;

public class Driver {

	public static void main(String[] args) {
		
		try{
			int NUM_OF_OBJECTS = Integer.parseInt(args[1]);
			String mode = args[0];
			String filename = args[2];
			boolean temp = false;
		
			ProxyCreator pc = new ProxyCreator();
			InvocationHandler handler = new StoreRestoreHandler();
		
			StoreRestoreI cpointRef = (StoreRestoreI) pc.createProxy(new Class[]{StoreI.class,RestoreI.class}, handler);
		
			MyAllTypesFirst myFirst;
			MyAllTypesSecond mySecond;
		
			
			if(mode.equals("deser")){
				
				((StoreRestoreHandler)handler).openFileRead(filename);
				SerializableObject myRecordRet;
				Vector<SerializableObject> returned_vector = new Vector<SerializableObject>();
				int wrong_objects = 0;
				
				for(int j=0; j<NUM_OF_OBJECTS; j++){
					myRecordRet = ((RestoreI)cpointRef).readObj("XML");
					returned_vector.addElement(myRecordRet);
				}
				for(int i=0;i<returned_vector.size();i++){
					if(returned_vector.elementAt(i) == null){
						wrong_objects++;
						continue;
					}
					System.out.println(returned_vector.elementAt(i).toString());
				}
				
				if(wrong_objects != 0){
					System.out.println("The File has only "+(NUM_OF_OBJECTS-wrong_objects)+" objects");
				}
				((StoreRestoreHandler)handler).closeFile();
				
			}
			else if(mode.equals("serdeser")){
				
				((StoreRestoreHandler)handler).openFileWrite(filename);
				char myChar = 'a';
				int mismatch = 0;
				Vector<SerializableObject> old_vector = new Vector<SerializableObject>();
				
				for(int i=0; i<NUM_OF_OBJECTS; i++){
					
					if(temp == false){
						temp=true;
					}
					else{
						temp=false;
					}
					
					myChar++;
					myFirst = new MyAllTypesFirst(i,i+3,"inputstring"+(i+1),temp);
					mySecond = new MyAllTypesSecond(i+2,i+4,(short) (i+6),myChar);
				
					old_vector.addElement(myFirst);
					((StoreI)cpointRef).writeObj(myFirst, "XML");
					old_vector.addElement(mySecond);
					((StoreI)cpointRef).writeObj(mySecond, "XML");
				}
				
				((StoreRestoreHandler)handler).closeFile();
				
				((StoreRestoreHandler)handler).openFileRead(filename);
				SerializableObject myRecordRet;
				Vector<SerializableObject> new_vector = new Vector<SerializableObject>();
				
				for(int j=0; j<2*NUM_OF_OBJECTS; j++){
					myRecordRet = ((RestoreI)cpointRef).readObj("XML");						
					new_vector.addElement(myRecordRet);
				}
				((StoreRestoreHandler)handler).closeFile();
				
				for(int i=0;i<old_vector.size();i++){
					if(old_vector.elementAt(i).equals(new_vector.elementAt(i))==false){
						mismatch++;
					}	
				}
				System.out.println("Mismatches="+mismatch);
				
			}
			else{
				System.err.println("The mode can be either serdeser or deser");
				System.exit(-1);
			}
		
		} 
		catch(NumberFormatException formatException) {
			System.err.println("Please enter valid Number of Objects !!");
			System.exit(-1);
		}
		
	}

}
