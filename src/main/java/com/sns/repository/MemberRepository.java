package com.sns.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sns.domain.MemberVO;

@Repository
@Transactional
public interface MemberRepository extends JpaRepository<MemberVO, Integer>{

	public MemberVO findByMemberName(String memberName);
	public int countByMemberId(String memberId);
	public MemberVO findByMemberId(String memberId);
	public Page<MemberVO> findAll(Pageable pageable);
	public MemberVO findBymemberId(String memberId); 
}
