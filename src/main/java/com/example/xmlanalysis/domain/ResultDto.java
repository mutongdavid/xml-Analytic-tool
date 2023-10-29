package com.example.xmlanalysis.domain;


import lombok.Data;

import java.io.Serializable;

@Data
public class ResultDto implements Serializable {
    private boolean success = true;
    /**
     * 返回码 200-成功，500-服务器内部错误
     */
    private Integer code;

    /**
     * 返回信息
     */
    private String msg;

    /**
     * 返回数据
     */
    private Object data;

    public static ResultDto succ() {
        ResultDto resultDto = new ResultDto();
        resultDto.setSuccess(true);
        resultDto.setCode(200);
        resultDto.setMsg("操作成功");
        return resultDto;
    }

    public static ResultDto succ(Object data) {
        ResultDto resultDto = new ResultDto();
        resultDto.setSuccess(true);
        resultDto.setCode(200);
        resultDto.setData(data);
        resultDto.setMsg("操作成功");
        return resultDto;
    }

    public static ResultDto succ(String msg, Object data) {
        ResultDto resultDto = new ResultDto();
        resultDto.setSuccess(true);
        resultDto.setCode(200);
        resultDto.setData(data);
        resultDto.setMsg(msg);
        return resultDto;
    }

    public static ResultDto fail(String msg) {
        ResultDto resultDto = new ResultDto();
        resultDto.setSuccess(false);
        resultDto.setCode(500);
        resultDto.setData(null);
        resultDto.setMsg(msg);
        return resultDto;
    }

    public static ResultDto fail(String msg, Object data) {
        ResultDto resultDto = new ResultDto();
        resultDto.setSuccess(false);
        resultDto.setCode(500);
        resultDto.setData(data);
        resultDto.setMsg(msg);
        return resultDto;
    }

    public static ResultDto fail(Integer errorCode, String msg) {
        ResultDto resultDto = new ResultDto();
        resultDto.setSuccess(false);
        resultDto.setCode(errorCode);
        resultDto.setData(null);
        resultDto.setMsg(msg);
        return resultDto;
    }

    public static ResultDto fail(Integer errorCode, String msg, Object data) {
        ResultDto resultDto = new ResultDto();
        resultDto.setSuccess(false);
        resultDto.setCode(errorCode);
        resultDto.setData(data);
        resultDto.setMsg(msg);
        return resultDto;
    }
}
