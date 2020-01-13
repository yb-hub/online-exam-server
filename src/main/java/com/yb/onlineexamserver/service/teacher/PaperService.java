package com.yb.onlineexamserver.service.teacher;

import com.yb.onlineexamserver.requestparams.PaperParams;

/**
 * @Auther: Yang
 * @Date: 2020/01/10 14:11
 * @Description:
 */
public interface PaperService {
    int insertPaper(PaperParams paperParams);
}
