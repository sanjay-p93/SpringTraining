package com.batch.BatchProject.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {

    @Id
    private Integer id;
    private String name;
    private String branch;
    private Date time;

	public Student(Integer id, String name, String branch, Date time) {
        this.id = id;
        this.name = name;
		this.branch = branch;
        this.time = time;
    }

    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public String getBranch() {
        return branch;
    }

	public void setBranch(String branch) {
		this.branch = branch;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
		sb.append(", branch='").append(branch).append('\'');
        sb.append('}');
		System.out.println(sb);
        return sb.toString();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
