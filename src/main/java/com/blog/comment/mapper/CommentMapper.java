package com.blog.comment.mapper;

import com.blog.comment.record.CommentCreateRecord;
import com.blog.comment.record.CommentRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {

    //-------------삽입----------------
    int insertComment(CommentCreateRecord param);

    //-------------조회----------------
    //게시글 번호로 댓글 목록 조회
    List<CommentRecord> findByPostId(@Param("postId") Integer postId);

    String selectWriterId(@Param("commentNum") Integer commentNum);

    //-------------수정----------------
    //댓글 내용 수정
    int update(CommentRecord record);

    //-------------삭제----------------
    //댓글 소프트 딜리트 삭제
    int delete(@Param("commentNum") Integer commentNum);
























}//interface
