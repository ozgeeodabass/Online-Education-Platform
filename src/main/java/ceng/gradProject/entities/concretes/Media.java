package ceng.gradProject.entities.concretes;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name="medias")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Media {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="media_id")
	private int mediaId;
	
	@Column(name="file_path")
	private String filePath;
	
	@Column(name="title")
	private String title;
	
	@ManyToOne
	@JoinColumn(name="course_id", insertable = false,updatable = false)
	@JsonIgnore
    private Course course;
	

}
