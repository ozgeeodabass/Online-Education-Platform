package ceng.gradProject.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="instructors")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Instructor {

	@Id
	@Column(name="instr_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int instrId;
	
	@Column(name="instr_first_name")
	private String instrFirstName;
	
	@Column(name="instr_last_name")
	private String instrLastName;
	
	@Column(name="instr_password")
	private String password;
	
	@Column(name="about_inst")
	private String aboutInstr;
	
	@JsonIgnore
	@OneToMany(mappedBy = "instructor")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Course> courses;
	
	@ManyToOne()
	@JoinColumn(name="dept_id", insertable = false,updatable = false)
	private Department department;

	
	
	
}
