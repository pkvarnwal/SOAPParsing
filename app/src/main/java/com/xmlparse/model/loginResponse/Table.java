package com.xmlparse.model.loginResponse;


import com.google.gson.annotations.SerializedName;

public class Table {

    @SerializedName("DistributorEMailID")
    private String DistributorEMailID;
    @SerializedName("diffgr:id")
    private String diffgrId;
    @SerializedName("DistributorName")
    private String distributorName;
    @SerializedName("DistributorLevel")
    private String distributorLevel;
    @SerializedName("ProfileImagePath")
    private String profileImagePath;
    @SerializedName("DistibutorAddress")
    private String distibutorAddress;
    @SerializedName("IsTrainer_Distributor")
    private String isTrainer_Distributor;
    @SerializedName("RANK")
    private String RANK;
    @SerializedName("DistributorId")
    private String distributorId;
    @SerializedName("Staus")
    private String staus;
    @SerializedName("DistributorMobNumber")
    private String distributorMobNumber;
    @SerializedName("msdata:rowOrder")
    private String msdataRowOrder;


    public String getDistributorEMailID() {
        return DistributorEMailID;
    }

    public void setDistributorEMailID(String distributorEMailID) {
        DistributorEMailID = distributorEMailID;
    }

    public String getDiffgrId() {
        return diffgrId;
    }

    public void setDiffgrId(String diffgrId) {
        this.diffgrId = diffgrId;
    }

    public String getDistributorName() {
        return distributorName;
    }

    public void setDistributorName(String distributorName) {
        this.distributorName = distributorName;
    }

    public String getDistributorLevel() {
        return distributorLevel;
    }

    public void setDistributorLevel(String distributorLevel) {
        this.distributorLevel = distributorLevel;
    }

    public String getProfileImagePath() {
        return profileImagePath;
    }

    public void setProfileImagePath(String profileImagePath) {
        this.profileImagePath = profileImagePath;
    }

    public String getDistibutorAddress() {
        return distibutorAddress;
    }

    public void setDistibutorAddress(String distibutorAddress) {
        this.distibutorAddress = distibutorAddress;
    }

    public String getIsTrainer_Distributor() {
        return isTrainer_Distributor;
    }

    public void setIsTrainer_Distributor(String isTrainer_Distributor) {
        this.isTrainer_Distributor = isTrainer_Distributor;
    }

    public String getRANK() {
        return RANK;
    }

    public void setRANK(String RANK) {
        this.RANK = RANK;
    }

    public String getDistributorId() {
        return distributorId;
    }

    public void setDistributorId(String distributorId) {
        this.distributorId = distributorId;
    }

    public String getStaus() {
        return staus;
    }

    public void setStaus(String staus) {
        this.staus = staus;
    }

    public String getDistributorMobNumber() {
        return distributorMobNumber;
    }

    public void setDistributorMobNumber(String distributorMobNumber) {
        this.distributorMobNumber = distributorMobNumber;
    }

    public String getMsdataRowOrder() {
        return msdataRowOrder;
    }

    public void setMsdataRowOrder(String msdataRowOrder) {
        this.msdataRowOrder = msdataRowOrder;
    }
}
