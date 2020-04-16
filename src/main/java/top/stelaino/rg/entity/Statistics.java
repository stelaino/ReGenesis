package top.stelaino.rg.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author stelaino [bigmagician@outlook.com]
 * @since 2020-04-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_statistics")
public class Statistics implements Serializable {

    private static final long serialVersionUID = -3786485051511815263L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField(exist = false)
    private Long modifyTime;
    private Integer currentConfirmedCount;
    private Integer currentConfirmedIncr;
    private Integer confirmedCount;
    private Integer confirmedIncr;
    private Integer curedCount;
    private Integer curedIncr;
    private Integer deadCount;
    private Integer deadIncr;
    //严重病例
    private Integer seriousCount = 0;
    private Integer seriousIncr = 0;
    //疑似病例
    private Integer suspectedCount = 0;
    private Integer suspectedIncr = 0;
    @TableField(exist = false)
    private Statistics foreignStatistics;
    @TableField(exist = false)
    private Statistics globalStatistics;
    private String recordTime;
    private String locale = "境内";
    private LocalDateTime createTime;

    public void setRecordTime(String recordTime) {
        this.recordTime = recordTime;
    }

    /**
     * 设置时间和校正对象中的foreignStatistics和globalStatistics属性
     */
    public void correctionInformation() {
        this.setCreateTime(null);
        this.recordTime = DateFormat.getDateTimeInstance().format(new Date(modifyTime));
        if (this.foreignStatistics != null) {
            this.foreignStatistics.setRecordTime(this.recordTime);
            this.foreignStatistics.setLocale("境外");
            this.foreignStatistics.setSeriousCount(null);
            this.foreignStatistics.setSeriousIncr(null);
        }
        if (this.getGlobalStatistics() != null) {
            this.globalStatistics.setRecordTime(this.recordTime);
            this.globalStatistics.setLocale("全球");
            this.globalStatistics.setSeriousCount(null);
            this.globalStatistics.setSeriousIncr(null);
            this.globalStatistics.setSuspectedCount(null);
            this.globalStatistics.setSuspectedIncr(null);
        }
    }
}
