package genericCheckpointing.xmlStoreRestore;

public class DeserializeTypes {
	
	public int deSerializeInt(String input){
		int value = Integer.parseInt(input.substring(input.indexOf(">")+1,input.indexOf("</")));
		return value;
	}
	public long deSerializeLong(String input){
		long value = Long.parseLong(input.substring(input.indexOf(">")+1,input.indexOf("</")));
		return value;
	}
	
	public String deSerializeString(String input){
		return input.substring(input.indexOf(">")+1,input.indexOf("</"));
	}
	
	public boolean deSerializeBoolean(String input){
		boolean value = Boolean.parseBoolean(input.substring(input.indexOf(">")+1,input.indexOf("</")));
		return value;
	}
	
	public double deSerializeDouble(String input){
		double value = Double.parseDouble(input.substring(input.indexOf(">")+1,input.indexOf("</")));
		return value;
	}
	
	public float deSerializeFloat(String input){
		float value = Float.parseFloat(input.substring(input.indexOf(">")+1,input.indexOf("</")));
		return value;
	}
	
	public short deSerializeShort(String input){
		short value = Short.parseShort(input.substring(input.indexOf(">")+1,input.indexOf("</")));
		return value;
	}
	
	public char deSerializeChar(String input){
		String myChar = input.substring(input.indexOf(">")+1,input.indexOf("</"));
		char value = myChar.charAt(0);
		return value;
	}
}
