package com.carlos.boot;

public class AjaxResponse {

    private boolean isok;
    private int code;//200 400 500

    public boolean isIsok() {
        return isok;
    }

    public void setIsok(boolean isok) {
        this.isok = isok;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    private String message;
    private Object data;

    public AjaxResponse(){};

    public static AjaxResponse success(){
        AjaxResponse ajaxResponse=new AjaxResponse();
        ajaxResponse.setIsok(true);
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("查詢成功");
        return ajaxResponse;
    }


    //默認查詢成功方法1
    public static AjaxResponse success(Object obj){
        AjaxResponse ajaxResponse=new AjaxResponse();
        ajaxResponse.setIsok(true);
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("查詢成功");
        ajaxResponse.setData(obj);
        return ajaxResponse;
    }

    //默認查詢成功方法2
    public static AjaxResponse success(Object obj,String message){
        AjaxResponse ajaxResponse=new AjaxResponse();
        ajaxResponse.setIsok(true);
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage(message);
        ajaxResponse.setData(obj);
        return ajaxResponse;
    }


}
