package com.gomefinance.hl.security.excepton;

/**
 * @Author hzj
 * @Date 2017/6/14 15:17
 * @Description :
 */
public class BusinessException extends RuntimeException{

    private String showMsg ;

    private String code ;

    public BusinessException( String showMsg, String code) {
        super(showMsg);
        this.showMsg = showMsg;
        this.code = code;
    }

    public String getShowMsg() {
        return showMsg;
    }

    public void setShowMsg(String showMsg) {
        this.showMsg = showMsg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
