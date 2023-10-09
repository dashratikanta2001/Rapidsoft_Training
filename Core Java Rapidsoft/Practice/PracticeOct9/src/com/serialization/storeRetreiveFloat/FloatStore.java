package com.serialization.storeRetreiveFloat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Serializable;

@SuppressWarnings("serial")
class MyFloat implements Serializable
{
	float list[] = {1.1f,2.2f,3.3f,4.4f,5.5f,9.9f,7.7f};
}

public class FloatStore {

	static void write() throws Exception
	{
		FileOutputStream fout = new FileOutputStream("FloatingValue.txt");
		DataOutputStream dout = new DataOutputStream(fout);

		MyFloat mf = new MyFloat();
		dout.writeInt(mf.list.length);
		for(float f:mf.list)
			dout.writeFloat(f);
		dout.close();
		fout.close();
	}
	static void read() throws Exception
	{
		FileInputStream fin = new FileInputStream("FloatingValue.txt");
		DataInputStream din = new DataInputStream(fin);

		float size=din.readInt();
		for(int i=0;i<size;i++)
		{
			System.out.println(din.readFloat());
		}

		din.close();
		fin.close();
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		write();
		read();

	}

}
