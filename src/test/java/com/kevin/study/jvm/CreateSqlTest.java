package com.kevin.study.jvm;


import java.io.File;
import java.io.FileInputStream;

/**
 * @Auther: kevin
 * @Description:
 * @Company: 上海博般数据技术有限公司
 * @Version: 1.0.0
 * @Date: Created in 15:06 2020/7/27
 * @ProjectName: jvm_lecture
 */
public class CreateSqlTest {

    public static void main(String[] args) {
        formatHex();

    }

    private static void createSql(){
        StringBuilder sb =  new StringBuilder("CREATE TABLE formula_result (");
        for (int i = 0; i < 60; i++) {
            String column = i < 10 ? "0" + i : i + "";
            sb.append("`").append("V").append(column).append("`").append(" double NULL DEFAULT NULL ").append(",");
            sb.append("`").append("S").append(column).append("`").append(" bigint(20) NULL DEFAULT NULL ").append(",");
            sb.append("`").append("D").append(column).append("`").append(" text CHARACTER SET utf8 COLLATE utf8_general_ci NULL ").append(",");
        }
        sb.append("`ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键自增'").append(",");
        sb.append("`FORMULA_ID`  bigint(20) NOT NULL ").append(",");
        sb.append("`DATA_TYPE` int(4) NOT NULL COMMENT '总-1 尖-2 峰-3 平-4 谷-5'").append(",");
        sb.append("`OCCUR_TIME`  datetime NOT NULL ").append(",");
        sb.append("PRIMARY KEY (`ID`)").append(",");
        sb.append("UNIQUE INDEX unique_index (`FORMULA_ID`,`OCCUR_TIME`,`DATA_TYPE`) USING BTREE").append(")").append(";");

        System.out.println(sb.toString());
    }

    private static void formatHex(){
        File file = new File("D:\\code\\github\\jvm_lecture\\src\\main\\java\\com\\kevin\\study\\jvm\\bytecode\\MyTest1_class_file");
        try (FileInputStream is = new FileInputStream(file)) {
            int read1 = -1;
            StringBuilder sb = new StringBuilder();
            int index = 0;
            do {
                byte[] read = new byte[2];
                read1 = is.read(read);
                index ++;
                sb.append(new String(read));
                if (index % 32 == 0){
                    sb.append("\n");
                }else {
                    sb.append(" ");
                }
            }while (read1 != -1);
            System.out.println(sb.toString());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
