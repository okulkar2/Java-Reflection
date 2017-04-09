package genericCheckpointing.server;

import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.SerializableObject;

public interface SerStrategy {
	public void processInput(SerializableObject sObject,FileProcessor fileProcessor);
	public SerializableObject processInput(FileProcessor fileProcessor);
}
