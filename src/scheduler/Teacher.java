package scheduler;

public class Teacher {
	int id;
	String name;
	String subject;
	// which represents the no. of
	// batches assigned to the teacher
	int assigned;

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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", subject=" + subject + ", assigned=" + assigned + "]";
	}

}
