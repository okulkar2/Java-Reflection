package genericCheckpointing.util;

public class MyAllTypesSecond extends SerializableObject {
	double myDoubleT;
	float myFloatT;
	short myShortT;
	char myCharT;
	
	public MyAllTypesSecond(){
	}
	
	public MyAllTypesSecond(double myDoubleIn,float myFloatIn,short myShortIn,char myCharIn){
		myDoubleT = myDoubleIn;
		myFloatT = myFloatIn;
		myShortT = myShortIn;
		myCharT = myCharIn;
	}
	
	/**
	 *
	 *get_myDoubleT() is used to return the  value of myDoubleT data member 
	 *
	 *@return myDoubleT data member value
	 *
	*/
	public double get_myDoubleT() {
		return myDoubleT;
	}
	
	/**
	 *
	 *set_myDoubleT() is used to set the value of myDoubleT data member
	 *
	 *@param myDoubleT- Double value which is used to set myDoubleT data member. 
	 *
	*/
	public void set_myDoubleT(double myDoubleT) {
		this.myDoubleT = myDoubleT;
	}
	
	/**
	 *
	 *get_myFloatT() is used to return the  value of myFloatT data member 
	 *
	 *@return myFloatT data member value
	 *
	*/
	public float get_myFloatT() {
		return myFloatT;
	}
	
	/**
	 *
	 *set_myFloatT() is used to set the value of myFloatT data member
	 *
	 *@param myFloatT- Float value which is used to set myFloatT data member. 
	 *
	*/
	public void set_myFloatT(float myFloatT) {
		this.myFloatT = myFloatT;
	}
	
	/**
	 *
	 *get_myShortT() is used to return the  value of myShortT data member 
	 *
	 *@return myShortT data member value
	 *
	*/
	public short get_myShortT() {
		return myShortT;
	}
	
	/**
	 *
	 *set_myShortT() is used to set the value of myShortT data member
	 *
	 *@param myShortT- Short value which is used to set myShortT data member. 
	 *
	*/
	public void set_myShortT(short myShortT) {
		this.myShortT = myShortT;
	}
	
	/**
	 *
	 *get_myCharT() is used to return the  value of myCharT data member 
	 *
	 *@return myCharT data member value
	 *
	*/
	public char get_myCharT() {
		return myCharT;
	}
	
	/**
	 *
	 *set_myCharT() is used to set the value of myCharT data member
	 *
	 *@param myCharT- Character value which is used to set myCharT data member. 
	 *
	*/
	public void set_myCharT(char myCharT) {
		this.myCharT = myCharT;
	}
	
	@Override
	public String toString(){
		return "MyAllTypesSecond Class\nDouble value:"+myDoubleT+"\nFloat value:"+myFloatT+"\nShort value:"+myShortT+"\nChar value:"+myCharT+"\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + myCharT;
		long temp;
		temp = Double.doubleToLongBits(myDoubleT);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + Float.floatToIntBits(myFloatT);
		result = prime * result + myShortT;
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
		
		boolean return_value = true;
		
		if(obj == null || getClass() != obj.getClass()){
			return false;
		}
		MyAllTypesSecond other = (MyAllTypesSecond) obj;
		if (myCharT != other.myCharT){
			return_value = false;
		}
		if (Double.doubleToLongBits(myDoubleT) != Double.doubleToLongBits(other.myDoubleT)){
			return_value = false;
		}
		if (Float.floatToIntBits(myFloatT) != Float.floatToIntBits(other.myFloatT)){
			return_value = false;
		}
		if (myShortT != other.myShortT){
			return_value = false;
		}
		
		return return_value;
	}
	
}
