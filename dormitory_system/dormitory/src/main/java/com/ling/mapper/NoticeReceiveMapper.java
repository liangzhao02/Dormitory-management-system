package com.ling.mapper;

import java.util.List;

import com.ling.entity.NoticeReceive;

public interface NoticeReceiveMapper {

	public int create(NoticeReceive noticeReceive);

	public int delete(Integer id);

	public int deleteByNoticeId(Integer noticeId);

	public int update(NoticeReceive noticeReceive);

	public int updateSelective(NoticeReceive noticeReceive);

	public List<NoticeReceive> query(NoticeReceive noticeReceive);

	public NoticeReceive detail(Integer id);

	public int count(NoticeReceive noticeReceive);

}
