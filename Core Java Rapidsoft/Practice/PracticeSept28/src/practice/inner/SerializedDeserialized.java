package practice.inner;

import java.io.*;

public class SerializedDeserialized {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Emp emp = new Emp();
		emp.name = "Ratiknta Dash";
		emp.adress="BBSR";
		
		try {
			FileOutputStream fileOut = new FileOutputStream("Text.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(emp);
			out.close();
			fileOut.close();
			System.out.println("Serialized data is saved");
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		emp = null;
		
		try {
			FileInputStream filein = new FileInputStream("Text.txt");
			ObjectInputStream in = new ObjectInputStream(filein);
			emp = (Emp)in.readObject();
			in.close();
			filein.close();
			
		} finally {
			// TODO: handle finally clause
			
			System.out.println("Deserialized Employee.....");
			System.out.println("Name: " +emp.name);
			System.out.println("Address: "+emp.adress);
		}

	}
	
}
