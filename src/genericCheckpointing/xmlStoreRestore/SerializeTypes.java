package genericCheckpointing.xmlStoreRestore;

public class SerializeTypes {
	
	public String serializeInt(int value,String tagName){
		return "  <"+tagName+" xsi:type=\"xsd:int\">"+value+"</"+tagName+">";
	}
	
	public String serializeLong(long value,String tagName){
		return "  <"+tagName+" xsi:type=\"xsd:long\">"+value+"</"+tagName+">";
	}
	
	public String serializeString(String value,String tagName){
		return "  <"+tagName+" xsi:type=\"xsd:string\">"+value+"</"+tagName+">";
	}
	
	public String serializeBoolean(boolean value,String tagName){
		return "  <"+tagName+" xsi:type=\"xsd:boolean\">"+value+"</"+tagName+">";
	}
	
	public String serializeDouble(double value,String tagName){
		return "  <"+tagName+" xsi:type=\"xsd:double\">"+value+"</"+tagName+">";
	}
	
	public String serializeFloat(float value,String tagName){
		return "  <"+tagName+" xsi:type=\"xsd:float\">"+value+"</"+tagName+">";
	}
	
	public String serializeShort(short value,String tagName){
		return "  <"+tagName+" xsi:type=\"xsd:short\">"+value+"</"+tagName+">";
	}
	
	public String serializeChar(char value,String tagName){
		return "  <"+tagName+" xsi:type=\"xsd:char\">"+value+"</"+tagName+">";
	}
}
