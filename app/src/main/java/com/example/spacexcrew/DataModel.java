package com.example.spacexcrew;

public class DataModel {

    private String crewMemberName,crewMemberAgency,crewMemberImage,CrewMemberStatus,wiki_link;

    public DataModel() {
    }

    public DataModel(String crewMemberName, String crewMemberAgency,
                     String crewMemberImage, String crewMemberStatus, String wiki_link) {

        this.crewMemberName = crewMemberName;
        this.crewMemberAgency = crewMemberAgency;
        this.crewMemberImage = crewMemberImage;
        this.CrewMemberStatus = crewMemberStatus;
        this.wiki_link = wiki_link;
    }

    public String getCrewMemberName() {
        return crewMemberName;
    }

    public void setCrewMemberName(String crewMemberName) {
        this.crewMemberName = crewMemberName;
    }

    public String getCrewMemberAgency() {
        return crewMemberAgency;
    }

    public void setCrewMemberAgency(String crewMemberAgency) {
        this.crewMemberAgency = crewMemberAgency;
    }

    public String getCrewMemberImage() {
        return crewMemberImage;
    }

    public void setCrewMemberImage(String crewMemberImage) {
        this.crewMemberImage = crewMemberImage;
    }

    public String getCrewMemberStatus() {
        return CrewMemberStatus;
    }

    public void setCrewMemberStatus(String crewMemberStatus) {
        CrewMemberStatus = crewMemberStatus;
    }

    public String getWiki_link() {
        return wiki_link;
    }

    public void setWiki_link(String wiki_link) {
        this.wiki_link = wiki_link;
    }
}
