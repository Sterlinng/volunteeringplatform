package org.acme.services.management.impl;

import java.util.List;

import org.acme.model.Notice;
import org.acme.services.management.INoticeMgtService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class NoticeMgtService implements INoticeMgtService {
    @Inject
    EntityManager entityManager;

    @Override
    @Transactional
    public Notice createNotice(Notice notice) {
        entityManager.persist(notice);
        return notice;
    }

    @Override
    @Transactional
    public Notice getNoticeById(int noticeId) {
        return entityManager.find(Notice.class, noticeId);
    }

    @Override
    @Transactional
    public List<Notice> getAllNotices() {
        return entityManager.createQuery("SELECT m FROM Notice m", Notice.class).getResultList();
    }

    @Override
    @Transactional
    public Notice updateNotice(int noticeId, Notice updatedNotice) {
        Notice existingNotice = entityManager.find(Notice.class, noticeId);
        if (existingNotice != null) {
            existingNotice.wording = updatedNotice.wording;
            existingNotice.id_notice = updatedNotice.id_notice;
            existingNotice.contained = updatedNotice.contained;
            existingNotice.date_notice = updatedNotice.date_notice;
        }
        return updatedNotice;
    }

    @Override
    @Transactional
    public void deleteNotice(int noticeId) {
        Notice noticeToDelete = entityManager.find(Notice.class, noticeId);
        if (noticeToDelete != null) {
            entityManager.remove(noticeToDelete);
        }
    }
}
