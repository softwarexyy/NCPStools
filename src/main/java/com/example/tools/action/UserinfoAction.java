package com.example.tools.action;

/**
 * 对用户进行的操作
 */
public class UserinfoAction {

    /**
     * 根据手机号查询客户ID
     *
     * @param phone 手机号
     * @return 客户ID，或者""
     */
    public static String getUsridByPhone(String phone) {
        String sql = "select usr_id from to_user where phone_no = '" + phone + "'";
        String result = JDBCUtil.querySingle(sql, "nxy_s_usr");
        return result;
    }

    /**
     * 根据客户ID解绑设备
     *
     * @param usrId 客户ID
     * @return 生效条数
     */
    public static int unbindDevice(String usrId) {
        String sql = "delete from tr_usr_com_eqp where usr_id = '" + usrId + "'";
        int num = JDBCUtil.executeSql(sql, "nxy_s_usr");
        return num;
    }
}
