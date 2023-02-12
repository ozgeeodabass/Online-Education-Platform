package ceng.gradProject.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCoursesResponse {

	private int id;
	private String name;
	private String description;
}
