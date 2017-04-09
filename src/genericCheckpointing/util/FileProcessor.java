package genericCheckpointing.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class FileProcessor {
	private InputStream inputStream=null;
	private BufferedReader bufferReader;
	private BufferedWriter bufferWriter;
	private OutputStream outputStream=null;
	
	/**
	 * Constructor of FileProcessor used to initialize inputStream 
	 * and instantiate Buffered Reader class with that input Stream.
	 * 	
	 * @param inputStreamIn
	 *            InputStream to read.
	 */
	public FileProcessor(InputStream inputStreamIn) {
		
		inputStream=inputStreamIn;
		bufferReader=new BufferedReader(new InputStreamReader(inputStream));
	}

	/**
	 * Constructor of FileProcessor used to initialize outputStream 
	 * and instantiate Buffered Writer class with that output Stream.
	 * 	
	 * @param outputStreamIn
	 *            OutputStream to read.
	 */
	public FileProcessor(OutputStream outputStreamIn) {
				
		outputStream = outputStreamIn;
		bufferWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
	}
	
	/**
	 * This function reads one line from a file and returns it.
	 * 
	 * @return String Represents a single line read from file.
	 * @throws IOException Exception thrown when an error occurs
	 * while reading.
	 */
	public String readLineFromFile() throws IOException {
		
		String line = null;
		line=bufferReader.readLine();
		return line;
	}
	
	/**
	 * This function writes one line to the file.
	 * 
	 * @throws IOException Exception thrown when an error occurs
	 * while writing to the file.
	 */
	public void writeLineToFile(String stringIn) throws IOException{
		
		if(stringIn != null){
			bufferWriter.write(stringIn);
			bufferWriter.newLine();
			bufferWriter.flush();
		}
	}
	
	/**
	 * Closes the input stream.
	 */
	public void closeStream() {
		
		try {
			
			if(inputStream!=null)
				inputStream.close();
			
			if(outputStream!=null)
				outputStream.close();
			
		} catch (IOException e) {
			
			System.err.println("An exception occurred while closing file !!");
		}
	}
}
