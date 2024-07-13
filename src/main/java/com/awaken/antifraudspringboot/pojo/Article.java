package com.awaken.antifraudspringboot.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.io.Serializable;

@TableName("article")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article implements Serializable {
    @TableId(type = IdType.AUTO)
    private int id;
    private int uid;
    private String content;
    private String datetime;
    private String title;
    private String img;
    private int type;
}
