package net.softsociety.exam.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 게시글 정보
 */
@Data
public class Board {

	private String title;
    private String content;
    private String category;
    private String member_id;
//	public void setCategory(String category) {
//		
//	}
//
//	public void setTitle(String title) {
//		
//	}
//
//	public void setContent(String content) {
//		
//	}
	
}
