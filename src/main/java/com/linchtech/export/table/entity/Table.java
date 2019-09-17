package com.linchtech.export.table.entity;

import lombok.Data;

/**
 * @author: 107
 * @date: 2019/7/11 14:07
 * @description:
 * @Review:
 */
@Data
public class Table {
    private String column;
    private String dataType;
    private String fieldType;
    private String length;
    private String isEmpty;
    private String defaultValue;
    private String note;
}
