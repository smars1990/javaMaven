package com.application.hbase;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.coprocessor.BaseRegionObserver;
import org.apache.hadoop.hbase.filter.*;
import org.apache.hadoop.hbase.io.compress.Compression;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class HbaseTest {

    private static final String TABLE_NAME = "MY_TABLE_NAME_TOO";
    private static final String CF_DEFAULT = "DEFAULT_COLUMN_FAMILY";

    public static void main(String[] args) throws IOException {
//        Configuration configuration = HBaseConfiguration.create();
//
//        String url = "";
//        configuration.addResource(url);
//        HBaseAdmin hBaseAdmin = new HBaseAdmin(configuration);
//
//        HTable hTable = new HTable(configuration,"emp");
//        Get get  = new Get(toBytes("row1"));


        //第一步，设置HBsae配置信息
        Configuration configuration = HBaseConfiguration.create();
        //注意。这里这行目前没有注释掉的，这行和问题3有关系  是要根据自己zookeeper.znode.parent的配置信息进行修改。
        //  configuration.set("zookeeper.znode.parent","/hbase-unsecure"); //与 hbase-site-xml里面的配置信息 zookeeper.znode.parent 一致
        configuration.set("hbase.zookeeper.quorum","127.0.0.1:");  //hbase 服务地址
        configuration.set("hbase.zookeeper.property.clientPort","2181"); //端口号
        //configuration.set("log4j.logger.org.apache.hadoop.hbase","WARN");
        //这里使用的是接口Admin   该接口有一个实现类HBaseAdmin   也可以直接使用这个实现类
        // HBaseAdmin baseAdmin = new HBaseAdmin(configuration);
        Connection connection = ConnectionFactory.createConnection(configuration);
        Admin admin = connection.getAdmin();




        HTable table = new HTable(configuration,"emp".getBytes());
        Scan scan = new Scan();

        /*
        //前缀过滤器----针对行键
        Filter filter = new PrefixFilter(Bytes.toBytes("person"));


        //行过滤器 ---针对行键
        //ByteArrayComparable rowComparator = new BinaryComparator(Bytes.toBytes("salary"));
        Filter  ddfilter = new SingleColumnValueFilter(Bytes.toBytes("professional data"), Bytes.toBytes("salary"),
                CompareFilter.CompareOp.GREATER_OR_EQUAL, Bytes.toBytes("40235"));
        ((SingleColumnValueFilter) ddfilter).setFilterIfMissing(true);



//        RowFilter rf = new RowFilter(CompareFilter.CompareOp.LESS_OR_EQUAL, rowComparator);
//        rf = new RowFilter(CompareFilter.CompareOp.EQUAL,  new SubstringComparator("5000"));

        //单值过滤器 1 完整匹配字节数组
        //new SingleColumnValueFilter("base_info".getBytes(), "name".getBytes(),  CompareFilter.CompareOp.EQUAL, "zhangsan".getBytes());

        //单值过滤器 2 匹配正则表达式
        //ByteArrayComparable comparator = new RegexStringComparator("zhang.");
        //new SingleColumnValueFilter("info".getBytes(), "NAME".getBytes(), CompareFilter.CompareOp.EQUAL, comparator);

        //单值过滤器 3 匹配是否包含子串,大小写不敏感
        //comparator = new SubstringComparator("wu");
        //new SingleColumnValueFilter("info".getBytes(), "NAME".getBytes(), CompareFilter.CompareOp.EQUAL, comparator);

//        //键值对元数据过滤-----family 过滤----字节数组完整匹配
//        FamilyFilter ff = new FamilyFilter(CompareFilter.CompareOp.EQUAL,
//                new BinaryComparator(Bytes.toBytes("base_info"))
//                //表中不存 在 inf 列族，过滤结果为空
//        );
//        //键值对元数据过滤-----family 过滤----字节数组前缀匹配
//        ff = new FamilyFilter(
//                CompareFilter.CompareOp.EQUAL,
//                new BinaryPrefixComparator(Bytes.toBytes("inf"))
//                //表中存在以inf 打头的列族 info，过滤结果为该列族所有行
//        );

//        //键值对元数据过滤-----qualifier 过滤----字节数组完整匹配
//        filter = new QualifierFilter(
//                CompareFilter.CompareOp.EQUAL,
//                new BinaryComparator(Bytes.toBytes("na"))
//                //表中不存在 na 列，过滤结果为空
//        );

//        filter = new QualifierFilter(
//                CompareFilter.CompareOp.EQUAL,
//                new BinaryPrefixComparator(Bytes.toBytes("na"))
//                //表中存在以 na 打头的列 name，过滤结果为所有行的该列数据
//        );

        //基于列名(即 Qualifier)前缀过滤数据的 ColumnPrefixFilter
        filter = new ColumnPrefixFilter("na".getBytes());

        //基于列名(即 Qualifier)多个前缀过滤数据的 MultipleColumnPrefixFilter
        byte[][] prefixes = new byte[][] {
                Bytes.toBytes("na"), Bytes.toBytes("me")
        };


        filter = new MultipleColumnPrefixFilter(prefixes);
        //为查询设置过滤条件
        scan.setFilter(filter);
        scan.addFamily(Bytes.toBytes("base_info"));

        FilterList filterList = new FilterList(FilterList.Operator.MUST_PASS_ALL);
        filterList.addFilter(ddfilter);
        scan.setFilter(filterList);

        */



        //一行
        //Result result = table.get(get);

//        //多行的数据
//        ResultScanner scanner = table.getScanner(scan);
//        JSONArray jsonArray = new JSONArray();
//        for (Result r : scanner) {
//            List<Cell> ceList =  r.listCells();
//            JSONObject jsonObject = new JSONObject();
//
//            String row = "";
//            if (ceList != null && ceList.size() > 0) {
//                for (Cell cell : ceList) {
//                    row = Bytes.toString(cell.getRowArray(), cell.getRowOffset(), cell.getRowLength());
//                    String value = Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength());
//                    String family = Bytes.toString(cell.getFamilyArray(), cell.getFamilyOffset(), cell.getFamilyLength());
//                    String quali = Bytes.toString(cell.getQualifierArray(), cell.getQualifierOffset(), cell.getQualifierLength());
//                    jsonObject.put(quali,value);
//                }
//                jsonObject.put("row",row);
//                jsonArray.add(jsonObject);
//            }
//        }
//        System.out.println(jsonArray);

//        hbaseTemplate.find(tableName, scan, new RowMapper<Map<String, Object>>() {
//            public Map<String, Object> mapRow(Result result, int rowNum) throws Exception {
//
//                List<Cell> ceList = result.listCells();
//                Map<String, Object> map = new HashMap<String, Object>();
//                Map<String, Map<String, Object>> returnMap = new HashMap<String, Map<String, Object>>();
//                String row = "";
//                if (ceList != null && ceList.size() > 0) {
//                    for (Cell cell : ceList) {
//                        row = Bytes.toString(cell.getRowArray(), cell.getRowOffset(), cell.getRowLength());
//                        String value = Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength());
//                        String family = Bytes.toString(cell.getFamilyArray(), cell.getFamilyOffset(), cell.getFamilyLength());
//                        String quali = Bytes.toString(cell.getQualifierArray(), cell.getQualifierOffset(), cell.getQualifierLength());
//                        map.put(family + "_" + quali, value);
//                    }
//                    map.put("row", row);
//                }
//                return map;
//            }
//        });


        //查看emp表是否存在
        pringListHbase(admin,connection);

        //创建表
        //createSchemaTables(admin);




    }

    public static void pringListHbase(Admin admin,Connection connection) throws IOException {
        TableName tableName1 = TableName.valueOf("emp");
        TableName tableName2 = TableName.valueOf("sally");


        //建立表的连接
        //Table table = connection.getTable(TableName.valueOf("emp"));
        System.out.println("emp 表是否存在："+ admin.tableExists(tableName1));

        //createSchemaTables(admin);


        Table empTable = connection.getTable(tableName1);
        Scan scan = new Scan();
        ResultScanner result = empTable.getScanner(scan);
        System.out.println("result:" + result);

        //Admin admin1 = ConnectionFactory.createConnection(configuration).getAdmin();
        if(admin !=null){
            try {
                //获取到数据库所有表信息
                HTableDescriptor[] allTable = admin.listTables();
                for (HTableDescriptor hTableDescriptor : allTable) {
                    System.out.println(hTableDescriptor.getNameAsString());
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }


//        Get get = new Get(Bytes.toBytes("admin"));
//        Result result = table.get(get);
//        for (Cell c : result.rawCells()) {
//            System.out.println(Bytes.toString(CellUtil.cloneRow(c))
//                    + "==> " + Bytes.toString(CellUtil.cloneFamily(c))
//                    + "{" + Bytes.toString(CellUtil.cloneQualifier(c))
//                    + ":" + Bytes.toLong(CellUtil.cloneValue(c)) + "}");
//        }
//        Scan scan = new Scan();
//        ResultScanner scanner = table.getScanner(scan);

        for (Result res : result) {
            for (Cell c : res.rawCells()) {
                System.out.println(Bytes.toString(CellUtil.cloneRow(c))
                        + " ==> " + Bytes.toString(CellUtil.cloneFamily(c))
                        + " {" + Bytes.toString(CellUtil.cloneQualifier(c))
                        + ":" + Bytes.toLong(CellUtil.cloneValue(c))
                        + "}");
            }
        }
    }

    public static void createOrOverwrite(Admin admin, HTableDescriptor table) throws IOException {
        if (admin.tableExists(table.getTableName())) {
            admin.disableTable(table.getTableName());
            admin.deleteTable(table.getTableName());
        }
        admin.createTable(table);
    }


    public static void createSchemaTables(Admin admin) throws IOException {

        TableName tableName   = TableName.valueOf("myTable");
        HTableDescriptor table = new HTableDescriptor(tableName);
        table.addFamily(new HColumnDescriptor(CF_DEFAULT).setCompressionType(Compression.Algorithm.SNAPPY));

        System.out.print("Creating table. ");
        createOrOverwrite(admin, table);
        System.out.println(" Done.");
    }
}

