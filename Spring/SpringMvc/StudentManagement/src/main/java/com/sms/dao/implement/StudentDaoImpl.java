package com.sms.dao.implement;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sms.dao.StudentDao;
import com.sms.dto.StudentDto;
import com.sms.entity.Student;

@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private static ModelMapper mapper = new ModelMapper();

	@Override
	public int save(Student student) {
		// TODO Auto-generated method stub

		try {
			sessionFactory.getCurrentSession().saveOrUpdate(student);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}
		
	@Override
	public void update(int id, StudentDto studentDto){
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.getCurrentSession();
		Student student = session.get(Student.class, id);
		if(student !=null)
		{
			student.setName(studentDto.getName());
			student.setClassNo(studentDto.getClassNo());
			student.setDob(studentDto.getDob());
			student.setPhoneNo(studentDto.getPhoneNo());
			student.setPresentAddress(studentDto.getPresentAddress());
			student.setPermanentAddress(studentDto.getPermanentAddress());
			student.setBloodGroup(studentDto.getBloodGroup());
			student.setAdmissionDate(studentDto.getAdmissionDate());
			student.setFatherName(studentDto.getFatherName());
			student.setMotherName(studentDto.getMotherName());
			student.setFatherPhoneNo(studentDto.getFatherPhoneNo());
			student.setMotherPhoneNo(studentDto.getMotherPhoneNo());
			System.err.println("Updated successfully");
		}

	}

	@Override
	public Student getById(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Student student = session.get(Student.class, id);

		return student;
	}

	@Override
	public List<Student> getByClass(int classNo) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = "from Student where classNo = " + classNo;
		List<Student> resultList = session.createQuery(query, Student.class).getResultList();
		return resultList;

	}

	@Override
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student getByEmail(String email) {
		// TODO Auto-generated method stub

		Session session = this.sessionFactory.getCurrentSession();
		String query = "from Student where email =:email";

		Query<Student> createQuery = session.createQuery(query, Student.class);

		createQuery.setParameter("email", email);

		Student student = createQuery.uniqueResult();
		System.out.println("Student = "+student);

		return student;
	}

}
