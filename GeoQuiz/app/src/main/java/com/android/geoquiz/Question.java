package com.android.geoquiz;

/**
 * Created by elcin on 8/19/17.
 */

public class Question {
    String category;
    int _quizid;
    String achoice;
    String bchoice;
    String cchoice;
    String dchoice;
    String puan;

    public Question(int quizid, String category, String achoice,
                    String bchoice,String cchoice,String dchoice,
                    String puan){
        this.category = category;
        this._quizid = quizid;
        this.achoice = achoice;
        this.bchoice = bchoice;
        this.cchoice = cchoice;
        this.dchoice = dchoice;
        this.puan = puan;

    }
    public String getCategory() {
        return this.category;
    }

    public int get_quizid() {
        return this._quizid;
    }

    public String getAchoice() {
        return this.achoice;
    }

    public String getBchoice() {
        return this.bchoice;
    }

    public String getCchoice() {
        return this.cchoice;
    }

    public String getDchoice() {
        return this.dchoice;
    }

    public String getPuan() {
        return this.puan;
    }


}
