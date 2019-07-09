import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

public class HbaseTest{
    public static HTable getTable(String name) throws Exception{
        StringBuffer sbf =new StringBuffer("ilovehl");
        String st = "ilovehl";
        Configuration conf  = HBaseConfiguration().create();
        HTable table = new HTable(conf,name);
        return table;
    }
    public static void getData(HTable table) throws IOException {
        Get get = new Get(Bytes.toBytes("20190117_10001")); //实例化创建的时候，指定一个rowkey
        get.addColumn(Bytes.toBytes("f1"),Bytes.toBytes("name"));//第一项是列簇，第二项是列的名称，不确定第一项这个写法对不对
        //load the get
        Result rs = table.get(get);
        for(Cell cell : rs.rawCells()){
            System.out.println(Bytes.toString(CellUtil.cloneFamily(cell)));
        }


    }
    public static void main(String[] args) throws Exception {
        HTable table = getTable("test:tb1");
    }
}
