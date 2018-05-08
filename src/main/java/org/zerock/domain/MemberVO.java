package org.zerock.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberVO {
	
	private String uid, upw, uname, email, grade; 
	//등급으로 허용제한... 솔루션쪽용어 : ACL액세스 컨트롤 리스트

	public MemberVO(String uid, String upw) {//디폴트
		this.uid = uid;
		this.upw = upw;
		this.uname = "Sample User";
		this.grade = "P";
	}
}
