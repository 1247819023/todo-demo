package com.nf147.todo.vo;

import com.github.pagehelper.Page;

public class ResultVO<T> {
    private int code;
    private T data;
    private Page<T> page;
    private String error;
    private Throwable throwable;


    public int getCode() {
        return code;
    }

    public ResultVO<T> setCode(int code) {
        this.code = code;
        //返回自身就可以形成链式操作
        return this;
    }

    public T getData() {
        return data;
    }

    public ResultVO<T> setData(T data) {
        this.data = data;
        return this;
    }

    public Page<T> getPage() {
        return page;
    }

    public ResultVO<T> setPage(Page page) {
        this.page = page;
        return this;
    }

    public String getError() {
        return error;
    }

    public ResultVO<T> setError(String error) {
        this.error = error;
        return this;
    }

    public Throwable getThrowable() {
        return throwable;

    }

    public ResultVO<T> setThrowable(Throwable throwable) {
        this.throwable = throwable;
        return this;
    }
}
