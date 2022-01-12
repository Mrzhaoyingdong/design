package com.zhaoyd;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**  * All rights Reserved, Designed By zhaoyd.
 *
 * 模拟配置类
 *
 * @author: zhaoyd
 * @date: 2021/8/23 22:38
 * @Copyright: ©2020 zhaoyd. All rights reserved.
 * 注意：本内容仅限于自己阅读，禁止外泄以及用于其他的商业用途。
 */
@Data
@AllArgsConstructor
public class ConfigFile {

    private String versionNo; //版本号
    private String content; // ٖ内容
    private Date dateTime; // 时间
    private String operator; // 操作人


}
