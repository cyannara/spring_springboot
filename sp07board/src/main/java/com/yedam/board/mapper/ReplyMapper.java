package com.yedam.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.board.service.Criteria;
import com.yedam.board.service.ReplyVO;

public interface ReplyMapper {

	public int insert(ReplyVO vo);

	public ReplyVO read(Long bno);

	public int delete(Long bno);

	public int update(ReplyVO reply);

	public List<ReplyVO> getList(@Param("cri") Criteria cri, @Param("bno") Long bno);

	public int getCountByBno(Long bno);
}
