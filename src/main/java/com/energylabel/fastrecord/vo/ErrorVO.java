package com.energylabel.fastrecord.vo;


public class ErrorVO {
    private String result;
    private String err_code;
    private String err_msg;

    public ErrorVO(String err_code, String err_msg) {
        this.result = "0";
        this.err_code = err_code;
        this.err_msg = err_msg;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getErr_code() {
        return err_code;
    }

    public void setErr_code(String err_code) {
        this.err_code = err_code;
    }

    public String getErr_msg() {
        return err_msg;
    }

    public void setErr_msg(String err_msg) {
        this.err_msg = err_msg;
    }

    @Override
    public String toString() {
        return "ErrorVO{" +
                "result='" + result + '\'' +
                ", err_code='" + err_code + '\'' +
                ", err_msg='" + err_msg + '\'' +
                '}';
    }
}
