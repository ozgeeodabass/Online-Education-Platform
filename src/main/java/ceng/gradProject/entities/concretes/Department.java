package ceng.gradProject.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "departments")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Department {

	@Id
	@Column(name = "dept_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int deptId;
	
	@Column(name = "dept_name")
	private String deptName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "department")
	private List<Instructor> instructors;
	
	@JsonIgnore
	@OneToMany(mappedBy = "department")
	private List<User> users;
	
	@JsonIgnore
	@OneToMany(mappedBy = "department")
	private List<Course> courses;
}
