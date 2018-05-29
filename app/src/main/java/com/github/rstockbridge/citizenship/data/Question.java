package com.github.rstockbridge.citizenship.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

public class Question implements Parcelable {

    @NonNull
    private String question;

    @NonNull
    private String answer;

    Question(@NonNull final String inputQuestion, @NonNull final String inputAnswer) {
        question = inputQuestion;
        answer = inputAnswer;
    }

    public String getQuestionText() {
        return question;
    }

    public String getAnswerText() {
        return answer;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(question);
        dest.writeString(answer);
    }

    @SuppressWarnings("WeakerAccess")
    protected Question(Parcel in) {
        question = in.readString();
        answer = in.readString();
    }

    public static final Creator<Question> CREATOR = new Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };
}
