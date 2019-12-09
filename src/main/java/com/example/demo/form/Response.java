package com.example.demo.form;

public class Response<T> {
    private int count;
    private T dataMovie;


    public Response() {
    }

    public Response(int count, T dataMovie) {
        this.count = count;
        this.dataMovie = dataMovie;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public T getDataMovie() {
        return dataMovie;
    }

    public void setDataMovie(T dataMovie) {
        this.dataMovie = dataMovie;
    }
}
