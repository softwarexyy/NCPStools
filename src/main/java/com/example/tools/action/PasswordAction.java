package com.example.tools.action;

/**
 * 对密码进行的操作
 */
public class PasswordAction {

    /**
     * 重置密码
     *
     * @param ownObj 客户ID
     * @param pwdTyp 密码类型
     * @return
     */
    public static int resetPwd(String ownObj, String pwdTyp) {
        String sql = "update to_pwd set pw='C7F66BEEE198FB411C8623E53CBBC6EB1E0F078B5D68ED7F10D02FFB0AF46D44', pw2='3D4F2BF07DC1BE38B20CD6E46949A1071F9D0E3D' where own_obj='"
                + ownObj + "' and pwd_typ='" + pwdTyp + "'";
        int num = JDBCUtil.executeSql(sql, "nxy_s_cert");
        return num;
    }

    /**
     * 重置密码状态
     *
     * @param ownObj 客户ID
     * @param pwdTyp 密码类型
     * @return
     */
    public static int resetPwdStat(String ownObj, String pwdTyp) {
        String sql = "update to_pwd set vald_statscd='NR' where own_obj='" + ownObj + "' and pwd_typ='" + pwdTyp + "'";
        int num = JDBCUtil.executeSql(sql, "nxy_s_cert");
        return num;
    }
}
