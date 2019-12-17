package com.example.hackersquiz;

public class questions {

    private int getresid;
    private boolean answer;

    public questions(int getresid, boolean answer) {
        this.getresid = getresid;
        this.answer = answer;
    }

    public int getGetresid() {
        return getresid;
    }

    public void setGetresid(int getresid) {
        this.getresid = getresid;
    }

    public boolean getAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}
