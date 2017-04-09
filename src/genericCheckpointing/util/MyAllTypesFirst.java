package genericCheckpointing.util;

public class MyAllTypesFirst extends SerializableObject{
	
	int myInt;
	long myLong;
	String myString;
	boolean myBool;
	
	public MyAllTypesFirst(){
	}
	
	public MyAllTypesFirst(int myIntIn,long myLongIn,String myStringIn,boolean myBoolIn){
		myInt = myIntIn;
		myLong = myLongIn;
		myString = myStringIn;
		myBool = myBoolIn;
	}
	
	/**
	 *
	 *get_myInt() is used to return the  value of myInt data member 
	 *
	 *@return myInt data member value
	 *
	*/
	public int get_myInt() {
		return myInt;
	}
	
	/**
	 *
	 *set_myInt() is used to set the value of myInt data member
	 *
	 *@param myInt- int value which is used to set myInt data member. 
	 *
	*/
	public void set_myInt(int myInt) {
		this.myInt = myInt;
	}
	
	/**
	 *
	 *get_myLong() is used to return the  value of myLong data member 
	 *
	 *@return myLong data member value
	 *
	*/
	public long get_myLong() {
		return myLong;
	}
	
	/**
	 *
	 *set_myLong() is used to set the value of myLong data member
	 *
	 *@param myLong-long value which is used to set myLong data member. 
	 *
	*/
	public void set_myLong(long myLong) {
		this.myLong = myLong;
	}
	
	/**
	 *
	 *get_myString() is used to return the  value of myString data member 
	 *
	 *@return myString data member value
	 *
	*/
	public String get_myString() {
		return myString;
	}
	
	/**
	 *
	 *set_myString() is used to set the value of myString data member
	 *
	 *@param myInt- String value which is used to set myString data member. 
	 *
	*/
	public void set_myString(String myString) {
		this.myString = myString;
	}
	
	/**
	 *
	 *get_myBool() is used to return the  value of myBool data member 
	 *
	 *@return myBool data member value
	 *
	*/
	public boolean get_myBool() {
		return myBool;
	}
	
	/**
	 *
	 *set_myBool() is used to set the value of myBool data member
	 *
	 *@param myBool- boolean value which is used to set myBool data member. 
	 *
	*/
	public void set_myBool(boolean myBool) {
		this.myBool = myBool;
	}
	
	@Override
	public String toString(){
		return "MyAllTypesFirst Class\nInt value:"+myInt+"\nLong value:"+myLong+"\nString value:"+myString+"\nBoolean value:"+myBool+"\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (myBool ? 1231 : 1237);
		result = prime * result + myInt;
		result = prime * result + (int) (myLong ^ (myLong >>> 32));
		result = prime * result + ((myString == null) ? 0 : myString.hashCode());
		return result;
	}

	/**
	 *
	 *equals() - This overridden method is used to check if the passed obj is equal to the given object. 	
	 *
	 * @param Object - The Object which is to be compared.
	 * @return boolean value which is true is objects are equal, false otherwise.
	 *          
	 */
	@Override
	public boolean equals(Object obj) {
	
		boolean return_value=true;
		
		if(obj == null || getClass() != obj.getClass()){
			return false;
		}
		MyAllTypesFirst other = (MyAllTypesFirst) obj;
		if (myBool != other.myBool){
			return_value = false;
		}
		if (myInt != other.myInt){
			return_value = false;
		}
		if (myLong != other.myLong){
			return_value = false;
		}
		if (myString == null) {
			if (other.myString != null){
				return_value = false;
			}
		} else if (!myString.equals(other.myString)){
			return_value = false;
		}
		
		return return_value;
	}
	
}
