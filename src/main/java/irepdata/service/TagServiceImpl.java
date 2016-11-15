package irepdata.service;

import irepdata.dao.TagDao;
import irepdata.model.Tag;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Admin on 15.11.2016.
 */
@Service
public class TagServiceImpl implements TagDao {
    private final static Log logger = LogFactory.getLog(TagServiceImpl.class);

    @Autowired
    private TagDao tagDao;

    public TagDao getTagDao() {
        return tagDao;
    }

    public void setTagDao(TagDao TagDAO) {
        tagDao = TagDAO;
    }

    @Transactional
    public Tag getTagById(Long id) {
        return tagDao.getTagById(id);
    }

    @Transactional
    public void createTag(Tag tag) {
        tagDao.createTag(tag);
    }

    @Transactional
    public boolean updateTag(Long id, String content) {
        return tagDao.updateTag(id, content);
    }

    @Transactional
    public boolean deleteTag(Long id) {
        return tagDao.deleteTag(id);
    }

    @Transactional
    public List<Tag> getSortedTagList(String orderingParameter, boolean ascend) {
        return tagDao.getSortedTagList(orderingParameter, ascend);
    }
}