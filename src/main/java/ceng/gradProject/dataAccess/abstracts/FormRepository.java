package ceng.gradProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import ceng.gradProject.entities.concretes.Form;

public interface FormRepository extends JpaRepository<Form, Integer> {

}
