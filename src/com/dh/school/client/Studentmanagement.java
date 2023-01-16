package com.dh.school.client;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dh.school.dao.StudentDao;
import com.dh.school.dao.StudentDaoImplementation;
import com.dh.school.dao.SubejctDao;
import com.dh.school.dao.SubjectDaoImplementation;
import com.dh.school.dto.StudentSubject;
import com.dh.school.pojo.Student;
import com.dh.school.pojo.Subjects;
import com.dh.school.utility.Validator;




public class Studentmanagement {
	
	private static final Logger logger = LoggerFactory.getLogger(Studentmanagement.class);
	

	public static void main(String[] args) {
		
		logger.info("Application Started");
		System.out.println("************Welcome*********************");
		int choice;
		Scanner scan = new Scanner(System.in);
		
			//created the object
			Student student = new Student();
			StudentDao studentDao = new StudentDaoImplementation();
			Validator validator = new Validator();
			SubejctDao subjectDao = new SubjectDaoImplementation();
			Subjects subject = new Subjects();
			
			
		do {
			//menus
			System.out.println("1)Add a new Student to the database");
			System.out.println("2)Search Student");
			System.out.println("3)Get All Records Of Student");
			System.out.println("4)Add a Student Subject to the database");
			System.out.println("5)Get student records with Subject");
			System.out.println("6)Exit");
			
			System.out.println("\nEnter your choice:");
			String mChoice = scan.next();
			
			try {
				choice = Integer.parseInt(mChoice);
			}catch (NumberFormatException ex) {
				System.out.println("Please Enter Number only");
				logger.error("Entered Wrong values");
				choice = 0;
			}
			
			switch(choice) {
			
			case 1 :
				
				
				logger.debug("Selected for Adding new Book");
				int studentRollNo;
				String StudentName, studentAddress;
				
				System.out.print("Enter Student Roll No:");
				//check if user has entered valid number
				studentRollNo = validator.validInt();
				
				System.out.print("Enter Student Name:");
				scan.nextLine();
				StudentName = scan.nextLine();
				
				System.out.print("Enter Student Address:");
				studentAddress = scan.nextLine();
				
				//set the student details obtained from user to the student object
				student.setRollNumber(studentRollNo);
				student.setName(StudentName);
				student.setAddress(studentAddress);
				
				//passing the student object to the the studentdao method for adding new student
				studentDao.addNewStudent(student);
				
				break;
				
			case 2 :
				
				
				logger.debug("Selected for Search");
				int searchRollNo;
				System.out.print("Enter Student Roll No:");
				//check if user has entered valid number
				searchRollNo = validator.validInt();
				
				//passing the user value to the studentdao method to get the student info by roll number
				studentDao.serachStudentByRollNo(searchRollNo);
				
				break;
			case 3:
				
				
				logger.debug("Selected to get all records of student");
				List<Student> studentList = new ArrayList<Student>();
				
				//calling studentdao method to get the details of all student and storing it in a list
				studentList=studentDao.getAllStudent();
				
				//checking if returned value is null or not
				if(studentList.equals(null)) {
					
					System.out.println("No Records Found");
					
				}else {
					
					//if returned values is not null then printing each object of student from student list
					for(Student students : studentList ) {
						 
						System.out.println(students);
						 
					}
					
				}
				break;
				
			case 4:
				
				
				logger.debug("Selected To add Subjects");
				int studentRollNoForSubject;
				List<String> subjectsOfStudent;
				
				System.out.print("Enter Student Roll Number :");
				studentRollNoForSubject = validator.validInt();
				
				//calling studentdao to get the subject enter by the user and storing it in a list of String
				subjectsOfStudent = subjectDao.getSubjectFromUser();
				
				System.out.println("Entered Subject :" +subjectsOfStudent);
				
				//looping to the subject list
				for(String studentSubject : subjectsOfStudent ) {
					 
					//calling studentDao method and passing roll number and each subject provided by the user one by one
					 subjectDao.addSubject(studentRollNoForSubject, studentSubject);
					 
				}
				
				
				break;
				
			case 5:
				
					logger.debug("Selected to Get student records with Subject");
					
					
				  //calling studentDao method to get the student details with marks.
				  studentDao.getStudentDetailWithMarks();
				  
				  break;
				 			
			case 6 :
				
				logger.debug("Selected to Exit");
				//Exit
				break;
				
			default :
				
				//entered value other than the menu
				System.out.println("Please Enter a proper Value");
				logger.debug("User Entered wrong value");
				
			}
			
			
		}while(choice != 6);
		
		logger.info("Application closed");
		System.out.println("************Thank You*********************");
	}

}
