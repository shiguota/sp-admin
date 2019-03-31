package com.evo.sp.basis.entity;

import java.time.LocalDateTime;
import com.evo.sp.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author sgt
 * @since 2019-03-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SpLog extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 方法名称
     */
    private String methodName;

    /**
     * 操作类似
     */
    private String operationType;

    /**
     * 请求时间
     */
    private LocalDateTime visiTime;

    /**
     * 响应时间
     */
    private LocalDateTime respTime;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 请求参数
     */
    private String parasms;

    /**
     * 错误代码
     */
    private String errorCode;

    /**
     * 错误提示
     */
    private String errorMsg;

    /**
     * 响应结果
     */
    private String results;

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public LocalDateTime getVisiTime() {
        return visiTime;
    }

    public void setVisiTime(LocalDateTime visiTime) {
        this.visiTime = visiTime;
    }

    public LocalDateTime getRespTime() {
        return respTime;
    }

    public void setRespTime(LocalDateTime respTime) {
        this.respTime = respTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getParasms() {
        return parasms;
    }

    public void setParasms(String parasms) {
        this.parasms = parasms;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }
}
