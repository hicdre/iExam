package com.xz.iexam.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by xuzhe on 2014/11/19.
 */
public class QuestionProvider {
    private static QuestionProvider ourInstance = new QuestionProvider();

    public static QuestionProvider getInstance() {
        return ourInstance;
    }

    private QuestionProvider() {
        questionMaps = new HashMap<Integer, Question>();
        Init();
    }

    private HashMap<Integer, Question> questionMaps;

    public void Init() {
        String s =  "[{\"id\":100,\"details\":\"泥泞道路对安全行车的主要影响是什么？\",\"answers\": [\"行驶阻力变小\", \"车轮极易滑转和侧滑\", \"能见度低，视野模糊\", \"路面附着力增大\"], \"result\": 2}]";
        try{
            JSONTokener jsonParser = new JSONTokener(s);
            JSONArray jsonArray = (JSONArray)jsonParser.nextValue();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                int id = jsonObject.getInt("id");
                String details = jsonObject.getString("details");
                int result = jsonObject.getInt("result");

                JSONArray jsonSubArray = jsonObject.getJSONArray("answers");
                ArrayList<String> answerList = new ArrayList<String>();
                for (int j = 0; j < jsonSubArray.length(); ++j) {
                    answerList.add(jsonSubArray.getString(j));
                }

                if (answerList.size() < result)
                    continue;

                questionMaps.put(id, new Question(id, details, answerList, result));

            }
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Question> GetQuestions() {
        ArrayList<Question> result = new ArrayList<Question>();
        for(HashMap.Entry<Integer,Question> me : questionMaps.entrySet()) {
            result.add(me.getValue());
        }
        return result;
    }
}
