package org.acme.services.management;

import java.util.List;

import org.acme.model.Notice;

public interface INoticeMgtService {

    /**
     * 
     * @param notice
     * @return
     */
    public Notice createNotice(Notice notice);
    
    /**
     * 
     * @param noticeId
     * @return
     */
    public Notice getNoticeById(int noticeId);

    /**
     * 
     * @return
     */
    public List<Notice> getAllNotices();

    /**
     * 
     * @param noticeId
     * @param updatedNotice
     * @return
     */
    public Notice updateNotice(int noticeId, Notice updatedNotice);

    /**
     * 
     * @param noticeId
     */
    public void deleteNotice(int noticeId);
}
