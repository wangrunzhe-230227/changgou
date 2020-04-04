package com.changgou.goods.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "tb_brand")
@ApiModel(description = "品牌")
public class Brand implements Serializable {
    @Id
    @ApiModelProperty(value = "id")
    private Integer id;//品牌id
    @ApiModelProperty(value = "品牌名称")
    @Column(name = "name")
    private String name;//品牌名称
    @Column(name = "image")
    @ApiModelProperty(value = "品牌图片地址")
    private String image;//品牌图片地址
    @Column(name = "letter")
    @ApiModelProperty(value = "品牌的首字母啊")
    private String letter;//品牌的首字母
    @Column(name = "seq")
    @ApiModelProperty(value = "排序")
    private Integer seq;//排序

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }
}
