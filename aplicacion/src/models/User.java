package models;

import java.util.Date;

public class User {
    private Integer empId;
    private String firstName;
    private String email;
    private String role;
    private String phone;
    private Date createdAt;
    private Date updatedAt;

    public User(Integer empId, String firstName, String email, String role, String phone, Date createdAt, Date updatedAt) {
        this.empId = empId;
        this.firstName = firstName;
        this.email = email;
        this.role = role;
        this.phone = phone;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getEmpId() {
        return empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public String getPhone() {
        return phone;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }
}
