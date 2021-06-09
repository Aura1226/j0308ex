package org.donghyun.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageDTO {

	@Builder.Default
	private int page = 1;
	@Builder.Default
	private int perSheet = 10;
	
	public int getSkip() {
		return (page - 1) * perSheet;
	}
}
