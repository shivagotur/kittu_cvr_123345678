import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	private int count=0;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		// Add your implementation here
		return students;
	}

	@Override
	public void setStudents(Student[] students) {
		// Add your implementation here
		if(students==null) throw new IllegalArgumentException();
		for(int i=0;i<this.students.length;i++)
			this.students[i]=students[i];
		
	}

	@Override
	public Student getStudent(int index) {
		// Add your implementation here 
		if(index<0||index>students.length) throw new IllegalArgumentException();
		
		return students[index];
	}

	@Override
	public void setStudent(Student student, int index) {
		// Add your implementation here
		if(student==null||index<0||index>students.length) throw new IllegalArgumentException();
		
		students[index]=student;
	}

	@Override
	public void addFirst(Student student) {
		// Add your implementation here
		if(student==null) throw new IllegalArgumentException();
		int i=0;
		for(;i<students.length;i++)
			if(students[i]==null) break;
		if(i<students.length){
			
			for(;i>=0;i--){
				try{
					students[i]=students[i-1];
				}catch(Exception e){}
				}
			students[0]=student;count++;
			}
		else{
			throw new IllegalArgumentException();
		}
	}

	@Override
	public void addLast(Student student) {
		// Add your implementation here
		if(student==null)
				throw new IllegalArgumentException();
			
			else{
				if(students[students.length-1]==null)
					students[students.length-1]=student;
				else
					students[students.length]=student;
				count++;
			}
		
	}

	@Override
	public void add(Student student, int index) {
		// Add your implementation here
		if(student==null||index<0||index>students.length) throw new IllegalArgumentException();
		int i=students.length-1;
		if(students[index]==null)
			students[index]=student;
		else{
		for(;i>index;i--){
			students[i]=students[i-1];
		}
		students[i]=student;
		}
	}

	@Override
	public void remove(int index) {
		// Add your implementation here
		if(index<0||index>students.length) throw new IllegalArgumentException();
		for(int i=index;i<students.length-1;i++){
			students[i]=students[i+1];
		}
	}

	@Override
	public void remove(Student student) {
		// Add your implementation here
		if(student==null) throw new IllegalArgumentException();
		int i=0;
		for(;i<students.length;i++){
			if(student.compareTo(students[i])==0){remove(i);break;}
			
		}
		if(i>students.length) throw new IllegalArgumentException("Student not exist");
		
	}

	@Override
	public void removeFromIndex(int index) {
		// Add your implementation here
		if(index<0||index>students.length) throw new IllegalArgumentException();
		for(;index<students.length;index++){students[index]=null;count--;}
	}

	@Override
	public void removeFromElement(Student student) {
		if(student==null) throw new IllegalArgumentException();
		int i=0;
		for(;i<students.length;i++){
			if(student.compareTo(students[i])==0){removeFromIndex(i);break;}
			
		}
		if(i>students.length) throw new IllegalArgumentException("Student not exist");
		
		
		// Add your implementation here
	}

	@Override
	public void removeToIndex(int index) {
		// Add your implementation here
		if(index<0||index>students.length) throw new IllegalArgumentException();
		System.arraycopy(students,index,students,0,students.length-index-1);
	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
		if(student==null) throw new IllegalArgumentException();
		int i=0;
		for(;i<students.length;i++){
			if(student.compareTo(students[i])==0){removeToIndex(i);break;}
			
		}
		if(i>students.length) throw new IllegalArgumentException("Student not exist");
		
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
		Arrays.sort(students, new Comparator<Student>(){

			@Override
			public int compare(Student o1, Student o2) {
				return o1.compareTo(o2);
			}
			
		});
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
		if(date==null) throw new IllegalArgumentException();
		
		ArrayList<Student> al=new ArrayList<>();
		for(int i=0;i<students.length;i++){
			if(students[i].getBirthDate().equals(date))al.add(students[i]);
		}
		return (Student[]) al.toArray();
		
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
		int i=0,j=0;
		Student s[]=new Student[students.length-1];
		for(i=0;i<students.length-1;i++){
			if((students[i].getBirthDate()).after(firstDate)&&(students[i].getBirthDate()).before(lastDate)){
			s[j++]=students[i];	
			}
				
		}
		return s;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		if(date==null) throw new IllegalArgumentException();
		ArrayList<Student> al=new ArrayList<>();
		for(int i=0;i<students.length;i++){
			if((students[i].getBirthDate().compareTo(date))>=0&&(students[i].getBirthDate().compareTo(date))<=days){al.add(students[i]);}
		}
		return (Student[]) al.toArray();
		
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		if(indexOfStudent<0||indexOfStudent>students.length) throw new IllegalArgumentException();
		
		return 2017-students[indexOfStudent].getBirthDate().getYear();
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		if(age<0) throw new IllegalArgumentException();
		ArrayList<Student> al=new ArrayList<>();
		for(int i=0;i<students.length;i++){
			if(2017-students[i].getBirthDate().getYear()==age)al.add(students[i]);
		
		}
		return (Student[]) al.toArray();
		
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		double max=Integer.MIN_VALUE;
		for(int i=0;i<students.length;i++){
			if(max<students[i].getAvgMark())max=students[i].getAvgMark();
		}
		ArrayList<Student> al=new ArrayList<>();
		for(int i=0;i<students.length;i++){
			if(2017-students[i].getAvgMark()==max)al.add(students[i]);
		
		}
		return (Student[]) al.toArray();
		
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
		if(student==null) throw new IllegalArgumentException();
		for(int i=0;i<students.length;i++){
			if(student.compareTo(students[i])==0){
				for(int j=i+1;j<students.length;j++){
					if(students[j]!=null)
						return students[j];
				}
			}
		}
		return null;
	}
}