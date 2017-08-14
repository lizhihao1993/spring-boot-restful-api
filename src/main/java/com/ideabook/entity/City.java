package com.ideabook.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author: lzh
 * @Description:
 * @Date: Created in 2017/8/7 14:54
 */
@Entity
@Table(name = "city")
public class City implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    Long createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    public City() {
    }

    public City(String name) {
        this.name = name;
        this.createDate = System.currentTimeMillis();
    }
}
