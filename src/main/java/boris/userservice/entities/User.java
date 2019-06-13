package boris.userservice.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Size(min = 2, max = 30, message = "Please input a username between 2 and 30 characters")
    @Column(name = "username")
    private String username;

    @NotBlank
    @Size(min = 6, max = 18, message = "Please input a paswword between 6 and 18 characters")
    @Column(name = "password")
    private String password;



}
