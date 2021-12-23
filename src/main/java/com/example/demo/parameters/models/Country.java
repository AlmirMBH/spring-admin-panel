package com.example.demo.parameters.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Entity
@Data // @ToString, @EqualsAndHashCode, @Getter, @Setter and @RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Country {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String code;
	private String capital;
	private String description;
	private String nationality;
	private String continent;

	// a country has many states; if a List<State> (optional, enables e.g. country.states to get all states) is used a @JsonIdentityInfo needs to be used (see above) in the related models to avoid infinite / infinite recursion
	@OneToMany(mappedBy="country")
	private List<State> states;
}
