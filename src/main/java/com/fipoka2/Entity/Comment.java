package com.fipoka2.Entity;

/**
 * Created by Dmitry on 23.04.2017.
 */
public class Comment
{
    private long idComment;
    private long idCommentator;
    private long idQuest;
    private String message;

    public Comment(long idComment, long idCommentator, long idQuest, String message)
    {
        this.idComment = idComment;
        this.idCommentator = idCommentator;
        this.idQuest = idQuest;
        this.message = message;
    }

    public Comment()
    {
    }

    public long getIdComment()
    {
        return idComment;
    }

    public void setIdComment(long idComment)
    {
        this.idComment = idComment;
    }

    public long getIdCommentator()
    {
        return idCommentator;
    }

    public void setIdCommentator(long idCommentator)
    {
        this.idCommentator = idCommentator;
    }

    public long getIdQuest()
    {
        return idQuest;
    }

    public void setIdQuest(long idQuest)
    {
        this.idQuest = idQuest;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }
}
