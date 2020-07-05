package front;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionSupport;
import scheduler.*;

public class TimetableAction extends ActionSupport implements ServletRequestAware {

	HttpServletRequest request;
	List<String> start, end;
	List<String> studentgroup, nosubject, stgrpsubject, subjecttime;
	List<String> teacher, teachersubject;
	String hoursperday, breakstart, breakend, daysperweek;
	int cumusubcount = 0;

	public String fromFile() {
		// invokes method to take input
		//Inputdata.takeinput();
		Inputdata.takeinputFromFile("/Users/k0d03gd/project/poc/code/automate-time-table-schduler/inputWithTime.txt");

		// invokes algorithm
		new SchedulerMain();

		// grabs final chromosome i.e. the output
		Chromosome finalson = SchedulerMain.finalson;

		// sets the final chromosome in request scope to be fetched by view page
		getServletRequest().setAttribute("son", finalson);

		return SUCCESS;
	}

	public String fromForm() {

		Inputdata.daysperweek = Integer.parseInt(daysperweek);
		Inputdata.hoursperday = Integer.parseInt(hoursperday);
		Inputdata.nostudentgroup = studentgroup.size();

		for (int i = 0; i < studentgroup.size(); i++) {

			Inputdata.studentgroup[i] = new StudentGroup();
			StudentGroup temp = Inputdata.studentgroup[i];

			temp.setId(i);
			temp.setName(studentgroup.get(i));
			temp.setNosubject(nosubject.get(i));

			int nosub = Integer.parseInt(nosubject.get(i));
			String[] sub = new String[nosub];
			int[] hrs = new int[nosub];
			for (int j = 0; j < nosub; j++) {
				sub[j] = stgrpsubject.get(cumusubcount);
				hrs[j] = Integer.parseInt(subjecttime.get(cumusubcount));
				cumusubcount++;
			}

			temp.setSubject(sub);
			temp.setHours(hrs);

		}

		Inputdata.noteacher = teacher.size();
		for (int i = 0; i < teacher.size(); i++) {

			Inputdata.teacher[i] = new Teacher();
			Teacher tmp = Inputdata.teacher[i];

			tmp.setId(i);
			tmp.setName(teacher.get(i));
			tmp.setSubject(teachersubject.get(i));
		}
		Arrays.stream(Inputdata.studentgroup).forEach(System.out::println);
		Arrays.stream(Inputdata.teacher).forEach(System.out::println);

		// after getting all input, teachers are assigned to each subject
		Inputdata.assignTeacher();

		new SchedulerMain();

		Chromosome finalson = scheduler.SchedulerMain.finalson;
		getServletRequest().setAttribute("son", finalson);
		return SUCCESS;
	}

	public List<String> getStart() {
		return start;
	}

	public void setStart(List<String> start) {
		this.start = start;
	}

	public List<String> getEnd() {
		return end;
	}

	public void setEnd(List<String> end) {
		this.end = end;
	}

	public List<String> getStudentgroup() {
		return studentgroup;
	}

	public void setStudentgroup(List<String> studentgroup) {
		this.studentgroup = studentgroup;
	}

	public List<String> getNosubject() {
		return nosubject;
	}

	public void setNosubject(List<String> nosubject) {
		this.nosubject = nosubject;
	}

	public List<String> getStgrpsubject() {
		return stgrpsubject;
	}

	public void setStgrpsubject(List<String> stgrpsubject) {
		this.stgrpsubject = stgrpsubject;
	}

	public List<String> getSubjecttime() {
		return subjecttime;
	}

	public void setSubjecttime(List<String> subjecttime) {
		this.subjecttime = subjecttime;
	}

	public List<String> getTeacher() {
		return teacher;
	}

	public void setTeacher(List<String> teacher) {
		this.teacher = teacher;
	}

	public List<String> getTeachersubject() {
		return teachersubject;
	}

	public void setTeachersubject(List<String> teachersubject) {
		this.teachersubject = teachersubject;
	}

	public String getHoursperday() {
		return hoursperday;
	}

	public void setHoursperday(String hoursperday) {
		this.hoursperday = hoursperday;
	}

	public String getBreakstart() {
		return breakstart;
	}

	public void setBreakstart(String breakstart) {
		this.breakstart = breakstart;
	}

	public String getBreakend() {
		return breakend;
	}

	public void setBreakend(String breakend) {
		this.breakend = breakend;
	}

	public String getDaysperweek() {
		return daysperweek;
	}

	public void setDaysperweek(String daysperweek) {
		this.daysperweek = daysperweek;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletRequest getServletRequest() {
		return this.request;
	}

}
