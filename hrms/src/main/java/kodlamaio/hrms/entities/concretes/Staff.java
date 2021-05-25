package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "staff")
@AllArgsConstructor
@NoArgsConstructor
public class Staff {
	
	@Id
	@GeneratedValue()
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "department")
	private String department; 

}
