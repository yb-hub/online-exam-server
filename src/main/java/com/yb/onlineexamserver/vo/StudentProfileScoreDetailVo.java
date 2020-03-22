package com.yb.onlineexamserver.vo;

import com.yb.onlineexamserver.dto.PaperDetailDto;
import com.yb.onlineexamserver.dto.PaperDto;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Auther: Yang
 * @Date: 2020/02/22 13:04
 * @Description: 学生成绩单详情返回参数
 */
@Data
public class StudentProfileScoreDetailVo {
    private Integer id;
    private PaperDetailDto paper;
    private Integer totalScore;
    private Integer rightSingle;
    private Integer rightMulti;
    private Integer rightJudge;
    private LocalDateTime createTime;
}
