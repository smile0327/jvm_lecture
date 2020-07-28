package com.kevin.study.jvm;

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

}
