/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 *
 * @author armenar
 */
@ManagedBean
@SessionScoped
public class DataBean implements Serializable {

    private Integer count;

    public List<String> dataList = new ArrayList<>();

    public DataBean() {
    }

    private SecureRandom random = new SecureRandom();

    @PostConstruct
    public void init() {
        for (int i = 0; i < 100; i++) {
            dataList.add(this.nextSessionId());
        }
    }

    public void sendInfo() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Attention!", "I know your all passwords!!!"));
        context.addMessage(null, new FacesMessage("Be Careful!", "You are hacked!!!!"));
    }

    public void sendInfo1() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Dear Boss!!!", "Give me my salary!!!!"));
    }

    public Integer getCount() {
        return dataList.size();
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String nextSessionId() {
        return new BigInteger(130, random).toString(32);
    }

    public List<String> getDataList() {

        return dataList;
    }

}
