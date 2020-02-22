package scheduler;

public class Utility {
	
	public static void printInputData(){
		System.out.println("Nostgrp="+Inputdata.nostudentgroup+" Noteachers="+Inputdata.noteacher+" daysperweek="+Inputdata.daysperweek+" hoursperday="+Inputdata.hoursperday);
		for(int i=0;i<Inputdata.nostudentgroup;i++){
			
			System.out.println(Inputdata.studentgroup[i].id+" "+Inputdata.studentgroup[i].name);
			
			for(int j=0;j<Inputdata.studentgroup[i].nosubject;j++){
				System.out.println(Inputdata.studentgroup[i].subject[j]+" "+Inputdata.studentgroup[i].hours[j]+" hrs "+Inputdata.studentgroup[i].teacherid[j]);
			}
			System.out.println("");
		}
		
		for(int i=0;i<Inputdata.noteacher;i++){			
			System.out.println(Inputdata.teacher[i].id+" "+Inputdata.teacher[i].name+" "+Inputdata.teacher[i].subject+" "+Inputdata.teacher[i].assigned);
		}
	}
	
	
	public static void printSlots(){
		
		int days=Inputdata.daysperweek;
		int hours=Inputdata.hoursperday;
		int nostgrp=Inputdata.nostudentgroup;
		System.out.println("----Slots----");
		for(int i=0;i<days*hours*nostgrp;i++){
			if(TimeTable.slot[i]!=null)
				System.out.println(i+"- "+TimeTable.slot[i].studentgroup.name+" "+TimeTable.slot[i].subject+" "+TimeTable.slot[i].teacherid);
			else
				System.out.println("Free Period");
			if((i+1)%(hours*days)==0) System.out.println("******************************");
		}
		
	}
	
	
	
}
