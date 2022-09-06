
// Written by: Dania Houssami


//WELCOME TO THE CLASS MANAGEMENT SYSTEM. THIS SYSTEM CAN BE USED TO CREATE, MODIFY AND ORGANIZE A CLASS WITH SEVERAL STUDENTS. 
//THE PROGRAM AIMS TO ALLOW A USER TO ADD AND DELETE STUDENTS IN THE CLASS LIST, INPUT AND CALCULATE THEIR GRADES, MODIFY EACH 
//STUDENT'S NAMES AND GRADES, LOCATE EACH STUDENT'S POSITION IN THE CLASS, AND CREATE A CLASS REPORT CARD THAT SUMMARIZES THE WHOLE 
//CLASSE'S OVERALL PERFORMANCE. 

// ** THE MAIN METHOD IS INCLUDED IN THIS CODE **

import java.util.Scanner;

class ClassOrganizer {
	
	// VARIABLES/ATTRIBUTES.

	private static int classSize, idx;
	private static String semesterYear;
	private static String lectureRoom;
	private static String instructorFname;
	private static String instructorLname;
	private String [] studFname;
	private String [] studLname;
	private int [] studID ;
	private double[] assgt1;
	private double[] assgt2;
	private double[] assgt3;
	private double[] assgt4;
	private double[] labs;
	private double[] midTerm;
	private double[] finalExam;
	private static double max, min;
	
	// METHOD FOR INSTRUCTOR FIRST NAME, LAST NAME, LECTURE ROOM, SEMESTER YEAR AND CLASS SIZE
	
	public ClassOrganizer(String fname, String lname, String room, String semYr, int size) {
		instructorFname = fname;
		instructorLname = lname;
		lectureRoom = room;
		semesterYear = semYr;
		classSize = size;
		studFname = new String [classSize];
		studLname = new String [classSize];
		studID = new int [classSize];
		assgt1 = new double [classSize];
		assgt2 = new double [classSize];
		assgt3 = new double [classSize];
		assgt4 = new double [classSize];
		labs = new double [classSize];
		midTerm = new double [classSize];
		finalExam = new double [classSize];

    }
	
	// METHOD TO ADD STUDENT TO CLASS USING STUDENT FIRST NAME, LAST NAME, STUDENT ID AND arrIdx 
	
    public void addStudent(String fname, String lname, int studID, int arrIdx) {
    	if (arrIdx >= classSize) {
    		System.out.println("Student with ID: " + studID + " CANNOT be added. Class is already full.");
    	}
    	else {
        studFname[arrIdx] = fname;
        studLname[arrIdx] = lname;
        this.studID[arrIdx] = studID;
        this.assgt1[arrIdx] = 0.0;
        this.assgt2[arrIdx] = 0.0;
        this.assgt3[arrIdx] = 0.0;
        this.assgt4[arrIdx] = 0.0;
        this.labs[arrIdx] = 0.0;
        this.midTerm[arrIdx] = 0.0;
        this.finalExam[arrIdx] = 0.0;
        
        System.out.println("Student with ID: " + studID + " added successfully.");
    	}
    }

    // METHOD TO GET EACH INDIVIDUAL STUDENT'S POSITION IN THE CLASS, STARTING WITH 0 AS FIRST POSITION

    public int getStudentIdx(int studID) {	
    	int idx = 0;
        for (idx = 0; idx <= classSize; idx++) {
        	if(this.studID[idx] == studID) {
        		return idx;
        	}
        }
        System.out.println("Student with ID: " + studID + " does NOT exist.");
        return -1;
    }

    // METHOD TO GET A STUDENT'S INFORMATION, INCLUDING ALL ASSIGNMENT GRADES, LAB GRADES, MIDTERM AND FINAL.
    
    String studInfo[] = new String[10];
    
    public String[] getStudentInfo(int studID) {
        int studentIdx = getStudentIdx(studID);
        if (studentIdx != -1) {								
        this.studInfo[0] = this.studFname[studentIdx];
        this.studInfo[1] = this.studLname[studentIdx];
        this.studInfo[2] = this.studID[studentIdx] + "";
        this.studInfo[3] = this.assgt1[studentIdx] + "";
        this.studInfo[4] = this.assgt2[studentIdx] + "";
        this.studInfo[5] = this.assgt3[studentIdx] + "";
        this.studInfo[6] = this.assgt4[studentIdx] + "";
        this.studInfo[7] = this.labs[studentIdx] + "";
        this.studInfo[8] = this.midTerm[studentIdx] + "";
        this.studInfo[9] = this.finalExam[studentIdx] + "";
        }
        else {
        	System.out.println("Unable to retrieve information for Student with ID: " + studID);
        }
        return studInfo;
    }

    // METHOD TO DELETE A STUDENT OFF THE CLASS LIST, ALSO ERASING THEIR INFORMATION 

    public int delStudent(int studID) {
    	int studIdx = getStudentIdx(studID);
    	int successor = 0;
    	
        if (studIdx == -1) {
        	successor = -1;
        	System.out.println("Unable to retrieve information for Student with ID: " + studID);
    
        }
        else {
        	this.studFname[studIdx] = null;
        	this.studLname[studIdx] = null;
        	this.studID[studIdx] = 0;
        	this.assgt1[studIdx] = 0;
        	this.assgt2[studIdx] = 0;
        	this.assgt3[studIdx] = 0;
        	this.assgt4[studIdx] = 0;
        	this.labs[studIdx] = 0;
        	this.midTerm[studIdx] = 0;
        	this.finalExam[studIdx] = 0;
        	System.out.println("Successfully removed student with ID: " + studID);
        }
        return successor;
        
        
    }
    
    // METHOD TO UPDATE A STUDENT'S FIRST AND LAST NAME USING THEIR STUDENT ID

    public int updateStudentPart(String fname, String lname, int studID) {
    	int studIdx = getStudentIdx(studID);
    	
    	if(studIdx == -1) {
    		return 0;
    	}
    	else {
    		 studFname[studIdx] = fname;
    	        studLname[studIdx] = lname;
    	        return 1;
    	}
       
    }
    
    // METHOD TO UPDATE A STUDENT'S ASSIGNMENT SCORES USING THEIR STUDENT ID

    public int updateAssgtScore(double a1, double a2, double a3, double a4, int studID) {
    	int studIdx = getStudentIdx(studID);

        if(studIdx == -1) {
        	return 0;
        }
        else {
        	assgt1[studIdx] = a1;
            assgt2[studIdx] = a2;
            assgt3[studIdx] = a3;
            assgt4[studIdx] = a4;
            return 1;
        }
        
    }
    
    // METHOD TO UPDATE A STUDENT'S LAB, MID-TERM AND FINAL GRADE USING THEIR STUDENT ID

    public int updateOtherScore(double lab, double test, double exam, int studID) {
    	int studIdx = getStudentIdx(studID);

        if(studIdx == -1) {
        	return 0;
        }
        else {
        	labs[studIdx] = lab;
            midTerm[studIdx] = test;
            finalExam[studIdx] = exam;
            return 1;
        }
    }
    
    // METHOD TO CALCULATE STUDENT'S FINAL WEIGHT AVERAGE, TAKING THE ALL THE INDIVIDUAL EVALUATION WEIGHTS INTO ACCOUNT 

    public double computeWeightScore(int studID) {
    	int studIdx = getStudentIdx(studID);
    	System.out.println(studIdx);
    	double weightScore = ((assgt1[studIdx]/20.0)*0.02)*100.0 + ((assgt2[studIdx]/20.0)*0.03)*100.0 + ((assgt3[studIdx]/20.0)*0.05)*100.0 + ((assgt4[studIdx]/20.0)*0.08)*100.0 + 
    			((labs[studIdx]/12.0)*0.12)*100.0 + ((midTerm[studIdx]/30.0)*0.3)*100.0 + ((finalExam[studIdx]/40.0)*0.4)*100.0;
    	return weightScore;
    	
    }
    
    // METHOD TO GIVE THE LETTER GRADE OF A STUDENT'S FINAL WEIGHT SCORE

    public static char computeGrade(double wgtScore) {
    	char grade;
        
        if(wgtScore >= 88) {
        	grade = 'A';
        }
        else if(wgtScore >= 80) {
        	grade = 'B';
        }
        else if(wgtScore >= 67) {
        	grade = 'C';
        }
        else if(wgtScore >= 60) {
        	grade = 'D';
        }
        else {
        	grade = 'F';
        	
        }

        return grade;
    }
    
    // METHOD TO FIND THE LOWEST GRADE IN THE CLASS FOR EACH EVALUATION

    public static double findMin(double[]dataArr) {
    	min = dataArr[0];
    	
    	for (int i = 0; i < classSize; i++) {
    		if (dataArr[i] < min) {
    			min = dataArr[i];
    		}
    	}
    	return min;
    }

    // METHOD TO FIND THE HIGHEST GRADE INT THE CLASS FOR EACH EVALUATION
    
    public static double findMax(double[]dataArr) {
    	max = dataArr[0];
    	
    	for (int i = 0; i < classSize; i++) {
    		if (dataArr[i] > max) {
    			max = dataArr[i];
    		}
    	}
    	return max;
    }
    
    // METHOD TO FIND THE AVERAGE OF EACH EVALUATION IN THE CLASS

    public static double findAvg(double[]dataArr) {
    	double sum = 0;
        
        for(idx = 0; idx < classSize; idx++) {
            sum += dataArr[idx];
        }

        return sum/(double)classSize;
    }
    
    // GET METHOD TO RETURN THE ELEMENTS AT THE GIVEN INDEX OF THE ARRAY, TO GET THE LOWEST GRADE IN THE CLASS

    public double[] getClassMin() {
    	double[] getClassMin = new double[7];
    	
        getClassMin[0] = findMin(assgt1);
        getClassMin[1] = findMin(assgt2);
        getClassMin[2] = findMin(assgt3);
        getClassMin[3] = findMin(assgt4);
        getClassMin[4] = findMin(labs);
        getClassMin[5] = findMin(midTerm);
        getClassMin[6] = findMin(finalExam);
        
        for  (int i = 0; i < getClassMin.length; i++) {
        	System.out.printf("%.2f" , getClassMin[i]);
        	System.out.print("\t");
        }
        
        return getClassMin;
    	
    }
    
 // GET METHOD TO RETURN THE ELEMENTS AT THE GIVEN INDEX OF THE ARRAY, TO GET THE HIGHEST GRADE IN THE CLASS

    public double[] getClassMax() {
    	double[] getClassMax = new double[7];
    	
        getClassMax[0] = findMax(assgt1);
        getClassMax[1] = findMax(assgt2);
        getClassMax[2] = findMax(assgt3);
        getClassMax[3] = findMax(assgt4);
        getClassMax[4] = findMax(labs);
        getClassMax[5] = findMax(midTerm);
        getClassMax[6] = findMax(finalExam);
        
        for  (int i = 0; i < getClassMax.length; i++) {
        	System.out.printf("%.2f" , getClassMax[i]);
        	System.out.print("\t");
        }
        
        return getClassMax;
    }
    
 // GET METHOD TO RETURN THE ELEMENTS AT THE GIVEN INDEX OF THE ARRAY, TO GET THE AVERAGE OF EACH EVALUATION IN THE CLASS

    public double[] getClassAvg() {
    	double[] getClassAvg = new double[7];
        
        getClassAvg[0] = findAvg(assgt1);
        getClassAvg[1] = findAvg(assgt2);
        getClassAvg[2] = findAvg(assgt3);
        getClassAvg[3] = findAvg(assgt4);
        getClassAvg[4] = findAvg(labs);
        getClassAvg[5] = findAvg(midTerm);
        getClassAvg[6] = findAvg(finalExam);

        for(int i = 0; i < getClassAvg.length; i++) {
            System.out.printf("%.2f", getClassAvg[i]);
            System.out.print("\t");
        }
        
        return getClassAvg; 
    }

    // METHOD TO PRINT OUT A FINAL CLASS REPORT CARD THAT INCLUDES ALL THE STUDENT'S NAMES, IDS, GRADES, THE MINIMUN AND MAXIMUM GRADES OF THE CLASS,
    // AND THE AVERAGE OF THE CLASS
    
    public void classReportCard() {

        System.out.println("\nDisplaying Class Report Card...");
        System.out.println("------------------------------" );
        System.out.println("-----------------------------------------------------------------------------------------------------------------" );
        System.out.println("First Name\tLast Name\tStud. ID\tA1\tA2\tA3\tA4\tLabs\tTest\tExam\tWgt.\t*" );
        System.out.println("-----------------------------------------------------------------------------------------------------------------" );
        
        for(idx = 0; idx < classSize; idx++) {
            double wgt = computeWeightScore(studID[idx]);

            System.out.println(
                studFname[idx] + 
                "\t\t" + studLname[idx] + 
                "\t\t" + studID[idx] + 
                "\t\t" + assgt1[idx] +
                "\t" + assgt2[idx] +
                "\t" + assgt3[idx] +
                "\t" + assgt4[idx] +
                "\t" + labs[idx] +
                "\t" + midTerm[idx] +
                "\t" + finalExam[idx] +
                "\t" + wgt +
                "\t" + computeGrade(wgt)
            );
        }
        
        	System.out.print("\n-----------------------------------------------------------------------------------------------------------------");
        	System.out.print("\n\t\tMinimum Score in Class:\t\t");
                
            getClassMin();

            System.out.print("\n\t\tAverage Score in Class:\t\t");

            getClassAvg();
            
            System.out.print("\n\t\tMaximum Score in Class:\t\t");

            getClassMax();

            System.out.println("\n-----------------------------------------------------------------------------------------------------------------");
       
    }
    
    // MAIN METHOD
    
	public static void main(String[] args) {
		
		// WELCOME MESSAGE AND USER INPUT OF INSTRUCTOR FIRST NAME, LAST NAME, LECTURE ROOM, SEMESTER YEAR AND CLASS SIZE
		
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to the Simple Classroom Management System:");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++\n");
		System.out.println("Enter instructor's partuculars (FirstName, LastName, LectureRoom, Semester, MaxClassSize) as a single-line entry:");
		
		String fname, lname, room, year;
		
		fname = in.next();
		lname = in.next();
		room = in.next();
		year = in.next();
		int size = 0;
		int index = 0;
		int ID = 0;
		int arrIdx = 0;
		
		// CONTIDITON TO CHECK IF CLASSSIZE INPUT IS A VALID INTEGER
		
		if(in.hasNextInt()) {
	          size = in.nextInt();  
		}
		else {
	            System.out.println("Error: Your input/entry for 'MaxClassSize' is NOT a valid integer. Kindly try again!");
	            System.exit(0); 
	        }
		
		// DIFFERENT CODE OPTIONS FOR USER
		
		System.out.println("Code => Description");
		System.out.println("-------------------");
		System.out.println("103 => Enroll New Student");
		System.out.println("106 => Find Student Position in Class List");
		System.out.println("109 => Retrieve Student's Information");
		System.out.println("112 => Unenrol Student");
		System.out.println("115 => Update Student's Particulars");
		System.out.println("118 => Update Assignment Scores");
		System.out.println("121 => Update Other Scores");
		System.out.println("124 => Display Student's Report Card");
		System.out.println("127 => Display Class Report Card");
		System.out.println("0 ===> Exit");
		System.out.println();
		System.out.print("Please enter a Code, from the aforementioned, that corresponds to your task: ");
		
		ClassOrganizer class0 = new ClassOrganizer(fname, lname, room, year, size);
		
		boolean bool = true;
		index = 0;
		while (bool == true) {
			if(in.hasNextByte()) { 		// CONDITION TO CHECK IF CODE OPTION IS A BYTE VALUE
			int option = in.nextInt();
		
		switch (option) {
		
		case 103: // IF USER USES CODE 103 TO ENROLL A STDUENT, USING addStudent METHOD
			
			System.out.println("\n\nEnrolling New Student... ");
			System.out.println("----------------------------");
			System.out.println("Enter student's particulars (FirstName, LastName, StudentID) as a single-line entry:");
			
			fname = in.next();
	 		lname = in.next();
	 		
	 		// CONDITION CHECKS IF STUDENT ID IS A VALID INTEGER
	 		
	 		if (in.hasNextInt()) {
	 			ID = in.nextInt();
	 			class0.addStudent(fname, lname, ID, index);
	 			index++;
	 			System.out.print("Kindly continue by entering a Code, from the menu above, that corresponds to your task: ");
	 			break;
	 		}
	 		else if (in.hasNextInt() == false) {
	 			System.out.println("Error: Your input/entry for 'StudentID' is NOT a valid integer. Kindly retry again!");
	 			System.out.print("Kindly continue by entering a Code, from the menu above, that corresponds to your task: ");
	 			in.next();
	 			continue;
	 		}
	 		
	 		// CONDITION PREVENTS USER FROM ADDING MORE STUDENTS THAN THE SIZE OF THE CLASS
	 		
	 		if(arrIdx > size) {
                System.out.println("Student with ID: " + ID + " CANNOT be added. Class is already full.");
                System.out.print("Kindly continue by entering a Code, from the menu above, that corresponds to your task:");

            }
			
	 		break;

		case 106:  // IF USER USES CODE 106 TO FIND STUDENT POSITION IN CLASS, USING getStudentIdx METHOD

			System.out.println("\n\nFinding Student's Position in Class List... ");
			System.out.println("-----------------------------------------------");
	  		System.out.println("Enter StudentID: ");
			
	  		// CONDITION CHECKS IF STUDENT ID IS A VALID INTEGER
	  		
	  		int studidx = class0.getStudentIdx(ID);
	  		
			if (in.hasNextInt()) {
	 			ID = in.nextInt();
	 			studidx = class0.getStudentIdx(ID);
	 			index++;
	 			System.out.println("The position of student with ID: " + ID + ", in the class list, is " + studidx);
	 			System.out.print("Kindly continue by entering a Code, from the menu above, that corresponds to your task: ");
	 			break;
	 			
	 		}
	 		else if (in.hasNextInt() == false) {
	 			System.out.println("Error: Your input/entry for 'StudentID' is NOT a valid integer. Kindly retry again!");
	 			System.out.print("Kindly continue by entering a Code, from the menu above, that corresponds to your task: ");
	 			in.next();
	 			continue;
	 		}
			
			//CONDITION CHECKS IF STUDENT IS EXISTANT
			
			if(studidx == -1) {
                System.out.print("Kindly continue by entering a Code, from the menu above, that corresponds to your task:");
                continue;
            }
			

	 		continue;
			
		case 109: // IF USER USES CODE 109 TO GET STUDENT'S INFORMATION, USING getStudentInfo METHOD

			System.out.println("\n\nRetrieving Student's information... ");
			System.out.println("---------------------------------------");
			System.out.println("Enter StudentID: ");

			// CONDITION CHECKS IF STUDENT ID IS A VALID INTEGER
			
			if (in.hasNextInt()) {
				ID = in.nextInt();
			
			String[] studInfo = class0.getStudentInfo(ID);
			
			System.out.println("Student's First Name = " + studInfo[0]);
			System.out.println("Student's Last Name = " + studInfo[1]);
			System.out.println("Student's ID = " + studInfo[2]);
			System.out.println("Score in Assignment 1 = " + studInfo[3]);
			System.out.println("Score in Assignment 2 = " + studInfo[4]);
			System.out.println("Score in Assignment 3 = " + studInfo[5]);
			System.out.println("Score in Assignment 4 = " +  studInfo[6]);
			System.out.println("Cumulative Score in Labs = " + studInfo[7]);	
			System.out.println("Midterm Test Score = " + studInfo[8]);
			System.out.println("Final Examination Score = " + studInfo[9]);
			System.out.print("Kindly continue by entering a Code, from the menu above, that corresponds to your task: ");
			break;
			}
			else if (in.hasNextInt() == false) {
	 			System.out.println("Error: Your input/entry for 'StudentID' is NOT a valid integer. Kindly retry again!");
	 			System.out.print("Kindly continue by entering a Code, from the menu above, that corresponds to your task: ");
	 			in.next();
	 			continue;
	 		}

			
			continue;
			
		case 112:  // IF USER USES CODE 112 TO DELETE A STDUENT OFF CLASS LIST, USING delStudent METHOD
			
			System.out.println("\n\nUnenrolling Student... ");
			System.out.println("--------------------------");
			System.out.println("Enter StudentID: ");
			
			// CONDITION CHECKS IF STUDENT ID IS A VALID INTEGER
			
			if (in.hasNextInt()) {
				ID = in.nextInt();
				class0.delStudent(ID);
				System.out.print("Kindly continue by entering a Code, from the menu above, that corresponds to your task: ");
		 		break;	
			}
			else if (in.hasNextInt() == false) {
	 			System.out.println("Error: Your input/entry for 'StudentID' is NOT a valid integer. Kindly retry again!");
	 			System.out.print("Kindly continue by entering a Code, from the menu above, that corresponds to your task: ");
	 			in.next();
	 			continue;
	 		}
	  		
			//CONDITION CHECKS IF STUDENT IS EXISTANT
			
			if(class0.delStudent(ID) == -1) {
                System.out.print("Kindly continue by entering a Code, from the menu above, that corresponds to your task:");
                continue;
            }
			
	 		continue;
	 		
		case 115: // IF USER USES CODE 115 TO UPDATE A STUDENT'S FIRST AND LAST NAME, USING updateStduentPart METHOD
			
			System.out.println("\n\nUpdating Student's Particulars... ");
			System.out.println("-------------------------------------");
			System.out.println("Enter update to student's particulars (FirstName, LastName, StudentID) as a single-line entry:");
			
			fname = in.next();
			lname = in.next();
			
			// CONDITION CHECKS IF STUDENT ID IS A VALID INTEGER
			
			if (in.hasNextInt()) {
				ID = in.nextInt();
				class0.updateStudentPart(fname, lname, ID);
				System.out.println("Successfully updated identification particulars for Student with ID: " + ID);
				System.out.print("Kindly continue by entering a Code, from the menu above, that corresponds to your task: ");
		 		break;	
			}
			else if (in.hasNextInt() == false) {
	 			System.out.println("Error: Your input/entry for 'StudentID' is NOT a valid integer. Kindly retry again!");
	 			System.out.print("Kindly continue by entering a Code, from the menu above, that corresponds to your task: ");
	 			in.next();
	 			continue;
	 		}
			
			//CONDITION CHECKS IF STUDENT IS EXISTANT
			
			if(class0.updateStudentPart(fname, lname, ID) == -1) {
                System.out.println("Kindly continue by entering a Code, from the menu above, that corresponds to your task:");
                continue;
            }


            continue;
			
		case 118:  // IF USER USES CODE 118 TO ADD A STUDENT'S ASSIGNMENT GRADES, USING updateAssgtScore METHOD
			
			System.out.println("\n\nUpdating Assignment Score... ");
			System.out.println("--------------------------------");
			System.out.println("Enter update to student's Assignment scores (Assignment1, Assignment2, Assignment3, Assignment4, StudentID) as a single-line entry:");
			
			int a1 = in.nextInt();
            int a2 = in.nextInt();
            int a3 = in.nextInt();
            int a4 = in.nextInt();
            
            // CONDITION CHECKS IF STUDENT ID IS A VALID INTEGER
            
            if (in.hasNextInt()) {
				ID = in.nextInt();
				class0.updateAssgtScore(a1, a2, a3, a4, ID);
				System.out.println("Successfully updated Assignments' scores for Student with ID: " + ID);
				System.out.print("Kindly continue by entering a Code, from the menu above, that corresponds to your task: ");
		 		break;	
			}
			else if (in.hasNextInt() == false) {
	 			System.out.println("Error: Your input/entry for 'StudentID' is NOT a valid integer. Kindly retry again!");
	 			System.out.print("Kindly continue by entering a Code, from the menu above, that corresponds to your task: ");
	 			in.next();
	 			continue;
	 		}
            
            // CONDITION TO CHECK IF STDUENT EXISTS
            
            if(class0.updateAssgtScore(a1, a2, a3, a4, ID) != 1) {
            	System.out.println("Student with ID: " + ID + " does NOT exist.");
                System.out.println("Unable to retrieve information for Student with ID: " + ID);
        	System.out.print("Kindly continue by entering a Code, from the menu above, that corresponds to your task:");
            } 

            
              continue;
			
		case 121: // IF USER USES CODE 121 TO A STUDENT'S LABS, MIDTERM AND FINAL GRADE, USING updateOtehrScore METHOD
	 		
			System.out.println("\n\nUpdating Other Scores... ");
			System.out.println("----------------------------");
			System.out.println("Enter update to student's other scores (CummulativeLabs, MidtTerm, FinalExam, StudentID) as a single-line entry:");
			
			// CONDITION CHECKS IF STUDENT ID IS A VALID INTEGER
			
			int labs = in.nextInt();
            int mid = in.nextInt();
            int finalE = in.nextInt();
            
            if (in.hasNextInt()) {
				ID = in.nextInt();
				class0.updateOtherScore(labs, mid, finalE, ID);
				System.out.println("Successfully updated Cummulative Labs, Mid-Term Test and Final Examination scores for Student with ID: " + ID);
                System.out.print("Kindly continue by entering a Code, from the menu above, that corresponds to your task:");
		 		break;	
			}
			else if (in.hasNextInt() == false) {
	 			System.out.println("Error: Your input/entry for 'StudentID' is NOT a valid integer. Kindly retry again!");
	 			System.out.print("Kindly continue by entering a Code, from the menu above, that corresponds to your task: ");
	 			in.next();
	 			continue;
	 		}
            
            // CONDITION TO CHECK IF STDUENT EXISTS
            
            if(class0.updateOtherScore(labs, mid, finalE, ID) != 1) {
            	System.out.println("Student with ID: " + ID + " does NOT exist.");
                System.out.println("Unable to retrieve information for Student with ID: " + ID);
        	    System.out.print("Kindly continue by entering a Code, from the menu above, that corresponds to your task:");
            } 

            continue;
            
		case 124: // IF USER USES CODE 124 TO GET A STUDENT'S INFORMATION REGARDING ALL GRADES, USING getStudentInfo, computeWeighScore, computeGrade METHODS
			
			System.out.println("\n\nRetrieving Student's information... ");
			System.out.println("---------------------------------------");
			System.out.println("Enter StudentID: ");

			// CONDITION CHECKS IF STUDENT ID IS A VALID INTEGER
			
			if (in.hasNextInt()) {
			
				ID = in.nextInt();
				String[] studInf = class0.getStudentInfo(ID);

            if(studInf[0] == null) {
                System.out.print("Kindly continue by entering a Code, from the menu above, that corresponds to your task:");
                continue;
            }

            double wScore = class0.computeWeightScore(ID);

            	System.out.println("Student's First Name = " + studInf[0]);
            	System.out.println("Student's Last Name = " + studInf[1]);
            	System.out.println("Student's ID = " + studInf[2]);
            	System.out.println("Score in Assignment 1 = " + studInf[3]);
            	System.out.println("Score in Assigmnent 2 = " + studInf[4]);
            	System.out.println("Score in Assignment 3 = " + studInf[5]);
            	System.out.println("Score in Assignment 4 = " + studInf[6]);
            	System.out.println("Cummulative Score in Labs = " + studInf[7]);
            	System.out.println("Mid-Term Test Score = " + studInf[8]);
            	System.out.println("Final Examination Score = " + studInf[9]);
            	System.out.println("-----------------------------------------");
            	System.out.println("Student's Cummulative Weighted Score = " + wScore);
            	System.out.println( "Student's Final Letter Grade = " + ClassOrganizer.computeGrade(wScore));
            	
            	System.out.print("Kindly continue by entering a Code, from the menu above, that corresponds to your task:");
            	break;
			}
			else if (in.hasNextInt() == false) {
	 			System.out.println("Error: Your input/entry for 'StudentID' is NOT a valid integer. Kindly retry again!");
	 			System.out.print("Kindly continue by entering a Code, from the menu above, that corresponds to your task: ");
	 			in.next();
	 			continue;
			}
			
			// CONDITION TO CHECK IF STDUENT EXISTS
            
            if(class0.computeWeightScore(ID) != 1) {
            	System.out.println("Student with ID: " + ID + " does NOT exist.");
                System.out.println("Unable to retrieve information for Student with ID: " + ID);
        	System.out.print("Kindly continue by entering a Code, from the menu above, that corresponds to your task:");
            } 
		
            continue;
			
		case 127: // IF USER USES CODE 127 TO GET THE FINAL REPORT CARD OF THE WHOLE CLASS, USING classReportCard METHOD
			
			class0.classReportCard();
            System.out.print("Kindly continue by entering a Code, from the menu above, that corresponds to your task:");
            continue;
			
		case 0: // IF USER USES CODE 0, USER IS THANKED AND CODE EXITS
			
			System.out.println("Thank you for using the Simple Classroom Management System");
            System.exit(0);
            
		case 100: 
			
			System.out.println("Thank you for patronizing out Simple Classroom Management System.");
			System.exit(0);
				} 
			}
			

			else { // ERROR MESSAGE IF CODE OPTION IS NOT A BYTE VALUE
				System.out.println("Error: Your input/entry is not a valid integer between -128 to 127. Kindly retry again!");
				System.exit(0);
			}
		}
		
	}
			
		

	
}
	
    


