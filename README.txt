FILES:

	This Assignment includes 11 Files, namely

	-- driver
	   1) Driver.java- Main file which contains the main method to run the code.
	
	-- util
	   1) FileProcessor.java- Used to open a File and read a single Line as well as write line to the given File.
	   2) MyAllTypesFirst.java- Java class which contains data members which are to be serialized or deserialized.
	   3) MyAllTypesSecond.java- Java class which contains data members which are to be serialized or deserialized.
	   4) ProxyCreator.java- Utility class used to create a dynamic proxy reference.
	   5) SerializableObject.java- Empty Base class.
	   6) XMLSerialization.java- Utility Class used to perofrm Serialization on Objects.
	   7) XMLDeserialization.java- Utility Class used to perform Deserialization on Xml File to create Objects.
	
	-- xmlStoreRestore
	   1) StoreRestoreHandler.java- Class used to invoke methods on dynamic proxies. 
	   2) SerialTypes.java- Class contains methods for each of the types that need to be serialized.
	   3) DeserialTypes.java- Class contains methods to deserialize each  of the types into Objects.
	
	-- server
	   1) RestoreI.java- Interface contains readObj() function used for Deserialization.
	   2) StoreI.java- Interace contains writeObj() function used for Serialization.
	   3) StoreRestoreI.java- Tag Interface. 
	
	- README.txt - The documentation part of the Assignment.
	- build.xml - ANT script to compile and run the Java program.

SAMPLE OUTPUT:

For 'serdeser' Mode: -

Inspiron-7548:~/workspace/genericCheckpointing$ ant -buildfile build.xml run -Darg0=serdeser -Darg1=2 -Darg2=output.txt
Buildfile: /home/omkar/workspace/genericCheckpointing/build.xml

jar:
    [mkdir] Created dir: /home/omkar/workspace/BUILD/jar
      [jar] Building jar: /home/omkar/workspace/BUILD/jar/genericCheckpointing.jar

run:
     [java] Mismatches=0

BUILD SUCCESSFUL
Total time: 0 seconds
Inspiron-7548:~/workspace/genericCheckpointing$


For 'deser' Mode: -

Inspiron-7548:~/workspace/genericCheckpointing$ ant -buildfile build.xml run -Darg0=deser -Darg1=4 -Darg2=output.txt
Buildfile: /home/omkar/workspace/genericCheckpointing/build.xml

jar:

run:
     [java] MyAllTypesFirst Class
     [java] Int value:0
     [java] Long value:3
     [java] String value:inputstring1
     [java] Boolean value:true
     [java] 
     [java] MyAllTypesSecond Class
     [java] Double value:2.0
     [java] Float value:4.0
     [java] Short value:6
     [java] Char value:b
     [java] 
     [java] MyAllTypesFirst Class
     [java] Int value:1
     [java] Long value:4
     [java] String value:inputstring2
     [java] Boolean value:false
     [java] 
     [java] MyAllTypesSecond Class
     [java] Double value:3.0
     [java] Float value:5.0
     [java] Short value:7
     [java] Char value:c
     [java] 

BUILD SUCCESSFUL
Total time: 0 seconds

	
TO COMPILE:

	On terminal after extracting the files from the tarball, 
	1. Navigate to the wordCount folder of project directory
	2. Type the command ant -buildfile build.xml clean and press Enter	
	3. Type the command ant -buildfile build.xml all and press Enter

TO RUN:

	After successful compilation, type command ant -buildfile build.xml run -Darg0=deser/serdeser -Darg1=<NO_OF_OBJECTS> -Darg2=<input/output filename> on command line and press Enter key.

DATA STRUCTURE USED:

	I have used Vector data structure to complete this assignment.
	Time Complexity: In Best Case scenario, the time complexity of Vector is O(1) and in the worst 
			 case the Time complexity is O(n). In this case, as most of values are different 
			 the Time complexity will be mostly O(1).   
	Space complexity: The space complexity of Vector is some O(n) where n is the number of Objects stored. 
			  If the number of elements increase, the Vector will increase the size by original
			  size to accomodate the Objects.



