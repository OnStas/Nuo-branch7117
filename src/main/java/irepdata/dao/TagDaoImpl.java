package irepdata.dao;

import irepdata.model.Tag;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Admin on 15.11.2016.
 */
@Repository
public class TagDaoImpl implements TagDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public Tag getTagById(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("select distinct t from Tag t where t.id = :id").setParameter("id", id);
        Tag tag = (Tag) query.uniqueResult();
        return tag;
    }

    @Override
    public Tag getTagAndIdeasById(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("select distinct t from Tag t left join fetch t.ideas i where t.id = :tag_id").setParameter("tag_id", id);
        return (Tag) query.uniqueResult();
    }

    @Override
    public void createTag(Tag tag) {
        sessionFactory.getCurrentSession().saveOrUpdate(tag);
    }

    @Override
    public boolean updateTag(Long id, String content, boolean isEnabled) {
        String hql = "UPDATE Tag set " +
                "content = :content, " +
                "enabled = :enabled " +
                "WHERE id = :tag_id";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("content", content);
        query.setParameter("enabled", isEnabled);
        query.setParameter("tag_id", id);
        int result = query.executeUpdate();
        if (result>0){
            return true;
        } else return false;
    }

    @Override
    public boolean deleteTag(Long id) {
        String hql = "DELETE FROM Tag " +
                "WHERE id = :tag_id";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("tag_id", id);
        int result = query.executeUpdate();
        if (result>0){
            return true;
        } else return false;
    }

    @Override
    public List<Tag> getSortedTagList(String orderingParameter, boolean ascend, boolean withoutDisabled) {
        StringBuilder hqlbuilder = new StringBuilder("select distinct t from Tag t ");
        if (withoutDisabled) hqlbuilder.append("where t.enabled = true ");
        hqlbuilder.append("order by t." + orderingParameter + " ");
        if (ascend) {
            hqlbuilder.append("asc");
        } else hqlbuilder.append("desc");
        return sessionFactory.getCurrentSession().createQuery(hqlbuilder.toString()).list();
    }

    @Override
    public List<Tag> getTagListWithIdeaId(Long ideaId, boolean withoutDisabled) {
        StringBuilder hqlbuilder = new StringBuilder("select distinct t from Tag t left join fetch t.ideas i where i.id = "+ ideaId);
        if (withoutDisabled) hqlbuilder.append(" and t.enabled = true");
        return sessionFactory.getCurrentSession().createQuery(hqlbuilder.toString()).list();
    }
}
