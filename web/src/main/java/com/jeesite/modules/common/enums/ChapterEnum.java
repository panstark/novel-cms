package com.jeesite.modules.common.enums;

/**
 * @author by panstark
 * @description
 * @notice
 * @date 2019/11/5
 */
public enum ChapterEnum {


    FIRSTCHAPTER("1", "第一章"),
    LASTCHAPTER("2", "最后一章");

    private String code;

    private String name;

    ChapterEnum(String code, String name){
        this.code = code;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

}
