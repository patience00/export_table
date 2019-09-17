package com.linchtech.export.table.mapper;

import com.linchtech.export.table.entity.Table;
import com.linchtech.export.table.entity.TableComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: 107
 * @date: 2019/7/11 14:12
 * @description:
 * @Review:
 */
@Mapper
@Repository
public interface TableMapper {

    List<Table> getFields(@Param("database") String database, @Param("tableName") String tableName);

    List<TableComment> getAllTableName(@Param("database") String database);
}
