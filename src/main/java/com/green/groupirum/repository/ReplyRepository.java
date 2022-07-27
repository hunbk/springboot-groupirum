package com.green.groupirum.repository;

import com.green.groupirum.domain.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.websocket.server.PathParam;
import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
//    @Query(nativeQuery = true, value = "select * from reply where recruit_id = ? order by if(isnull(parent_id), reply_id, parent_id)")
//    @Query("SELECT r FROM Reply r INNER JOIN r.recruit rec ON r.recruit.id = rec.id WHERE rec.id = :recruitId ORDER BY coalesce(r.parent.id, r.id) , r.id")
    @Query("SELECT r FROM Reply r WHERE r.recruit.id = :recruitId ORDER BY coalesce(r.parent.id, r.id) , r.id")
    List<Reply> findAllByRecruitId(@PathParam("recruitId") Long recruitId);
}
