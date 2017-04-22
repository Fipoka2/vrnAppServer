package com.fipoka2.Entity;

/**
 * Created by Dmitry on 23.04.2017.
 */
public class QuestDetails
{
    private long idQuestDetails;
    private long idTeam;
    private long idQuest;
    private byte[] binaryData;
    private boolean isAccepted;
    private String message;

    public QuestDetails(long idQuestDetails, long idTeam, long idQuest, byte[] binaryData, boolean isAccepted, String message)
    {
        this.idQuestDetails = idQuestDetails;
        this.idTeam = idTeam;
        this.idQuest = idQuest;
        this.binaryData = binaryData;
        this.isAccepted = isAccepted;
        this.message = message;
    }

    public long getIdQuestDetails()
    {
        return idQuestDetails;
    }

    public void setIdQuestDetails(long idQuestDetails)
    {
        this.idQuestDetails = idQuestDetails;
    }

    public long getIdTeam()
    {
        return idTeam;
    }

    public void setIdTeam(long idTeam)
    {
        this.idTeam = idTeam;
    }

    public long getIdQuest()
    {
        return idQuest;
    }

    public void setIdQuest(long idQuest)
    {
        this.idQuest = idQuest;
    }

    public byte[] getBinaryData()
    {
        return binaryData;
    }

    public void setBinaryData(byte[] binaryData)
    {
        this.binaryData = binaryData;
    }

    public boolean isAccepted()
    {
        return isAccepted;
    }

    public void setAccepted(boolean accepted)
    {
        isAccepted = accepted;
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
