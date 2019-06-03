package com.sns.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.sns.util.SHA256Util;

import lombok.Data;

@Entity
@Table(name="tbl_member")
@Data
public class MemberVO {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idx;
	
	@Column(name="member_id", unique=true, length=20)
	private String memberId;
	
	@Column(name="member_pw", nullable=false, length=100)
	private String memberPw;
	
	@NotNull
	@Column(name="member_name", length=10)
	private String memberName;

	@Temporal(TemporalType.DATE)
	@NotNull
	@Column(name="member_date")
	private Date memberDate;
	
	@NotNull
	@Column(name="member_salt", length=30)
	private String memberSalt;

	public MemberVO() {
		memberDate = new Date();
		memberSalt = SHA256Util.generateSalt();
	}
}