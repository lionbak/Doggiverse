package com.community.common;

public class PageCreator {


	//페이지 번호와 한 페이지당 들어갈 게시물의 개수를 가지고 있는 객체.
	private PageVO paging;
	private int articleTotalCount; //총 게시물의 개수
	private int beginPage; //시작 페이지 번호
	private int endPage; //끝 페이지 번호
	private boolean prev; //이전 버튼 활성화 여부
	private boolean next; //다음 버튼 활성화 여부





	//한 화면에 보여질 페이지 버튼 수
	private final int displayBtn = 5;



	//페이징 알고리즘을 수행할 메서드 선언하자
	private void calcDataOfPage() {
		//시작 페이지 번호 구하자
		this.beginPage = (this.endPage - displayBtn) + 1;

		//제일먼저 보정 전 끝 페이지 구하기
		this.endPage = (int)Math.ceil(paging.getPage() / (double) displayBtn) * displayBtn;

		//현재 시작 페이지가 1이라면 이전 버튼 비활성화.
		this.prev = (beginPage == 1) ? false : true;

		//다음 버튼 비활성 판단
		this.next = (articleTotalCount <= (endPage * paging.getCpp())) ? false : true;

		//다음 버튼 비활성화라면 끝 페이지를 보정하기
		if(!next) {
			endPage = (int) Math.ceil(articleTotalCount / (double) paging.getCpp());
		}
	}



	//그리고 게터세터생성할 떄 final로 생성한 displayBtn은 필요없어서 뺏다.
	public PageVO getPaging() {
		return paging;
	}

	public void setPaging(PageVO paging) {
		this.paging = paging;
	}

	public int getArticleTotalCount() {
		return articleTotalCount;
	}

	public void setArticleTotalCount(int articleTotalCount) {
		this.articleTotalCount = articleTotalCount;
		//Service 클래스가 이 메서드를 통해 총 게시물의 개수를 전달할 때, 즉시 알고리즘이 가동될 수 있도록 하겠다.
		calcDataOfPage();
	}

	public int getBeginPage() {
		return beginPage;
	}

	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}





}







