package scheduler;

//slot is single block of timetable

/**
 * A slot here is the most basic unit of Genetic algorithm. It represents a
 * single characteristic of a Gene
 * 
 * @author krudash
 *
 */
public class Slot {
	StudentGroup studentgroup;
	int teacherid;
	String subject;

	// non parametrized constructor for allowing free periods
	Slot() {
	};

	Slot(StudentGroup studentgroup, int teacherid, String subject) {

		this.studentgroup = studentgroup;
		this.subject = subject;
		this.teacherid = teacherid;

	}

	public StudentGroup getStudentgroup() {
		return studentgroup;
	}

	public void setStudentgroup(StudentGroup studentgroup) {
		this.studentgroup = studentgroup;
	}

	public int getTeacherid() {
		return teacherid;
	}

	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
}
