package com.github.rstockbridge.citizenship.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

public class Question implements Parcelable {

    @NonNull
    private final String question;

    @NonNull
    private final  String answer;

    private final int id;

    Question(@NonNull final String question, @NonNull final String answer, final int id) {
        this.question = question;
        this.answer = answer;
        this.id = id;
    }

    public String getQuestionText() {
        return question;
    }

    public String getAnswerText() {
        return answer;
    }

    public int getId() {
        return id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(question);
        dest.writeString(answer);
        dest.writeInt(id);
    }

    @SuppressWarnings("WeakerAccess")
    protected Question(Parcel in) {
        question = in.readString();
        answer = in.readString();
        id = in.readInt();
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
