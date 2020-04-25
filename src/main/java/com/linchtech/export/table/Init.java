package com.linchtech.export.table;

import com.linchtech.export.table.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author: 107
 * @date: 2019/7/11 14:22
 * @description:
 * @Review:
 */
@Component
public class Init implements ApplicationRunner {
    @Autowired
    private TableService tableService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        tableService.getTable("***.xlsx","***");
        tableService.getTable("***.xlsx","***");
        tableService.getTable("***.xlsx","***");
        tableService.getTable("***.xlsx","***");
    }
}
