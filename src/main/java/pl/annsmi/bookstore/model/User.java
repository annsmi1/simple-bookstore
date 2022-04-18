package pl.annsmi.bookstore.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    private String address;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Transaction> transactions;

}
