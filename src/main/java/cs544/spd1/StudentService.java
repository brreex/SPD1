package cs544.spd1;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class StudentService {
	private StudentDAO studentdao;

	public StudentService() {
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void addStudent(Student student){
		studentdao.save(student);
	}
	@Transactional(readOnly=true)
	public Student getStudent(long studentid) {
		Student student = studentdao.getOne(studentid);
		return student;
		
	}

	public void setStudentdao(StudentDAO studentdao) {
		this.studentdao = studentdao;
	}
}
