package com.community.news;

public class NewsVO {
	private int seq;
	private String href;
	private String img;
	private String title;
	private String ref;
	private String regdate;
	private String detail;
	
	public NewsVO() {
		
	}
	
	public NewsVO(int seq, String href, String img, String title, String ref, String regdate, String detail) {
		super();
		this.seq = seq;
		this.href = href;
		this.img = img;
		this.title = title;
		this.ref = ref;
		this.regdate = regdate;
		this.detail = detail;
	}
	
	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "NewsVO [seq=" + seq + ", href=" + href + ", img=" + img + ", title=" + title + ", ref=" + ref
				+ ", regdate=" + regdate + ", detail=" + detail + "]";
	}
	
	
	
}
