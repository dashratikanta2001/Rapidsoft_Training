package Practice.java;

class Subject{
	private String subId;
	private String name;
	private byte maxMarks;
	private byte marksObtain;
	
	public Subject(String subId, String name)
	{
		this.subId=subId;
		this.name = name;
	}
	
	public Subject(String subId, String name, byte maxMark)
	{
		this.subId=subId;
		this.name = name;
		setMaxMark(maxMark);
	}
	
	public String getSubId()
	{
		return subId;
	}
	
	public String getName()
	{
		return name;
	}
	
	public byte getMaxMarks()
	{
		return maxMarks;
	}
	
	public byte getMarksObtain()
	{
		return marksObtain;
	}
	
	public void setMaxMark(byte m)
	{
		maxMarks=m;
	}
	
	public void setMarksObtain(byte mo)
	{
		marksObtain=mo;
	}
	
	public boolean isQualified()
	{
		return marksObtain>=maxMarks/10*4;
	}
	
	public String toString()
	{
		return "\nSubject Id: "+subId+"\nName: "+name+"\nMarks Obtain: "+marksObtain+"\nIs Qualified: "+isQualified();
	}
	
	
}

class Student {
	private String rollNo;
	private String name;
	private String dept;
	private String subjects;
	
	public Student(String r, String n, String d)
	{
		rollNo = r;
		name=n;
		dept=d;
	}
	
	public String getRollNO()
	{
		return rollNo;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getDept()
	{
		return dept;
	}
	
	public String getSubjects()
	{
		return subjects;
	}
	
	public void setSubjects(String s)
	{
		subjects=s;
	}
	
	public String toString()
	{
		return "\nStudent RollNo:"+rollNo+"\nName: "+name+"\nDept: "+dept+"\nSubjects: "+subjects;
	}
}

public class Practice5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Subject subs[] = new Subject[3];
		subs[0] = new Subject("s101","DS",(byte)100);
		subs[1] = new Subject("s102","CS",(byte)100);
		subs[2] = new Subject("s103","OS",(byte)100);
		
		subs[0].setMarksObtain((byte)60);
		subs[1].setMarksObtain((byte)20);
		subs[2].setMarksObtain((byte)90);

		for(Subject s:subs)
		{
			System.out.println(s);
		}
		
		Student std[] = new Student[3];
		std[0] = new Student("R1001","Rati","MCA");
		std[1] = new Student("R1002","Ram","MCA");
		std[2] = new Student("R1003","Dam","MCA");
		std[0].setSubjects("DS");
		std[1].setSubjects("OS");
		std[2].setSubjects("CS");
		
		for(Student s:std)
		{
			System.out.println(s);
		}
		
	}

}
