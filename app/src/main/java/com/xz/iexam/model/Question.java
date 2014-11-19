package com.xz.iexam.model;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by xuzhe on 2014/11/19.
 */
public class Question{
    // {"id":100,
    //  "details":"泥泞道路对安全行车的主要影响是什么？",
    //  "answers": ["行驶阻力变小", "车轮极易滑转和侧滑", "能见度低，视野模糊", "路面附着力增大"]
    //  "result": 2}
    private int id;
    private String details;
    private ArrayList<String> answers;
    private int result;

    public Question(int id, String details, ArrayList<String> answers, int result) {
        this.id = id;
        this.details = details;
        this.answers = answers;
        this.result = result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getResultString() {
        if (answers.size() > result)
            return answers.get(result);
        return "";
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

}
