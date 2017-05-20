package com.fipoka2.Entity;


public class QuestDatafiles
{
    private long idQuestDatafiles;

    private long idQuestDetails;

    private String type;

    private String link;

    public QuestDatafiles()
    {
    }

    public long getIdQuestDatafiles()
    {
        return idQuestDatafiles;
    }

    public void setIdQuestDatafiles(long idQuestDatafiles)
    {
        this.idQuestDatafiles = idQuestDatafiles;
    }

    public long getIdQuestDetails()
    {
        return idQuestDetails;
    }

    public void setIdQuestDetails(long idQuestDetails)
    {
        this.idQuestDetails = idQuestDetails;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getLink()
    {
        return link;
    }

    public void setLink(String link)
    {
        this.link = link;
    }

}
