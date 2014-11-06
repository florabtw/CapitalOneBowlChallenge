package me.nickpierson.bowlchallenge.api;

import com.google.gson.annotations.SerializedName;

public class Points {

    @SerializedName("for")
    private int _for;

    private int against;

    private int net;

    public Points() {
    }

    public Points(int _for, int against, int net) {
        this._for = _for;
        this.against = against;
        this.net = net;
    }

    public int getFor() {
        return _for;
    }

    public void setFor(int _for) {
        this._for = _for;
    }

    public int getAgainst() {
        return against;
    }

    public void setAgainst(int against) {
        this.against = against;
    }

    public int getNet() {
        return net;
    }

    public void setNet(int net) {
        this.net = net;
    }
}