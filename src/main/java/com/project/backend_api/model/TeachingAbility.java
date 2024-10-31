package com.project.backend_api.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "teachingAbility")
public class TeachingAbility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Mối quan hệ 1:N với TeachingAssignment
    @OneToMany(mappedBy = "teachingAbility", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "assign_ability")
    private List<TeachingAssignment> teachingAssignments; // Danh sách phân công giảng dạy

    @ManyToOne
    @JoinColumn(name = "topic_id")
    @JsonBackReference(value = "teachTopic")
    private Topic topic;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonBackReference(value = "empTeach")
    private Employee employee;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<TeachingAssignment> getTeachingAssignments() {
		return teachingAssignments;
	}

	public void setTeachingAssignments(List<TeachingAssignment> teachingAssignments) {
		this.teachingAssignments = teachingAssignments;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
    
    
}
