package top.stelaino.rg.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

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
 * @since 2020-04-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_timeline")
public class Timeline implements Serializable {

    private static final long serialVersionUID = 5473277463511884393L;

    private Integer id;

    @TableField(exist = false)
    private Long pubDate;

    private String newTime;

    private String title;

    private String summary;

    private String infoSource;

    private String sourceUrl;

    private LocalDateTime createTime;

    public void correctionInformation() {
        this.newTime = DateFormat.getDateTimeInstance().format(new Date(this.pubDate));
    }

}
