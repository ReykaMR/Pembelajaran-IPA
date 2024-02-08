package com.example.pembelajaranipa;

public class MateriPembelajaranModel {

    String setName;
    int setImage;

    public MateriPembelajaranModel(String setName, int setImage)  {
        this.setName = setName;
        this.setImage = setImage;
    }

    public String getSetName() {
        return setName;
    }

    public int getSetImage() {
        return setImage;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }

    public void setSetImage(int setImage) {
        this.setImage = setImage;
    }


}
