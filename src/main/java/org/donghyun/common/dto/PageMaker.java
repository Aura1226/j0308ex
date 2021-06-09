package org.donghyun.common.dto;

import org.donghyun.board.dto.PageDTO;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageMaker {

	private boolean prev;
	private boolean next;
	private int start;
	private int end;
	private PageDTO pageDTO;
	private int total;
	private int lastPage;
	
	
	public PageMaker(PageDTO pageDTO, int total) {
		// �� ������ ����
		this.total = total;
		this.pageDTO = pageDTO;
		
		int perSheet = pageDTO.getPerSheet();
		
		// ���� ������ ��ȣ
		double currentPage = (double)pageDTO.getPage();
		
		// System.out.println("currentPage : " + currentPage);
		// System.out.println("perSheet : " + perSheet);
		
		// �ӽ� ������ ��ȣ 13 -> 1.3 -> 2.0 -> 20
		int tempEnd = (int)(Math.ceil(currentPage * 0.1) * 10);
		// System.out.println("tempEnd : " + tempEnd);
		
		this.start = tempEnd - 9;
		
		// ��¥ ������ ������ 131
		int realEnd = (int)(Math.ceil(total / (double)perSheet));
		
		// �� ���� ���� end �� �ȴ�.
		this.end = realEnd < tempEnd ? realEnd : tempEnd;
		
		this.prev = start > 1;
		
		this.next = end * perSheet < total;  
		
		this.lastPage = (int)(Math.ceil(total / (double)perSheet));		
	}
	
	public String getLink(int page) {
		return "page=" + page + "&perSheet=" + this.pageDTO.getPerSheet();
	}
}
