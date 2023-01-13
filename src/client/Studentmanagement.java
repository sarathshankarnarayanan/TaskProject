package client;


import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Dao.StudentDaoImplementation;
import Dao.SubjectDaoImplementation;
import dto.StudentSubject;
import pojo.Student;
import pojo.Subject;
import utility.Validator;




public class Studentmanagement {
	
	private static final Logger logger = LoggerFactory.getLogger(Studentmanagement.class);
	

	public static void main(String[] args) {
		
		System.out.println("************Welcome*********************");
		int choice;
		Scanner scan = new Scanner(System.in);
		
			Student student = new Student();
			StudentDaoImplementation studentDao = new StudentDaoImplementation();
			Validator validator = new Validator();
			Subject subject = new Subject();
			SubjectDaoImplementation subjectDao = new SubjectDaoImplementation();
			
			
		do {
			
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
				choice = 0;
			}
			
			switch(choice) {
			
			case 1 :
				logger.info("Selected for Adding new Book");
				int studentRollNo;
				String StudentName, studentAddress;
				
				System.out.print("Enter Student Roll No:");
				studentRollNo = validator.validInt();
				
				System.out.print("Enter Student Name:");
				scan.nextLine();
				StudentName = scan.nextLine();
				
				System.out.print("Enter Student Address:");
				studentAddress = scan.nextLine();
				
				student.setRollNumber(studentRollNo);
				student.setName(StudentName);
				student.setAddress(studentAddress);
				
				studentDao.addNewStudent(student);
				
				break;
				
			case 2 :
				logger.info("Selected for Search");
				int searchRollNo;
				System.out.print("Enter Student Roll No:");
				searchRollNo = validator.validInt();
				
				studentDao.serachStudentByRollNo(searchRollNo);
				
				break;
			case 3:
				logger.info("Selected to get all records of student");
				
				
				studentDao.getAllStudent();
				break;
				
			case 4:
				logger.info("To add Marks to database");
				int studentRollNoForSubject;
				String subject1,subject2,subject3;
				
				System.out.print("Enter Student Roll Number");
				studentRollNoForSubject = validator.validInt();
				
				System.out.print("Enter Subject1:");
				scan.nextLine();
				subject1 = scan.nextLine();
				
				System.out.print("Enter Subject2:");
				subject2 = scan.nextLine();
				
				System.out.print("Enter Subject3:");
				subject3 = scan.nextLine();
				
				subject.setStudentRollNo(studentRollNoForSubject);
				subject.setSubject1(subject1);
				subject.setSubject2(subject2);
				subject.setSubject3(subject3);
				
				subjectDao.addSubject(subject);
				
				
			case 5:
				
				
				  studentDao.getStudentDetailWithMarks();
				  
				  break;
				 			
			case 6 :
				
				break;
				
			default :
				
				System.out.println("Please Enter a proper Value");
				logger.error("User Entered wrong value");
				
			}
			
			
		}while(choice != 6);
		
		logger.info("Application closed");
		System.out.println("************Thank You*********************");
	}

}
