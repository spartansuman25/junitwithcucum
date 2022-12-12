package cucumber.hello;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
	@Id
	private Object id;
	private String name;
	private int age;
	private String address;

}
