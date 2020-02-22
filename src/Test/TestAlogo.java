package Test;

import java.util.Arrays;

import scheduler.Chromosome;
import scheduler.Inputdata;
import scheduler.SchedulerMain;

public class TestAlogo {
	public static void main(String[] args) {
		Inputdata.takeinputFromFile("D:\\Eclipse\\code\\TimeTable\\Time-table-scheduler\\InputTest2");
		
		Arrays.stream(Inputdata.studentgroup).forEach(System.out::println);
		Arrays.stream(Inputdata.teacher).forEach(System.out::println);
		// invokes algorithm
		new SchedulerMain();

		// grabs final chromosome i.e. the output
		Chromosome finalson = SchedulerMain.finalson;
		finalson.printTimeTable();

	}
}
