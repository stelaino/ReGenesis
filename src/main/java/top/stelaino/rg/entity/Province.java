package top.stelaino.rg.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.List;

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
@TableName("tb_province")
public class Province implements Serializable {

    private static final long serialVersionUID = -4341251268438976695L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String provinceName;

    private String provinceShortName;

    private String currentConfirmedCount;

    private String confirmedCount;

    private String suspectedCount;

    private String curedCount;

    private String deadCount;

    private String comment;

    @TableField(exist = false)
    private List<City> cities;

    private LocalDateTime createTime;

    public void correctionInformation() {
        cities.forEach(city -> city.setProvinceName(this.provinceShortName));
    }
}
