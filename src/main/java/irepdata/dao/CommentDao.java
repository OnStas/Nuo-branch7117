package irepdata.dao;

import irepdata.model.Comment;
import irepdata.model.Idea;
import irepdata.model.User;

import java.util.List;
import java.util.SortedSet;

/**
 * Created by Gvozd on 13.11.2016.
 */
public interface CommentDao {
    public Comment getCommentById(Long id);
    public void createComment(Comment comment);
    public void updateComment(Long id, String content, boolean isEnabled);
    public boolean deleteComment(Long id);
    public List<Comment> getSortedCommentsForIdea(Long ideaId, String orderingParameter, boolean ascend, boolean withoutDisabled);
}
