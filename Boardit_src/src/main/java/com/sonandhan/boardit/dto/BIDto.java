package com.sonandhan.boardit.dto;

import java.sql.Timestamp;

public class BIDto {
	/**
	 * db데이터를 클래스 객체로 바꾸는 애
	 */
	// DB테이블 칼럼 명 그대로 쓰는게 좋겠다ㅏ

	int bId;
	String bName;
	String bTitle;
	Timestamp bDate;
	int bHit; // 조회수 우리는 없음
	int bGroup;
	int bStep;
	int bIndent;

	public BIDto() {
		super();
	}

	public BIDto(int bId, String bName, String bTitle, Timestamp bDate, int bHit, int bGroup, int bStep, int bIndent) {
		super();
		this.bId = bId;
		this.bName = bName;
		this.bTitle = bTitle;
		this.bDate = bDate;
		this.bHit = bHit;
		this.bGroup = bGroup;
		this.bStep = bStep;
		this.bIndent = bIndent;
	}

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public Timestamp getbDate() {
		return bDate;
	}

	public void setbDate(Timestamp bDate) {
		this.bDate = bDate;
	}

	public int getbHit() {
		return bHit;
	}

	public void setbHit(int bHit) {
		this.bHit = bHit;
	}

	public int getbGroup() {
		return bGroup;
	}

	public void setbGroup(int bGroup) {
		this.bGroup = bGroup;
	}

	public int getbStep() {
		return bStep;
	}

	public void setbStep(int bStep) {
		this.bStep = bStep;
	}

	public int getbIndent() {
		return bIndent;
	}

	public void setbIndent(int bIndent) {
		this.bIndent = bIndent;
	}

}
