package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class AssignmentDB {

	private static Map<String, Assignment> assignmentDatabase = new HashMap<>();
	private static final String ASSIGNMENT_DATABASE = "assignment.dat";

	public AssignmentDB() {
		loadDatabase();
	}

	public void insertAssignment(Assignment assignment) {
		assignmentDatabase.put(assignment.getName(), assignment);

		try (FileOutputStream fos = new FileOutputStream(ASSIGNMENT_DATABASE);
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(assignmentDatabase);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		//create file
//		try {
//		      File dir = new File ("/output")
//			  File myObj = new File(dir, "filename.txt");
//		      if (myObj.createNewFile()) {
//		        System.out.println("File created: " + myObj.getName());
//		      } else {
//		        System.out.println("File already exists.");
//		      }
//		} catch (IOException e) {
//		      System.out.println("An error occurred.");
//		      e.printStackTrace();
//		  }
		
		//write to file
//		try {
//		      FileWriter myWriter = new FileWriter("filename.txt");
//		      myWriter.write("Files in Java might be tricky, but it is fun enough!");
//		      myWriter.close();
//		      System.out.println("Successfully wrote to the file.");
//		} catch (IOException e) {
//		      System.out.println("An error occurred.");
//		      e.printStackTrace();
//		  }
	}

	public Assignment getAssignment(String name) {
		return assignmentDatabase.get(name);
	}

	public boolean hasAssignment(String name) {
		return assignmentDatabase.containsKey(name);
	}

	public Map<String, Assignment> getAllAssignments() {
		return assignmentDatabase;
	}

	//read file
	private void loadDatabase() {
		HashMap<Integer, String> map = null;
		try (FileInputStream fis = new FileInputStream(ASSIGNMENT_DATABASE);
				ObjectInputStream ois = new ObjectInputStream(fis);) {
			assignmentDatabase = (Map<String, Assignment>) ois.readObject();
		} catch (FileNotFoundException fe) {
			System.out.println("no database file");
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			System.out.println("Class not found");
			c.printStackTrace();
			return;
		}
	}
}
