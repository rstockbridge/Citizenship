package com.github.rstockbridge.citizenship.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

public final class Question implements Parcelable {

    @NonNull
    private final String question;

    @NonNull
    private final String answer;

    private final int id;

    Question(@NonNull final String question, @NonNull final String answer, final int id) {
        this.question = question;
        this.answer = answer;
        this.id = id;
    }

    @NonNull
    public String getQuestionText() {
        return question;
    }

    @NonNull
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
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeString(question);
        dest.writeString(answer);
        dest.writeInt(id);
    }

    protected Question(final Parcel in) {
        question = in.readString();
        answer = in.readString();
        id = in.readInt();
    }

    public static final Creator<Question> CREATOR = new Creator<Question>() {
        @Override
        public Question createFromParcel(final Parcel in) {
            return new Question(in);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };
}
