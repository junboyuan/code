package com.xzj.mybatis.mysql.dao;

import com.xzj.mybatis.mysql.model.Record;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2017-11-17.
 */
public interface RecordManager {

    List<Record> selectAll();

    int insertAlarm(Record record);

    int delete();
}
