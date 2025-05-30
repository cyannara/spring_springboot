package com.yedam.board.service.impl;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yedam.board.mapper.ReplyMapper;
import com.yedam.board.service.Criteria;
import com.yedam.board.service.ReplyPageDTO;
import com.yedam.board.service.ReplyService;
import com.yedam.board.service.ReplyVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@AllArgsConstructor
public class ReplyServiceImpl implements ReplyService {

  
  private ReplyMapper mapper;

  
  
  @Override
  public int register(ReplyVO vo) {
    return mapper.insert(vo);

  }

  @Override
  public ReplyVO get(Long rno) {
    return mapper.read(rno);
  }

  @Override
  public int modify(ReplyVO vo) {
    return mapper.update(vo);
  }

  @Override
  public int remove(Long rno) {
    return mapper.delete(rno);
  }

  @Override
  public List<ReplyVO> getList(Criteria cri, Long bno) {
    return mapper.getList(cri, bno);
  }
  
  @Override
  public ReplyPageDTO getListPage(Criteria cri, Long bno) {       
    return new ReplyPageDTO(
        mapper.getCountByBno(bno), 
        mapper.getList(cri, bno));
  }
  
}

