package scheduler;

import java.util.Arrays;

public class StudentGroup {
	int id;
	String name;

	String[] subject;
	// Total number of subject
	int nosubject;
	int teacherid[];

	// hours of study required for each subject
	int[] hours;

	public StudentGroup() {
		subject = new String[10];
		hours = new int[10];
		teacherid = new int[10];
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getSubject() {
		return subject;
	}

	public void setSubject(String[] subject) {
		this.subject = subject;
	}

	public int getNosubject() {
		return nosubject;
	}

	public void setNosubject(String snosubject) {
		int nosubject = Integer.parseInt(snosubject);
		this.nosubject = nosubject;
	}

	public int[] getTeacherid() {
		return teacherid;
	}

	public void setTeacherid(int[] teacherid) {
		this.teacherid = teacherid;
	}

	public int[] getHours() {
		return hours;
	}

	public void setHours(int[] hours) {
		this.hours = hours;
	}

	@Override
	public String toString() {
		return "StudentGroup [id=" + id + ", name=" + name + ", subject=" + Arrays.toString(subject) + ", nosubject="
				+ nosubject + ", teacherid=" + Arrays.toString(teacherid) + ", hours=" + Arrays.toString(hours) + "]";
	}
	
	

}
