package com.quiz.lesson07.entity;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity // 이 클래스는 Entity 다
@Getter // getter
@Builder // setter 대용
@NoArgsConstructor // 파라미터 없는 기본 생성자
@AllArgsConstructor // 모든 필드를 인자값으로 받는 생성자
@ToString // toString override  값 예쁘게출력
@Table(name = "company")
public class CompanyEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String business;
	private String scale;
	private String headcount;
	@UpdateTimestamp
	@Column(name="createdAt" ,updatable = false)
	private ZonedDateTime createdAt;
	@UpdateTimestamp
	@Column(name = "updatedAt")
	private ZonedDateTime updatedAt;
}
