package com.xzj.mybatis.mysql;


import com.xzj.mybatis.mysql.dao.RecordManager;
import com.xzj.mybatis.mysql.model.Record;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-11-16.
 */
public class Main {
    public static void main(String[] args) throws SQLException {


        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        try {

            RecordManager mapper = session.getMapper(RecordManager.class);
            List<Record> records = mapper.selectAll();
            System.out.println(records);

            mapper.delete();
            session.commit();


            List<Record> newRecords = new ArrayList<Record>();
            for (int i = 0; i < 100; i++) {
                Record record = new Record();
                record.setCsn(i);
                record.setAckUser("xzj");
                record.setAlarmId("alarmid" + i);
                record.setClearUtc(System.currentTimeMillis());
                record.setAlarmName("alarmname" + i);
                record.setOccurUtc(System.currentTimeMillis());
                record.setClearUser("fewfewfew");
                newRecords.add(record);

                mapper.insertAlarm(record);
            }
            session.commit();

        } finally {
            session.close();
        }
    }

}
