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
 * 外国疫情统计
 * </p>
 *
 * @author stelaino [bigmagician@outlook.com]
 * @since 2020-04-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_foreign")
public class Foreign implements Serializable {
    private static final long serialVersionUID = -8867579994020118198L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(exist = false)
    private Long modifyTime;

    private String recordTime;

    private String continents;

    private String provinceName;

    private Integer currentConfirmedCount;

    private Integer confirmedCount;

    private Integer confirmedCountRank;

    private Integer suspectedCount;

    private Integer curedCount;

    private Integer deadCount;

    private Integer deadCountRank;

    private Double deadRate;

    private Integer deadRateRank;

    private String countryShortCode;

    private String countryFullName;

    private Integer currentConfirmedIncr;

    private Integer curedIncr;

    private Integer confirmedIncr;

    private Integer deadIncr;

    @TableField(exist = false)
    private IncrVo incrVo;

//    @TableField(exist = false)
    private LocalDateTime createTime;

    public void correctionInformation() {
        if (this.modifyTime != null) {
            this.recordTime = DateFormat.getDateTimeInstance().format(new Date(this.modifyTime));
        }
        if (this.incrVo == null) return;
        this.currentConfirmedIncr = this.incrVo.currentConfirmedIncr;
        this.curedIncr = this.incrVo.curedIncr;
        this.confirmedIncr = this.incrVo.confirmedIncr;
        this.deadIncr = this.incrVo.deadIncr;
    }

    private static class IncrVo {
        private Integer currentConfirmedIncr;
        private Integer curedIncr;
        private Integer confirmedIncr;
        private Integer deadIncr;
    }
}
