package com.sinam.mybank.model.auth;

import com.sinam.mybank.myenums.Role;
import com.sinam.mybank.myenums.Status;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRegisterRequestDto {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Surname is required")
    private String surname;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 3, message = "Password must be at least 3 characters")
    private String password;

    @NotBlank(message = "Fin is required")
    private String fin;

    @NotBlank(message = "Gender is required")
    private String gender;
    private Role role = Role.USER;
    private Status status = Status.ACTIVE;

    public UserRegisterRequestDto() {}

    public UserRegisterRequestDto(String name, String surname, String email, String password, String fin, String gender, Role role, Status status) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.fin = fin;
        this.gender = gender;
        this.role = role;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
