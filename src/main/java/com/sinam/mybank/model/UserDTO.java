package com.sinam.mybank.model;


import com.sinam.mybank.myenums.Gender;
import com.sinam.mybank.myenums.Role;

import java.time.LocalDateTime;
import java.util.List;

public class UserDTO {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String fin;
    private Gender gender;
    private Role role;
    private List<BankAccountDTO> bankAccountDTOList;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", fin='" + fin + '\'' +
                ", gender=" + gender +
                ", role=" + role +
                ", bankAccountDTOList=" + bankAccountDTOList +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    public UserDTO() {

    }

    public UserDTO(Long id, String name, String surname, String email, String fin, Gender gender, Role role, List<BankAccountDTO> bankAccountDTOList, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.fin = fin;
        this.gender = gender;
        this.role = role;
        this.bankAccountDTOList = bankAccountDTOList;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public List<BankAccountDTO> getBankAccountDTOList() {
        return bankAccountDTOList;
    }

    public void setBankAccountDTOList(List<BankAccountDTO> bankAccountDTOList) {
        this.bankAccountDTOList = bankAccountDTOList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
